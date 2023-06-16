package com.kce.util;

import com.kce.bean.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/visproj";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "OPENVISHWA@22sql";

    public static Connection getConnection() {
        try {
        	System.out.print("Database is successfully Connected");
        	return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}