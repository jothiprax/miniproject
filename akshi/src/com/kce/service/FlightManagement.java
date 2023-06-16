package com.kce.service;

import com.kce.bean.*;

import com.kce.util.*;

import com.kce.dao.*;

import com.kce.bean.flight;

import com.kce.dao.flightDAO;

import com.kce.util.DBUtil;

import java.util.*;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.InputMismatchException;

import java.util.List;

import java.util.Scanner;



public class FlightManagement {

	private flightDAO flgDAO;

	

	public FlightManagement() {

		Connection connection= DBUtil.getConnection();

		flgDAO = new flightDAO(connection);

	
	}
	public void displayMenu() {

		System.out.println("***FLIGHT MANAGEMENT SYSTEM***");

		System.out.println("1.Add a new flight");

		System.out.println("2.Update an existing flight");

		System.out.println("3.Delete a flight");

		System.out.println("4.Veiw all flights");

		System.out.println("5.Exit");

		System.out.println("------------------------------------");

	}

	public void run() {

		Scanner sc = new Scanner(System.in);

		boolean exit=false;

		while(!exit) {

			displayMenu();

			try {

				System.out.println("Enter your choice : ");

				int choice= sc.nextInt();

				sc.nextLine();

				switch(choice) {

				case 1:

					addFlight();

					break;

				case 2:

					UpdateFlight();

					break;

				case 3:

					deleteFlight();

					break;

				case 4:

					viewAllFlights();

					break;

				case 5:

					exit = true;

					System.out.println("Exit the program");

					break;

				default:

					System.out.println("Invalid choice");

					break;

				}

			}

			catch(InputMismatchException e)

			{

				System.out.println("Invalid input");

				sc.nextLine();

			}

			catch(SQLException e) {

				System.out.println("ERROR!!..");

			}

		}

		sc.close();

		DBUtil.closeConnection();

	}

	private void addFlight() throws SQLException {

		Scanner sc = new Scanner(System.in);

		

		System.out.println("Enter the deatils of new flight");

		System.out.println("Airline: ");

		String airline = sc.nextLine();

		System.out.println("Origin: ");

		String origin = sc.nextLine();

		System.out.println("Destination: ");

		String destination= sc.nextLine();

		System.out.println("Departuretime: ");

		int departuretime = sc.nextInt();

		System.out.println("Arrivaltime: ");

		int arrivaltime = sc.nextInt();

		System.out.println("Duration: ");

		int duration = sc.nextInt();

		System.out.println("Capacity: ");

		int capacity = sc.nextInt();

		System.out.println("Availableseats: ");

		int availableseats = sc.nextInt();

		System.out.println("Fare: ");

		double fare = sc.nextDouble();

		

		flight flg = new flight();

		flg.setAirline(airline);

		flg.setOrigin(origin);

		flg.setDestination(destination);

		flg.setDeparturetime(departuretime);

		flg.setArrivaltime(arrivaltime);

		flg.setDuration(duration);

		flg.setCapacity(capacity);

		flg.setAvailableseats(availableseats);

		flg.setFare(fare);

		

		flgDAO.addFlight(flg);

		System.out.println("Flight added!!!");

	}

