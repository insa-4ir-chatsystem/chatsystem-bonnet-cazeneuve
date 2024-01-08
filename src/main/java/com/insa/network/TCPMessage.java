package com.insa.network;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * This class represents a TCP message
 */
public record TCPMessage(String content, User sender, User receiver, Timestamp date) {
    /**
     * Method overriding equals to compare two TCPMessage objects
     *
     * @param other the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            System.out.println("[TEST] - Same object");
            return true;
        }
        if (other == null) {
            System.out.println("[TEST] - Other is null");
            return false;
        }
        if (!(other instanceof TCPMessage msg)) {
            System.out.println("[TEST] - Other is not a TCPMessage");
            return false;
        }

        // System.out.println("[TEST] - Comparing " + msg.content.equals(this.content) + " " + msg.sender.equals(this.sender) + " " + msg.receiver.equals(this.receiver) + " " + msg.date.equals(this.date));
        return msg.content.equals(this.content) && msg.sender.equals(this.sender) && msg.receiver.equals(this.receiver) && msg.date.equals(this.date);
    }

    /**
     * Method overriding hashCode to compare two TCPMessage objects
     *
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(content, sender, receiver, date);
    }

}
