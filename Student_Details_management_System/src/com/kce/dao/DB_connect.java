package com.kce.dao;

import java.sql.*;
public class DB_connect {
	

public static  Connection DBConnection(){
	Connection connection = null;
	try {
	 String Url="jdbc:mysql://localhost:3306/user";
	 String User="root";
	 String PWD="Nagarasu";
	connection =DriverManager.getConnection(Url,User,PWD);
	}
	catch(Exception e) {
		System.out.print(e);
	}
	return connection;
 }
}
