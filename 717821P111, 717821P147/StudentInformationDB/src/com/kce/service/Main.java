package com.kce.service;
import com.kce.bean.*;
import com.kce.*;
import com.kce.dao.*;
import java.sql.SQLException;
import java.util.*;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws SQLException {
		StudentInfoDB std = new StudentInfoDB();
		System.out.println("-----------------------------------------------------------");
		System.out.println("P.R.S.R Student Management System!");
		System.out.println("-----------------------------------------------------------");
		System.out.println();
		while (true) {
			System.out.println("Insert Student Details:1");
			System.out.println("If you want Update Student Details: 2");
			System.out.println("If you want Delete some Student Details:3");
			System.out.println("If you want particularly Student Details:4");
			System.out.println("If you display All student details :5");
			System.out.println("Enter the choice:");
			char choice = sc.next().charAt(0);
			switch (choice) {
			case '1': {
				System.out.println("Enter the Student Name :");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter the Student ID:");
				int id = sc.nextInt();
				System.out.println("Enter the Grade of Student:");
				String grade = sc.next();
				Student st1 = new Student(name, id, grade);
				std.createDetails(st1);
				System.out.println("Insert successfully..............");
				break;
			}
			case '2': {
				System.out.println("Enter the Student Name :");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter the Grade of Student:");
				String grade = sc.next();
				System.out.println("Enter the Student ID:");
				int id = sc.nextInt();
				Student st2 = new Student(name, id, grade);
				std.updateDetails(st2);
				System.out.println("Updated successfully..............");
				break;
			}
			case '3': {

				System.out.println("Enter the Student ID:");
				int id = sc.nextInt();
				std.deleteDetails(id);
				System.out.println("Deleted successfully..............");
				break;
			}
			case '4': {
				System.out.println("Enter the What Student Id do you want:");
				int id = sc.nextInt();
				std.getStudentById(id);
				break;
			}
			case '5': {
				std.getAllSutdent();
				break;
			}
			default: {
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			}
		}
	}
}

