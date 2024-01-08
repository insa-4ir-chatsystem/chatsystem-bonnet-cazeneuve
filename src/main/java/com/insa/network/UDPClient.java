package com.insa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class UDPClient {
    private final DatagramSocket clientSocket;

    /**
     * No-arg constructor
     */
    public UDPClient() {
        try {
            clientSocket = new DatagramSocket();
            InetAddress clientAddress = InetAddress.getByName("localhost");
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * send UDP Message
     * @param msg Message to be sent
     * @param sendingPort int
     * @param sendingAddress InetAddress, destinator address
     * @throws UnknownHostException
     */
    public void sendUDP(Message msg, int sendingPort, String sendingAddress) throws UnknownHostException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        InetAddress address = InetAddress.getByName(sendingAddress);
        byte[] buffer = (gson.toJson(msg)).getBytes();

        try {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, sendingPort);
            clientSocket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @return List of all Broadcast InetAddresses of UDPClient machine
     * @throws SocketException
     */
    List<InetAddress> listAllBroadcastAddresses() throws SocketException {
        List<InetAddress> broadcastList = new ArrayList<>();
        Enumeration<NetworkInterface> interfaces
                = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();

            if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                continue;
            }

            networkInterface.getInterfaceAddresses().stream()
                    .map(a -> a.getBroadcast())
                    .filter(Objects::nonNull)
                    .forEach(broadcastList::add);
        }
        return broadcastList;
    }

    /**
     * send UDP Broadcast to each Broadcast address listed by listAllBroadcastAddresses()
     * @param msg Message to be sent
     * @param sendingPort int
     * @throws IOException
     */
    public void sendBroadcast(Message msg, int sendingPort) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List<InetAddress> groupBroadcast = listAllBroadcastAddresses();

        if (groupBroadcast.isEmpty()){
            throw new IllegalStateException("No broadcast address available");
        } else {
            byte[] buffer = gson.toJson(msg).getBytes();
            for (InetAddress address : groupBroadcast) {
                clientSocket.setBroadcast(true);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, sendingPort);
                clientSocket.send(packet);
            }
        }
    }

    public void close() { clientSocket.close();}

}
