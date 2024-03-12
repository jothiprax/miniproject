package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book_List {
	public void displayBook() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");		
		PreparedStatement smt = c.prepareStatement("select * from books");
		ResultSet rs = smt.executeQuery();
		System.out.printf("--------------------------------------------------------------------\n");
		System.out.printf("|%-4s|%-70s|%-20s|\n","SNO","Title","Author");
		while(rs.next())
			System.out.printf("|%-4s|%-70s|%-20s|\n",rs.getString(1),rs.getString(2),rs.getString(3));
	}
}
