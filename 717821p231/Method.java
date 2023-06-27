package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Method {
	public void update(int a) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Connection con = null;
			String DB_URL = "jdbc:mysql://localhost:3306/hospital_management";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, "root", "#Nesamani5");
			System.out.println("Enter the id to be updated=");
			String id1=sc.nextLine();
			if(a==1)
			{
				System.out.println("Enter the new name=");
				String n1=sc.nextLine();
				PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET name="+n1+" where id="+id1+";");
				int rowsUpdated = updateStmt.executeUpdate();
				if (rowsUpdated > 0) 
				{
					System.out.println("Name updated successfully!");
				} 
				else 
				{
					System.out.println("Patient id not found!");
				}
			}
			else if(a==2)
			{
				System.out.println("Enter the new weight=");
				String w1=sc.nextLine();
				PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET weight="+w1+" where id="+id1+";");
				int rowsUpdated = updateStmt.executeUpdate();
				if (rowsUpdated > 0) 
				{
					System.out.println("Weight updated successfully!");
				} 
				else 
				{
					System.out.println("Patient id not found!");
				}
			}
			else if(a==3)
			{
				System.out.println("Enter the new age=");
				String a1=sc.nextLine();
				PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET age="+a1+" where id="+id1+";");
				int rowsUpdated = updateStmt.executeUpdate();
				if (rowsUpdated > 0) 
				{
					System.out.println("Age updated successfully!");
				} 
				else 
				{
					System.out.println("Patient id not found!");
				}
			}
			else if(a==4)
			{
				System.out.println("Enter the new doctor=");
				String d1=sc.nextLine();
				PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET doctor="+d1+" where id="+id1+";");
				int rowsUpdated = updateStmt.executeUpdate();
				if (rowsUpdated > 0) 
				{
					System.out.println("Doctor updated successfully!");
				} 
				else 
				{
					System.out.println("Patient id not found!");
				}
			}
			else if(a==5)
			{
				System.out.println("Enter the new comments=");
				String c1=sc.nextLine();
				PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET comments="+c1+" where id="+id1+";");
				int rowsUpdated = updateStmt.executeUpdate();
				if (rowsUpdated > 0) 
				{
					System.out.println("Comments updated successfully!");
				} 
				else 
				{
					System.out.println("Patient id not found!");
				}
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
	public void delete() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Connection con = null;
			String DB_URL = "jdbc:mysql://localhost:3306/hospital_management";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, "root", "#Nesamani5");
			System.out.println("Enter the id to be deleted=");
			String id2=sc.nextLine();
			String delQuery = "DELETE FROM hospital_management WHERE id = ?";
			PreparedStatement deleteStmt = con.prepareStatement(delQuery);
		    deleteStmt.setString(1, id2);
			int rowsDeleted = deleteStmt.executeUpdate();
			if (rowsDeleted > 0) 
			{
				System.out.println("Patient record deleted successfully!");
			} 
			else 
			{
			System.out.println("Patient id found!");
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
