package Library1;
import java.util.*;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.*;

import com.mysql.jdbc.PreparedStatement;
public class Main {
	class LibraryManagementSystem {

		private static final String DriverManager = null;

		public static void main(String[] args) {

		try {

		// Establish database connection

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root123#@");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter borrower ID: ");

		int borrowerId = scanner.nextInt();

		scanner.nextLine(); // Consume the newline character

		System.out.print("Enter borrower name: ");

		String borrowerName = scanner.nextLine();

		Borrower borrower = new Borrower(borrowerId, borrowerName, connection);

		System.out.print("Enter book ID: ");

		int bookId = scanner.nextInt();

		scanner.nextLine(); // Consume the newline character

		System.out.print("Enter book title: ");

		String bookTitle = scanner.nextLine();

		System.out.print("Enter book author: ");

		String bookAuthor = scanner.nextLine();

		Book book = new Book(bookId, bookTitle, bookAuthor);

		borrower.borrowBook(book);

		System.out.println(borrower.getName() + " borrowed books: " + borrower.getBorrowedBooks());

		// Close database connection

		connection.close();

		} catch (SQLException e) {

		System.out.println("SQL Error: " + e.getMessage());

		} catch (LibraryException e) {

		System.out.println("Library Error: " + e.getMessage());

		} catch (Exception e) {

		System.out.println("Error: " + e.getMessage());

		}

		}

}
