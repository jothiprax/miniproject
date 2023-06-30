package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    public static Connection connect() {
    	Connection con=null;
    	try {
    		 String Url="jdbc:mysql://localhost:3306/user";
    		 String User="root";
    		 String PWD="Nagarasu";
    		con =DriverManager.getConnection(Url,User,PWD);
    }
    	catch(Exception e) {
    		System.out.println(e);
    	}
		return con;
}
}
