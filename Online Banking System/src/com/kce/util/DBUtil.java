package com.kce.util;
import java.sql.*;
import java.sql.Connection;
public class DBUtil {
	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "K.Guna14");
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}

