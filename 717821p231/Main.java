package com.kce.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.kce.bean.ClassDemo;
import com.kce.dao.Method;
import com.kce.util.Dbutil;
class Main{
	public static void main(String[] args) throws SQLException, NumberFormatException, IOException
	{
		 Connection con;
		 String DB_URL = "jdbc:Mysql://localhost:3306/hospital_management";
		 String USER = "root";
		 String PASSWORD = "#Nesamani5";
		 try 
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			 Statement stmt = con.createStatement();
		 }
		 catch(ClassNotFoundException e)
		 {
			 System.out.println(e);
		 }
		Dbutil du=new Dbutil();
		du.getConnection();
		Method m=new Method();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int ch = -1;
		 while (ch != 0) 
		 {
			 System.out.println("\n----- HOSPITAL MANAGEMENT SYSTEM -----");
			 System.out.println("1. Add a new patient");
			 System.out.println("2. Update the patients details");
			 System.out.println("3. Delete a patient record");
			 System.out.println("4. Show All patients details");
			 System.out.println("5. Exit");
			 System.out.print("Enter your choice: ");
			 ch = Integer.parseInt(br.readLine());
			 switch (ch) {
			 case 1:
				 // Add a patient detail
				 System.out.print("enter the number of patients:");
				 int n=Integer.parseInt(br.readLine());
				 for(int i=0;i<n;i++)
				 {
					 System.out.print("Enter patient id: ");
					 int id = Integer.parseInt(br.readLine());
					 System.out.print("Enter patient name: ");
					 String name = br.readLine();
					 System.out.print("Enter patient weight: ");
					 int weight = Integer.parseInt(br.readLine());
					 System.out.print("Enter patient age: ");
					 int age = Integer.parseInt(br.readLine());
					 System.out.print("Enter consultant doctor: ");
					 String doctor = br.readLine();
					 System.out.print("Enter medical comments: ");
					 String comments = br.readLine();
					 ClassDemo cd1=new ClassDemo(id,name,weight,age,doctor,comments);
					 cd1.insert();
				 }
				 System.out.println("Patient name added successfully!");
				  break;
				  case 2:
					  System.out.println("1.Name");
					  System.out.println("2.Weight");
					  System.out.println("3.Age");
					  System.out.println("4.Doctor");
					  System.out.println("5.Comments");		
					  int a1=Integer.parseInt(br.readLine());
					  m.update(a1);
				    break;
				  case 3:
					  m.delete();
				  break;
				  case 4:
					  ClassDemo cd2=new ClassDemo();
					  cd2.show();
				  break;
			 }
		 }
	}
}