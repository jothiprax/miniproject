package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.bean.LoginAccess;
import com.kce.util.DButil;

public class SignupDao {
	public static void insertData(LoginAccess user) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into login (username,email,password) values(?, ?, ?)");
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getPassword());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
