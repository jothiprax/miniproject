package com.kce.service;
import java.sql.*;
import java.util.*;

import com.kce.util.DBConnection;
class startmini{
    static int UserId;
    static String Password;
    static String Password1;
    static String Password2;
     static Scanner sc=new Scanner(System.in);
     static Connection con;
    static PreparedStatement pre;
    public static void DBConnection(){
        DBConnection db = new DBConnection();
        con = db.con;
    }
    public static void ExchaningData() throws Exception{
     System.out.println("YOU WANT SEND A MESSAGE SOMEONE PRESS 1\n");
       System.out.println("YOU WANT RECEIVER A MESSAGE FROM SOMEONE PRESS 2");
       int a=sc.nextInt();
       if(a==1)
       {
           System.out.println("Enter the message Receiver ID");
           int reciverId=sc.nextInt();
           SendingMessage(reciverId);
           ExchaningData();
        }
    else if(a==2){
       Reciver r1 =new Reciver(UserId);
       ExchaningData();
    }

}
    public static void newUser() throws Exception{
       pre=con.prepareStatement("insert into users values(?,?,?)");
       System.out.println("Enter the Your Name: ");
       String newname=sc.nextLine();
       System.out.println("Enter the new login id: ");
       UserId=sc.nextInt();
       sc.nextLine();
       System.out.println("Enter the new password: ");
       Password1=sc.nextLine();
       System.out.println("Enter the confirm password: ");
       Password2=sc.nextLine();
       if(Password1.equals(Password2)){
           pre.setInt(1, UserId);
        pre.setString(2, Password1);
        pre.setString(3, newname);
        pre.executeQuery();
        System.out.println("YOURE ACCOUNT WAS DONE SUCCESSFULLY CREATED AND LOGIN\n");
        System.out.println("\t\t\t\t\t WELCOME:"+newname);
               ExchaningData();
        }
        else
        {
            System.out.println("YOURE CONFIRM PASSWORD NOT MATCHED");
            System.out.println("Re-Enter you Detials:");
            newUser();
        }
    }
    public static void OldUser() throws Exception{
        System.out.println("Enter the login id: ");
        UserId=sc.nextInt();
        int id=UserId;
        sc.nextLine();
        System.out.println("Enter the password: ");
        Password=sc.nextLine();
        pre=con.prepareStatement("select * from Users where userid=?");
        pre.setInt(1,id);
        ResultSet rs=pre.executeQuery();
       String name="";
       String passwd=null;
     
       while(rs.next()){
           name=rs.getString(3);
         passwd=rs.getString(2);
         }
         
        if(name.length()==0){
            System.out.println("YOURE ACCOUNT WAS NOT EXIXTS\n");
            System.out.println("\n\t CREAT NEW ACCOUNT");
        newUser();
        }
        else{
            if(passwd.equals(Password)){

                System.out.println("\t\t\t\t YOURE ACCOUNT WAS DONE SUCCESSFULLY LOGIN\n");
                System.out.println("\t\t\t\t\t WELCOME:"+name);
               ExchaningData();
            }else{
                System.out.println("\t\t\t\t YOURE ACCOUNT PASSWORD WAS WRONG");
                
            }
            // System.out.println("\t\t\t\t\t "+name);
        }
        
    }
    
    public static void SendingMessage(int reciverId) throws Exception{
        pre=con.prepareStatement("select name from Users where userid=?");
        pre.setInt(1,reciverId);
        ResultSet rs1=pre.executeQuery();
        
        String name="";
        while(rs1.next()){
            name=rs1.getString(1);
        }
       if(name.length()==0)
       {
           System.out.println("We cant find the user Id");
        }
        else
        {
            System.out.println("Reciver Tracked Done");
            System.out.println(reciverId+"-"+name);
            
            sc.nextLine();
         String message=sc.nextLine();
         Sender s=new Sender(UserId,reciverId,message);
         
        }
        
    }
    public static void main(String[] args) throws Exception {
        
        int loginOption;
        System.out.println("\t"+"\t"+"\t\t\t\t\t"+"WELCOME TO CHATTING\n");
        System.out.println("YOUR ARE ALREADY REGISTER PRESS 1\n");
        System.out.println("YOUR ARE NEW USER PRESS 2\n");
        loginOption=sc.nextInt();
        if(loginOption==1){
            DBConnection();
            sc.nextLine();
            OldUser();
            
        }else if(loginOption==2){
            DBConnection();
            sc.nextLine();
              newUser();

        }
}
}
