package com.studentinfosystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentinfosystem.bean.Student;
import com.studentinfosystem.utils.DBUtils;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        connection = DBUtils.getConnection(); // Assuming you have a DBUtils class for database connectivity.
    }

    // Method to insert a new student record into the database
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all student records from the database
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                Student student = new Student(id, name, age, grade);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
