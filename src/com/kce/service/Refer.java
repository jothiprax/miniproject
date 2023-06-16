package com.kce.service;
import com.kce.dao.Access;
import com.kce.dao.TestAccess;
import com.kce.util.*;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import com.kce.bean.*;
public class Refer{
	
	public void addBookDetails() throws ClassNotFoundException,SQLException,IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("BookId: ");
		int BookId= Integer.parseInt(br.readLine());
		System.out.println("Title: ");
		String Title =br.readLine();
		System.out.println("Author: ");
		String Author=br.readLine();
		System.out.println("Quantity: ");
		int Quantity=Integer.parseInt(br.readLine());
		System.out.println("Which section you want to insert: ");
		String section=br.readLine();
		try {
			if(section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("insert into GeneralKnowledgeBooks values(?,?,?,?)");
			psmt.setInt(1,BookId);
			psmt.setString(2, Title);
			psmt.setString(3, Author);
			psmt.setInt(4, Quantity);
			psmt.executeUpdate();
			System.out.println("Successfully Inserted");
			}
			else if(section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("insert into ProgrammingBooks values(?,?,?,?)");
				psmt.setInt(1,BookId);
				psmt.setString(2, Title);
				psmt.setString(3, Author);
				psmt.setInt(4, Quantity);
				psmt.executeUpdate();
				System.out.println("Successfully Inserted");
				}
			else if(section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("insert into ExamPreparationBooks values(?,?,?,?)");
				psmt.setInt(1,BookId);
				psmt.setString(2, Title);
				psmt.setString(3, Author);
				psmt.setInt(4, Quantity);
				psmt.executeUpdate();
				}
			else if(section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("insert into ComicBooks values(?,?,?,?)");
				psmt.setInt(1,BookId);
				psmt.setString(2, Title);
				psmt.setString(3, Author);
				psmt.setInt(4, Quantity);
				psmt.executeUpdate();
				System.out.println("Successfully Inserted");
				}
			else {
				System.out.println("Enter valid Section");
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
	
		}
	public void DeleteBookDetails() throws ClassNotFoundException,SQLException,IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("BookId: ");
		int BookId= Integer.parseInt(br.readLine());
		System.out.println("Which section you want to delete: ");
		String section=br.readLine();
		try {
			if(section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("delete from GeneralKnowledgeBooks where BookId= ?");
			psmt.setInt(1,BookId);
			psmt.executeUpdate();
			System.out.println("Successfully Deleted");
			}
			else if(section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("delete from ProgrammingBooks where BookId= ?");
				psmt.setInt(1,BookId);
				psmt.executeUpdate();
				System.out.println("Successfully deleted");
				}
			else if(section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("delete from ExamPreparationBooks where BookId=?");
				psmt.executeUpdate();
				System.out.println("Successfully Deleted");
				}
			else if(section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("delete from ComicBooks where BookId=?");
				psmt.setInt(1,BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Deleted");
				}
			else {
				System.out.println("Enter valid Section");
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
	
		}
	public void UpdateBookDetails() throws ClassNotFoundException,SQLException,IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("BookId: ");
		int BookId= Integer.parseInt(br.readLine());
		System.out.println("Title: ");
		String Title =br.readLine();
		System.out.println("Author: ");
		String Author=br.readLine();
		System.out.println("Quantity: ");
		int Quantity=Integer.parseInt(br.readLine());
		System.out.println("Which section you want to Update: ");
		String section=br.readLine();
		try {
			if(section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("update GeneralKnowledgeBooks set Title =?,Author =?,Quantity =? where BookId=?");
			psmt.setString(1, Title);
			psmt.setString(2, Author);
			psmt.setInt(3, Quantity);
			psmt.setInt(4,BookId);
			psmt.executeUpdate();
			System.out.println("Successfully Updated");
			}
			else if(section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ProgrammingBooks set Title =?,Author =?,Quantity =? where BookId=?");
				psmt.setString(1, Title);
				psmt.setString(2, Author);
				psmt.setInt(3, Quantity);
				psmt.setInt(4,BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Updated");
				}
			else if(section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ExamPreparatinBooks set Title =?,Author =?,Quantity =? where BookId=?");
				psmt.setString(1, Title);
				psmt.setString(2, Author);
				psmt.setInt(3, Quantity);
				psmt.setInt(4,BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Updated");
				}
			else if(section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ComicBooks set Title =?,Author =?,Quantity =? where BookId=?");
				psmt.setString(1, Title);
				psmt.setString(2, Author);
				psmt.setInt(3, Quantity);
				psmt.setInt(4,BookId);
				psmt.executeUpdate();
				System.out.println("Successfully Updated");
		}
		}
			catch(Exception e) {
				System.out.println(e);
			}
	
		}
	
	public void UpdateQuantity()  {
        try {
			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("BookId: ");
			int BookId=Integer.parseInt(sc.readLine());
			System.out.println("Enter section: ");
			String Section=sc.readLine();
			if(Section.equals("GeneralKnowledgeBooks")) {
			Connection con=DButil.getConnections();
			PreparedStatement psmt=con.prepareStatement("update GeneralKnowledgeBooks set Quantity= Quantity + 1 where BookId= ?");
			psmt.setInt(1, BookId);
			psmt.executeUpdate();
			}
			else if(Section.equals("ProgrammingBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ProgrammingBooks set Quantity= Quantity + 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				}
			else if(Section.equals("ExamPreparationBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ExamPreparationBooks set Quantity= Quantity + 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				}
			else if(Section.equals("ComicBooks")) {
				Connection con=DButil.getConnections();
				PreparedStatement psmt=con.prepareStatement("update ComicBooks set Quantity= Quantity + 1 where BookId= ?");
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				}
			else {
				System.out.println("enter valid section");
			}
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}


