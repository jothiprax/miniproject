package com.kce.bean;
import java.sql.*;
public class student{
	public void print() {
         try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Aish942004*");
        	 Statement st=con.createStatement();
        	 ResultSet rs=st.executeQuery("select * from student");
        	 while (rs.next()) {
                 
                 int id = rs.getInt(1);
                 String name = rs.getString(2);
                 String dob = rs.getString(3);
                 String course = rs.getString(5);
                 String email= rs.getString(4);
                 

                
                 System.out.println("ID: " + id);
                 System.out.println("Name: " + name);
                 System.out.println("dob: " + dob);
                 System.out.println("course: " + course);
                 System.out.println("email: " + email);
                 
                 System.out.println("--------------------");
             }

         }
         catch (Exception e) {
        	 System.out.println(e);
         }
	}
}
 
