package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String userName="commerce";
    private static final String password="9894";
    public static Connection getconnection() throws SQLException
    {
        return DriverManager.getConnection(url,userName,password);

    }
}
