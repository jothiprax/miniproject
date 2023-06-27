package Demo;
import java.sql.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Establish connection to MySQL database
            String url = "jdbc:mysql://localhost:3306/flight_reservation";
            String username = "system";
            String password = "123";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create tables if they don't exist
            createTables(connection);

            FlightReservationSystem frs = new FlightReservationSystem(connection);

            boolean exit = false;
            while (!exit) {
                System.out.println("** Flight Reservation System **");
                System.out.println("1. Add Flight");
                System.out.println("2. Book Flight");
                System.out.println("3. Display Reservation");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter flight number: ");
                        int flightNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter airline: ");
                        String airline = scanner.nextLine();
                        System.out.print("Enter source: ");
                        String source = scanner.nextLine();
                        System.out.print("Enter destination: ");
                        String destination = scanner.nextLine();
                        Flight flight = new Flight(flightNumber, airline, source, destination);
                        frs.addFlight(flight);
                        break;
                    case 2:
                        System.out.print("Enter flight number: ");
                        flightNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter passenger name: ");
                        String passengerName = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = scanner.nextLine();
                        Passenger passenger = new Passenger(passengerName, email, phone);
                        frs.bookFlight(flightNumber, passenger);
                        break;
                    case 3:
                        System.out.print("Enter reservation number: ");
                        int reservationNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        frs.displayReservation(reservationNumber);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

                System.out.println();
            }

            System.out.println("Thank you for using the Flight Reservation System!");

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String createFlightsTableQuery = "CREATE TABLE IF NOT EXISTS flights (" +
                "flight_number INT PRIMARY KEY," +
                "airline VARCHAR(100) NOT NULL," +
                "source VARCHAR(100) NOT NULL," +
                "destination VARCHAR(100) NOT NULL" +
                ")";

        String createReservationsTableQuery = "CREATE TABLE IF NOT EXISTS reservations (" +
                "reservation_number INT AUTO_INCREMENT PRIMARY KEY," +
                "flight_number INT NOT NULL," +
                "passenger_name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "phone VARCHAR(20) NOT NULL," +
                "FOREIGN KEY (flight_number) REFERENCES flights(flight_number)" +
                ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createFlightsTableQuery);
        statement.executeUpdate(createReservationsTableQuery);
    }
}
