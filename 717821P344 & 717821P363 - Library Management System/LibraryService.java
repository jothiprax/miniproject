import java.sql.SQLException;
class LibraryService {
    public  DatabaseUtil databaseUtil;
    public LibraryService() throws SQLException {
        databaseUtil = new DatabaseUtil();
    }
    public void addBook(Book book) {
        try {
            if (book.title.isEmpty() || book.author.isEmpty()) {
                throw new IllegalArgumentException("Book title and author cannot be empty.");
            }
            databaseUtil.insertBook(book);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to add book: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }
    public void updateBook(Book book) {
        try {
            if (book.title.isEmpty() || book.author.isEmpty()) {
                throw new IllegalArgumentException("Book title and author cannot be empty.");
            }
            databaseUtil.updateBook(book);
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update book: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to update book: " + e.getMessage());
        }
    }
    public void deleteBook(int bookId) {
        try {
            databaseUtil.deleteBook(bookId);
            System.out.println("Book deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete book: " + e.getMessage());
        }
    }

}


