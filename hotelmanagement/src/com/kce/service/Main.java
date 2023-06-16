package com.kce.service;
import com.kce.bean.*;
import com.kce.dao.*;
import com.kce.util.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomService roomService = new RoomService();
        BookingService bookingService = new BookingService();
        GuestService guestService = new GuestService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------ Hotel Management System ------");
            System.out.println("1. Room Operations");
            System.out.println("2. Booking Operations");
            System.out.println("3. Guest Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performRoomOperations(roomService, scanner);
                    break;
                case 2:
                    performBookingOperations(bookingService, scanner);
                    break;
                case 3:
                    performGuestOperations(guestService, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void performRoomOperations(RoomService roomService, Scanner scanner) {
        System.out.println("\n------ Room Operations ------");
        System.out.println("1. Get all rooms");
        System.out.println("2. Get room by ID");
        System.out.println("3. Get available rooms");
        System.out.println("4. Update room");
        System.out.println("5. Delete room");
        System.out.println("6.insert room");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                List<Room> allRooms = roomService.getAllRooms();
                System.out.println("All Rooms:");
                for (Room room : allRooms) {
                    System.out.println(room);
                }
                break;
            case 2:
                System.out.print("Enter the ID of the room to retrieve: ");
                int roomId = scanner.nextInt();
                Room roomById = roomService.getRoomById(roomId);
                System.out.println("\nRoom with ID " + roomId + ":");
                System.out.println(roomById);
                break;
            case 3:
                System.out.print("Enter the check-in date (yyyy-mm-dd): ");
                String checkInDateString = scanner.next();
                System.out.print("Enter the check-out date (yyyy-mm-dd): ");
                String checkOutDateString = scanner.next();

                Date checkInDate = java.sql.Date.valueOf(checkInDateString);
                Date checkOutDate = java.sql.Date.valueOf(checkOutDateString);

                List<Room> availableRooms = roomService.getAvailableRooms(checkInDate, checkOutDate);
                System.out.println("\nAvailable Rooms between " + checkInDate + " and " + checkOutDate + ":");
                for (Room room : availableRooms) {
                    System.out.println(room);
                }
                break;
            case 4:
                System.out.print("Enter the ID of the room to update: ");
                int roomToUpdateId = scanner.nextInt();

                Room roomToUpdate = roomService.getRoomById(roomToUpdateId);
                if (roomToUpdate != null) {
                    System.out.print("Enter the new room name: ");
                    String newName = scanner.next();
                    roomToUpdate.setRoom_id(roomToUpdateId);

                    roomService.updateRoom(roomToUpdate);
                    System.out.println("\nRoom updated successfully!");
                } else {
                    System.out.println("\nRoom with ID " + roomToUpdateId + " does not exist.");
                }
                break;
            case 5:
                System.out.print("Enter the ID of the room to delete: ");
                int roomToDeleteId = scanner.nextInt();
                roomService.deleteRoom(roomToDeleteId);
                System.out.println("\nRoom with ID " + roomToDeleteId + " deleted successfully!");
                break;
            case 6:
            	RoomDao.insertRoom();
            	break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void performBookingOperations(BookingService bookingService, Scanner scanner) {
        System.out.println("\n------ Booking Operations ------");
        System.out.println("1. Create booking");
        System.out.println("2. Update booking");
        System.out.println("3. Cancel booking");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the ID of the guest making the booking: ");
                int guestId = scanner.nextInt();
                System.out.print("Enter the ID of the room to book: ");
                int roomToBookId = scanner.nextInt();
                System.out.print("Enter the check-in date (yyyy-mm-dd): ");
                String bookingCheckInDateString = scanner.next();
                System.out.print("Enter the check-out date (yyyy-mm-dd): ");
                String bookingCheckOutDateString = scanner.next();

                Date bookingCheckInDate = java.sql.Date.valueOf(bookingCheckInDateString);
                Date bookingCheckOutDate = java.sql.Date.valueOf(bookingCheckOutDateString);

                Booking booking = new Booking();
                booking.setGuest_id(guestId);
                booking.setRoom_id(roomToBookId);
                booking.setCheck_in_date(bookingCheckInDate);
                booking.setCheck_out_date(bookingCheckOutDate);

                bookingService.createBooking(booking);
                System.out.println("\nBooking created successfully!");
                break;
            case 2:
                System.out.print("Enter the ID of the booking to update: ");
                int bookingToUpdateId = scanner.nextInt();

                Booking bookingToUpdate = bookingService.getBookingById(bookingToUpdateId);
                if (bookingToUpdate != null) {
                    System.out.print("Enter the new check-in date (yyyy-mm-dd): ");
                    String newCheckInDateString = scanner.next();
                    System.out.print("Enter the new check-out date (yyyy-mm-dd): ");
                    String newCheckOutDateString = scanner.next();

                    Date newCheckInDate = java.sql.Date.valueOf(newCheckInDateString);
                    Date newCheckOutDate = java.sql.Date.valueOf(newCheckOutDateString);

                    bookingToUpdate.setCheck_in_date(newCheckInDate);
                    bookingToUpdate.setCheck_out_date(newCheckOutDate);

                    bookingService.updateBooking(bookingToUpdate);
                    System.out.println("\nBooking updated successfully!");
                } else {
                    System.out.println("\nBooking with ID " + bookingToUpdateId + " does not exist.");
                }
                break;
            case 3:
                System.out.print("Enter the ID of the booking to cancel: ");
                int bookingToCancelId = scanner.nextInt();
                bookingService.cancelBooking(bookingToCancelId);
                System.out.println("\nBooking with ID " + bookingToCancelId + " canceled successfully!");
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void performGuestOperations(GuestService guestService, Scanner scanner) {
        System.out.println("\n------ Guest Operations ------");
        System.out.println("1. Add guest");
        System.out.println("2. Get guest by ID");
        System.out.println("3. Update guest");
        System.out.println("4. Delete guest");
        System.out.println("0. Go back to main menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the name of the guest to add: ");
                String guestName = scanner.next();
                System.out.print("Enter the email of the guest: ");
                String guestEmail = scanner.next();

                Guest guest = new Guest();
                guest.setName(guestName);
                guest.setEmail(guestEmail);

                guestService.addGuest(guest);
                System.out.println("\nGuest added successfully!");
                break;
            case 2:
                System.out.print("Enter the ID of the guest to retrieve: ");
                int guestToRetrieveId = scanner.nextInt();
                Guest guestById = guestService.getGuestById(guestToRetrieveId);
                System.out.println("\nGuest with ID " + guestToRetrieveId + ":");
                System.out.println(guestById);
                break;
            case 3:
                System.out.print("Enter the ID of the guest to update: ");
                int guestToUpdateId = scanner.nextInt();

                Guest guestToUpdate = guestService.getGuestById(guestToUpdateId);
                if (guestToUpdate != null) {
                    System.out.print("Enter the new guest name: ");
                    String newGuestName = scanner.next();
                    System.out.print("Enter the new guest email: ");
                    String newGuestEmail = scanner.next();

                    guestToUpdate.setName(newGuestName);
                    guestToUpdate.setEmail(newGuestEmail);

                    guestService.updateGuest(guestToUpdate);
                    System.out.println("\nGuest updated successfully!");
                } else {
                    System.out.println("\nGuest with ID " + guestToUpdateId + " does not exist.");
                }
                break;
            case 4:
                System.out.print("Enter the ID of the guest to delete: ");
                int guestToDeleteId = scanner.nextInt();
                guestService.deleteGuest(guestToDeleteId);
                System.out.println("\nGuest with ID " + guestToDeleteId + " deleted successfully!");
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
