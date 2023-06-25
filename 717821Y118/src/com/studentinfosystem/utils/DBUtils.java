package com.studentinfosystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db"; // Replace with your MySQL database URL
    private static final String USERNAME = "username"; // Replace with your MySQL username
    private static final String PASSWORD = "password"; // Replace with your MySQL password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
