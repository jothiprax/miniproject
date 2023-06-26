package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
public static Connection getDBConnection() throws Exception {
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Nambi@2003");
	return con;
}
}
