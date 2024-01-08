package com.insa.GUI;

import com.insa.database.LocalDatabase;
import com.insa.network.NetworkManager;
import com.insa.network.User;
import com.insa.utils.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    private final JFrame window = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel usernameLabel = new JLabel("Enter your username:");
    private final JTextField inputUsername = new JTextField();
    private final JButton enterButton = new JButton("Enter");
    private final JLabel chooseOtherUsernameLabel = new JLabel();

    public void start() {
        window.setTitle("ODD");
        window.setSize(400, 275);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel welcomeText = new JLabel("Welcome");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(welcomeText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        inputUsername.setPreferredSize(new Dimension(100, 30));
        panel.add(inputUsername, constraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(enterButton);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterButtonHandler();
            }
        });

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(buttonPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(chooseOtherUsernameLabel, constraints);

        window.add(panel);
        window.setVisible(true);
    }

    private void enterButtonHandler() {

        LocalDatabase.Database.currentUser = new User(inputUsername.getText());

        NetworkManager nwm = NetworkManager.getInstance();

        MyLogger.getInstance().info("Begin client discovery");
        
        if(nwm.discoverNetwork(inputUsername.getText())) {

            chooseOtherUsernameLabel.setForeground(Color.RED);
            chooseOtherUsernameLabel.setText("Username not available, please choose a new one.");
        } else {
            chooseOtherUsernameLabel.setText("Connected");

            enterButton.setVisible(false);
            MainWindow mainWindow = new MainWindow();
            mainWindow.start();
        };

    }
}


/*
import com.insa.database.LocalDatabase;
import com.insa.network.NetworkManager;
import com.insa.network.User;
import com.insa.utils.MyLogger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow {

    Stage window = new Stage();

    GridPane grid = new GridPane();
    Label usernameLabel = new Label("Enter your username:");
    TextField inputUsername = new TextField();

    Button enterButton = new Button("Enter");
    Label chooseOtherUsernameLabel = new Label();


    public void start() {
        //Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("mainwindow.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Welcome !");
//        stage.setScene(scene);
//        stage.show();
        window.setTitle("ODD");
        window.show();
        window.setTitle("Set Username");


        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text welcomeText = new Text("Welcome");
        GridPane.setColumnIndex(welcomeText, 0);
        GridPane.setRowIndex(welcomeText, 0);
        GridPane.setColumnSpan(welcomeText, 2);
        grid.getChildren().add(welcomeText);

        GridPane.setColumnIndex(usernameLabel, 0);
        GridPane.setRowIndex(usernameLabel, 1);
        grid.getChildren().add(usernameLabel);

        GridPane.setColumnIndex(inputUsername, 1);
        GridPane.setRowIndex(inputUsername, 1);
        grid.getChildren().add(inputUsername);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setColumnIndex(buttonBox, 1);
        GridPane.setRowIndex(buttonBox, 2);

        enterButton.setOnAction(e->enterButtonHandler());
        buttonBox.getChildren().add(enterButton);
        grid.getChildren().add(buttonBox);

        GridPane.setColumnIndex(chooseOtherUsernameLabel, 0);
        GridPane.setRowIndex(chooseOtherUsernameLabel, 4);
        grid.getChildren().add(chooseOtherUsernameLabel);

        Scene scene = new Scene(grid, 400, 275);
        window.setScene(scene);

        window.show();

    }
    private void enterButtonHandler() {
        LocalDatabase.Database.currentUser = new User(inputUsername.getText());

        NetworkManager nwm = NetworkManager.getInstance();

        MyLogger.getInstance().info("Begin client discovery");
        if(nwm.discoverNetwork(inputUsername.getText())) {

            chooseOtherUsernameLabel.setTextFill(Color.rgb(255,0,0));
            chooseOtherUsernameLabel.setText("Username not available, please choose a new one.");
        } else {
            chooseOtherUsernameLabel.setText("Connected");

            SecondWindow secondWindow = new SecondWindow();
            secondWindow.start();
        };
    }
}

*/

