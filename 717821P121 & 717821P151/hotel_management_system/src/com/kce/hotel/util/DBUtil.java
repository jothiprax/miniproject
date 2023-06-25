package com.kce.hotel.util;

import java.sql.*;

public class DBUtil {
    private static Connection connection;
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/hotel_management";
            connection = DriverManager.getConnection(url, "root", "password");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

   }
