package com.kce.util;

import java.sql.*;

public class DButil {
	public static Connection getConnection() throws SQLException {

		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy","root","9626424882");
		return con;
	}
}

