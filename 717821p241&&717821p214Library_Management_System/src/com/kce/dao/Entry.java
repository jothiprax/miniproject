package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entry {
	public void addBook(String roll,String id,String from_date,String to_date) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt1 = c.prepareStatement("select * from books where sno=?");
		smt1.setString(1, id);
		String b_name=null;
		String b_auth=null;
		ResultSet rs1 = smt1.executeQuery();
		while(rs1.next()) {
			 b_name = rs1.getString(2);
			 b_auth = rs1.getString(3);
		}
		PreparedStatement smt2 = c.prepareStatement("insert into book_issued values(?,?,?,?,?,?)");
		smt2.setString(1, roll);
		smt2.setString(2, id);
		smt2.setString(3, b_name);
		smt2.setString(4, b_auth);
		smt2.setString(5, from_date);
		smt2.setString(6, to_date);
		smt2.execute();
	}
	
}
