package Flight;

import java.sql.*;

public class Available_Flights {
	 public void updateAvailableSeats(int flightId) {
	        try {
	        	String query = "SELECT * FROM flights WHERE available_seats > 0";
	            String url="jdbc:mysql://127.0.0.1:3306/flight_reservation";
				String username="root";
				String password="teddy@22";
				Connection  connection = DriverManager.getConnection(url,username,password);
				Statement statement=connection.createStatement();
	            String updateQuery = "UPDATE flights SET available_seats = available_seats - 1 WHERE id = ?";
	            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	            updateStatement.setInt(1, flightId);
	            updateStatement.executeUpdate();
	            updateStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } 
	 public void getAvailableFlights() {
	        try {
	            String query = "SELECT * FROM flights WHERE available_seats > 0";
	            String url="jdbc:mysql://127.0.0.1:3306/flight_reservation";
				String username="root";
				String password="teddy@22";
				Connection  connection = DriverManager.getConnection(url,username,password);
				Statement statement=connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);
	            System.out.println("----------------------------------------------------------------------");
	            System.out.printf("%-20s%-20s%-20s%-20s\n","Flight_ID","Flight_Number","Origin","Destination","available_seats");
	            System.out.println("----------------------------------------------------------------------");

	            while (resultSet.next()) {
	                int id = resultSet.getInt(1);
	                String flightNumber = resultSet.getString(2);
	                String origin = resultSet.getString(3);
	                String destination = resultSet.getString(4);
	                int availableSeats = resultSet.getInt(5);
	                System.out.printf("%-20s%-20s%-20s%-20s\n",id,flightNumber,origin,destination,availableSeats);

	            }
	            System.out.println("----------------------------------------------------------------------");

	            resultSet.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
}
