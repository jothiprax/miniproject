package com.kce.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.kce.util.DBConnection;

public class Update {
	
	public static void updateValue(String query)  {
		try {
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Value has been Updated Successfullly.");
	}catch(Exception e) {e.getStackTrace();
	System.out.print(e);}
	}
	
}
