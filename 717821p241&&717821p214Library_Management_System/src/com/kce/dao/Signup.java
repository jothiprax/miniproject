package com.kce.dao;
import com.kce.bean.Students;
import java.sql.*;
public class Signup{		
	public void addUser(String rollno, String dob) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");		
		PreparedStatement smt = c.prepareStatement("create table if not exists User_data (Roll_No varchar(200),Passwd varchar(200));");
		smt.execute();
		PreparedStatement smt1 = c.prepareStatement("insert into User_data values(?,?)");
		smt1.setString(1, rollno);
		smt1.setString(2, dob);
		smt1.execute();
	}
}
