package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection {
	Connection con = null;
	PreparedStatement prs = null;
	public JDBCConnection() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
		// data base url of our database
		String username = "root"; // username of our database
		String password = "Vishnu@f15"; // password to access our database
		con = DriverManager.getConnection(url,username,password); 
		/*
		 * Established the connection between our JDBC driver and Database
		 */
	}
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		return prs = con.prepareStatement(query);
		// preparedstatement generated for our server
	}
}
