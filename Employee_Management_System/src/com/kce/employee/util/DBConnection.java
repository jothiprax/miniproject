package com.kce.employee.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DBConnection {
    
    static Connection connection;

    public static  Connection createDBConnection(){
        try{
        //Loading the Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //Getting the Connection
        final String dburl = "jdbc:oracle:thin:@localhost:1521:XE";
        final String username = "employee";
        final String password = "employee";
        connection = DriverManager.getConnection(dburl , username , password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("\nConnection to the database is created successfully\n");
        //returning the connection
        return connection;
    }

    public static void deleteDBConnection(){
        
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("\nConnection to the database is deleted successfully\n");
        return;
    }

    
}

