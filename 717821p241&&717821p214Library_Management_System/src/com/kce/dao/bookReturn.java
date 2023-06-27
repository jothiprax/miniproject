package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bookReturn {
	public void display(String roll) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt1 = c.prepareStatement("select * from book_issued where roll=?");
		smt1.setString(1, roll);
		ResultSet rs = smt1.executeQuery();
		while(rs.next())
			System.out.printf("|%-4s|%-70s|%-20s|%-20s|%-20s|%-20s|\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
	}
	public List<String> colletBook_id(String roll) throws SQLException {
		List<String> l = new ArrayList<>();
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt1 = c.prepareStatement("select book_id from book_issued where roll=?");
		smt1.setString(1, roll);
		ResultSet rs = smt1.executeQuery();
		while(rs.next())	
			l.add(rs.getString(1));
		return l;
			
	}
	public Map<String,String> colletreturn_date(String roll,String b_id) throws SQLException {
		Map<String,String> m = new HashMap<>();
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt1 = c.prepareStatement("select book_id,return_date from book_issued where roll=? && book_id=?");
		smt1.setString(1, roll);
		smt1.setString(2, b_id);
		ResultSet rs = smt1.executeQuery();
		while(rs.next()) 
			m.put(rs.getString(1),rs.getString(2));		
		return m;
			
	}
	public void removeBook(String roll,String id) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt1 = c.prepareStatement("delete from book_issued where book_id=? && roll=?");
		smt1.setString(1, id);
		smt1.setString(2, roll);
		smt1.executeUpdate();
	}
}
