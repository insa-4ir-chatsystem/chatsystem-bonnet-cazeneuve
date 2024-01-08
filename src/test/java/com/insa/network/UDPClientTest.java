package com.insa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UDPClientTest {

    private Message testMessage;
    DatagramSocket testSocket;
    User testUser;
    @Test
    void sendUDP() throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        testSocket= new DatagramSocket(4444);

        //initialize testmessage
        testUser = new User("test");
        testMessage = new Message();
        testMessage.setSender(testUser);
        testMessage.setType(Message.MessageType.USER_CONNECTED);

        UDPClient udpClient = new UDPClient();
        udpClient.sendUDP(testMessage, 4444, "localhost"); //my machine's address -> to be changed


        //in testSocket, reception of the sent message
        byte[] buffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);

        testSocket.receive(receivedPacket);

        String receivedMessageString = new String(receivedPacket.getData(),0, receivedPacket.getLength(), "UTF-8");

        //compare String formatted received message with sent message
        assertEquals(gson.toJson(testMessage), receivedMessageString, "not good");
    }

    @Test
    void sendBroadcast() {

    }
}