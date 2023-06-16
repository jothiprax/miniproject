package com.kce.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		//Class.forName("dbc:mysql://127.0.0.1:3306/?user=student");
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/world","student","sree2003$");
		return con;
	}
}
