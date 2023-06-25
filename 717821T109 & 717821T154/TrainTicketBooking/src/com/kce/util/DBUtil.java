package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Train";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "riyas";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
}
