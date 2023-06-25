package com.kce.service;

import com.kce.bean.Student;
import com.kce.bean.Result;
import com.kce.dao.StudentDAO;
import com.kce.dao.ResultDAO;

import java.util.List;
import java.util.Scanner;

public class ResultManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();
    private static ResultDAO resultDAO = new ResultDAO();

    public static void main(String[] args) {
        System.out.println("Welcome to Result Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Add result");
            System.out.println("3. Display student results");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addResult();
                    break;
                case 3:
                    displayStudentResults();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        studentDAO.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void addResult() {
        System.out.print("Enter result ID: ");
        int resultId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Result result = new Result(resultId, studentId, subjectName, marks);
        resultDAO.addResult(result);
        System.out.println("Result added successfully.");
    }

    private static void displayStudentResults() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        List<Result> results = resultDAO.getResultsByStudentId(studentId);

        if (results.isEmpty()) {
            System.out.println("No results found for the given student ID.");
        } else {
            System.out.println("Results for Student ID " + studentId + ":");
            for (Result result : results) {
                System.out.println("Result ID: " + result.getResultId());
                System.out.println("Subject Name: " + result.getSubjectName());
                System.out.println("Marks: " + result.getMarks());
                System.out.println("---------------------------");
            }
        }
    }
}
