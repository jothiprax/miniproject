package com.kce.util;

	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.SQLException;
	public class DBConnection {
	    
	    static Connection connection;

	    public static  Connection createDBConnection(){
	    try {
	        	
	        //Loading the Driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //Getting the Connection
	        final String dburl = "jdbc:mysql://localhost:3306/java_project";
	        final String username = "root";
	        final String password = "system123";
	        connection = DriverManager.getConnection(dburl , username , password);
	        }
	        catch(ClassNotFoundException e){
	            e.printStackTrace();
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        System.out.println("\nConnection to the database is created successfully\n");
	        
	        //returning the connection
	        return connection;
	    }

	    public static void deleteDBConnection(){
	        
	        try {
	        	// To delete Connection  
	            connection.close();
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	        System.out.println("\nConnection to the database is deleted successfully\n");
	        return;
	    } 
	}
