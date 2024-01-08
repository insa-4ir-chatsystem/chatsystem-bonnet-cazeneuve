package com.insa.network;

import com.google.gson.GsonBuilder;
import com.insa.utils.MyLogger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class TCPServer extends Thread {

    /**
     * Observer interface for the TCP server
     **/
    public interface TCPServerObserver {
        /**
         * Called when a new message is received
         **/
        void onNewMessage(TCPMessage message);
    }

    private final ServerSocket socket;
    private static final List<TCPServerObserver> observerList = new ArrayList<>();

    public TCPServer(int port) throws IOException {
        this.socket = new ServerSocket(port);
    }

    /**
     * Adds a new observer to the class, for which the onNewMessage method will be called when a new message is received
     **/
    public void addObserver(TCPServerObserver observer) {
        synchronized (observerList) {
            MyLogger.getInstance().info("Adding observer");
            observerList.add(observer);
        }
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                // Accept new client
                new ClientHandler(socket.accept()).start();
            } catch (IOException e) {
                MyLogger.getInstance().log("Error while accepting client: " + e.getMessage(), Level.SEVERE);
                System.err.println("Error while accepting client: " + e.getMessage());
            }
        }
    }

    /**
     * Closes the server socket
     **/
    public void close() throws IOException {
        socket.close();
    }

    /**
     * Class handling a client connection
     */
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // Create Gson object with custom date format so that the date is correctly parsed
            var gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.S").create();

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String receivedMessage;
                while ((receivedMessage = in.readLine()) != null) {
                    MyLogger.getInstance().info("Message received: \n" + receivedMessage);
                    // Notify observers
                    synchronized (observerList) {
                        for (TCPServerObserver observer : observerList) {
                            MyLogger.getInstance().info("Notifying observer that a message has been received");
                            observer.onNewMessage(gson.fromJson(receivedMessage, TCPMessage.class));
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
