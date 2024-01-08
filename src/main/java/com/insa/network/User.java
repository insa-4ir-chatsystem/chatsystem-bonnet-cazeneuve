package com.insa.network;

import java.util.UUID;

public class User implements java.io.Serializable {

    private String username;
    private UUID uuid;


    /**
     * Single arg constructor
     **/
    public User(String name) {
        this.username = name;
        this.uuid = UUID.randomUUID();
    }

    /**
     * Double arg constructor
     **/
    public User(String name, UUID uuid) {
        this.username = name;
        this.uuid = uuid;
    }


    /**
     * Setter for property Username
     *
     * @param name chosen username
     */
    public void setUsername(String name) {
        this.username = name;
    }

    /**
     * Getter for property type Username
     *
     * @return String Username of instance of User
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for property UUID
     *
     * @return UUID, unique identifier of instance of User
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Method overriding hashCode to compare two User objects
     *
     * @return the hashcode of the object (here the hashcode of the UUID)
     */
    @Override
    public int hashCode() {
        return this.uuid.hashCode();
    }

    /**
     * Method overriding equals to compare two User objects
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return this.uuid.equals(user.uuid);
        }
        return false;
    }

    /**
     * Serializer of User
     *
     * @return String containing fields of User
     */
    public String toString() {
        return "username: " + this.username + "\nUUID: " + this.uuid.toString();
    }


}
