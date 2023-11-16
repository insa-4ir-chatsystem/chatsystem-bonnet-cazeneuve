package com.example.contactdiscovery;

import java.net.InetAddress;
import java.util.UUID;

public class ConnectedUser extends User {

    private InetAddress ip;

    public ConnectedUser(String username, InetAddress ip) {
        super(username);
        this.ip = ip;
    }
    public ConnectedUser(String username, UUID uuid, InetAddress ip) {
        super(username, uuid);
        this.ip = ip;
    }

    public InetAddress getIP() {
        return ip;
    }
    public void setIP(InetAddress ip){
        this.ip=ip;
    }


    /**
    public String getUsername(){
        return super.getUsername();
    }
    public void setUsername(String username){
        super.setUsername(username);
    }

    public UUID getUuid(){
        return super.getUuid();
    }
    **/
}
