package com.insa.database;
import com.insa.network.ConnectedUser;
import com.insa.network.User;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


public class LocalDatabase {

    public static class Database{

        public static User currentUser;

        public static InetAddress currentIP;

        public static List<ConnectedUser> connectedUserList = new ArrayList<>();
    }
}
