package com.kce.dao;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	public class DBconnection {
		    private static final String URL = "jdbc:mysql://localhost:3306/flight_reservation_system";
		    private static final String USERNAME = "root";
		    private static final String PASSWORD = "password";

		    public static Connection getConnection() {
		        try {
		            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
		}
