package com.kce.student;

import com.kce.student.bean.Student;
import com.kce.student.bean.UndergraduateStudent;
import com.kce.student.exception.StudentNotFoundException;
import com.kce.student.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter major (for undergraduate student): ");
                    String major = scanner.nextLine();
                    Student student;
                    if (major.isEmpty()) {
                        student = new Student(studentId, name, age);
                    } else {
                        student = new UndergraduateStudent(studentId, name, age, major);
                    }
                    try {
                        studentService.addStudent(student);
                    } catch (SQLException e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    student = new Student(studentId, name, age);
                    try {
                        studentService.updateStudent(student);
                    } catch (SQLException e) {
                        System.out.println("Database error: " + e.getMessage());
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    try {
                        studentService.deleteStudent(studentId);
                    } catch (SQLException e) {
                        System.out.println("Database error: " + e.getMessage());
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        studentService.displayAllStudents();
                    } catch (SQLException e) {
                        System.out.println("Database error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
