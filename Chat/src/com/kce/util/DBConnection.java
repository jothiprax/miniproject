package com.kce.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection con;
    public DBConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
         con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MINI","2003");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
