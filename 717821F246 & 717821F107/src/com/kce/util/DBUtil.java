package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

private static Connection con;

public static Connection getConnection() {
if (con == null) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
  }
 }
return con;
  }
}
class StockNotFoundException extends Exception{
	public StockNotFoundException(String msg) {
		super(msg);
	}
}
class NoSuchFoodException extends Exception{
	public NoSuchFoodException(String msg) {
		super(msg);
	}
}


