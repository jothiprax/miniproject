package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

public static Connection getConnection() throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/hotel","root","Siva@2003");
return con;
}
}