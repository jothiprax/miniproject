package com.kce.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectToDB {
private static Connection con;
public static Connection ConnectDB(){
	String url = "jdbc:oracle:thin:@localhost:1521/XE";
	String username = "ADMIN";
	String password = "oracle";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, username, password);
	} catch (SQLException |ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
}
