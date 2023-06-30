package com.kce.sports.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SportsCon {
	public static Connection getDBConnection() {
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsmanagementsystem" ,"root","12345");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
