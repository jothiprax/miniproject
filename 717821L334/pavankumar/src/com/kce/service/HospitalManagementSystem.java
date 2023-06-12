package com.kce.service;

import com.kce.bean.*;
import com.kce.util.*;
import com.kce.dao.*;
import com.kce.bean.Hospital;
import com.kce.dao.HospitalDAO;
import com.kce.util.DBUtil;

import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
	private HospitalDAO hospitalDAO;

	public HospitalManagementSystem() {
		Connection connection = DBUtil.getConnection();
		hospitalDAO = new HospitalDAO(connection);
	}

	public void displayMenu() {
		System.out.println("*** Hospital Management System ***");
		System.out.println("1. Add a new hospital");
		System.out.println("2. Update an existing hospital");
		System.out.println("3. Delete a hospital");
		System.out.println("4. View all hospitals");
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
					addHospital();
					break;
				case 2:
					updateHospital();
					break;
				case 3:
					deleteHospital();
					break;
				case 4:
					viewAllHospitals();
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

	private void addHospital() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the details of the new hospital:");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Location: ");
		String location = scanner.nextLine();
		System.out.print("Capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine(); 
		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Director Name: ");
		String directorName = scanner.nextLine();
		System.out.print("Emergency Contact: ");
		String emergencyContact = scanner.nextLine();
		System.out.print("Website: ");
		String website = scanner.nextLine();
		System.out.print("Established Date: ");
		String establishedDate = scanner.nextLine();

		Hospital hospital = new Hospital();
		hospital.setName(name);
		hospital.setLocation(location);
		hospital.setCapacity(capacity);
		hospital.setPhoneNumber(phoneNumber);
		hospital.setEmail(email);
		hospital.setDirectorName(directorName);
		hospital.setEmergencyContact(emergencyContact);
		hospital.setWebsite(website);
		hospital.setEstablishedDate(establishedDate);

		hospitalDAO.addHospital(hospital);
		System.out.println("Hospital added successfully!");
	}

	private void updateHospital() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the hospital ID to update: ");
		int hospitalId = scanner.nextInt();
		scanner.nextLine();

		Hospital hospital = hospitalDAO.getHospitalById(hospitalId);

		if (hospital == null) {
			System.out.println("Hospital not found with ID: " + hospitalId);
			return;
		}

		System.out.println("Hospital Details:");
		System.out.println("Name: " + hospital.getName());
		System.out.println("Location: " + hospital.getLocation());
		System.out.println("Capacity: " + hospital.getCapacity());
		System.out.println("Phone Number: " + hospital.getPhoneNumber());
		System.out.println("Email: " + hospital.getEmail());
		System.out.println("Director Name: " + hospital.getDirectorName());
		System.out.println("Emergency Contact: " + hospital.getEmergencyContact());
		System.out.println("Website: " + hospital.getWebsite());
		System.out.println("Established Date: " + hospital.getEstablishedDate());

		System.out.println("Enter the new details (leave blank to keep current value):");

		System.out.print("New name: ");
		String name = scanner.nextLine();
		if (!name.isEmpty()) {
			hospital.setName(name);
		}
		System.out.print("New location: ");
		String location = scanner.nextLine();
		if (!location.isEmpty()) {
			hospital.setLocation(location);
		}
		System.out.print("New capacity: ");
		String capacityInput = scanner.nextLine();
		if (!capacityInput.isEmpty()) {
			int capacity = Integer.parseInt(capacityInput);
			hospital.setCapacity(capacity);
		}
		System.out.print("New phone number: ");
		String phoneNumber = scanner.nextLine();
		if (!phoneNumber.isEmpty()) {
			hospital.setPhoneNumber(phoneNumber);
		}
		System.out.print("New email: ");
		String email = scanner.nextLine();
		if (!email.isEmpty()) {
			hospital.setEmail(email);
		}
		System.out.print("New director name: ");
		String directorName = scanner.nextLine();
		if (!directorName.isEmpty()) {
			hospital.setDirectorName(directorName);
		}
		System.out.print("New emergency contact: ");
		String emergencyContact = scanner.nextLine();
		if (!emergencyContact.isEmpty()) {
			hospital.setEmergencyContact(emergencyContact);
		}
		System.out.print("New website: ");
		String website = scanner.nextLine();
		if (!website.isEmpty()) {
			hospital.setWebsite(website);
		}
		System.out.print("New established date: ");
		String establishedDate = scanner.nextLine();
		if (!establishedDate.isEmpty()) {
			hospital.setEstablishedDate(establishedDate);
		}

		hospitalDAO.updateHospital(hospital);
		System.out.println("Hospital updated successfully!");
	}

	private void deleteHospital() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the hospital ID to delete: ");
		int hospitalId = scanner.nextInt();
		scanner.nextLine();

		Hospital hospital = hospitalDAO.getHospitalById(hospitalId);

		if (hospital == null) {
			System.out.println("Hospital not found with ID: " + hospitalId);
			return;
		}

		System.out.println("Hospital Details:");
		System.out.println("Name: " + hospital.getName());
		System.out.println("Location: " + hospital.getLocation());
		System.out.println("Capacity: " + hospital.getCapacity());
		System.out.println("Phone Number: " + hospital.getPhoneNumber());
		System.out.println("Email: " + hospital.getEmail());
		System.out.println("Director Name: " + hospital.getDirectorName());
		System.out.println("Emergency Contact: " + hospital.getEmergencyContact());
		System.out.println("Website: " + hospital.getWebsite());
		System.out.println("Established Date: " + hospital.getEstablishedDate());

		System.out.print("Are you sure you want to delete this hospital? (Y/N): ");
		String confirmation = scanner.nextLine();

		if (confirmation.equalsIgnoreCase("Y")) {
			hospitalDAO.deleteHospital(hospitalId);
			System.out.println("Hospital deleted successfully!");
		} else {
			System.out.println("Deletion cancelled.");
		}
	}

	private void viewAllHospitals() throws SQLException {
		List<Hospital> hospitals = hospitalDAO.getAllHospitals();

		if (hospitals.isEmpty()) {
			System.out.println("No hospitals found.");
			return;
		}

		System.out.println("Hospital List:");
		for (Hospital hospital : hospitals) {
			System.out.println("ID: " + hospital.getId());
			System.out.println("Name: " + hospital.getName());
			System.out.println("Location: " + hospital.getLocation());
			System.out.println("Capacity: " + hospital.getCapacity());
			System.out.println("Phone Number: " + hospital.getPhoneNumber());
			System.out.println("Email: " + hospital.getEmail());
			System.out.println("Director Name: " + hospital.getDirectorName());
			System.out.println("Emergency Contact: " + hospital.getEmergencyContact());
			System.out.println("Website: " + hospital.getWebsite());
			System.out.println("Established Date: " + hospital.getEstablishedDate());
			System.out.println("-*-*-*-*-*-*-*-*-*-");
		}
	}

	public static void main(String[] args) {
		HospitalManagementSystem hospitalManagementSystem = new HospitalManagementSystem();
		hospitalManagementSystem.run();
	}
}
