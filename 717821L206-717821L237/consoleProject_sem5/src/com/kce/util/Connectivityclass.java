package com.kce.util;
import java.util.*;
	import java.sql.*;
	public class Connectivityclass {

	static Connection con;
	public static Connection createConnection() 
	throws ClassNotFoundException,SQLException{
	
		
			Class.forName("com.mysql.jdbc.Driver");
			String user="root@localhost";
			String password="rachana";
			String url="jdbc:mysql://localhost:3306/Bavya";
			con=DriverManager.getConnection(url,user,password);
			
			
		
		
		return con;
	}
	}

