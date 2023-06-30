package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kce.bean.Student;
import com.kce.util.DBUtil;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public void addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into students(name, age, gender, address, phone) values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getGender());
        preparedStatement.setString(4, student.getAddress());
        preparedStatement.setString(5, student.getPhone());
        preparedStatement.executeUpdate();
    }

    public void updateStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update students set name=?, age=?, gender=?, address=?, phone=? where id=?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getGender());
        preparedStatement.setString(4, student.getAddress());
        preparedStatement.setString(5, student.getPhone());
        preparedStatement.setInt(6, student.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from students");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            Student student = new Student(id, name, age, gender, address, phone);
            students.add(student);
        }
        return students;
    }

    public Student getStudentById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            Student student = new Student(id, name, age, gender, address, phone);
            return student;
        }
        return null;
    }
}
