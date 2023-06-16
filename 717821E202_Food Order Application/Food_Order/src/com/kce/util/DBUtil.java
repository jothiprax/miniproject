package com.kce.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	public static  Connection getConnection()
	{
		Connection con = null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ajay";
		String admin="root";
		String pass="";
		con=DriverManager.getConnection(url,admin,pass);
		System.out.println("Connected");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
