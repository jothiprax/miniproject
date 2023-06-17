package com.kce.service;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.service.Customer;
import com.kce.Dao.BookingDetailsDAO;
import com.kce.Dao.flightDetailsDAO;
import com.kce.bean.BookingDetails;

public class Main {
		static Scanner sc = new Scanner(System.in);

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			System.out.println("If you are a Manager enter 1");
			System.out.println("If you want to book enter 2");
			int press = sc.nextInt();
			while (true) {
				if (press == 1) {

					System.out.println("--------------------------------------------------------------------------------------------------------------------");
					System.out.println("Enter the choice:");
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
						BusDetailsDAO.insert(sc.nextInt());

						break;

					case 2:
						BusDetailsDAO.update();
						break;

					case 3:
						BusDetailsDAO.delete();
						break;

					case 4:
						BusDetailsDAO.displayTable();
						break;

					case 5:
						System.out.println("Thank You!!!!");
						System.exit(0);
						break;

					default:
						System.out.println("Invalid choice....");
						break;
					}

				} else if (press == 2) {
					while (true) {
						System.out.println("Enter the Choice");
						System.out.println("1. Customer: ");
						System.out.println("2. Delete Rows");
						System.out.println("3. Update Data");
						System.out.println("4. Display Customer Details");
						System.out.println("5. Exit");
						int choice = sc.nextInt();
						sc.nextLine();

						switch (choice) {
						case 1:
							BusDetailsDAO.displayTable();

							System.out.println("Enter Customer Name: ");
							String name = sc.next();
							System.out.println("Enter the Ph No: ");
							int phNo = sc.nextInt();
							System.out.println("Enter flight Id: ");
							int busNo = sc.nextInt();
							System.out.println("Enter the No of seats: ");
							int noOfSeats = sc.nextInt();

							double seatPrice = flightDetailsDAO.getSeatPrice(busNo);
							double totalBill = noOfSeats * seatPrice;

							System.out.println("Details Collected Successfully!!!");
							System.out.println("Total Bill: $" + totalBill);

							BookingDetails bookingDetails = new BookingDetails(name, phNo, flightNo, noOfSeats);
							BookingDetailsDAO.Customer(bookingDetails);
							break;
						case 2:
							BookingDetailsDAO.deleteRows();
							break;
						case 3:
							BookingDetailsDAO.update();
							break;
						case 4:
							BookingDetailsDAO.displayTable();
							break;

						case 5:
							System.out.println("Thank You!!!!");
							System.exit(0);
							break;



						default:

							System.out.println("Invalid choice....");
							break;
						}

						System.out.println("--------------------------------------------------------------------------------------------------------------------------");


					}
				}}}}
}
