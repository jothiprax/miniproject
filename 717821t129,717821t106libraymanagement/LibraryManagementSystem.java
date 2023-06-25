package libmanage;
import java.util.*;
import java.sql.*;
public class LibraryManagementSystem {
	public static void main(String[] args) {

		try {

		// Establish database connection

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busdetails1", "root", "123");

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

		} catch (LibrayException e) {

		System.out.println("Library Error: " + e.getMessage());

		} catch (Exception e) {

		System.out.println("Error: " + e.getMessage());

		}

		}
}
