//package com.insa.GUI.controller;
//
//import com.insa.network.NetworkManager;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.paint.Color;
//
//public class SetUsernameController {
//
//
//    public TextField inputUsername;
//    public Button enterButton;
//    public Label chooseOtherUsername;
//
//    public void onEnterButtonClick(){
//        // starts discovery
//        NetworkManager nwm = new NetworkManager();
//        if (nwm.discoverNetwork(inputUsername.getText())){
//            chooseOtherUsername.setTextFill(Color.rgb(255,0,0));
//            chooseOtherUsername.setText("Username not available, please choose a new one.");
//        } else {
//            //pursue
//        }
//    }
//
//}
