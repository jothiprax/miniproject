package com.kce.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBConnectivity {
public static void main(String[] args) {
try {
Class.forName("oracle.java.Driver.DriverManager");
Connection 
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","21p145");
Statement st=con.createStatement();
}catch(Exception e) {
System.out.println(e);
}
}
}