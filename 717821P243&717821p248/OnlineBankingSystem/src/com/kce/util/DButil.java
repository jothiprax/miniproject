package com.kce.util;

import java.sql.DriverManager;
import java.sql.Connection;
public class DButil {
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Banking","root","root");
		return con;
	}
}
