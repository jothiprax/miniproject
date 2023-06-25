package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// Base class representing a student
class Student {
    protected int studentId;
    protected String name;
    protected double grades;

    // Constructor
    public Student(int studentId, String name, double grades) {
        this.studentId = studentId;
        this.name = name;
        this.grades = grades;
    }

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }
}

// Custom exception class for handling invalid student ID
class InvalidStudentIdException extends Exception {
    public InvalidStudentIdException(String message) {
        super(message);
    }
}
// Class for managing student data
class StudentManagementSystem {
    private Connection connection;

    // Constructor
    public StudentManagementSystem(Connection connection) {
        this.connection = connection;
    }

    // Create a new student record
    public void createStudent(Student student) throws SQLException {
        String query = "INSERT INTO students(student_id, name, grades) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, student.getStudentId());
        statement.setString(2, student.getName());
        statement.setDouble(3, student.getGrades());
        statement.executeUpdate();
    }

    // Read student data
    public void readStudent(int studentId) throws SQLException, InvalidStudentIdException {
        String query = "SELECT * FROM students WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
        	int sid=resultSet.getInt("student_Id");
            String name = resultSet.getString("name");
            double grades = resultSet.getDouble("grades");
            System.out.format("%-20S%-20S%-20S\n","Student ID","Name","Grades");
            System.out.println("-----------------------------------------------");
            System.out.format("%-20S%-20S%-20S\n",sid, name,grades);
            System.out.println("-----------------------------------------------");
        } else {
            throw new InvalidStudentIdException("Student ID not found.");
        }
    }

    // Update student data
    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET name = ?, grades = ? WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setDouble(2, student.getGrades());
        statement.setInt(3, student.getStudentId());
        statement.executeUpdate();
    }

    // Delete student record
    public void deleteStudent(int studentId) throws SQLException {
        String query = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentId);
        statement.executeUpdate();
    }
}
