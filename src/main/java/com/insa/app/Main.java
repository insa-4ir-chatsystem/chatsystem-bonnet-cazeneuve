package com.insa.app;

import com.insa.GUI.NoGui;
import com.insa.network.NetworkManager;
import com.insa.utils.MyLogger;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        MyLogger.getInstance().info("Args: " + Arrays.toString(args));
        if (Arrays.asList(args).contains("no-gui")) {
            MyLogger.getInstance().info("Running with no gui");
            NoGui.getInstance();
        } else {
            App.main(args);
        }
    }
}
