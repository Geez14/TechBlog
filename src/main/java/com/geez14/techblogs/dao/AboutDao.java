package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.About;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AboutDao {
    Connection conn;

    public AboutDao(Connection conn) {
        this.conn = conn;
    }

    private static final String QUERY = "INSERT INTO ABOUTS(id, about) VALUES(?, ?)";

    public boolean save(About about) {
        try (PreparedStatement stmt = this.conn.prepareStatement(QUERY)) {
//            System.out.println(about);
            stmt.setInt(1, about.getId());
            stmt.setString(2, about.getAbout());
            stmt.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        }
        return true;
    }
}
