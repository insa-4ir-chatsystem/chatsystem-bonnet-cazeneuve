package com.example.contactdiscovery;


import java.util.Date;
import java.util.UUID;

public class Message implements java.io.Serializable {


    public Message(MessageType type, String content) {
        this.type = type;
        this.content = content;
    }

    public enum MessageType {USER_CONNECTED, USER_DISCONNECTED, USERNAME_CHANGED, TEXT_MESSAGE};

    /** Properties **/
    private MessageType type;
    private String content;
    private Date date;
    private User sender;
    private User receiver;
    private UUID uuid;


    /** No-arg constructor **/
    public Message(){   }

    /**
     * Getter for property type
     *
     * @return type of the message
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Setter for property type
     *
     * @param type
     */
    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String data) {
        this.content = data;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}