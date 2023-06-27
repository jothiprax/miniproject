package com.kce.student.util;
import java.sql.*;
public class DButil {

	public static Connection getDBConnection()
		{
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmgt","root","j0b0r2ee4");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
			
		}
	}

