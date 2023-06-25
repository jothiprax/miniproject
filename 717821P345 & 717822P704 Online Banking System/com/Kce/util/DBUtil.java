package com.Kce.util;
import java.sql.*;
import java.lang.*;
public class DBUtil {
    public Connection getDBConnection()throws ClassNotFoundException,SQLException{
        //created a jdbc connection with database name,username and password
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Madhavan");
        return con;
    }
}
