package com.kce.dao;
import java.sql.*;
public class DButil {
	public static Connection getConnections() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","vishal@1209");
		return con;
	}
}
