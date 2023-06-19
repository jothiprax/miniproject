package com.studentinfosystem.service;

import java.util.List;

import com.studentinfosystem.bean.Student;
import com.studentinfosystem.dao.StudentDAO;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
