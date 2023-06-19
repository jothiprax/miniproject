package com.kce.service;

import com.kce.bean.Train;
import com.kce.bean.Ticket;
import com.kce.dao.TrainDAO;
import com.kce.dao.TicketDAO;

import java.util.List;
import java.util.Scanner;

public class TrainTicketBooking {
    private TrainDAO trainDAO;
    private TicketDAO ticketDAO;

    public TrainTicketBooking() {
        trainDAO = new TrainDAO();
        ticketDAO = new TicketDAO();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Train Ticket Booking System");
            System.out.println("1. Add Train");
            System.out.println("2. Update Train");
            System.out.println("3. Delete Train");
            System.out.println("4. View All Trains");
            System.out.println("5. Book Ticket");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. View Ticket Details");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTrain(scanner);
                    break;
                case 2:
                    updateTrain(scanner);
                    break;
                case 3:
                    deleteTrain(scanner);
                    break;
                case 4:
                    viewAllTrains();
                    break;
                case 5:
                    bookTicket(scanner);
                    break;
                case 6:
                    cancelTicket(scanner);
                    break;
                case 7:
                    viewTicketDetails(scanner);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 8);
        scanner.close();
    }

    private void addTrain(Scanner scanner) {
        System.out.println("Enter Train Details:");
        System.out.print("Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Train Name: ");
        String trainName = scanner.nextLine();
        System.out.print("Source: ");
        String source = scanner.nextLine();
        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Departure Time: ");
        String departureTime = scanner.nextLine();
        System.out.print("Arrival Time: ");
        String arrivalTime = scanner.nextLine();

        Train train = new Train(trainNumber, trainName, source, destination, departureTime, arrivalTime);
        trainDAO.addTrain(train);
    }

    private void updateTrain(Scanner scanner) {
        System.out.print("Enter the Train Number to update: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Train train = trainDAO.getTrainByNumber(trainNumber);
        if (train != null) {
            System.out.println("Enter new Train Details:");
            System.out.print("Train Name (Current: " + train.getTrainName() + "): ");
            String trainName = scanner.nextLine();
            System.out.print("Source (Current: " + train.getSource() + "): ");
            String source = scanner.nextLine();
            System.out.print("Destination (Current: " + train.getDestination() + "): ");
            String destination = scanner.nextLine();
            System.out.print("Departure Time (Current: " + train.getDepartureTime() + "): ");
            String departureTime = scanner.nextLine();
            System.out.print("Arrival Time (Current: " + train.getArrivalTime() + "): ");
            String arrivalTime = scanner.nextLine();

            if (!trainName.isEmpty()) {
                train.setTrainName(trainName);
            }
            if (!source.isEmpty()) {
                train.setSource(source);
            }
            if (!destination.isEmpty()) {
                train.setDestination(destination);
            }
            if (!departureTime.isEmpty()) {
                train.setDepartureTime(departureTime);
            }
            if (!arrivalTime.isEmpty()) {
                train.setArrivalTime(arrivalTime);
            }

            trainDAO.updateTrain(train);
        } else {
            System.out.println("Train not found with Train Number: " + trainNumber);
        }
    }

    private void deleteTrain(Scanner scanner) {
        System.out.print("Enter the Train Number to delete: ");
        int trainNumber = scanner.nextInt();

        Train train = trainDAO.getTrainByNumber(trainNumber);
        if (train != null) {
            trainDAO.deleteTrain(trainNumber);
        } else {
            System.out.println("Train not found with Train Number: " + trainNumber);
        }
    }

    private void viewAllTrains() {
        List<Train> trainList = trainDAO.getAllTrains();
        if (!trainList.isEmpty()) {
            System.out.println("All Trains:");
            for (Train train : trainList) {
                System.out.println(train);
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("No trains found.");
        }
    }

    private void bookTicket(Scanner scanner) {
        System.out.print("Enter Ticket Details:");
        System.out.print("Ticket Number: ");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Passenger Name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Journey Date: ");
        String journeyDate = scanner.nextLine();

        Ticket ticket = new Ticket(ticketNumber, passengerName, trainNumber, journeyDate);
        ticketDAO.bookTicket(ticket);
    }

    private void cancelTicket(Scanner scanner) {
        System.out.print("Enter the Ticket Number to cancel: ");
        int ticketNumber = scanner.nextInt();

        Ticket ticket = ticketDAO.getTicketByNumber(ticketNumber);
        if (ticket != null) {
            ticketDAO.cancelTicket(ticketNumber);
        } else {
            System.out.println("Ticket not found with Ticket Number: " + ticketNumber);
        }
    }

    private void viewTicketDetails(Scanner scanner) {
        System.out.print("Enter the Ticket Number to view details: ");
        int ticketNumber = scanner.nextInt();

        Ticket ticket = ticketDAO.getTicketByNumber(ticketNumber);
        if (ticket != null) {
            System.out.println("Ticket Details:");
            System.out.println(ticket);
            System.out.println("--------------------------");
        } else {
            System.out.println("Ticket not found with Ticket Number: " + ticketNumber);
        }
    }


 public static void main(String[] args) {
        TrainTicketBooking trainTicketBooking = new TrainTicketBooking();
        trainTicketBooking.run();
    }
}
