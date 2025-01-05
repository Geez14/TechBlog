package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.Detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetailDao {
    private Connection conn;
    private static final String QUERY =
            "INSERT INTO DETAILS(id, first_name, last_name, gender, phone_number) VALUES(?, ?, ?, ?, ?)";

    public DetailDao(Connection conn) {
        this.conn = conn;
    }

    public boolean save(Detail detail) {
        try (PreparedStatement stmt = conn.prepareStatement(QUERY)) {
            stmt.setInt(1, detail.getId());
            stmt.setString(2, detail.getFirstName());
            stmt.setString(3, detail.getLastName());
            stmt.setString(4, detail.getGender());
            stmt.setString(5, detail.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException sqe) {
            return false;
        }
        return true;
    }
}
