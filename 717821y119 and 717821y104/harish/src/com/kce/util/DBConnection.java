package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		
		public static Connection getConnection() {
			Connection con=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				String url="jdbc:mysql://localhost:3306/hotelmanagement";	
				String name="root";
				String password="dhananjai";
				con=DriverManager.getConnection(url,name,password);
			}
			catch(SQLException | ClassNotFoundException e) {
				System.out.println(e);
			}
			
		return con;
		}
}

