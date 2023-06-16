package com.kce.service;

import com.kce.bean.Vehicle;
import com.kce.dao.VehicleDAO;
import com.kce.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VehicleManagementSystem {
	private VehicleDAO vehicleDAO;

	public VehicleManagementSystem() {
		Connection connection = DBUtil.getConnection();
		vehicleDAO = new VehicleDAO(connection);
	}

	public void displayMenu() {
		System.out.println("*** Vehicle Management System ***");
		System.out.println("1. Add a new vehicle");
		System.out.println("2. Update an existing vehicle info");
		System.out.println("3. Delete a vehicle");
		System.out.println("4. View all vehicle");
		System.out.println("5. Exit");
		System.out.println("**********************************");
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			displayMenu();
			try {
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					addVehicle();
					break;
				case 2:
					updateVehicle();
					break;
				case 3:
					deleteVehicle();
					break;
				case 4:
					viewAllVehicles();
					break;
				case 5:
					exit = true;
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid choice.");
				scanner.nextLine();
			} catch (SQLException e) {
				System.out.println("An error occurred while executing the operation. Please try again.");
			}
		}
		scanner.close();
		DBUtil.closeConnection();
	}

	private void addVehicle() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the details of the new vehicle:");
		System.out.print("VEHICLE NO VIN: ");
		int vin = scanner.nextInt();
		scanner.nextLine();
		System.out.print("OwnerName: ");
		String name = scanner.nextLine();
		System.out.print("Brand: ");
		String brand = scanner.nextLine();
		System.out.print("Model: ");

		String model = scanner.nextLine();
		System.out.print("Vehicle no: ");
		String vehicleno = scanner.nextLine();
		System.out.print("Color: ");
		String color = scanner.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("Date: ");
		String Date = scanner.nextLine();
		Vehicle vehicle = new Vehicle();
		vehicle.setVin(vin);
		vehicle.setOwnerName(name);
		vehicle.setBrand(brand);
		vehicle.setModel(model);
		vehicle.setColor(color);
		vehicle.setVehicleNo(vehicleno);
		vehicle.setEmail(email);
		vehicle.setPhoneNumber(phoneNumber);

		vehicle.setDate(Date);
		vehicleDAO.addVehicle(vehicle);
		System.out.println("Vehicle added successfully!");
	}

	private void updateVehicle() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the vehicle ID to update: ");
		int vehicleId = scanner.nextInt();
		scanner.nextLine();
		Vehicle vehicle = VehicleDAO.getVehicleById(vehicleId);
		if (vehicle == null) {
			System.out.println("Vehicle not found with ID: " + vehicleId);
			return;
		}
		System.out.println("Vehicle Details:");
		System.out.println("VIN: " + vehicle.getVin());
		System.out.println("OwnerName: " + vehicle.getOwnerName());
		System.out.println("Brand: " + vehicle.getBrand());
		System.out.println("Model : " + vehicle.getModel());
		System.out.println("Vehicle no: " + vehicle.getVehicleNo());
		System.out.println("Color : " + vehicle.getColor());

		System.out.println("Phone Number: " + vehicle.getPhoneNumber());
		System.out.println("Email: " + vehicle.getEmail());

		System.out.println(" Date: " + vehicle.getDate());
		System.out.println("Enter the new details (leave blank to keep current value):");
		System.out.print("New VIN: ");
		String vin1 = scanner.nextLine();
		if (!vin1.isEmpty()) {
			int vin = Integer.parseInt(vin1);
			vehicle.setVin(vin);
		}
		System.out.print("New Ownername: ");
		scanner.nextLine();
		String ownername = scanner.nextLine();
		if (!ownername.isEmpty()) {
			vehicle.setOwnerName(ownername);
		}
		System.out.print("New Brand: ");
		String brand = scanner.nextLine();
		if (!brand.isEmpty()) {

			vehicle.setBrand(brand);
		}
		System.out.print("New Model: ");
		String model = scanner.nextLine();
		if (!model.isEmpty()) {

			vehicle.setModel(model);
		}
		System.out.print("New Vehicle no: ");
		String vehicleno = scanner.nextLine();
		if (!vehicleno.isEmpty()) {

			vehicle.setVehicleNo(vehicleno);
		}
		System.out.print("New Color: ");
		String color = scanner.nextLine();
		if (!color.isEmpty()) {

			vehicle.setColor(color);
		}
		System.out.print("New phone number: ");
		String phoneNumber = scanner.nextLine();
		if (!phoneNumber.isEmpty()) {
			vehicle.setPhoneNumber(phoneNumber);
		}
		System.out.print("New email: ");
		String email = scanner.nextLine();
		if (!email.isEmpty()) {
			vehicle.setEmail(email);
		}

		System.out.print("New date: ");
		String Date = scanner.nextLine();
		if (!Date.isEmpty()) {
			vehicle.setDate(Date);
		}
		vehicleDAO.updateVehicle(vehicle);
		System.out.println("Vehicle updated successfully!");
	}

	private void deleteVehicle() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the hospital ID to delete: ");
		int hospitalId = scanner.nextInt();
		scanner.nextLine();
		Vehicle vehicle = VehicleDAO.getVehicleById(hospitalId);
		if (vehicle == null) {
			System.out.println("Hospital not found with ID: " + hospitalId);
			return;
		}
		System.out.println("Vehicle Details:");
		System.out.println("VIN: " + vehicle.getVin());
		System.out.println("OwnerName: " + vehicle.getOwnerName());
		System.out.println("Brand: " + vehicle.getBrand());
		System.out.println("Model : " + vehicle.getModel());
		System.out.println("Vehicle no: " + vehicle.getVehicleNo());
		System.out.println("Color : " + vehicle.getColor());

		System.out.println("Phone Number: " + vehicle.getPhoneNumber());
		System.out.println("Email: " + vehicle.getEmail());

		System.out.println(" Date: " + vehicle.getDate());
		System.out.print("Are you sure you want to delete this vehicle info? (Y/N): ");
		String confirmation = scanner.nextLine();
		if (confirmation.equalsIgnoreCase("Y")) {
			vehicleDAO.deleteVehicle(vehicle.getId());
			System.out.println("Vehicle info deleted successfully!");
		} else {
			System.out.println("Deletion cancelled.");
		}
	}

	private void viewAllVehicles() throws SQLException {
		List<Vehicle> vehicles = vehicleDAO.getAllVehicle();
		if (vehicles.isEmpty()) {
			System.out.println("No Vehicle info found.");
			return;
		}
		System.out.println("Vehicle Details:");
		for (Vehicle vehicle : vehicles) {
			System.out.println("ID: " + vehicle.getId());

			System.out.println("VIN: " + vehicle.getVin());
			System.out.println("OwnerName: " + vehicle.getOwnerName());
			System.out.println("Brand: " + vehicle.getBrand());
			System.out.println("Model : " + vehicle.getModel());
			System.out.println("Vehicle no: " + vehicle.getVehicleNo());
			System.out.println("Color : " + vehicle.getColor());

			System.out.println("Phone Number: " + vehicle.getPhoneNumber());
			System.out.println("Email: " + vehicle.getEmail());

			System.out.println(" Date: " + vehicle.getDate());
			System.out.println("-*-*-*-*-*-*-*-*-*-");
		}
	}

	public static void main(String[] args) {
		VehicleManagementSystem vehicleManagementSystem = new VehicleManagementSystem();
		vehicleManagementSystem.run();
	}
}