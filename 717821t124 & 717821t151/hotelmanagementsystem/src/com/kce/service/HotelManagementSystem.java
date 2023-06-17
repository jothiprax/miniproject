package com.kce.service;

import com.kce.bean.Customer;
import com.kce.bean.Hotel;
import com.kce.dao.CustomerDAO;
import com.kce.dao.HotelDAO;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel Management System!");

        HotelDAO hotelDAO = new HotelDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Hotel");
            System.out.println("2. Update Hotel");
            System.out.println("3. Delete Hotel");
            System.out.println("4. View Hotels");
            System.out.println("5. Add Customer");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Add Hotel:");
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();

                    System.out.print("Enter room number: ");
                    int roomNo = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    Hotel hotel = new Hotel(hotelName, roomNo, price);
                    hotelDAO.addHotel(hotel);
                    System.out.println("Hotel added successfully!");
                    break;

                case 2:
                    System.out.println("Update Hotel:");
                    System.out.print("Enter room number to update: ");
                    int roomNoToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter new hotel name: ");
                    String updatedHotelName = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    double updatedPrice = scanner.nextDouble();

                    Hotel updatedHotel = new Hotel(updatedHotelName, roomNoToUpdate, updatedPrice);
                    hotelDAO.updateHotel(updatedHotel);
                    System.out.println("Hotel updated successfully!");
                    break;

                case 3:
                    System.out.println("Delete Hotel:");
                    System.out.print("Enter room number to delete: ");
                    int roomNoToDelete = scanner.nextInt();
                    hotelDAO.deleteHotel(roomNoToDelete);
                    System.out.println("Hotel deleted successfully!");
                    break;

                case 4:
                    System.out.println("View Hotels:");
                    hotelDAO.viewHotels();
                    break;

                case 5:
                    System.out.println("Add Customer:");
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();

                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();

                    System.out.print("Enter room number: ");
                    int customerRoomNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter check-in date: ");
                    String checkInDate = scanner.nextLine();

                    System.out.print("Enter check-out date: ");
                    String checkOutDate = scanner.nextLine();

                    Customer customer = new Customer(customerName, customerEmail, customerId, customerRoomNo, checkInDate, checkOutDate);
                    customerDAO.addCustomer(customer);
                    System.out.println("Customer added successfully!");
                    break;

                case 0:
                    System.out.println("Thank you for using Hotel Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
