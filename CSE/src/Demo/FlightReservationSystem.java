package Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightReservationSystem {
	private Connection connection;

    public FlightReservationSystem(Connection connection) {
        this.connection = connection;
    }

    public void addFlight(Flight flight) {
        try {
            String query = "INSERT INTO flights (flight_number, airline, source, destination) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, flight.getFlightNumber());
            statement.setString(2, flight.getAirline());
            statement.setString(3, flight.getSource());
            statement.setString(4, flight.getDestination());
            statement.executeUpdate();
            System.out.println("Flight added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bookFlight(int flightNumber, Passenger passenger) {
        try {
            String query = "INSERT INTO reservations (flight_number, passenger_name, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, flightNumber);
            statement.setString(2, passenger.getName());
            statement.setString(3, passenger.getEmail());
            statement.setString(4, passenger.getPhone());
            statement.executeUpdate();
            System.out.println("Flight booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayReservation(int reservationNumber) {
        try {
            String query = "SELECT * FROM reservations JOIN flights ON reservations.flight_number = flights.flight_number WHERE reservation_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, reservationNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String passengerName = resultSet.getString("passenger_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int flightNumber = resultSet.getInt("flight_number");
                String airline = resultSet.getString("airline");
                String source = resultSet.getString("source");
                String destination = resultSet.getString("destination");

                System.out.println("Reservation Number: " + reservationNumber);
                System.out.println("Passenger Name: " + passengerName);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Flight Number: " + flightNumber);
                System.out.println("Airline: " + airline);
                System.out.println("Source: " + source);
                System.out.println("Destination: " + destination);
            } else {
                System.out.println("No reservation found with the given reservation number: " + reservationNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
