package com.insa.network;

import java.net.InetAddress;
import java.util.UUID;

public class ConnectedUser extends User {

    private InetAddress ip;

    /** Two args constructor  **/
    public ConnectedUser(String username, InetAddress ip) {
        super(username);
        this.ip = ip;
    }

    /** Three args constructor  **/
    public ConnectedUser(String username, UUID uuid, InetAddress ip) {
        super(username, uuid);
        this.ip = ip;
    }

    /**  Alternative two args constructor   **/
    public ConnectedUser(User user, InetAddress ip) {
        super(user.getUsername(), user.getUuid());
        this.ip = ip;
    }

    /**
     * Getter for property IP
     *
     * @return IP address of the instance of ConnectedUsers
     */
    public InetAddress getIP() {
        return this.ip;
    }
    public void setIP(InetAddress ip){
        this.ip=ip;
    }

}
