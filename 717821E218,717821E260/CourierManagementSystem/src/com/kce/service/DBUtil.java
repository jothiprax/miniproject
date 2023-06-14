package com.kce.service;

import java.sql.*;

public class DBUtil {
	static Connection connection;
	public static Connection createConnection()
	{
		try
		{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vikash","root","vikash27");}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
