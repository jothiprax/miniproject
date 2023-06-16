package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kce.util.DButil;

public class LoginDao {
	public static int validate(String username,String password) {
		int count=0;
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("Select username,email,password from login");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				if((username.equals(rs.getString(1))||username.equals(rs.getString(2)))&&password.equals(rs.getString(3))){
					count++;
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
}

