package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {
    //private static final String  driverName = "oracle.jdbc.driver.OracleDriver";
    //private static final String  jdbcUrl = "jdbc:oracle:thin:@localhost:1521:onlineshop";
    private static final String  driverName = "org.h2.Driver";
    private static final String  jdbcUrl = "jdbc:h2:~/onlineshop";
    private static final String userName = "sa";
    private static final String password = "test";

    private static Connection connection;

    private DbConnectionUtils() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(jdbcUrl, userName, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
