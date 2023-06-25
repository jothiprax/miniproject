package com.kce.stud.util;
import java.sql.*;
public class DbUtil {
	public static Connection getConnection()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student1","root","Dce@123-7"); 
	    return con;
	   

}
}
