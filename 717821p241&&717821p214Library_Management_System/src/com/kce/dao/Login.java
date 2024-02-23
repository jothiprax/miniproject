package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public boolean validateLogin(String reg,String dob) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");		
		PreparedStatement smt = c.prepareStatement("select * from user_data");
		ResultSet rs = smt.executeQuery();
		while(rs.next()) {
			if(reg.equals(rs.getString(1)) && dob.equals(rs.getString(2)))
				return true;		}
		return false;
	}
}
