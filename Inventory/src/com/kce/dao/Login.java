package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
    private Connection con;
    private Class c;
    private PreparedStatement ps;

    private static String customerId;

    private static String username ;
    private static String password ;


    Scanner sc=new Scanner(System.in);
    public Login(){
        try {
            c=Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "commerce", "9894");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String getCustomerId() throws Exception {
        return customerId;
    }

    public  void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }
    public String loginType() throws Exception{
        System.out.println("Username : ");
        String username=sc.nextLine();
        System.out.println("Password : ");
        String password=sc.nextLine();
        ps=con.prepareStatement("select * from login where username = ? and password = ?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            Login.customerId = rs.getString(1);
            this.username=username;
            System.out.println("\n Welcome back "+rs.getString(2)+" as "+rs.getString(4));
            return rs.getString(4);
        }
        return "";
    }
}
