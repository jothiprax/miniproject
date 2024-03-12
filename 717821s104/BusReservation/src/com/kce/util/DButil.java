package com.kce.util;

import java.sql.*;



public class DButil {

	public static Connection getConnection() throws SQLException {



		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_reserv","root","8248085464");

		return con;

	}

}





