package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
        public static Connection getConnection() throws ClassNotFoundException, SQLException {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","sanjay#244");
        	return con;
        }
}
