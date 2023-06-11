package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.kce.bean.LoginAccess;
import com.kce.util.DButil;

public class LoginAccessDao {
	static Scanner sc = new Scanner(System.in);

	public static int Login(LoginAccess la) {
		try {
			int count=0;
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("Select user_name,password from login");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(la.getUserName())&&rs.getString(2).equals(la.getPassword())) {
					System.out.println("Login Successful:");
					TimeUnit.SECONDS.sleep(5);
					count++;
					break;
				}
			}
			if (count==0) {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Invalid UserName or PassWord Please Check it");
				TimeUnit.SECONDS.sleep(2);
				return 1;
			}

		}catch(SQLException e) {
			System.out.println(e);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public static  void SignIn(LoginAccess la) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO login VALUES (?, ?, ?)");
			stmt.setString(1, la.getUserName());
			stmt.setString(2,la.getEmailId());
			stmt.setString(3,la.getPassword());
			stmt.executeUpdate();
			TimeUnit.SECONDS.sleep(5);
			System.out.println("SignIn Successful..........");
			TimeUnit.SECONDS.sleep(2);
		}catch(SQLException e) {
			System.out.println(e);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}