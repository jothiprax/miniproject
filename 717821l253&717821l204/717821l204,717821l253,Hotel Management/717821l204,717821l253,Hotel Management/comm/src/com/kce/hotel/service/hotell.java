import java.sql.*;
import java.util.*;

public class HotelManagement {
    private static final String DB_URL = "jdbc:mysql://localhost/hotel_management";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createTables(connection); // Create database tables if they don't exist

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Welcome to the Hotel Management System");
                System.out.println("1. Add Room");
                System.out.println("2. Book Room");
                System.out.println("3. Display Available Rooms");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addRoom(connection, scanner);
                        break;
                    case 2:
                        bookRoom(connection, scanner);
                        break;
                    case 3:
                        displayAvailableRooms(connection);
                        break;
                    case 4:
                        System.out.println("Thank you for using the Hotel Management System. Goodbye!");
                        scanner.close();
                        connection.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createRoomsTableQuery = "CREATE TABLE IF NOT EXISTS rooms (id INT AUTO_INCREMENT PRIMARY KEY, " +
                "room_number INT, room_type VARCHAR(50), is_available BOOLEAN)";
        statement.executeUpdate(createRoomsTableQuery);
    }

    private static void addRoom(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter the room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        System.out.print("Enter the room type: ");
        String roomType = scanner.nextLine();

        String insertRoomQuery = "INSERT INTO rooms (room_number, room_type, is_available) VALUES (?, ?, TRUE)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertRoomQuery);
        preparedStatement.setInt(1, roomNumber);
        preparedStatement.setString(2, roomType);
        preparedStatement.executeUpdate();

        System.out.println("Room added successfully!");
    }

    private static void bookRoom(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter the room number you want to book: ");
        int roomNumber = scanner.nextInt();

        String updateRoomQuery = "UPDATE rooms SET is_available = FALSE WHERE room_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateRoomQuery);
        preparedStatement.setInt(1, roomNumber);
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Room not available for booking.");
        }
    }

    private static void displayAvailableRooms(Connection connection) throws SQLException {
        String selectRoomsQuery = "SELECT * FROM rooms WHERE is_available = TRUE";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectRoomsQuery);

        System.out.println("Available Rooms:");
        System.out.println("Room Number\tRoom Type");
        while (resultSet.next())