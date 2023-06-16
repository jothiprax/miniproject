package com.jdbc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

//connect to the database system using jdbc connection 
public class Database {
	public Connection getConnection() throws SQLException	{
		String url = "jdbc:mysql://localhost:3306/database";
		String username = "root";
		String password = "password@123";
		return DriverManager.getConnection(url,username,password);
		
}
}