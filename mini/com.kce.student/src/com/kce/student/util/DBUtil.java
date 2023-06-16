package com.kce.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
		//method to create Connection
		public static Connection getConnection() throws ClassNotFoundException {
			Connection con=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				String url="jdbc:mysql://localhost:3306/studen";	
				String name="root";
				String password="Dce@123-7";
				con=DriverManager.getConnection(url,name,password);
			}
			catch(SQLException e) {
				System.out.println("Database connectivity not established");
			}		
		return con;
		}
}