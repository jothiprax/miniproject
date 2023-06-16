package com.kce.Util;
import java.sql.*;
public class DButil {
	public static Connection getConnection() throws SQLException {
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","#sham@2004");
		return con;



	}



}