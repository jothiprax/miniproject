package com.kce.util;
import java.sql.*;

public class FMutil {
	public static Connection getConnection() throws SQLException {



		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement","root","Vishnu2003@");

		return con;

	}

}
