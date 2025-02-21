package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    private static final String QUERY = "INSERT INTO USERS(username, email, password) VALUES(?, ?, ?)";
    private static final String QUERY_GET_ID = "SELECT ID FROM USERS WHERE USERNAME = ? AND EMAIL = ?";
    private static final String QUERY_DROP_USER = "DELETE FROM USERS WHERE USERNAME = ? AND EMAIL = ?";
    private static final String QUERY_GET_BY_EMAIL_PASSWORD = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";

    /**
     * @param user com.geez14.techblogs.entities.User
     * @return boolean
     * Create User into database
     * CREATE TABLE users
     * (
     * id       NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
     * username VARCHAR2(36) NOT NULL UNIQUE,
     * email    VARCHAR2(128) NOT NULL UNIQUE,
     * reg_date TIMESTAMP DEFAULT SYSTIMESTAMP,
     * password VARCHAR2(256) NOT NULL
     * );
     * get the USER_ID and save the id in existing instance of User class
     * if cannot fetch the instance due to any particular reason
     * clean the data the user
     */
    public boolean save(User user) {
        try (PreparedStatement stmt = this.conn.prepareStatement(QUERY)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            try (PreparedStatement stmt2 = this.conn.prepareStatement(QUERY_GET_ID)) {
                stmt2.setString(1, user.getUsername());
                stmt2.setString(2, user.getEmail());
                ResultSet rs = stmt2.executeQuery();
                rs.next();
                user.setId(rs.getInt(1));
//                System.out.println(user);

            } catch (SQLException sqe) {
                return false;
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        }
        return true;
    }

    public User verifyByEmailAndPassword(String email, String password) {

        if (email == null || password == null)
            throw new IllegalArgumentException("Email and password are required");

        User user = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BY_EMAIL_PASSWORD);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword("hidden");
                user.setRegistrationDate(rs.getTimestamp("reg_date"));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
        return user;
    }
}
