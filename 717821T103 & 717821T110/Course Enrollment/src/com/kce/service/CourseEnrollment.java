// com.kce.service.CourseEnrollmentApp.java
package com.kce.service;

import com.kce.bean.Course;
import com.kce.bean.Student;
import com.kce.dao.CourseDAO;
import com.kce.dao.StudentDAO;

import java.util.List;
import java.util.Scanner;

public class CourseEnrollment{
    private Scanner scanner;
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;

    public CourseEnrollment() {
        scanner = new Scanner(System.in);
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
    }

    public void mainmenu() {
        int choice;
        do {
            System.out.println("\n*--------------------------------Course Enrollment System------------------------------------*\n");
            System.out.println("1) Manage Courses");
            System.out.println("2) Manage Students");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("\n----------------------------------------------------------------------------------------");
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageCourses();
                    break;
                case 2:
                    manageStudents();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private void manageCourses() {
        int choice;
        do {
            System.out.println("Course Management");
            System.out.println("1) Add Course");
            System.out.println("2) Update Course");
            System.out.println("3) Delete Course");
            System.out.println("4) View Courses");
            System.out.println("5) Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    updateCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    viewCourses();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    mainmenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private void addCourse() {
        System.out.println("\nAdd a Course");
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Start Date: ");
        String startDate = scanner.nextLine();
        System.out.print("Enter End Date: ");
        String endDate = scanner.nextLine();

        Course course = new Course(courseName, courseCode, startDate, endDate);
        courseDAO.addCourse(course);

        System.out.println("Course added successfully!");
    }

    private void updateCourse() {
        System.out.println("\nUpdate a Course");
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseDAO.getCourseByCode(courseCode);
        if (course != null) {
            System.out.println("Current Course Details:");
            System.out.println(course);

            System.out.print("Enter New Course Name (Press Enter to skip): ");
            String newCourseName = scanner.nextLine();
            System.out.print("Enter New Start Date (Press Enter to skip): ");
            String newStartDate = scanner.nextLine();
            System.out.print("Enter New End Date (Press Enter to skip): ");
            String newEndDate = scanner.nextLine();

            if (!newCourseName.isEmpty()) {
                course.setCourseName(newCourseName);
            }
            if (!newStartDate.isEmpty()) {
                course.setStartDate(newStartDate);
            }
            if (!newEndDate.isEmpty()) {
                course.setEndDate(newEndDate);
            }

            courseDAO.updateCourse(course);
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Course not found!");
        }
    }

    private void deleteCourse() {
        System.out.println("\nDelete a Course");
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseDAO.getCourseByCode(courseCode);
        if (course != null) {
            System.out.println("Are you sure you want to delete the following course?");
            System.out.println(course);
            System.out.print("Enter 'yes' to confirm deletion: ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                courseDAO.deleteCourse(courseCode);
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Course not found!");
        }
    }

    private void viewCourses() {
        System.out.println("\nView All Courses");
        List<Course> courses = courseDAO.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found!");
        } else {
            for (Course course : courses) {
                System.out.println(course);
                System.out.println();
            }
        }
    }

    private void manageStudents() {
        int choice;
        do {
            System.out.println("Student Management");
            System.out.println("1) View Courses");
            System.out.println("2) Enroll in Course");
            System.out.println("3) Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    mainmenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private void enrollStudent() {
        System.out.println("\nEnroll in Course");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter College Name: ");
        String collegeName = scanner.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student = new Student(name, collegeName, rollNo, courseCode, email);
        studentDAO.enrollStudent(student);

        System.out.println("Student enrolled successfully!");
    }

    public static void main(String[] args) {
        CourseEnrollment cE = new CourseEnrollment();
        cE.mainmenu();
    }
}

