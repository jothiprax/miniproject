package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.kce.bean.LoginAccess;
import com.kce.util.DBUtil;

public class LoginAccessDao {
	static Scanner sc = new Scanner(System.in);

	public static int Login(LoginAccess l) {
		try {
			int count=0;
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("Select user_name,password from login");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(l.getUserName())&&rs.getString(2).equals(l.getPassword())) {
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

	public static void SignIn(LoginAccess l) {
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO login VALUES (?, ?, ?)");
			pst.setString(1,l.getUserName());
			pst.setString(2,l.getEmailId());
			pst.setString(3,l.getPassword());
			pst.executeUpdate();
			System.out.println("SignIn Successfull");
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
}
