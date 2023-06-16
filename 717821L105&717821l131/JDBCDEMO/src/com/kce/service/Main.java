package com.kce.service;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.dao.BookingDAO;
import com.kce.dao.BusDAO;
import com.kce.bean.BookingDetails;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	System.out.println("Manager enter 1");
	System.out.println("To book enter 2");
	int press = sc.nextInt();
	while (true) {
	if (press == 1) {

	System.out.println("****************************************************************************************************************************************");
	System.out.println("ENTER THE CHOICE:");
	System.out.println("1. Insert records");
	System.out.println("2. Update records");
	System.out.println("3. Delete records");
	System.out.println("4. Show records");
	System.out.println("5. Exit");

	int choice = sc.nextInt();
	sc.nextLine();

	switch (choice) {
	case 1:

	System.out.println("Enter the Number of Records to be inserted:");
	BusDAO.insert(sc.nextInt());

	break;

	case 2:
	BusDAO.update();
	break;

	case 3:
	BusDAO.delete();
	break;

	case 4:
	BusDAO.display();
	break;

	case 5:
	System.out.println("THANKYOU..");
	System.exit(0);
	break;

	default:
	System.out.println("INVALID");
	break;
	}

	} else if (press == 2) {
	while (true) {
	System.out.println("ENTER THE CHOICE");
	System.out.println("1. Customer ");
	System.out.println("2. Delete Rows");
	System.out.println("3. Update Data");
	System.out.println("4. Display Customer Details");
	System.out.println("5. Exit");
	int choice = sc.nextInt();
	sc.nextLine();

	switch (choice) {
	case 1:
	BusDAO.display();

	System.out.println("ENTER CUSTOMER NAME: ");
	String name = sc.next();
	System.out.println("ENTER THE PHONE NUMBER: ");
	String phNo = sc.next();
	System.out.println("ENTER THE BUS ID: ");
	int busNo = sc.nextInt();
	System.out.println("ENTER THE NO OF SEATS: ");
	int noOfSeats = sc.nextInt();

	double seatPrice = BusDAO.getSeatPrice(busNo);
	double totalBill = noOfSeats * seatPrice;

	System.out.println("DETAILS COLLECTED..");
	System.out.println("Total Bill: $" + totalBill);

	BookingDetails bookingDetails = new BookingDetails(name, phNo, busNo, noOfSeats);
	BookingDAO.Customer(bookingDetails);
	break;
	case 2:
	BookingDAO.deleteRows();
	break;
	case 3:
	BookingDAO.update();
	break;
	case 4:
	BookingDAO.display();
	break;

	case 5:
	System.out.println("THANK YOU");
	System.exit(0);
	break;



	default:

	System.out.println("INVALID CHOICE");
	break;
	}
	System.out.println("***************************************************************************************************************************************");


	}
	}}}

}
