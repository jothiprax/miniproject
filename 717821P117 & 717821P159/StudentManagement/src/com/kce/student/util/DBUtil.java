package com.kce.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection(){
        Connection con=null;
        try{
            final String URL = "jdbc:mysql://localhost:3306/student";
            final String USR = "root"; 
            final String PASS = "Ganesh@2003";
            con = DriverManager.getConnection(URL, USR, PASS);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
