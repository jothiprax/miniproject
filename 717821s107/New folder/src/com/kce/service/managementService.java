package com.kce.service;

import com.kce.bean.Student;
import com.kce.bean.Teacher;
import com.kce.dao.StudentDAO;
import com.kce.dao.TeacherDAO;

import java.util.Scanner;

public class managementService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Add student");
        System.out.println("2. Add teacher");
        System.out.println("3. Get student by ID");
        System.out.println("4. Get teacher by ID");
        System.out.println("5. Update student");
        System.out.println("6. Update teacher");
        System.out.println("7. Delete student");
        System.out.println("8. Delete teacher");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addStudent(scanner);
                break;
            case 2:
                addTeacher(scanner);
                break;
            case 3:
                getStudentById(scanner);
                break;
            case 4:
                getTeacherById(scanner);
                break;
            case 5:
                updateStudent(scanner);
                break;
            case 6:
                updateTeacher(scanner);
                break;
            case 7:
                deleteStudent(scanner);
                break;
            case 8:
                deleteTeacher(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Clear the newline character

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        Student student = new Student(id, name, age);
        StudentDAO.addStudent(student);

        System.out.println("Student added successfully!");
    }

    private static void addTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Clear the newline character

        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();

        System.out.print("Enter teacher subject: ");
        String subject = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, subject);
        TeacherDAO.addTeacher(teacher);

        System.out.println("Teacher added successfully!");
    }

    private static void getStudentById(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = StudentDAO.getStudentById(id);

        if (student != null) {
            System.out.println("Student details:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void getTeacherById(Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();

        Teacher teacher = TeacherDAO.getTeacherById(id);

        if (teacher != null) {
            System.out.println("Teacher details:");
            System.out.println("ID: " + teacher.getId());
            System.out.println("Name: " + teacher.getName());
            System.out.println("Subject: " + teacher.getSubject());
        } else {
            System.out.println("Teacher not found!");
        }
    }
    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Clear the newline character

        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new student age: ");
        int age = scanner.nextInt();

        Student updatedStudent = new Student(id, name, age);
        StudentDAO.updateStudent(updatedStudent);

        System.out.println("Student updated successfully!");
    }

    private static void updateTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // Clear the newline character

        System.out.print("Enter new teacher name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new teacher subject: ");
        String subject = scanner.nextLine();

        Teacher updatedTeacher = new Teacher(id, name, subject);
        TeacherDAO.updateTeacher(updatedTeacher);

        System.out.println("Teacher updated successfully!");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        StudentDAO.deleteStudent(id);

        System.out.println("Student deleted successfully!");
    }

    private static void deleteTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();

        TeacherDAO.deleteTeacher(id);

        System.out.println("Teacher deleted successfully!");
    }
}
    
