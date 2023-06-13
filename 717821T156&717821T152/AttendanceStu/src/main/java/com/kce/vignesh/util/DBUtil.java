package com.kce.vignesh.util;
import java.sql.*;
public class DBUtil {
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/attendance";
	private static String username = "root";
	private static String password = "vignesh";
	public static Connection getDBConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			con=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.println("Connected to "+url+" Successfully");
		}else {
			System.out.println("Could not connect to "+url);
		}
		return con;
	}
}
