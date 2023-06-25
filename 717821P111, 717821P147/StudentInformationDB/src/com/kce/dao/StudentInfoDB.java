package com.kce.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bean.Student;

public class StudentInfoDB {
	private Connection con;

	public StudentInfoDB() throws SQLException {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "21p111");
	}

	public void createDetails(Student student) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into students values(?,?,?)");
		ps.setString(1, student.getName());
		ps.setInt(2, student.getStudentID());
		ps.setString(3, student.getGrade());
		ps.executeQuery();
	}

	public void updateDetails(Student student) throws SQLException {
		PreparedStatement ps = con.prepareStatement("update students set name=? ,grade=? where studentID=?");
		ps.setString(1, student.getName());
		ps.setString(2, student.getGrade());
		ps.setInt(3, student.getStudentID());
		ps.executeQuery();
	}

	public void deleteDetails(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("delete from students where studentID=?");
		ps.setInt(1, id);
		ps.executeQuery();
	}

	public void getStudentById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from students where studentID = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
		}
	}

	public void getAllSutdent() throws SQLException {
		String query = "select * from students";
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
			}
		}
	}
}

