package com.kce.service;

import com.kce.bean.Event;
import com.kce.dao.EventDAO;

import java.util.List;
import java.util.Scanner;
public class EventManagementService {
	private EventDAO eventDAO;
    private Scanner scanner;
    public EventManagementService() {
        eventDAO = new EventDAO();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        int choice;
        do {
            System.out.println("----- Event Management System Menu -----");
            System.out.println("1. Create Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Display All Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    displayAllEvents();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 5);
    }
    private void createEvent() {
        System.out.println("----- Create Event -----");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date: ");
        String date = scanner.nextLine();
        System.out.print("Enter event capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Event event = new Event(name, date, capacity);
        eventDAO.createEvent(event);
        System.out.println("Event created successfully!");
    }
    private void updateEvent() {
        System.out.println("----- Update Event -----");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        Event event = eventDAO.getEventByName(name);
        if (event == null) {
            System.out.println("Event not found!");
        } else {
            System.out.print("Enter new event date: ");
            String date = scanner.nextLine();
            System.out.print("Enter new event capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            event.setDate(date);
            event.setCapacity(capacity);
            eventDAO.updateEvent(event);
            System.out.println("Event updated successfully!");
        }
    }

    private void deleteEvent() {
        System.out.println("----- Delete Event -----");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        Event event = eventDAO.getEventByName(name);
        if (event == null) {
            System.out.println("Event not found!");
        } else {
            eventDAO.deleteEvent(name);
            System.out.println("Event deleted successfully!");
        }
    }

    private void displayAllEvents() {
        System.out.println("----- All Events -----");
        List<Event> events = eventDAO.getAllEvents();
        for (Event event : events) {
            System.out.println("Name: " + event.getName());
            System.out.println("Date: " + event.getDate());
            System.out.println("Capacity: " + event.getCapacity());
            System.out.println("---------------------");
        }
    }

    private void exit() {
        eventDAO.closeConnection();
        System.out.println("Exiting Event Management System. Goodbye!");
    }
}
