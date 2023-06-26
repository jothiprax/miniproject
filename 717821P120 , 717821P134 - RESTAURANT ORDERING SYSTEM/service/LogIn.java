package com.kce.service;

import com.kce.dao.DBConnection;

import java.sql.*;
import java.util.Scanner;

class LogIn implements SignIn{
    Connection con;
    private static String customerId;

    public LogIn(){
            DBConnection db = new DBConnection();
            this.con = db.con;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String logInCheck() {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("User name : ");
            String username = sc.nextLine();
            System.out.print("Password : ");
            String password = sc.nextLine();

            PreparedStatement ps = con.prepareStatement("select * from login where username = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("\nWelcome back "+rs.getString(3)+" : "+rs.getString(1));
                setCustomerId(rs.getString(1));
                return rs.getString("type");
            }else{
                System.out.println("Wrong Username or Password Try Again\n");
                System.out.print("Enter : 1 to signup \nEnter : 2 to login again\nEnter : 3 to exit ");
                int n = sc.nextInt();


                if(n == 1) {

                    System.out.print("User new name : ");
                    username = sc.nextLine();
                    System.out.print("Password : ");
                    password = sc.nextLine();
                    ps = con.prepareStatement("insert into login values(?,?,'CUSTOMER')");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.executeUpdate();
                    System.out.println("Welcome to the new journey");

                    System.out.println("\nwelcome " + "CUSTOMER" + " : " + username);
                    return "CUSTOMER";
                } else if (n == 2) {
                    logInCheck();
                } else if (n == 3) {
                    System.exit(0);
                }

            }

        }catch(Exception e){
            System.out.println(e);
        }
            return "";
    }


}
