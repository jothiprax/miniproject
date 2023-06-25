package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public JDBCConnection(){
	}
   public Connection getConnection() throws Exception{
	   String url = "jdbc:mysql://localhost:3306/mydb";
		Connection con =DriverManager.getConnection(url,"root","Sathis@123");
		return con;
   }
}
