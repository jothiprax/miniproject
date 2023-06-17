package com.javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	public static Connection getConnection() throws SQLException {
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/muthu","root","Muthu@2004");
	return con;
	
}
}