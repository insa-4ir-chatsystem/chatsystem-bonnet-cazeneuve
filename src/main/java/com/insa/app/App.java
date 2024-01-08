package com.insa.app;

import com.insa.GUI.LoginWindow;
import com.insa.utils.MyLogger;


import javax.swing.*;

public class App {

    private final LoginWindow loginWindow = new LoginWindow();

    public void start() {
        // Initialize logger
        MyLogger logger = MyLogger.getInstance();
        MyLogger.getInstance().info("Launching app");

        SwingUtilities.invokeLater(() -> {
            loginWindow.start();
        });
    }

    public static void main(String[] args) {
        new App().start();
    }
}

/*
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    LoginWindow loginWindow = new LoginWindow();
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initalize logger
        MyLogger logger = MyLogger.getInstance();
        MyLogger.getInstance().info("Launching app");

        loginWindow.start();
    }

    public static void main(String[] args){
        launch(args);
    }
}
*/