package com.kce.dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class insert {
 public void insertmethod() {
	 try {
			Scanner sc=new Scanner(System.in);
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Aish942004*");
		 String s="insert into student values(?,?,?,?,?);";
		 PreparedStatement pst=con.prepareStatement(s);
		 int id=sc.nextInt();
		 String name=sc.nextLine();
		 String dob=sc.nextLine();
		 String emailid=sc.nextLine();
		 String course=sc.nextLine();
		 pst.setInt(1,id);
		 pst.setString(2,name);
		 pst.setString(3,dob);
		 pst.setString(4,emailid);
		 pst.setString(5,course);
		 System.out.println("row inserted");
		}catch(Exception e) {
			System.out.println(e);
		}
 }
}
