package com.kce.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   static Connection con;
    public static Connection createDBConnetion(){

        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Rakeshram@27");

        }catch (Exception e){
            System.out.println(e);
        }
     return con;
    }
}