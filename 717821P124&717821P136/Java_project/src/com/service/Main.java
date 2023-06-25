package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/Student"; // Replace with your MySQL database URL
        String username = "root"; // Replace with your MySQL username
        String password = "122163"; // Replace with your MySQL password

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            StudentManagementSystem sms = new StudentManagementSystem(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Create student");
                System.out.println("2. Read student");
                System.out.println("3. Update student");
                System.out.println("4. Delete student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int studentId = scanner.nextInt();
                        System.out.print("Enter student name: ");
                        scanner.nextLine(); // Consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter student grades: ");
                        int grades = scanner.nextInt();

                        Student newStudent = new Student(studentId, name, grades);
                        sms.createStudent(newStudent);
                        System.out.println("Student created successfully.");
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        int readStudentId = scanner.nextInt();
                        sms.readStudent(readStudentId);
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int updateStudentId = scanner.nextInt();
                        System.out.print("Enter updated name: ");
                        scanner.nextLine(); // Consume newline
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter updated grades: ");
                        double updatedGrades = scanner.nextDouble();

                        Student updatedStudent = new Student(updateStudentId, updatedName, updatedGrades);
                        sms.updateStudent(updatedStudent);
                        System.out.println("Student updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter student ID: ");
                        int deleteStudentId = scanner.nextInt();
                        sms.deleteStudent(deleteStudentId);
                        System.out.println("Student deleted successfully.");
                        break;
                    case 5:
                        connection.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidStudentIdException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
