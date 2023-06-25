package com.kce.DBUnit;
import java.sql.*;

public class DBConnection {
    public Connection con;
    public DBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "commerce", "9894");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
