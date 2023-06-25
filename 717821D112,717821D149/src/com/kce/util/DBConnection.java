package com.kce.util;
import java.sql.*;
public class DBConnection {
    public Connection con;

    public DBConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RESTAURANT", "2003");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
