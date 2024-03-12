package Flight;
import java.sql.*;
import java.util.Scanner;

class OutOfChoicesException extends Exception
{
	public String toString()
	{
		return "You entered Invalid Choices";
	}
}

public class Flight_Reservation_System {
	
		    private Connection connection;
		    private Statement statement;
		    private static int notBooked;

		    public  Flight_Reservation_System() {
		        try {
		            String url="jdbc:mysql://127.0.0.1:3306/flight_reservation";
		            String username="root";
		            String password="teddy@22";
		            connection = DriverManager.getConnection(url,username,password);
		            System.out.println(connection);
		            statement = connection.createStatement();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		 
		  

		    public static void main(String[] args) throws IdNotFoundException, SQLException {
		    	Flight_Reservation_System reservationSystem = new Flight_Reservation_System ();
		    	Reserve_Flight reserve=new Reserve_Flight();
		    	Available_Flights availble_flights=new Available_Flights();
		    	Scanner scanner = new Scanner(System.in);
		    	int verify=1;
		    	int flightid=0;
		    	int passenegrID=0;
		    	 while(verify!=0)
				 {
				   System.out.println("--------------------");
				   System.out.println("1.Available Flights");
				   System.out.println("2.Reserve Flight");
				   System.out.println("3.Show Ticket");
				   System.out.println("4.Update_Seats");
				   System.out.println("5. Exit !!! Enter 5");
				   System.out.println("--------------------");
				   System.out.println("Enter your choice : ");
				  
				   int  option=scanner.nextInt();
				   switch(option)
				   {
				   case 1: availble_flights.getAvailableFlights();;
				           break;
				           
				   case 2: System.out.print("TICKET RESERVING\nEnter the filght id :");
					         flightid=scanner.nextInt();
					       System.out.println("Enter the passenger Id : ");
					        passenegrID=scanner.nextInt();
					       reserve.reserveFlight(flightid,passenegrID);
					       break;
				   case 3:reserve.BookedDetails(flightid,passenegrID);
				          break;
				   case 4:availble_flights.updateAvailableSeats(flightid);
			              break;
				   case 5:System.out.println("Thanks for Booking");
					     return;
				   
			      default: 
			    	  try{
			    		  throw new OutOfChoicesException();
			    	  }
			    	  catch(OutOfChoicesException e) {
			    	    System.err.println(e);
			    	  }
				   }
				 }
			            
			               
		   
		        
		       
		      
		    }
	 }
		    	



