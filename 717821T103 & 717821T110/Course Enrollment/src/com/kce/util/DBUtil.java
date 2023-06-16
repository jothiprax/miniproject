package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Course";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "riyas";

   

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    
    }
}
