package com.kce.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseConnection {
	
	//CREATING CONNECTION
       public Connection createConnection() {
    	   Connection cnx = null;
    	   try {
    		   Class.forName("com.mysql.cj.jdbc.Driver");
    		   String url = "jdbc:mysql://localhost:3306/project";
    		    cnx = DriverManager.getConnection(url,"root","Dharshu@11");
    	   }
    	   catch(ClassNotFoundException  e) {
    		   System.out.println("Class");
    	   }
           catch(SQLException  e) {
    		   System.out.println("sql");
    	   }
		   return cnx;
       }
      
}
