package OnlineBanking;
import java.sql.*;
import java.util.Scanner;

public class TaxiManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhosT:3306/sree";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Eagle_&$2004";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();

            createTables(statement);

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Taxi Management System");
                System.out.println("1. Add Taxi");
                System.out.println("2. Add Driver");
                System.out.println("3. Book Taxi");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addTaxi(statement, scanner);
                        break;
                    case 2:
                        addDriver(statement, scanner);
                        break;
                    case 3:
                        bookTaxi(statement, scanner);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Statement statement) throws SQLException {
        String createTaxiTable = "CREATE TABLE IF NOT EXISTS taxi (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "registration_number VARCHAR(10) UNIQUE, capacity INT, available BOOLEAN DEFAULT TRUE)";
        String createDriverTable = "CREATE TABLE IF NOT EXISTS driver (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100), taxi_id INT, FOREIGN KEY (taxi_id) REFERENCES taxi(id))";
        String createBookingTable = "CREATE TABLE IF NOT EXISTS booking (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "customer_name VARCHAR(100), source VARCHAR(100), destination VARCHAR(100), " +
                "taxi_id INT, FOREIGN KEY (taxi_id) REFERENCES taxi(id))";

        statement.executeUpdate(createTaxiTable);
        statement.executeUpdate(createDriverTable);
        statement.executeUpdate(createBookingTable);
    }

    private static void addTaxi(Statement statement, Scanner scanner) throws SQLException {
        System.out.print("Enter taxi registration number: ");
        String registrationNumber = scanner.next();

        System.out.print("Enter taxi capacity: ");
        int capacity = scanner.nextInt();

        String addTaxiQuery = "INSERT INTO taxi (registration_number, capacity) VALUES ('" +
                registrationNumber + "', " + capacity + ")";
        statement.executeUpdate(addTaxiQuery);

        System.out.println("Taxi added successfully!");
    }

    private static void addDriver(Statement statement, Scanner scanner) throws SQLException {
        System.out.print("Enter driver name: ");
        String driverName = scanner.next();

        System.out.print("Enter taxi ID for the driver: ");
        int taxiId = scanner.nextInt();

        String addDriverQuery = "INSERT INTO driver (name, taxi_id) VALUES ('" +
                driverName + "', " + taxiId + ")";
        statement.executeUpdate(addDriverQuery);

        System.out.println("Driver added successfully!");
    }

    private static void bookTaxi(Statement statement, Scanner scanner) throws SQLException {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();

        System.out.print("Enter source location: ");
        String source = scanner.next();

        System.out.print("Enter destination location: ");
        String destination = scanner.next();

        System.out.print("Enter taxi ID for the booking: ");
        int taxiId = scanner.nextInt();

        String bookTaxiQuery = "INSERT INTO booking (customer_name, source, destination, taxi_id) VALUES ('" +
                customerName + "', '" + source + "', '" + destination + "', " + taxiId + ")";
        statement.executeUpdate(bookTaxiQuery);

        String updateTaxiAvailabilityQuery = "UPDATE taxi SET available = FALSE WHERE id = " + taxiId;
        statement.executeUpdate(updateTaxiAvailabilityQuery);

        System.out.println("Taxi booked successfully!");
    }
}
