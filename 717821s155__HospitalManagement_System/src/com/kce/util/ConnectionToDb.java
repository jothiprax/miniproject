package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {
//method to create Connection
			public static Connection getConnection() {
				Connection con=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	//it defines about he database and driver used
					String url="jdbc:mysql://localhost:3306/hospitalmanagementdb";	//url that defines the database details
					String name="root";
					String password="root962";
					con=DriverManager.getConnection(url,name,password);
				}
				catch(SQLException | ClassNotFoundException e) {
					System.out.println(e);
				}
				
			return con;
			}
}
