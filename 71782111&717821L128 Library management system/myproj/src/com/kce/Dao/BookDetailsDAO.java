
package com.kce.Dao;
import com.kce.bean.BookDetails;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class OverdueException extends Exception {

	public OverdueException(String message) {
        super(message);
    }
}

public class BookDetailsDAO {
	static Scanner sc = new Scanner(System.in);


	public static void insert(int a) throws ClassNotFoundException {
		try {
			BookDetails[] arr = new BookDetails[a];
			for (int i = 0; i < a; i++) {
				System.out.println("Enter book id: ");
				int bookid = sc.nextInt();
				System.out.println("Enter the book name: ");
				String bookname = sc.next();
				System.out.println("Enter the author: ");
				String author = sc.next();
				System.out.println("Enter the rate: ");
				double rate = sc.nextInt();
	
				arr[i] = new BookDetails(bookid, bookname,author,rate);
			}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			
			PreparedStatement stmt = con.prepareStatement("insert into books values(?,?,?,?)");
			for (int i = 0; i < a; i++) {
				stmt.setInt(1, arr[i].getBookid());
				stmt.setString(2, arr[i].getBookname());
				stmt.setString(3, arr[i].getAuthor());
				stmt.setDouble(4,  arr[i].getRate());
				stmt.executeUpdate();
			}
					
			System.out.println("Data collected successfully");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	



	public static void update() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("UPDATE books SET author = ? WHERE bookname = ?");
			System.out.println("Enter book name: ");
			String bookname = sc.next();
			System.out.println("Enter the author: ");
			String author = sc.next();
			stmt.setString(1, author);
			stmt.setString(2, bookname);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Update successful");
			} else {
				System.out.println("No records found for the given book id");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void delete() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM books WHERE bookid = ?");
			System.out.println("Enter book id: ");
			int bookid = sc.nextInt();
			stmt.setInt(1, bookid);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Delete successful");
			} else {
				System.out.println("No records found for the given book id");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void displayTable() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM books");
			ResultSet rs = stmt.executeQuery();

			System.out.println("Book Details:");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "BookId", "BookName", "Author","rate");
			
			while (rs.next()) {

				System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}

