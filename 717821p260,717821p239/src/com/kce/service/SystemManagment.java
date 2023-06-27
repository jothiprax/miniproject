package com.kce.service;
import java.util.*;

import com.kce.util.UserException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
public class SystemManagment{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vinith","root","root");
		PreparedStatement smt=con.prepareStatement("insert into student values(?,?,?,?)");
		System.out.println("1.Student");
		System.out.println("2.Teacher");
		System.out.println("Choice: ");
		int choice=sc.nextInt(); 
		if(choice==1)
		{
			System.out.println("Enter the Roll Number:");
			int Rollno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Password:");
			String date=sc.nextLine();
			int count=0;
			PreparedStatement smt2=con.prepareStatement("select * from student where studentId=? && dob=?");
			smt2.setInt(1, Rollno);
			smt2.setString(2, date);
			ResultSet rst=smt2.executeQuery();
			while(rst.next()) {
			 count++;
			}
			if(count==0)
			{
				System.out.println("User not exist");
			}
			
			else
			{
				rst=smt2.executeQuery();
				while(rst.next()) {
					System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3));
					}
			}
			
			
		}
		else
		{
			System.out.println("Enter Number of Student:");
			int n=sc.nextInt();
		  for(int i=0;i<n;i++)
		{
			System.out.println("Student ID:");
			int id=sc.nextInt();
			sc.nextLine();
			if(id>=100)
			{
				throw new UserException("Wrong user id ");
			}
			System.out.println("Student Name:");
			String name=sc.nextLine();
			System.out.println("Student Mark:");
			int mark=sc.nextInt();
			
			String grade=null;
			if(mark>=90)
			{
				grade ="A";
			}
			else if(mark>=80)
			{
				grade ="B";
			}
			else if(mark>=70)
			{
				grade ="C";
			}
			else if(mark>=60)
			{
				grade ="D";
			}
			else
			{
				System.out.println("Failed in Course");
			}
			if(!grade.equals("A") && !grade.equals("B") && !grade.equals("C") && !grade.equals("D"))
			{
				throw new UserException("Invalid Grade");
			}
			System.out.println("Date of Birth:");
			sc.nextLine();
			
			String DOB=sc.nextLine();
			smt.setInt(1,id);
			smt.setString(2,name);
			smt.setString(3,grade);
			smt.setString(4, DOB);
			smt.executeUpdate();
		}
		PreparedStatement smt1=con.prepareStatement("select * from student");
		ResultSet rs=smt1.executeQuery();
		System.err.println("Student details!!!....");
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
	}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}

