package com.kce.dao;
import java.sql.*;
public class DBConnection {
    public Connection con;

    public DBConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RESTAURANT", "2004");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
