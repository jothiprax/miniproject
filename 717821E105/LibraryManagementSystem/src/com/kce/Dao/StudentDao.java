package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.kce.service.StudentDetails;
import com.kce.util.DButil;
public class StudentDao {

	public static void addStudent(StudentDetails s) throws InvalidDateException  {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?)");

			psmt.setInt(1, s.getStudentId());
			psmt.setString(2, s.getStudentName());
			psmt.setInt(3, s.getBookId());


			psmt.setString(4, s.getIssueDate());

			psmt.setString(5, s.getReturnDate());
			int affectedRows = psmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Student details added successfully...");
			} else {
				System.out.println("Failed to add student details...");
			}

			psmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void displayData() {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement psmt = con.prepareStatement("SELECT StudentId, StudentName, BookId, IssueDate, ReturnDate FROM student");
			ResultSet rs = psmt.executeQuery();
			System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "StudentId", "StudentName", "BookId",
					"IssueDate", "ReturnDate");
			while (rs.next()) {
				int studentId = rs.getInt("StudentId");
				String studentName = rs.getString("StudentName");
				int bookId = rs.getInt("BookId");
				String issueDate = rs.getString("IssueDate");
				String returnDate = rs.getString("ReturnDate");

				System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", studentId, studentName, bookId,
						issueDate, returnDate);
			}

			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void deleteDetails() {
		try {
			Connection con = DButil.getConnection();
			Statement st = con.createStatement();
			int affectedRows = st.executeUpdate("TRUNCATE TABLE student");
			if (affectedRows > 0) {
				System.out.println("Details are deleted successfully!");
			} else {
				System.out.println("Failed to delete details...");
			}

			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}


