import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class DatabaseUtil {
    String url = "jdbc:mysql://localhost:3306/lib";
    String name = "root";
    String password = "Yogesh@123";
    Connection connection= DriverManager.getConnection(url,name,password);
    PreparedStatement preparedStatement;
    public DatabaseUtil() throws SQLException {
    }
    public void insertBook(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO books VALUES (?, ?, ?,?)");
        preparedStatement.setInt(1, book.id);
        preparedStatement.setString(2, book.title);
        preparedStatement.setString(3, book.author);
        preparedStatement.setInt(4,book.checking);
        preparedStatement.executeUpdate();
    }
    public void updateBook(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id = ?");
        preparedStatement.setString(1, book.title);
        preparedStatement.setString(2, book.author);
        preparedStatement.setInt(3, book.id);
        preparedStatement.executeUpdate();
    }
    public void deleteBook(int bookId) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
        preparedStatement.setInt(1, bookId);
        preparedStatement.executeUpdate();
    }
    public void insertBorrower(Borrower borrower) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO borrowers VALUES (?, ?, ?)");
        preparedStatement.setInt(1, borrower.id);
        preparedStatement.setString(2, borrower.name);
        preparedStatement.setString(3, borrower.email);
        preparedStatement.executeUpdate();
    }

}


