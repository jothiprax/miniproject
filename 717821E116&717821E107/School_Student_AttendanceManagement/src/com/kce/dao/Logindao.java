package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.LoginPage;
import com.kce.util.DbUtil;

public class Logindao {
	public static int Login(LoginPage a) throws ClassNotFoundException {
		try {
			int count=0;
			Connection con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("Select Username,Password from login");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(a.getUsername())&&rs.getString(2).equals(a.getPassword())) {
					System.out.println("Login Successful:");
					count++;
					break;
				}
			}
			if (count==0) {
				System.out.println("Invalid UserName or PassWord Please Check it");
				return 1;
			}

		}catch(SQLException e) {
			System.out.println(e);
		}
		return 0;
	}
	public static  void StaffSignIn(LoginPage a) throws ClassNotFoundException {
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO login VALUES (?, ?, ?)");
			stmt.setString(1, a.getUsername());
			stmt.setString(2,a.getPassword());
			stmt.setString(3,a.getStaffId());
			stmt.executeUpdate();
			System.out.println("SignIn Successful..........");
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
