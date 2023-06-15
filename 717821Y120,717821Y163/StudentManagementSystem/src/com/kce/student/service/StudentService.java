package com.kce.student.service;

import com.kce.student.bean.Student;
import com.kce.student.bean.UndergraduateStudent;
import com.kce.student.dao.StudentDAO;
import com.kce.student.exception.StudentNotFoundException;

import java.sql.SQLException;

// Service class for student management
public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) throws SQLException {
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) throws SQLException, StudentNotFoundException {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) throws SQLException, StudentNotFoundException {
        studentDAO.deleteStudent(studentId);
    }

    public void displayAllStudents() throws SQLException {
        studentDAO.displayAllStudents();
    }
}
