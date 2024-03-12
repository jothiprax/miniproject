package com.kce.student.util;
import java.sql.*;
public class JDBCconnection {
     public static Connection getConnection() {
    	 try {
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudharsan","admin");
    			return con;
    			}
    			catch(SQLException e) {
    				System.out.println(e);
    			}
    			catch(ClassNotFoundException e) {
    				System.out.println(e);
    			}
    			return null;
     }
}
