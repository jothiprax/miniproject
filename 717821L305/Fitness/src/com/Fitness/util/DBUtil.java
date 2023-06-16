package com.Fitness.util;
import java.sql.*;
public class DBUtil {
	private static Connection con;
	private static String url="jdbc:mysql://localhost:3306/Fitness";
	private static String user_name ="root";
	private static String password="Subaash@11";
public static Connection getConnection(){
	try {
	con = DriverManager.getConnection(url,user_name,password);
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
}
	}
	
