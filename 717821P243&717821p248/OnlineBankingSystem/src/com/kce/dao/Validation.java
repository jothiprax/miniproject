package com.kce.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.kce.bean.User;
import com.kce.util.DButil;

public class Validation {
	public boolean userNameAvailable(String username)
	{
		try {
		Statement stmt = DButil.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select username from user_details");
		while(rs.next())
		{
			if(rs.getString(1).equals(username))
				return false;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public boolean checkCredentials(String username, String password)
	{
		try {
		Statement stmt = DButil.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select username, password from user_details");
		while(rs.next())
		{
			if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
				return true;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
}

