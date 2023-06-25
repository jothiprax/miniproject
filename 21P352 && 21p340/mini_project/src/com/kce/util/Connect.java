package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Connect{
	public static Connection getConnection() throws Exception
	{
	    String url="jdbc:mysql://localhost:3306/music_store";
		String username="root";
		String password="haridevil";
		String query="select * from Album";
		
		return DriverManager.getConnection(url,username,password);
	}
}
