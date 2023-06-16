package com.kce.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

import com.kce.dao.Access;
import com.kce.util.DButil;

class InvalidStudentIdException extends Exception{
	public InvalidStudentIdException(String str) {
		super(str);
	}
}
public class StudentAccess {
	public void Student() {
	try {
	BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Department: ");
	String department=sc.readLine();
	System.out.println("Year: ");
	int year=Integer.parseInt(sc.readLine());
	System.out.println("enter BookSection:");
	String str=sc.readLine();
	if(str.equals("GeneralKnowledgeBooks")) {
		Connection con=DButil.getConnections();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from GeneralKnowledgeBooks");
		while(rs.next()) {
		System.out.println("Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));			}
	}
	else if(str.equals("ProgrammingBooks")) {
		Connection con=DButil.getConnections();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ProgrammingBooks");
		while(rs.next()) {
		System.out.println("Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));			}
	}
	else if(str.equals("ExamPreparationBooks")) {
		Connection con=DButil.getConnections();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ExamPreparationBooks");
		while(rs.next()) {
		System.out.println("Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));			
		}
	}
	
	else if(str.equals("ComicBooks")) {
		Connection con=DButil.getConnections();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ComicBooks");
		while(rs.next()) {
		System.out.println("Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));
		}
	}
	else {
		System.out.println("Enter valid BookSection");
	}
	
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	public void StudentPurchase() {
		try {
			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Book want to Purchase");
			System.out.println("BookId: ");
			int BookId=Integer.parseInt(sc.readLine());
			System.out.println("Enter section: ");
			String Section=sc.readLine();
			if(Section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("select * from GeneralKnowledgeBooks where BookId= ?");
			psmt.setInt(1, BookId);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				System.out.println("Successfully Purchased =>"+"Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));
			}
			}
			if(Section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("select * from ExamPreparationBooks where BookId= ?");
				psmt.setInt(1, BookId);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					System.out.println("Successfully Purchased =>"+"Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));
				}
				}
			else if(Section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("select * from ProgrammingBooks where BookId= ?");
				psmt.setInt(1, BookId);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					System.out.println("Successfully Purchased =>"+"Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));
				}
				}
			else if(Section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("select * from ComicBooks where BookId= ?");
				psmt.setInt(1, BookId);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					System.out.println("Successfully Purchased =>"+"Book Id: "+rs.getInt(1)+"--> "+"Title: "+rs.getString(2)+"--> "+"Author: "+rs.getString(3)+"--> "+"Quantity: "+rs.getInt(4));
				}
				}
			else {
				System.out.println("enter valid section");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void UpdateQuantity() {
         try {
        	 System.out.println("To updateQuantity");
			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter BookId");
			int BookId=Integer.parseInt(sc.readLine());
			System.out.println("Enter section: ");
			String Section=sc.readLine();
			if(Section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("update GeneralKnowledgeBooks set Quantity= Quantity - 1 where BookId= ?");
			psmt.setInt(1, BookId);
			psmt.executeUpdate();
			System.out.println("Successfully Quantity Updated");
			}
			else if(Section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ProgrammingBooks set Quantity= Quantity - 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Quantity Updated");
				}
			else if(Section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ExamPreparationBooks set Quantity= Quantity - 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Quantity Updated");
				}
			else if(Section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ComicBooks set Quantity= Quantity - 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Quantity Updated");
				}
			else {
				System.out.println("enter valid section");
			}
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
}
