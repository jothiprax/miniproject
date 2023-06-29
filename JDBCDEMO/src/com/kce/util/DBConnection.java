package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{
	private static Connection con;
	public static Connection createconnection(){
		try{
			if(con==null)
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sam","root","Y1012Jqkhkp");
			System.out.println("Connection established");
		}
       catch(Exception e)
		{
    	   System.out.println(e.getMessage());
		}
		return con;
}
}
