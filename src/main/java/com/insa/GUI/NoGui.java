package com.insa.GUI;

import com.insa.database.LocalDatabase;
import com.insa.network.ConnectedUser;
import com.insa.network.NetworkManager;
import com.insa.network.UDPClient;
import com.insa.network.User;
import com.insa.utils.MyLogger;

import java.util.Scanner;

import static java.lang.System.exit;

public class NoGui {
    private static volatile NoGui instance;

    boolean connected;
    String[] options;
    Scanner scanner;

    private NoGui() {
        connected = false;
        options = makeOptions();
        scanner = new Scanner(System.in);
        menuManager();
    }

    synchronized static public NoGui getInstance() {
        NoGui result = instance;
        if (result != null) {
            return result;
        }
        synchronized (NoGui.class) {
            if (instance == null) {
                instance = new NoGui();
            }
            return instance;
        }
    }

    public void menuManager() {
        char selectedOption = '1';
        while (selectedOption != 'q' && selectedOption != 'Q') {
            printMenu(makeOptions());
            try {
                selectedOption = (char) scanner.next().charAt(0);
                if (connected) {
                    switch (selectedOption) {
                        case 'c', 'C' -> changeUsernameOption();
                        case 'd', 'D' -> disconnectOption();
                        case 'l', 'L' -> showConnectedUserOption();
                        case 'Q', 'q' -> quitOption();
                    }
                } else {
                    switch (selectedOption) {
                        case 'u', 'U' -> usernameOption();
                        case 'Q', 'q' -> quitOption();
                    }
                }

            } catch (Exception e) {
                System.out.println("Please enter the letter associated to your option.");
                e.printStackTrace();
                scanner.next();
            }
        }
    }

    private String[] makeOptions() {
        if (!connected) {
            return new String[]{
                    "u - Choose username",
                    "q - Quit",
            };
        } else {
            return new String[]{
                    "c - Change username",
                    "l - Show connectedUser",
                    "d - Disconnect",
                    "q - Quit",
            };
        }
    }

    public void printMenu(String[] options) {
        System.out.println("\nMENU:");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void usernameOption() {
        String selectedUsername = "";
        while (selectedUsername.isBlank()) {
            System.out.print("Write your username: ");
            selectedUsername = scanner.next();
        }
        LocalDatabase.Database.currentUser = new User(selectedUsername);
        NetworkManager nwm = NetworkManager.getInstance();
        if (nwm.discoverNetwork(selectedUsername)) {
            System.out.println("Username not available, please choose a new one.");
        } else {
            connected = true;
            System.out.println("Connected");
        }
    }

    public void changeUsernameOption() {
        String selectedUsername = "";
        while (selectedUsername.isBlank()) {
            System.out.println("Write new username: ");
            selectedUsername = scanner.next();
        }
        ConnectedUser currentUser = new ConnectedUser(LocalDatabase.Database.currentUser, LocalDatabase.Database.currentIP);

        NetworkManager.getInstance().sendChangeUsername(currentUser, selectedUsername);
        System.out.println("Username changed!");

    }

    public void showConnectedUserOption() {
        System.out.println("Display connected users:");
        for (ConnectedUser u : LocalDatabase.Database.connectedUserList) {
            System.out.println("\t" + u.getUsername());
        }
        System.out.println();
    }

    public void disconnectOption() {
        NetworkManager.getInstance().sendDisconnection(new ConnectedUser(LocalDatabase.Database.currentUser, LocalDatabase.Database.currentIP));
        connected = false;
    }

    public void quitOption() {
        if (connected) {
            disconnectOption();
        }
        connected = false;
        exit(0);
    }
}
