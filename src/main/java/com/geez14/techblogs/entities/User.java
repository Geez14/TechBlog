package com.geez14.techblogs.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private Timestamp dateTime;

    /**
     * For serialization and other purpose
     */
    public User() {
        super();
    }

    /**
     * Constructor to set data
     *
     * @param username int
     * @param email    java.lang.String
     * @param password java.lang.String
     * @param dateTime java.sql.Timestamp
     */
    public User(String username, String email, String password, Timestamp dateTime) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateTime = dateTime;
    }

    /**
     * Constructor to get data
     *
     * @param id       int
     * @param username java.lang.String
     * @param email    java.lang.String
     * @param password java.lang.String
     * @param dateTime java.sql.TimeStamp
     */
    public User(int id, String username, String email, String password, Timestamp dateTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return id == users.id &&
                username.equals(users.username) &&
                email.equals(users.email) &&
                password.equals(users.password) &&
                dateTime.equals(users.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}