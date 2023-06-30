package com.kce.student.dao;

import com.kce.student.bean.Student;
import com.kce.student.bean.UndergraduateStudent;
import com.kce.student.exception.StudentNotFoundException;
import com.kce.student.util.DBUtil;

import java.sql.*;

// Data Access Object class for student management
public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public void addStudent(Student student) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO students (student_id, name, age) VALUES (?, ?, ?)");
        statement.setInt(1, student.getStudentId());
        statement.setString(2, student.getName());
        statement.setInt(3, student.getAge());
        statement.executeUpdate();
        System.out.println("Student added successfully!");
    }

    public void updateStudent(Student student) throws SQLException, StudentNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE students SET name = ?, age = ? WHERE student_id = ?");
        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setInt(3, student.getStudentId());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 0) {
            throw new StudentNotFoundException("Student not found!");
        }
        System.out.println("Student updated successfully!");
    }

    public void deleteStudent(int studentId) throws SQLException, StudentNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM students WHERE student_id = ?");
        statement.setInt(1, studentId);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 0) {
            throw new StudentNotFoundException("Student not found!");
        }
        System.out.println("Student deleted successfully!");
    }

    public void displayAllStudents() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Student ID: " + studentId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println();
        }
    }
}
