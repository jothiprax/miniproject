package com.kce.service;

import com.kce.bean.Train;
import com.kce.bean.Ticket;
import com.kce.dao.TrainDAO;
import com.kce.dao.TicketDAO;
import com.kce.util.RailwayException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RailwayManagementSystem {
    public static void main(String[] args) throws SQLException,RailwayException{
        Scanner scanner = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("----- Railway Management System Menu -----");
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
                        viewAllTrains();
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
                        System.out.println("Exiting Railway Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            } while (choice != 5);
        } catch (SQLException | RailwayException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllTrains() throws SQLException {
        List<Train> trains = TrainDAO.getAllTrains();

        System.out.println("----- All Trains -----");
        for (Train train : trains) {
            train.displayDetails();
            System.out.println();
        }
    }

    private static void bookTicket(Scanner scanner) throws SQLException, RailwayException {
        System.out.println("----- Book a Ticket -----");
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Train ID: ");
        int trainId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();

        Train train = getTrainById(trainId);
        if (train == null) {
            throw new RailwayException("Invalid Train ID! Train not found.");
        }

        Ticket ticket = new Ticket(ticketId, trainId, passengerName);
        TicketDAO.addTicket(ticket);

        System.out.println("Ticket booked successfully!");
    }
    private static Train getTrainById(int trainId) throws SQLException {
        List<Train> trains = TrainDAO.getAllTrains();

        for (Train train : trains) {
            if (train.getTrainId() == trainId) {
                return train;
            }
        }

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
}