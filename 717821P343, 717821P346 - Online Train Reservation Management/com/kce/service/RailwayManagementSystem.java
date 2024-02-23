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
    public static void main(String[] args) {
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
                        TicketDAO td=new TicketDAO();
                        td.viewAllTickets();
                        break;
                    case 4:
                    	TicketDAO t=new TicketDAO();
                        t.cancelTicket(scanner);
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
}
