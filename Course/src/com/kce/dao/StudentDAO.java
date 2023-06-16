package com.kce.dao;
import com.kce.bean.Student;
import com.kce.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void enrollStudent(Student student) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student (name, college_name, roll_no, course, email) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCollegeName());
            pstmt.setString(3, student.getRollNo());
            pstmt.setString(4, student.getCourse());
            pstmt.setString(5, student.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsByCourse(String courseCode) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE course = ?")) {
            pstmt.setString(1, courseCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String collegeName = rs.getString("college_name");
                    String rollNo = rs.getString("roll_no");
                    String course = rs.getString("course");
                    String email = rs.getString("email");
                    Student student = new Student(name, collegeName, rollNo, course, email);
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
