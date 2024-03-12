package com.kce.bank.util;
import java.util.*;
import java.sql.*;
public class DBUtil {
	private static Connection con;
	public static Connection getConnection() {
		if(con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}
