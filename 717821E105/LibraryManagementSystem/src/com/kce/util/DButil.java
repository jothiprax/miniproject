package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibManagement","root","Anu27@#");
		return con;
	}
}
