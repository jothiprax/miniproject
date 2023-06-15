package com.kce.service;

import com.kce.Dao.InvalidDateException;
import com.kce.Dao.LibraryManagerDao;
import com.kce.Dao.StudentDao;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LibraryManagerDaoMain {

	public static void main(String[] args) throws InvalidDateException  {
		Scanner sc = new Scanner(System.in);
		LibraryManagerDao dao = new LibraryManagerDao();
		StudentDao studentDao = new StudentDao();

		System.out.println("Enter 1 for Updatements");
		System.out.println("Enter 2 for Entry Student Details");
		int choice = sc.nextInt();

		if (choice == 1) {
			while (true) {
				System.out.println("Choose an operation:");
				System.out.println("1. Insert Data");
				System.out.println("2. Update Data");
				System.out.println("3. Delete Data");
				System.out.println("4. Display Data");
				System.out.println("5. Exit");
				System.out.println("Enter the Operation:");
				int operation = sc.nextInt();

				switch (operation) {
				case 1:
					System.out.println("Enter the number of books to insert:");
					int numBooks = sc.nextInt();
					dao.InsertData(numBooks);
					break;

				case 2:
					System.out.println("Enter the BookId:");
					int bookId = sc.nextInt();
					System.out.println("Enter the new genre:");
					String newGenre = sc.next();
					dao.updateData(bookId, newGenre);
					break;

				case 3:
					System.out.println("Enter the BookId:");
					int deleteBookId = sc.nextInt();
					dao.deleteData(deleteBookId);
					break;

				case 4:
					dao.displayData();
					break;

				case 5:
					System.out.println("Exit...Thank you!!!");
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice...Please try again!!!");
					break;
				}
			}
		} else if (choice == 2) {
			while (true) {
				System.out.println("Enter the choice:");
				System.out.println("1. Choose the book:");
				System.out.println("2. Display Student Details");
				System.out.println("3. Delete the Student Details");
				System.out.println("4. Exit");
				int bookChoice = sc.nextInt();
				sc.nextLine();

				switch (bookChoice) {
				case 1:
					dao.displayData();
					System.out.println("Enter the StudentId:");
					int studentId = sc.nextInt();
					System.out.println("Enter the StudentName:");
					String name = sc.next();
					System.out.println("Enter the BookId:");
					int bookId = sc.nextInt();
					System.out.println("Enter the IssueDate (yyyy-MM-dd):");
					String issueDate = sc.next();
					if (!isValidDate(issueDate)) {
						throw new InvalidDateException("Invalid date format!");
					}
					System.out.println("Enter the ReturnDate (yyyy-MM-dd):");
					String returnDate = sc.next();
					if (!isValidDate(returnDate)) {
						throw new InvalidDateException("Invalid date format!");
					}

					StudentDetails sd = new StudentDetails(studentId, name, bookId, issueDate, returnDate);
					studentDao.addStudent(sd);
					break;

				case 2:
					studentDao.displayData();
					break;

				case 3:
					studentDao.deleteDetails();
					break;
				case 4:
					System.out.println("Exit!!!");
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice...Please try again!!!");
					break;
				}
			}
		} else {
			System.out.println("Invalid choice...Please try again!!!");
		}
	}

	private static boolean isValidDate(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}

