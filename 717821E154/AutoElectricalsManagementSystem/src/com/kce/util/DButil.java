package com.kce.util;

import java.sql.*;

public class DButil {
	
	//THIS METHOD IS USED FOR CONNECTION TO THE DATABASE
	
	public static Connection getConnection()throws ClassNotFoundException, SQLException{
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Project","root","@SuryaMK123"); 
		return con;
	}
}
