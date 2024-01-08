package com.insa.network;

import com.google.gson.GsonBuilder;
import com.insa.utils.MyLogger;

import java.io.*;
import java.net.Socket;

/**
 * This class is used to send TCP messages to a server
 **/
public class TCPClient {
    private Socket clientSocket;
    private PrintWriter out;


    /**
     * Starts a connection with a server
     **/
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    /**
     * Sends a message to the server and returns the response
     **/
    public void sendMessage(TCPMessage message) {
        var gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();

        MyLogger.getInstance().info("Sending message: " + gson.toJson(message));
        //System.out.println(("[TEST] - Check that conversion is working: " + gson.fromJson(gson.toJson(message), TCPMessage.class)));
        out.println(gson.toJson(message));
    }

    /**
     * Stops the connection with the server
     *
     * @throws IOException if an error occurs while closing the socket
     */
    public void stopConnection() throws IOException {
        clientSocket.close();
    }
}
