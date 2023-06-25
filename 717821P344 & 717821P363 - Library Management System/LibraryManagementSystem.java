import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
public class LibraryManagementSystem {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/lib";
        String name = "root";
        String password = "Yogesh@123";
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Book\n2. Update Book\n3. Delete Book\n4. Borrow Book\n5. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        boolean b = true;
        while (b) {
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    int checking=1;
                    Book book = new Book(bookId, bookTitle, bookAuthor,checking);
                    libraryService.addBook(book);
                    System.out.println("if you want to stop adding more books press N\n if you want to continue press Y");
                    String str =scanner.nextLine();
                    if(str.equals("N"))
                    {
                        b=false;
                    }
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int bookId1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle1 = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String bookAuthor1 = scanner.nextLine();
                    int checking1=1;
                    Book book1 = new Book(bookId1, bookTitle1, bookAuthor1,checking1);
                    libraryService.updateBook(book1);
                    System.out.println("if you want to stop adding more books press N\n if you want to continue press Y");
                    String str1 =scanner.nextLine();
                    if(str1.equals("N"))
                    {
                        b=false;
                    }
                    break;
                case 3:
                    int n = scanner.nextInt();
                    libraryService.deleteBook(n);
                    System.out.println("if you want to stop adding more books press N\n if you want to continue press Y");
                    String str3 =scanner.nextLine();
                    if(str3.equals("N"))
                    {
                        b=false;
                    }
                    break;
                case 4:
                    System.out.println("Enter the Book Id to Borrow:");
                    int book_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the borrower name:");
                    String borrower_name = scanner.nextLine();
                    System.out.println("Enter the borrower email:");
                    String borrower_email = scanner.nextLine();
                    try {
                        Connection connection = DriverManager.getConnection(url,name,password);
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery("Select checking from books where id = " + "'" + book_id + "'");
                        while(rs.next()){
                            if(rs.getInt(1) == 1){
                                PreparedStatement preparedstatement = connection.prepareStatement("Insert into borrowers values(?,?,?)");
                                preparedstatement.setInt(1,book_id);
                                preparedstatement.setString(2,borrower_name);
                                preparedstatement.setString(3,borrower_email);
                                preparedstatement.executeUpdate();
                                System.out.println("Book borrowed successfully.");
                            }
                            else
                            {
                                System.out.println("book not borrowed");
                            }
                        }
                        statement.executeUpdate("Update Books set checking = 0 where id = " + "'" + book_id + "'");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("if you want to stop adding more books press N\n if you want to continue press Y");
                    String str4 =scanner.nextLine();
                    if(str4.equals("N"))
                    {
                        b=false;
                    }
                    break;
            }
        }
    }
}
