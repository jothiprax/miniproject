import java.sql.*;

public class FlightReservationSystem {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null; 

        try {
            // Establishing database connection
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);

            // Creating the necessary tables
            statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS flights (flight_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "flight_name VARCHAR(50), available_seats INT)";
            statement.executeUpdate(createTableQuery);

            // Initializing flight data if not already present
            String initializeFlightsQuery = "INSERT INTO flights (flight_name, available_seats) " +
                    "SELECT 'Flight A', 100 FROM DUAL WHERE NOT EXISTS (SELECT * FROM flights)";
            statement.executeUpdate(initializeFlightsQuery);

            // Main loop
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("For flight booking, press 1");
                System.out.println("For flight cancellation, press 2");
                System.out.println("For flight availability, press 3");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Enter the flight name");
                    String flightName = scanner.next();

                    System.out.println("Enter the number of seats you wish to book");
                    int seats = scanner.nextInt();

                    // Fetching available seats from the database
                    String selectSeatsQuery = "SELECT available_seats FROM flights WHERE flight_name = '" + flightName + "'";
                    ResultSet resultSet = statement.executeQuery(selectSeatsQuery);

                    if (resultSet.next()) {
                        int availableSeats = resultSet.getInt("available_seats");

                        if (seats > availableSeats) {
                            System.out.println("Sufficient seats not available");
                        } else {
                            availableSeats -= seats;

                            // Updating available seats in the database
                            String updateSeatsQuery = "UPDATE flights SET available_seats = " + availableSeats +
                                    " WHERE flight_name = '" + flightName + "'";
                            statement.executeUpdate(updateSeatsQuery);

                            System.out.println("Seats booked successfully");
                        }
                    } else {
                        System.out.println("Invalid flight name");
                    }

                } else if (choice == 2) {
                    System.out.println("Enter the flight name");
                    String flightName = scanner.next();

                    System.out.println("Enter the number of seats you wish to cancel");
                    int seats = scanner.nextInt();

                    // Fetching available seats from the database
                    String selectSeatsQuery = "SELECT available_seats FROM flights WHERE flight_name = '" + flightName + "'";
                    ResultSet resultSet = statement.executeQuery(selectSeatsQuery);

                    if (resultSet.next()) {
                        int availableSeats = resultSet.getInt("available_seats");
                        availableSeats += seats;
                        // Updating available seats in the database
                        String updateSeatsQuery = "UPDATE flights SET available_seats = " + availableSeats +
                                " WHERE flight_name = '" + flightName + "'";
                        statement.executeUpdate(updateSeatsQuery);

                        System.out.println("Seats canceled successfully");
                    } else {
                        System.out.println("Invalid flight name");
                    }

                } else if (choice == 3) {
                    System.out.println("Enter the flight name");
                    String flightName = scanner.next();

                    // Fetching available seats from the database
                    String selectSeatsQuery = "SELECT available_seats FROM flights WHERE flight_name = '" + flightName + "'";
                }}
            }
        }
    }