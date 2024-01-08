package com.insa.GUI;


import com.insa.database.LocalDatabase;
import com.insa.network.ConnectedUser;
import com.insa.network.NetworkManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private final JFrame window = new JFrame();
    private final JPanel grid = new JPanel();
    private final JTextField inputNewUsername = new JTextField();
    private final JButton changeUsernameButton = new JButton("Change Username");
    private final JLabel changedUsernameLabel = new JLabel("");

    public void start() {
        window.setTitle("Chats");
        window.setSize(400, 275);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        grid.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        inputNewUsername.setPreferredSize(new Dimension(100, 30));
        grid.add(inputNewUsername, constraints);

        JPanel buttonBox = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonBox.add(changeUsernameButton);
        changeUsernameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeUsernameButtonHandler();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        grid.add(buttonBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        grid.add(changedUsernameLabel, constraints);

        window.add(grid);
        window.setVisible(true);
    }

    private void changeUsernameButtonHandler() {
        // Replace with your logic for handling the button click
        NetworkManager nwm = NetworkManager.getInstance();
        System.out.println("Clicked changeUsername");

        if (!inputNewUsername.getText().isEmpty()) {
            // Replace with your logic for notifying the change in username
            // ConnectedUser currentUser = new ConnectedUser(LocalDatabase.Database.currentUser, LocalDatabase.Database.currentIP);
            // nwm.notifyChangeUsername(currentUser, inputNewUsername.getText());

            ConnectedUser currentUser = new ConnectedUser(LocalDatabase.Database.currentUser, LocalDatabase.Database.currentIP);
            nwm.notifyChangeUsername(currentUser,inputNewUsername.getText());
            changedUsernameLabel.setText("Username changed!");
            changedUsernameLabel.setText("Username changed!");
        } else {
            System.out.println("Empty textfield new username");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().start();
        });
    }
}




/*
import com.insa.database.LocalDatabase;
import com.insa.network.ConnectedUser;
import com.insa.network.NetworkManager;
import com.insa.network.ConnectedUser;
import com.insa.utils.MyLogger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import java.awt.*;

public class SecondWindow {
    Stage window = new Stage();
    GridPane grid = new GridPane();
    TextField inputNewUsername = new TextField();
   Button changeUsernameButton = new Button("Change Username");
   Label changedUsernameLabel = new Label("");

    public void start(){
        window.setTitle("Chats");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        GridPane.setColumnIndex(inputNewUsername, 0);
        GridPane.setRowIndex(inputNewUsername, 0);
        grid.getChildren().add(inputNewUsername);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setColumnIndex(buttonBox, 0);
        GridPane.setRowIndex(buttonBox, 1);

        changeUsernameButton.setOnAction(e->changeUsernameButtonHandler());
        buttonBox.getChildren().add(changeUsernameButton);
        grid.getChildren().add(buttonBox);

        GridPane.setColumnIndex(changedUsernameLabel, 0);
        GridPane.setRowIndex(changedUsernameLabel, 2);
        grid.getChildren().add(changedUsernameLabel);

        Scene scene = new Scene(grid, 400, 275);
        window.setScene(scene);

        window.show();
    }


    private void changeUsernameButtonHandler(){
        NetworkManager nwm = NetworkManager.getInstance();

        MyLogger.getInstance().info("Clicked changeUsername");

        if (!inputNewUsername.getText().isEmpty()){
            ConnectedUser currentUser = new ConnectedUser(LocalDatabase.Database.currentUser, LocalDatabase.Database.currentIP);
            nwm.notifyChangeUsername(currentUser,inputNewUsername.getText());
            changedUsernameLabel.setText("Username changed!");
        }
        else {
            MyLogger.getInstance().info("Empty textfield new username");
        }

    }
}
*/