	private void UpdateFlight() throws SQLException{

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter flight id to update the details");

		int flgId=sc.nextInt();

		sc.nextLine();

		flight flg  = flgDAO.getFlightById(flgId);

		if(flg==null)

		{

			System.out.println("Flight not found: "+flgId);

			return ;

		}

		System.out.println("Flight details: ");

		System.out.println("Airline: "+flg.getAirline());

		System.out.println("Origin: "+flg.getOrigin());

		System.out.println("Destination: "+flg.getDestination());

		System.out.println("Departuretime: "+flg.getDeparturetime());

		System.out.println("Arrivaltie: "+flg.getArrivaltime());

		System.out.println("Durtion: "+flg.getDuration());

		System.out.println("Capacity: "+flg.getCapacity());

		System.out.println("Availableseats: "+flg.getAvailableseats());

		System.out.println("Fare: "+flg.getFare());

		

		System.out.println("Enter new details");

		System.out.println("New airline:");

		String airline = sc.nextLine();

		if(!airline.isEmpty()) {

			flg.setAirline(airline);

	

		System.out.println("New origin");

		String origin=sc.nextLine();

		if(!origin.isEmpty()) {

			flg.setOrigin(origin);

		}

		

		System.out.println("New destination");

		String destination=sc.nextLine();

		if(!destination.isEmpty()) {

			flg.setDestination(destination);

		}

		

		System.out.println("New departuretime");

		String departuretimedt=sc.nextLine();

		if(!departuretimedt.isEmpty()) {

			int departuretime = Integer.parseInt(departuretimedt);

			flg.setDeparturetime(departuretime);

		}

		

		System.out.println("New arrivaltime");

		String arrivaltimeat=sc.nextLine();

		if(!arrivaltimeat.isEmpty()) {

			int arrivaltime = Integer.parseInt(arrivaltimeat);

			flg.setArrivaltime(arrivaltime);

		}

		

		System.out.println("New duration");

		String durationdt=sc.nextLine();

		if(!durationdt.isEmpty()) {

			int duration=Integer.parseInt(durationdt);

			flg.setDuration(duration);

		}

		

		System.out.println("New capacity");

		String capacitydt=sc.nextLine();

		if(!capacitydt.isEmpty()) {

			int capacity=Integer.parseInt(capacitydt);

			flg.setCapacity(capacity);

		}

		

		System.out.println("New availableseats");

		String availableseatsdt=sc.nextLine();

		if(!availableseatsdt.isEmpty()) {

			int availableseats=Integer.parseInt(availableseatsdt);

			flg.setAvailableseats(availableseats);

		}

		

		System.out.println("New fare");

		String faredt=sc.nextLine();
		if(!faredt.isEmpty()) {
			double fare=Double.parseDouble(faredt);
			flg.setFare(fare);
		}
		   flgDAO.UpdateFlight(flg);
         System.out.println("Flight UPdataed!");	 
		}
	}
		private void deleteFlight()throws SQLException{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the flight id to delete");
			int flgId = sc.nextInt();
			sc.nextLine();
			flight flg = flgDAO.getFlightById(flgId);
			if(flg == null) {
				System.out.println("Flight not found with ID: "+flgId);
				return;
			}
			System.out.println("Flight id");
			System.out.println("Airline: "+flg.getAirline());
			System.out.println("Origin: "+flg.getOrigin());
			System.out.println("Destination: "+flg.getDestination());
			System.out.println("Departuretime: "+flg.getDeparturetime());
			System.out.println("Arrivaltime: "+flg.getArrivaltime());
			System.out.println("Duration: "+flg.getDuration());
			System.out.println("Capacity: "+flg.getCapacity());
			System.out.println("Availableseats: "+flg.getAvailableseats());
			System.out.println("Fare: "+flg.getFare());
			System.out.println("Are you sure want to delete this flight?(Y/N): ");
			String cfrm = sc.nextLine();
			if(cfrm.equalsIgnoreCase("Y")) {
				flgDAO.deleteFlight(flgId);
				System.out.println("Flight deleted successfully!");
			}
			else
			{
				System.out.println("Deletion cancelled");
			}
		}
		public void viewAllFlights() throws SQLException{
			List<flight> flgt = flgDAO.getAllflights();
			if(flgt.isEmpty()) {
				System.out.println("No flight found");
				return;
			}
			System.out.println("Flight list:");
			for(flight flg:flgt) {
			System.out.println("Airline: "+flg.getAirline());
			System.out.println("Origin: "+flg.getOrigin());
			System.out.println("Destination: "+flg.getDestination());
			System.out.println("Departuretime: "+flg.getDeparturetime());
			System.out.println("Arrivaltime: "+flg.getArrivaltime());
			System.out.println("Duration: "+flg.getDuration());
			System.out.println("Capacity: "+flg.getCapacity());
			System.out.println("Availableseats: "+flg.getAvailableseats());
			System.out.println("Fare: "+flg.getFare());
			System.out.println("----------");
		}
	}	
	public static void main(String args[]) {
		FlightManagement fm = new FlightManagement();
		fm.run();
	}
}