package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.About;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutDao {
    Connection conn;

    public AboutDao(Connection conn) {
        this.conn = conn;
    }

    private static final String QUERY = "INSERT INTO ABOUTS(id, profile_picture, about) VALUES(?, ?, ?)";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM ABOUTS WHERE id = ?";
    final String DEFAULT_PROFILE_PICTURE = "default.png";
    final String DEFAULT_USER_ABOUT = "Hey! I am using knowledgeMD";

    public boolean save(About about) {
        try (PreparedStatement stmt = this.conn.prepareStatement(QUERY)) {
            stmt.setInt(1, about.getId());
            stmt.setString(2, about.getProfilePicture() == null ? DEFAULT_PROFILE_PICTURE : about.getProfilePicture());
            stmt.setString(3, about.getAbout() == null ? DEFAULT_USER_ABOUT : about.getAbout());
            stmt.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        }
        return true;
    }

    public About getAboutById(int id) {
        About about = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY_FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                about = new About();
                about.setId(rs.getInt("id"));
                about.setProfile_picture(rs.getString("profile_picture"));
                about.setAbout(rs.getString("about"));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
        return about;
    }
}
