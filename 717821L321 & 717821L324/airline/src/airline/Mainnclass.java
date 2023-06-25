package airline;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
public class Mainnclass {
	    public static void main(String[] args)throws Exception{
	    	        Scanner scanner = new Scanner(System.in);
	    	        int n=1;
	    	        while(n>0) {
	    	        System.out.println();	
	    	        System.out.println();
	    	        airlinedao flightDAO = new airlinedao();
	    	            System.out.println(" Enter 1 to Add Flight");
	    	            System.out.println("Enter 2 to Remove Flight");
	    	            System.out.println("Enter 3 to Get Flight by Number");
	    	            System.out.println("Enter 4 to Get All Flights");
	    	            System.out.println("Enter 5 to Add Passenger");
	    	            System.out.println("Enter 6 to Remove Passenger");
	    	            System.out.println("Enter 7 to Update Passenger");
	    	            System.out.println(" Enter 8 to Update Flight");
	    	           System.out.println("Enter 0 to Exit");
	    	            System.out.print("Enter your choice: ");
	    	            int choice = scanner.nextInt(); 
                if(choice>=1 &&choice<=8) {
	       connectionclass css=new connectionclass();
	            css.getConnection(choice);
	            n=1;
	               System.out.println();
	
                      }else if(choice==0) {
                    	  n--;
                      }
	    
	    	            switch (choice) {
	    	                case 1:
	    	                   
	    	                    Flight flight = new Flight();
	    	                    System.out.print("Enter flight number: ");
	    	                    flight.setFlightNumber(scanner.next());
	    	                    System.out.print("Enter origin city: ");
	    	                    flight.setOriginCity(scanner.next());
	    	                    System.out.print("Enter destination city: ");
	    	                    flight.setDestinationCity(scanner.next());
	    	                    System.out.print("Enter total capacity: ");
	    	                    flight.setCapacity(scanner.nextInt());              
	    	                    flightDAO.addFlight(flight);
	    	                    System.out.println("Flight added successfully!");
	    	                    break;

	    	                case 2:	    	                   
	    	                    System.out.print("Enter flight number: ");
	    	                    String flightNumber = scanner.next();
	    	                    flightDAO.removeFlight(flightNumber);
	    	                    System.out.println("Flight removed successfully!");
	    	                    break;

	    	                case 3:	    	                   
	    	                    System.out.print("Enter flight number: ");
	    	                    flightNumber = scanner.next();
	    	                    Flight retrievedFlight = flightDAO.getFlightByNumber(flightNumber);
	    	                    System.out.println("Retrieved Flight: " + retrievedFlight);
	    	                    break;

	    	                case 4:	    	                 
	    	                    List<Flight> allFlights = flightDAO.getAllFlights();
	    	                    for (Flight f : allFlights) {
	    	                        System.out.println(f);
	    	                    }
	    	                    break;

	    	                case 5:
	    	                	Reservation reserve=new Reservation();
	    	                    Passenger passenger = new Passenger();
	    	                    System.out.print("Enter passenger ID: ");
	    	                    passenger.setPassengerId(scanner.next());
	    	                    System.out.print("Enter passport number: ");
	    	                    String ss=scanner.next();
	    	                    passenger.setPassportNumber(ss);
	    	                    System.out.print("Enter passenger name: ");
	    	                    String name = scanner.next();
	    	                    passenger.setName(name);
	    	                    System.out.print("Enter total seats: ");
	    	               reserve.setTotalSeats(scanner.nextInt());
	    	                    System.out.print("Enter current passenger count: ");
	    	             reserve.setCurrentPassengerCount(scanner.nextInt());
	    	             System.out.print("Enter destination place:");
	    	             String place=scanner.next();
	    	             boolean result=flightDAO.checkflight(place);
	    	           int a=  reserve.getTotalSeats();
	    	            int b= reserve. getCurrentPassengerCount();
	    	                 int  nn= flightDAO.seatavailability(a,b);
	    	                 int mm= flightDAO.validatePassportNumber(ss);
	    	                 if(result) {
	    	                   if(nn==1) {
	    	                	   if(mm==1) {
	    	                		   
	    	                		   System.out.print("reservationid: ");
	    	                		   reserve.setReservationId(scanner.next());
	    	                    System.out.print("seat number: ");
	    	                    reserve.setSeatNumber(scanner.next());
	    	                    flightDAO.addPassenger(passenger,reserve);
	    	                   System.out.println("Passenger added successfully!");
	    	                   }else {
	    	                	   System.out.println("Passport number is not valid");
	    	                   }
	    	                   }
	    	                   else {
	    	                	   System.out.println("seat is not available");
	    	                   }
	    	                   }else {
	    	                	   System.out.println("flight for your destination place is not available");
	    	                   }
	    	                    break;

	    	                case 6:	    	                   
	    	                    System.out.print("Enter passenger ID: ");
	    	                    String passengerId = scanner.next();
	    	                    flightDAO.removePassenger(passengerId);
	    	                    System.out.println("Passenger removed successfully!");
	    	                    break;

	    	                case 7:	  
	    	                	Reservation rese=new Reservation();
	    	                    Passenger updatedPassenger = new Passenger();
	    	                    System.out.print("Enter passenger ID: ");
	    	                    updatedPassenger.setPassengerId(scanner.next());
	    	                    System.out.print("Enter new name: ");
	    	                    name = scanner.next();
	    	                    updatedPassenger.setName(name);
	    	                    System.out.print("Enter new passport number: ");
	    	                    updatedPassenger.setPassportNumber(scanner.next());
	    	                    System.out.println("reservationid: ");
	    	                    rese.setReservationId(scanner.next());
	    	                    System.out.println("seat number: ");
	    	                    rese.setSeatNumber(scanner.next());
	    	                    flightDAO.updatePassenger(updatedPassenger,rese);
	    	                    System.out.println("Passenger updated successfully!");
	    	                    break;

         	                case 8:
	    	                    Flight updatedFlight = new Flight();
	    	                    System.out.print("Enter flight number: ");
	    	                    updatedFlight.setFlightNumber(scanner.next());
	    	                    System.out.print("Enter new origin city: ");
	    	                    updatedFlight.setOriginCity(scanner.next());
	    	                    System.out.print("Enter new destination city:");
	    	                    updatedFlight.setDestinationCity(scanner.next());
	    	                    System.out.print("Enter total capacity: ");	    	                   
	    	                    updatedFlight.setCapacity(scanner.nextInt());
	    	                    flightDAO.updateFlight(updatedFlight);
	    	                    System.out.println("Flight updated successfully!");
	    	                    break;
	    	                    default:
	    	                    	System.out.println("invalid choice");
	    	                    	break;
	    	            }
	    	            }
	    }
	    	    }



