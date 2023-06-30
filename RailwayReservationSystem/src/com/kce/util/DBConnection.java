package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static String USER = "commerce";
    static String PASSWORD = "9894";
    public DBConnection(){}
    public Connection getDbConnection(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
