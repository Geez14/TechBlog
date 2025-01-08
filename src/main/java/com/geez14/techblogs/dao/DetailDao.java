package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailDao {
    private final Connection conn;
    private static final String QUERY =
            "INSERT INTO DETAILS(id, first_name, last_name, gender, phone_number) VALUES(?, ?, ?, ?, ?)";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM DETAILS WHERE id = ?";
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
    public Detail getDetailById(int id) {
        Detail detail = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY_FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                detail = new Detail();
                detail.setId(rs.getInt("id"));
                detail.setFirstName(rs.getString("first_name"));
                detail.setLastName(rs.getString("last_name"));
                detail.setGender(rs.getString("gender"));
                detail.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
        return detail;
    }
}
