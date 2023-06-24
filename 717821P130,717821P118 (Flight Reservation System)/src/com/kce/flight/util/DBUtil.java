package com.kce.flight.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/kavin";
	private static final String userName = "root";
	private static final String passWord = "root@123";

	public static Connection getDBConnection() {
		try {
			return DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return null;
	}
}

