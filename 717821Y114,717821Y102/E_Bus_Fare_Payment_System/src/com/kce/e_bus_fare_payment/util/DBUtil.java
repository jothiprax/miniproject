package com.kce.e_bus_fare_payment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection(){
		final String url="jdbc:mysql://localhost/bus_fare_payment_db";
		final String username="admin";
		final String password="dhinesh2004";
		try {
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (SQLException e) {
			System.out.println("Oops..Database Connection Failed!!");
			return null;
		}
		
		
	}

}
