package com.geez14.techblogs.entities;

import java.sql.Date;

public class User {
    private int id = -1;
    private String username;
    private String email;
    private String password;
    private Date registrationDate;

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
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor to get data
     *
     * @param id       int
     * @param username java.lang.String
     * @param email    java.lang.String
     * @param password java.lang.String
     */
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return id == users.id &&
                username.equals(users.username) &&
                email.equals(users.email) &&
                password.equals(users.password);
    }

    @Override
    public int hashCode() {
        return id;
    }


    /**
     * Override toString method to get object representation
     *
     * @return java.lang.String
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}