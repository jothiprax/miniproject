package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.Members;
import com.kce.bean.Schedules;
import com.kce.bean.Scores;
import com.kce.bean.UserDefinedException;

import util.DBUtil;
//import com.kce.bean.Borrower;
//import com.kce.util.DBUtil;
public class DAO {
public void addMembers()throws UserDefinedException {
       Scanner sc=new Scanner(System.in);
        	 System.out.print("Enter player name: ");
             String name = sc.nextLine();
             
            System.out.print("Enter player id: ");
            int id = sc.nextInt();
            System.out.print("Enter player age: ");
            int age = sc.nextInt(); 
Members m = new Members();
            m.setName(name);
            m.setId(id);
            m.setAge(age);
Connection con=DBUtil.createConnection();
try {
            PreparedStatement ps = con.prepareStatement("insert into members values (?, ?, ?,?)");
            ps.setString(1, m.getName());
            ps.setInt(2, m.getId());
            ps.setInt(3, m.getAge());

            int a = ps.executeUpdate();

            if (a > 0) {
                System.out.println("Player details added successfully!");
            } else {
                System.out.println("Failed to add.");
            }
}catch(SQLException e)
{
	e.printStackTrace();
	
	
} } 
    public void addMembers1()throws UserDefinedException {
        
    	Scanner sc=new Scanner(System.in);
    	 System.out.print("Enter Player Name: ");
         String name = sc.nextLine();

        System.out.print("Enter Player id: ");
        int id = sc.nextInt();
        System.out.print("Enter time: ");
        int time = sc.nextInt();
        
        Schedules s=new Schedules();
        s.setName(name);
        s.setId(id);
        s.setTime(time);
        
         Connection con=DBUtil.createConnection();
try {
        PreparedStatement ps = con.prepareStatement("insert into members values (?, ?, ?,?,?)");
        ps.setInt(1, s.getName());
        ps.setString(2, s.getId());
        ps.setString(3, s.getTime());
        
        int a = ps.executeUpdate();
       if (a > 0) {
            System.out.println("Schedule details added successfully!");
        } else {
            System.out.println("Failed to add schedule details.");
        }
}catch(SQLException e)
{
e.printStackTrace();


} } 
         public void updateMembers() 
    {
    	Scanner sc=new Scanner(System.in);
          System.out.print("Enter Player name: ");
          String name = sc.nextLine();

         System.out.print("Enter Player id: ");
         int id = sc.nextInt();
         System.out.print("Enter Player age: ");
         int age = sc.nextInt();
         
         Members m1=new Members();
         m1.setName(name);
         m1.setId(id);
         m1.setAge(age);
         
         
          
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps1 = con.prepareStatement("update books set title = ? where Id = ?");
                ps1.setString(1, m1.getName());
                 ps1.setInt(2, m1.getId());
                 ps1.setInt(2, m1.getAge());

                int a = ps1.executeUpdate();

                if (a > 0) {
                    System.out.println("Schedule updated successfully!");
                } else {
                    System.out.println("Failed to update Schedule");
                }} catch(SQLException e)
                {
                	e.printStackTrace();
                	
                	
                } 
            } 
         public void updateSchedule() 
         {
         	Scanner sc=new Scanner(System.in);
               
               System.out.print("Enter new player : ");
               String name = sc.nextLine();
                System.out.print("Enter new player age: ");
              int id = sc.nextInt();
              System.out.print("Enter Player time: ");
              int time = sc.nextInt();
              Schedules s1=new Schedules();
              s1.setName(name);
              s1.setId(id);
              s1.setTime(time);
              
               
     Connection con=DBUtil.createConnection();
     try {
                     PreparedStatement ps1 = con.prepareStatement("update borrower set Email = ?, Borrowerbookname =? where Id = ?");
                     ps1.setString(1, s1.getName());
                     ps1.setInt(2,s1.getTime());
                      ps1.setInt(3, s1.getAge());

                     int a = ps1.executeUpdate();

                     if (a > 0) {
                         System.out.println("Player details updated successfully!");
                     } else {
                         System.out.println("Failed to update Player details.");
                     }} catch(SQLException e)
                     {
                     	e.printStackTrace();
                     	
                     	
                     } 
                 } 
         
    

    public void deletePlayer() {
    	Scanner sc=new Scanner(System.in);
       
            System.out.print("Enter Player id : ");
            int id2 = sc.nextInt();
            sc.nextLine();
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps2 = con.prepareStatement("delete from  books where Id = ?");
                ps2.setInt(1, id2);

                int a = ps2.executeUpdate();

                if (a > 0) {
                    System.out.println("Player deleted successfully!");
                } else {
                    System.out.println("Failed to delete Player.");
          
}}catch(SQLException e)
{
	e.printStackTrace();
	
	
} 
                
    }
    public void deletePlayer1() {
    	Scanner sc=new Scanner(System.in);
       
            System.out.print("Enter player id : ");
            int id3 = sc.nextInt();
            sc.nextLine();
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps2 = con.prepareStatement("delete from  borrower where Id = ?");
                ps2.setInt(1, id3);

                int a = ps2.executeUpdate();

                if (a > 0) {
                    System.out.println("Player details deleted successfully!");
                } else {
                    System.out.println("Failed to delete Player detail.");
          
}}catch(Exception e)
{
	e.printStackTrace();
	
	
} 
                
    }
    public void DisplayMemberdetails() {
    	Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter player : ");
        String aname = sc.nextLine();
    	 Connection con=DBUtil.createConnection();
    	 try {
    	 PreparedStatement ps3 = con.prepareStatement("select *from player where player=?");
    	  ps3.setString(1,aname );
    	  ResultSet r=ps3.executeQuery();
           if(r.next())
    	 {
    		  System.out.println("Player Details");
    		  do {
    	
    		 System.out.println( "Id : " +r.getInt(1)+"\nAge : "+r.getInt(2)+"\nName : "+r.getString(3));
    		 System.out.println("----------------------");
      		
    		  }while(r.next());
    		  }
    	
    	  else {
	 System.out.println("Player details of selected author is not found");
		
 }
    	 }catch(SQLException e)
    	 {
    	 	e.printStackTrace();
    	 	
    	 	
    	 } 
    }
    public void DisplayScheduledetails() {
    	
    	 Connection con=DBUtil.createConnection();
    	 try {
    	 PreparedStatement ps4 = con.prepareStatement("select *from borrower ");
    	  ResultSet r=ps4.executeQuery();
    	 System.out.println("Displaying all the player details in the library");
    	 while(r.next())
    	 {
    		 System.out.println( "Id : " +r.getInt(1)+"\nName : "+r.getString(2)+"\nTime : "+r.getInt(3));
    		 System.out.println("Player name : "+r.getString(4));
    		 System.out.println("----------------------");
     		
    	 }
    	 } catch(Exception e)
    	 {
    	 	e.printStackTrace();
    	 	
    	 	
    	 } }
    	 public void DisplayScoredetails() {
    	    	
        	 Connection con=DBUtil.createConnection();
        	 try {
        	 PreparedStatement ps4 = con.prepareStatement("select *from score ");
        	  ResultSet r=ps4.executeQuery();
        	 System.out.println("Displaying all the player details in the library");
        	 while(r.next())
        	 {
        		 System.out.println( "Id : " +r.getInt(1)+"\nName : "+r.getString(2)+"\nScore : "+r.getInt(3));
        		 System.out.println("Player name : "+r.getString(4));
        		 System.out.println("----------------------");
         		
        	 }
        	 } catch(Exception e)
        	 {
        	 	e.printStackTrace();
        	 	
        	 	
        	 }
    }
}