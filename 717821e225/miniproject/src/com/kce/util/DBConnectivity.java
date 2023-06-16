package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnectivity {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resort_db","root","kabil");
			Statement st=con.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
