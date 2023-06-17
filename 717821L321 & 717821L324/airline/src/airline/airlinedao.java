package airline;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class airlinedao {
	private connectionclass connectionclas;
	public airlinedao() {
	connectionclas=new connectionclass();
	}
	    public void addFlight(Flight flight) {
	        try (Connection connectionn = connectionclas.getConnection()) {
	            String query = "INSERT INTO flights (flight_number, origin_city, destination_city, totalcapacity) VALUES (?, ?, ?, ?)";
	            
	            PreparedStatement statement = connectionn.prepareStatement(query);
	            statement.setString(1, flight.getFlightNumber());
	            statement.setString(2, flight.getOriginCity());
	            statement.setString(3, flight.getDestinationCity());
	            statement.setInt(4, flight.getCapacity());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removeFlight(String flightNumber) {
	        try (Connection connectionn = connectionclas.getConnection()) {
	            String query = "DELETE FROM flights WHERE flight_number = ?";
	            
	            PreparedStatement statement = connectionn.prepareStatement(query);
	            statement.setString(1, flightNumber);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Flight getFlightByNumber(String flightNumber) {
	        Flight flight = null;
	        try (Connection connectionn = connectionclas.getConnection()) {
	            String query = "SELECT * FROM flights WHERE flight_number = ?";
	            
	            PreparedStatement statement = connectionn.prepareStatement(query);
	            statement.setString(1, flightNumber);

	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                flight = new Flight();
	                flight.setFlightNumber(resultSet.getString("flight_number"));
	                flight.setOriginCity(resultSet.getString("origin_city"));
	                flight.setDestinationCity(resultSet.getString("destination_city"));
	                flight.setCapacity(resultSet.getInt("total capacity"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return flight;
	    }

	    public List<Flight> getAllFlights() {
	        List<Flight> flights = new ArrayList<>();
	        try (Connection connectionn = connectionclas.getConnection()) {
	            String query = "SELECT * FROM flights";
	            
	            PreparedStatement statement = connectionn.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Flight flight = new Flight();
	                flight.setFlightNumber(resultSet.getString("flight_number"));
	                flight.setOriginCity(resultSet.getString("origin_city"));
	                flight.setDestinationCity(resultSet.getString("destination_city"));
	                flight.setCapacity(resultSet.getInt("totalcapacity"));
	                flights.add(flight);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return flights;
	    }
	    public int seatavailability(int seatsrreserved,int passengerccount) {
	    	if(passengerccount<seatsrreserved) 
	    		return 1;
	    	return 0;
	    	
	    }
	    public int validatePassportNumber(String passportNumber) {
	        String regex=("\\d{9}");
	        		if(passportNumber.matches(regex))
	        			return 1;
	        		return 0;
	        	
	    }
	    public boolean checkflight(String name)  {
	 	        try (Connection connectionn = connectionclas.getConnection()) {
	 	            String query = "SELECT * FROM flights where destination_city=?";
	 	            
	 	            PreparedStatement statement = connectionn.prepareStatement(query);
	 	            statement.setString(1,name);
	 	            ResultSet resultSet = statement.executeQuery();
                  int i=0;
	 	            while (resultSet.next()) {   
	 	            	i++;
	 	                Flight flight = new Flight();
	 	                flight.setDestinationCity(resultSet.getString(3)); 
	 	                if(i>0)
	 	                return true;
	 	            }
	 	        } catch (SQLException e) {
	 	            e.printStackTrace();
	 	        }
	 	        return false;
	 	    }
	    

	    public void addPassenger(Passenger passenger,Reservation reserve) {
	        try (Connection connectionn = connectionclas.getConnection()) {
	            String query = "INSERT INTO passengers (passenger_id, name, passport_number,reservationid,seatnumber) VALUES (?, ?, ?,?,?)";
	            PreparedStatement statement = connectionn.prepareStatement(query);
	            statement.setString(1, passenger.getPassengerId());
	            statement.setString(2, passenger.getName());
	            statement.setString(3, passenger.getPassportNumber());
	            statement.setString(4, reserve.getReservationId());
	            statement.setString(5, reserve.getSeatNumber());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removePassenger(String passengerId) {
	        try (Connection connection = connectionclas.getConnection()) {
	            String query = "DELETE FROM passengers WHERE passenger_id = ?";
	            
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, passengerId);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void updatePassenger(Passenger passenger,Reservation rese) {
	        try (Connection connection = connectionclas.getConnection()) {
	            String query = "UPDATE passengers SET name = ?, passport_number = ?, reservationid = ?, seatnumber = ? WHERE passenger_id = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, passenger.getName());
	            statement.setString(2, passenger.getPassportNumber());
	            statement.setString(3, rese.getReservationId());
	            statement.setString(4, rese.getSeatNumber());
	            statement.setString(5, passenger.getPassengerId());
	            
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void updateFlight(Flight flight) {
	        try (Connection connection = connectionclas.getConnection()) {
	            String query = "UPDATE flights SET origin_city = ?, destination_city = ?, totalcapacity = ? WHERE flight_number = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, flight.getOriginCity());
	            statement.setString(2, flight.getDestinationCity());
	            statement.setInt(3, flight.getCapacity());
	            statement.setString(4, flight.getFlightNumber());

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	    }
}


