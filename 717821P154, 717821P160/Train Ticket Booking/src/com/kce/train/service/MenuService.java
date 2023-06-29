package com.kce.train.service;

import com.kce.train.bean.Passenger;
import com.kce.train.bean.Ticket;
import com.kce.train.bean.Train;
import com.kce.train.dao.TrainDAO;

import java.util.Scanner;

public class MenuService {
    private TrainDAO trainDAO;
    private TicketBookingService ticketBookingService;
    private ValidationService validationService;
    private Scanner sc;

    public MenuService() {
        trainDAO = new TrainDAO();
        ticketBookingService = new TicketBookingService();
        validationService = new ValidationService();
        sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Add Train");
        System.out.println("2. View All Trains");
        System.out.println("3. Book Ticket");
        System.out.println("4. View Ticket");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                addTrain();
                break;
            case 2:
                viewAllTrains();
                break;
            case 3:
                bookTicket();
                break;
            case 4:
                viewTicket();
                break;
            case 5:
                System.out.println("Exiting...");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addTrain() {
        System.out.println("\nEnter train number:");
        String trainNumber = sc.nextLine();
        System.out.println("Enter train name:");
        String trainName = sc.nextLine();
        System.out.println("Enter train type:");
        String trainType = sc.nextLine();
        System.out.println("Enter source:");
        String source = sc.nextLine();
        System.out.println("Enter destination:");
        String destination = sc.nextLine();
        Train train = new Train(trainNumber, trainName, trainType, source, destination);
        trainDAO.addTrain(train);
        System.out.println("Train added successfully.");
    }

    private void viewAllTrains() {
        trainDAO.viewAllTrains();
    }

    private void bookTicket() {
        System.out.println("Enter passenger name:");
        String name = sc.nextLine();
        System.out.println("Enter passenger age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter passenger gender:");
        String gender = sc.nextLine();
        Passenger passenger = new Passenger(name, age, gender);

        System.out.println("Enter train number:");
        String trainNumber = sc.nextLine();
        System.out.println("Enter concession percentage:");
        double concession = Double.parseDouble(sc.nextLine());
        Ticket ticket = ticketBookingService.bookTicket(passenger, trainNumber, concession);
        System.out.println("Ticket booked successfully. Ticket ID: " + ticket.getTicketId());
    }

    private void viewTicket() {
        System.out.println("Enter ticket ID:");
        int ticketId = Integer.parseInt(sc.nextLine());
        ticketBookingService.viewTicket(ticketId);
    }

    public void startMenu() {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());
            processChoice(choice);
        }
    }
}
