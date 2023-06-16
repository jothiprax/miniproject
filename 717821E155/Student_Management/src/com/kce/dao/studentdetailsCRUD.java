package com.kce.dao;

import com.kce.util.DBUtil;
import com.kce.util.InvalidPhnoException;
import com.kce.bean.buspass;
import com.kce.bean.studentdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class studentdetailsCRUD {
	
	static Scanner sc=new Scanner(System.in);
	public static void create() throws SQLException, ClassNotFoundException{
		Connection con=DBUtil.getConnection();
		PreparedStatement stmt=con.prepareStatement("create table STUDENTINFORMATION(name varchar(20),id number,year int,gender varchar(10),phno varchar(10),emailid varchar(20))");
		stmt.executeUpdate();
	
	}
	public static void insert(int a) throws SQLException, ClassNotFoundException {
		try {
		studentdetails[] arr=new studentdetails[a];
		for(int i=0;i<a;i++) {
			System.out.println("Enter student name: ");
			String name=sc.next();
			System.out.println("Enter student id: ");
			int id=sc.nextInt();
			System.out.println("Enter student year: ");
			int year=sc.nextInt();
			System.out.println("Enter student gender: ");
			String gender=sc.next();
			System.out.println("Enter student phno: ");
			String phno=sc.next();
			validatePhoneNumber(phno);
			System.out.println("Enter student EmailID: ");
			String emailid=sc.next();
			arr[i]=new studentdetails(name,id,year,gender,phno,emailid);
		}
		Connection con=DBUtil.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into STUDENTINFORMATION values(?,?,?,?,?,?)");
	    for(int i=0;i<a;i++) {
		stmt.setString(1,arr[i].getname());
		stmt.setInt(2,arr[i].getid());
		stmt.setInt(3, arr[i].getyear());
		stmt.setString(4,arr[i].getgender());
		stmt.setString(5,arr[i].getphno());
		stmt.setString(6, arr[i].getemailid());
		stmt.executeUpdate();
	}
	System.out.println("Updated successfully...");
	}
		catch(SQLException e) {
			System.out.println(e);
		}catch(InvalidPhnoException e) {
		System.out.println(e.getMessage());
		}
	}
	public static void validatePhoneNumber(String phoneNumber) throws InvalidPhnoException {
		        String phoneRegex = "^[0-9]{10}$";

		        if (!phoneNumber.matches(phoneRegex)) {
		            throw new InvalidPhnoException("Invalid phone number.");
		        }
		    }
	
	

	
	public static void update() throws ClassNotFoundException {
		try {
			Connection con =DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement("UPDATE STUDENTINFORMATION SET name=? WHERE id=?");
			System.out.println("Enter id: ");
			int id=sc.nextInt();
			System.out.println("Enter name: ");
			String name=sc.next();
		    stmt.setString(1,name);
		    stmt.setInt(2,id);
		int rowsAffected=stmt.executeUpdate();
		
		if(rowsAffected>0) 
		{
			System.out.println("UPDATES SUCCESSFULLY...");
		}    
		else 
		{
			System.out.println("no records found!"); 
		}
		}catch(SQLException e) 
		{
			System.out.println("Error:"+e.getMessage());
		}
	}
	
	
	public static void delete() throws ClassNotFoundException {
		try {
			Connection con =DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement("DELETE FROM STUDENTINFORMATION WHERE id=?");
			System.out.println("Enter STUDENT ID:");
			int id =sc.nextInt();
			stmt.setInt(1,id);
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("DELETED SUCCESSFULLY...");
			}
			else {
				System.out.println("no records found for  delete!");
			}
			}
			catch(SQLException e) {
				System.out.println("Error:"+e.getMessage());
			}
			}
		
		public static void display() throws ClassNotFoundException {
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENT");
		ResultSet rs=stmt.executeQuery();
		System.out.println("Student Details:");
		System.out.println("--------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s |  %-20s | %-20s |%n", "name", "id", "year","gender","phno","emailid");
		while(rs.next()) {
			System.out.printf("| %-20s | %-20s |  %-20s | %-20s | %-20s | %-20s|%n", rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
		}
		rs.close();
		}
		catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		
	}
		
		public static void createinfo() throws SQLException, ClassNotFoundException{
			Connection con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement("create table BUSPASS_INFO(id number,busno number,fees number,emailid varchar(20))");
			stmt.executeUpdate();
		
		}
		public static void stud(buspass bs) throws ClassNotFoundException,SQLException {
			try {
				Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement("INSERT INTO BUSPASS_INFO(id,fees,source,busno)VALUES(?,?,?,?)"); 
			stmt.setInt(1, bs.getid());
			stmt.setInt(2, bs.getbusno());
			stmt.setDouble(3, bs.getfees());
		
			stmt.setString(4, bs.getsource());
			
			System.out.println("Details inserted!");
			}
			catch(SQLException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		public static void deleteInfo() throws ClassNotFoundException,SQLException {
			try {
				Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement("TRUNCATE TABLE BUSPASS_INFO");
				stmt.executeUpdate();
				System.out.print("Informations deleted..");
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		}
		
		public static void displayInfo() throws ClassNotFoundException,SQLException  {
			try {
				Connection con=DBUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement("SELECT * FROM BUSPASS_INFO");
				ResultSet rs=stmt.executeQuery();
				
				System.out.println("Student Informations");
				System.out.println("--------------------------------------------------");
				System.out.printf("| %-20s | %-20s |  %-20s | %-20s |%n", "id","busno","fees", "source");
				while(rs.next()) {
					System.out.printf("| %-20s | %-20s |  %-20s | %-20s|%n", rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
				}
				rs.close();
				}
				catch(SQLException e) {
					System.out.println("Error: "+e.getMessage());
				}
				
			}
	
	
}
