package com.kce.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class for database connection
public class DBUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USERNAME = "vinoth";
    private static final String PASSWORD = "vinoth";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
