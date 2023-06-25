package com.kce.service;

import com.kce.bean.Bus;
import com.kce.bean.Ticket;
import com.kce.dao.BusDAO;
import com.kce.dao.TicketDAO;
import com.kce.util.TransportException;
import com.kce.util.TransportException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class TransportManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("----- Transport Management System Menu -----");
                System.out.println("1. View All Trains");
                System.out.println("2. Book a Ticket");
                System.out.println("3. View All Tickets");
                System.out.println("4. Cancel a Ticket");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        viewAllBuses();
                        break;
                    case 2:
                        bookTicket(scanner);
                        break;
                    case 3:
                        viewAllTickets();
                        break;
                    case 4:
                        cancelTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting Transport Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            } while (choice != 5);
        } catch (SQLException | TransportException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllBuses() throws SQLException {
        List<Bus> buses = BusDAO.getAllBuses();

        System.out.println("----- All Buses -----");
        for (Bus bus : buses) {
            bus.displayDetails();
            System.out.println();
        }
    }

    private static void bookTicket(Scanner scanner) throws SQLException, TransportException {
        System.out.println("----- Book a Ticket -----");
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Bus ID: ");
        int busId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();

        Bus bus = getBusById(busId);
        if (bus == null) {
            throw new TransportException("Invalid Bus ID! Bus not found.");
        }

        Ticket ticket = new Ticket(ticketId, busId, passengerName);
        TicketDAO.addTicket(ticket);

        System.out.println("Ticket booked successfully!");
    }

    private static Bus getBusById(int busId) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void viewAllTickets() throws SQLException {
        List<Ticket> tickets = TicketDAO.getAllTickets();

        System.out.println("----- All Tickets -----");
        for (Ticket ticket : tickets) {
            ticket.displayDetails();
            System.out.println();
        }
    }

    private static void cancelTicket(Scanner scanner) throws SQLException {
        System.out.println("----- Cancel a Ticket -----");
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = getTicketById(ticketId);
        if (ticket == null) {
            System.out.println("Invalid Ticket ID! Ticket not found.");
            return;
        }

        TicketDAO.deleteTicket(ticketId);

        System.out.println("Ticket canceled successfully!");
    }

    private static Ticket getTicketById(int ticketId) throws SQLException {
        List<Ticket> tickets = TicketDAO.getAllTickets();

        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }

        return null;
    }

    private static Bus getBusById1(int busId) throws SQLException {
        List<Bus> buses = BusDAO.getAllBuses();

        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }

        return null;
    }
}
