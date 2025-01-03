package com.geez14.techblogs.util;

import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton connection.
 * TODO: Implement the connection pooling
 */
public class ConnectionProvider {
    private static Connection conn;
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "servlets", "asdf");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
