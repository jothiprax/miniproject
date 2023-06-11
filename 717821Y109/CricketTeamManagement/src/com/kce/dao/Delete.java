package com.kce.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.util.DBConnection;

public class Delete {

	static Connection con=DBConnection.getConnection();
	
	public static void delete(int matchNo,int jerseyNo) {
		try {
			Statement stmt=con.createStatement();
			stmt.addBatch("Delete from player where jersey_no="+jerseyNo+" and match_no="+matchNo);
			stmt.addBatch("Delete from score where jersey_no="+jerseyNo+" and match_no="+matchNo);
			stmt.executeBatch();
			System.out.println("Value Deleted.");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}