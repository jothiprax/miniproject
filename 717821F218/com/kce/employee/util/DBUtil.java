package com.kce.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String name = "sample";
		String pass = "123";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, name, pass);
			return con;
		} catch (ClassNotFoundException|SQLException e) {
			System.out.println(e);
		} 
		return null;
	}
} 
