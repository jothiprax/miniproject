package com.kce.util;
import java.sql.*;
public class DButil {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.java.Driver.DriverManager");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "21p111");
			Statement stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}