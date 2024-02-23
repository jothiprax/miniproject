package com.kce.util;
import java.sql.*;
public class Dbutil {
	public static void getConnection()
	{
		try
		{
			Connection con = null;
			if(con==null)
			{
				String DB_URL = "jdbc:mysql://localhost:3306/hospital_management";
				String USER = "root";
				String PASSWORD = "#Nesamani5";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				System.out.println("Connection established");
			}
			/*Statement stmt = con.createStatement();
			 String createTableQuery = "CREATE TABLE hospital_management("
			 + "id VARCHAR(20) NOT NULL,"
			 + "name VARCHAR(50) NOT NULL,"
			 + "weight VARCHAR(50) NOT NULL,"
			 + "age VARCHAR(50) NOT NULL,"
			 + "consultantdoctor VARCHAR(70) NOT NULL,"
			 + "medicalcomments VARCHAR(70) NOT NULL)";
			 stmt.executeUpdate(createTableQuery);*/
			 System.out.println("Table created successfully!");
			} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
