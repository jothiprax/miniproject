package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection()throws ClassNotFoundException,SQLException {
		
		   
		  // Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Sreem@007");
	        return con;
		}
}

