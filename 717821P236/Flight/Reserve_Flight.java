package Flight;


import java.sql.*;
import java.util.*;
class IdNotFoundException extends Exception {
	public String toString()
	{
		return "Flight id (or) Passenger ID doesn't match";
	}
	
}
public class Reserve_Flight {
	 public void reserveFlight(int flightId, int passengerId) throws IdNotFoundException, SQLException  {
	        Scanner scanner= new Scanner(System.in);
			String url="jdbc:mysql://127.0.0.1:3306/flight_reservation";
			String username="root";
			String password="teddy@22";
			Connection  connection = DriverManager.getConnection(url,username,password);
			
			
			System.out.println("Booking Flight .......");
     
      
			String query = "INSERT INTO reservations (flight_id, passenger_id) VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, flightId);
			preparedStatement.setInt(2, passengerId);
			preparedStatement.executeUpdate();
			System.out.println("Filght Booked");
			preparedStatement.close();     
	        
	       }
   

public void  BookedDetails(int flightId, int passengerId)
{
	   try {
         String query = "select  id ,flight_number ,origin ,destination  from flights where id="+flightId;
         Scanner scanner= new Scanner(System.in);
		String url="jdbc:mysql://127.0.0.1:3306/flight_reservation";
		String username="root";
		String password="teddy@22";
		Connection  connection = DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20s\n","Flight_ID","Flight_Number","Passenger Id","Origin","Destination");
        System.out.println("----------------------------------------------------------------------");
        while (resultSet.next()) {
             int id = resultSet.getInt(1);
             String flightNumber = resultSet.getString(2);
             String origin = resultSet.getString(3);
             String destination = resultSet.getString(4);
             System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",id,flightNumber,passengerId,origin,destination);
       
         }
        System.out.println("---------------------------------------------------------------");
         resultSet.close();
     } 
	    catch (SQLException e) {
         e.printStackTrace();
        
     }
	 
}
}
