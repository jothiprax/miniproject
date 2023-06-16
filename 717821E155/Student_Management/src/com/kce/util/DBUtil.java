package com.kce.util;

import java.sql.*;


public class DBUtil {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");

 Connection  con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Student@2"); 
System.out.println("done");
	return con;
}
}
