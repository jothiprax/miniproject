package com.kce.util;

import java.sql.*;


public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/flight_reservation_system?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
