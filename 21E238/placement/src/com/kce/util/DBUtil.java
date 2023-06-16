package com.kce.util;

import java.sql.*;

public class DBUtil{
	public static Connection getConnection()throws ClassNotFoundException, SQLException{
	Class.forName("jdbc.oracle.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	return con;
		}
		}

