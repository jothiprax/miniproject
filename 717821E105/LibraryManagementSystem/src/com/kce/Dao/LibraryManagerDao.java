package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.bean.LibraryManager;
import com.kce.util.DButil;

public class LibraryManagerDao {
	static Scanner sc = new Scanner(System.in);

	public static void InsertData(int lib) {
		try {
			LibraryManager[] a = new LibraryManager[lib];

			for (int i = 0; i < lib; i++) {
				System.out.println("Enter the BookId");
				int id = sc.nextInt();

				System.out.println("Enter the BookName");
				String name = sc.next();

				System.out.println("Enter the Author");
				String author = sc.next();

				System.out.println("Enter the Genre");
				String genre = sc.next();

				a[i] = new LibraryManager(id, name, author, genre);
			}

			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("INSERT INTO LibraryManager VALUES (?,?,?,?)");

			for (int i = 0; i < lib; i++) {
				psmt.setInt(1, a[i].getBookId());
				psmt.setString(2, a[i].getBookName());
				psmt.setString(3, a[i].getAuthor());
				psmt.setString(4, a[i].getGenre());
				psmt.executeUpdate();
			}

			System.out.println("Data inserted successfully!!!");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void updateData(int bookId, String newGenre) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("UPDATE LibraryManager SET genre = ? WHERE bookId = ?");
			psmt.setString(1, newGenre);
			psmt.setInt(2, bookId);
			int rows = psmt.executeUpdate();

			if (rows > 0) {
				System.out.println("Data updated successfully...");
			} else {
				System.out.println("No record found with the provided BookId!!!");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void deleteData(int bookId) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("DELETE FROM LibraryManager WHERE bookId = ?");
			psmt.setInt(1, bookId);
			int rows = psmt.executeUpdate();

			if (rows > 0) {
				System.out.println("Data deleted successfully...");
			} else {
				System.out.println("No record found with the provided BookId!!!");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void displayData() {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM LibraryManager");
			ResultSet rs = psmt.executeQuery();
			System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "BookId", "BookName", "Author", "Genre");
			while (rs.next()) {
				int bookId = rs.getInt("bookId");
				String bookName = rs.getString("bookName");
				String author = rs.getString("author");
				String genre = rs.getString("genre");

				System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", bookId, bookName, author, genre);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}