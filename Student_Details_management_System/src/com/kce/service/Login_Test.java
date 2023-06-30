package com.kce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.util.SQLConnection;

public class Login_Test{
	public  Login_Test(String Uname,String password ) throws SQLException,Student_Exception {
		Connection connection=SQLConnection.connect();
		 String query="Select * from Students_login where Id=? and Password=?;";
		 PreparedStatement pt=connection.prepareStatement(query);
		 pt.setString(1, Uname);
		 pt.setString(2, password);
		 ResultSet rs=pt.executeQuery();
		if(Uname.equalsIgnoreCase(rs.getString(1)+"") && password.equals(rs.getString(2)+"")) {
          throw new Student_Exception();
		}
	 }
}

