package com.RKFoodOrder.util;
import java.sql.*;
public class DBUtil {
 private static Connection con;
 private static String url = "jdbc:mysql://localhost:3306/Food_Order";
 private static String user_name = "root";
 private static String password = "RK07*";
 public static Connection getConnection() throws Exception{
	 //Class.forName("com.mysql.jdbc.Driver");
	 try {
		 con = DriverManager.getConnection(url,user_name,password);
	 }
	 catch(SQLException e){
		 e.printStackTrace();
	 }
	 if(con !=null) {
		// System.out.println("Connection Connected");
	 }
	 else {
		 System.out.println("Connection failed");
	 }
	 
	return con;
 }
}
