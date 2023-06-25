package com.kce.dao;

import com.kce.bean.Student;
import com.kce.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(Student student) {
        String query = "INSERT INTO students (student_id, student_name) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getStudentName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}