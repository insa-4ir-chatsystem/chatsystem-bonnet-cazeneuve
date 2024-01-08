package com.insa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.UUID;

public class Message {
    public enum MessageType {DISCOVERY, USER_CONNECTED, USER_DISCONNECTED, USERNAME_CHANGED, USERNAME_TAKEN, TEXT_MESSAGE};

    /** Properties **/
    private MessageType type;
    private String content;
    private Date date = new Date();
    private User sender;
    private User receiver;
    private UUID uuid;


    /** No-arg constructor **/
    public Message(){   }

    /** Six-args constructor **/
    public Message(MessageType type, String content, Date date, User sender, User receiver, UUID uuid) {
        this.type = type;
        this.content = content;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.uuid = uuid;
    }

    /** Five-args constructor **/
    public Message(MessageType type, String content, Date date, User sender, User receiver) {
        this.type = type;
        this.content = content;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.uuid = UUID.randomUUID();
    }

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

    /**
     * Getter for message content
     *
     * @return String content of the message
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter for message content
     *
     * @param data String
     */
    public void setContent(String data) {
        this.content = data;
    }

    /**
     * Getter for property Date
     *
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for property date
     *
     * @param date Date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for property Sender
     *
     * @return User sender of the message
     */
    public User getSender() {
        return sender;
    }

    /**
     * Setter for property Sender
     *
     * @param sender User
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * Getter for property Receiver
     *
     * @return User receiver of message
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * Setter for property Receiver
     *
     * @param receiver User
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    /**
     * Getter for the unique identifier of the message
     *
     * @return Unique identifier for the message
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Serializer of the message
     *
     * @return String containing the serialized instance of Message
     */
    @Override
    public String toString() {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        return g.toJson(this);
    }
}
