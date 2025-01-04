package com.geez14.techblogs.dao;

import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrationDao {
    private Connection conn;
    private static final String QUERY1 =
            "INSERT INTO USERS(username, email, password) VALUES(?, ?, ?)";

    private static final String QUERY2 =
            "INSERT INTO ABOUTS(id, about) VALUES(?, ?)";

    private static final String QUERY3 =
            "INSERT INTO DETAILS(id, first_name, last_name, gender, phone_number) VALUES(?, ?, ?, ?, ?)";

    public RegistrationDao(Connection conn) {
        this.conn = conn;
    }

    public boolean save(User user, About about, Detail detail) {
        return true;
    }
}
