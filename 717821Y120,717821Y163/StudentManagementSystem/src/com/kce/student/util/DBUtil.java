package com.kce.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class for database connection
public class DBUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USERNAME = "harish";
    private static final String PASSWORD = "harish123";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
