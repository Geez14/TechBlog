package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Deprecated(forRemoval = true)
public class RegistrationDao {
    private Connection conn;
    private static final String QUERY1 =
            "INSERT INTO USERS(username, email, password) VALUES(?, ?, ?)";

    private static final String QUERY2 = "INSERT INTO ABOUTS(id, about) VALUES(?, ?)";

    private static final String QUERY3 =
            "INSERT INTO DETAILS(id, first_name, last_name, gender, phone_number) VALUES(?, ?, ?, ?, ?)";

    private static final String QUERY4 =
            "SELECT ID FROM USERS WHERE USERNAME = ? AND EMAIL = ?";

    public RegistrationDao(Connection conn) {
        this.conn = conn;
    }

    public boolean save(User user, About about, Detail detail) {
        try {
            PreparedStatement stmt1 = this.conn.prepareStatement(QUERY1);
            stmt1.setString(1, user.getUsername());
            stmt1.setString(2, user.getEmail());
            stmt1.setString(3, user.getPassword());
            stmt1.executeUpdate();
            stmt1.close();

            PreparedStatement stmt2 = this.conn.prepareStatement(QUERY4);
            int id = stmt2.executeQuery().getInt(0);
            stmt2.close();

            PreparedStatement stmt3 = this.conn.prepareStatement(QUERY2);
            stmt3.setInt(1, id);
            stmt3.setString(2, about.getAbout());
            stmt3.executeUpdate();
            stmt3.close();

            PreparedStatement stmt4 = this.conn.prepareStatement(QUERY3);
            stmt4.setInt(1, id);
            stmt4.setString(2, detail.getFirstName());
            stmt4.setString(3, detail.getLastName());
            stmt4.setString(4, detail.getGender());
            stmt4.setString(5, detail.getPhoneNumber());
            stmt4.executeUpdate();
            stmt4.close();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        }
        return true;
    }
}
