package com.kce.service;

import com.kce.dao.Railway;
import com.kce.util.DBConnection;

import java.sql.*;
import java.util.*;
public class RailwayDetails {
    public static void main(String[] args) {
        try {
            DBConnection db=new DBConnection();
            Connection con = db.getDbConnection();
            Statement stmt = con.createStatement();
            Railway r=new Railway();
// Create table
//            String createTableQuery = "CREATE TABLE RailwayTicketDetail("
//                    + "ticket_id VARCHAR(20) NOT NULL,"
//                    + "name VARCHAR(50) NOT NULL,"
//                    + "source VARCHAR(50) NOT NULL,"
//                    + "destination VARCHAR(50) NOT NULL,"
//                    + "class VARCHAR(20) NOT NULL,"
//                    + "age VARCHAR(5) NOT NULL,"
//                    + "gender VARCHAR(1) NOT NULL,"
//                    + "ph_number VARCHAR(10) NOT NULL,"
//                    + "fare VARCHAR(50) NOT NULL)";
//            stmt.executeUpdate(createTableQuery);
//            System.out.println("Table created successfully!");
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (choice != 0) {
                System.out.println("\n----- RAILWAY BOOKING TICKET SYSTEM -----");
                System.out.println("1. Book a Ticket");
                System.out.println("2. Update Ticket Fare");
                System.out.println("3. Update Ticket Class");
                System.out.println("4. Update Ticket Destination");
                System.out.println("5. Update passenger Age");
                System.out.println("6. Update passenger ph_number");
                System.out.println("7. Delete a Ticket");
                System.out.println("8. Show All Tickets");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:r.bookTicket();break;
                    case 2:r.updateFare();break;
                    case 3:r.updateClass();break;
                    case 4:r.updateDestination();break;
                    case 5:r.updateAge();break;
                    case 6:r.updatePhoneNo();break;
                    case 7:r.deleteTicket();break;
                    case 8:r.showAllTickets();break;
                    case 9:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}