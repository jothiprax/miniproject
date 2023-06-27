package com.kce.service;

import java.sql.SQLException;
import java.util.List;
import com.kce.bean.Student;
import com.kce.dao.StudentDAO;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDAO studentDAO = new StudentDAO();
            Student student = new Student(1, "John Doe", 18, "Male", "123 Main St", "123-456-7890");
            studentDAO.addStudent(student);
            student.setName("John Smith");
            student.setAge(19);
            studentDAO.updateStudent(student);
            studentDAO.deleteStudent(1);
            List<Student> students = studentDAO.getAllStudents();
            for (Student s : students) {
                System.out.println(s.getName());
            }
            Student s = studentDAO.getStudentById(1);
            System.out.println(s.getName());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
