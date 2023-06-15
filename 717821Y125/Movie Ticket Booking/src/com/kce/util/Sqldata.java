package com.kce.util;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Sqldata{
	public Connection getconnection() {
	try {
	String url="jdbc:mysql://localhost:3306/jdbc";
	String user="root";
	String password="";
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(url,user,password);
	return con;
     }
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
	
}
}
