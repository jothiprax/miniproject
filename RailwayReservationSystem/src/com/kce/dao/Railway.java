package com.kce.dao;

import com.kce.util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Railway {
    Scanner sc=new Scanner(System.in);
    DBConnection db=new DBConnection();
    Connection con = db.getDbConnection();
    public void bookTicket(){
        try{
            System.out.print("enter the number of passenger:");
            int n=sc.nextInt();
            sc.nextLine();
            for(int i=0;i<n;i++)
            {
                System.out.print("Enter passenger id: ");
                String ticket_id = sc.nextLine();
                System.out.print("Enter passenger name: ");
                String name = sc.nextLine();
                System.out.print("Enter source station: ");
                String source = sc.nextLine();
                System.out.print("Enter destination station: ");
                String destination = sc.nextLine();
                System.out.print("Enter class (First/Second): ");
                String ticketClass = sc.nextLine();
                System.out.print("Enter passenger age: ");
                String age = sc.nextLine();
                System.out.print("Enter passenger gender: ");
                String gender = sc.nextLine();
                System.out.print("Enter passenger ph_number: ");
                String ph_number = sc.nextLine();
                System.out.print("Enter ticket fare: ");
                String fare = sc.nextLine();
                String insertQuery = "INSERT INTO RailwayTicketDetail VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement insertStmt = con.prepareStatement(insertQuery);
                insertStmt.setString(1,ticket_id);
                insertStmt.setString(2, name);
                insertStmt.setString(3, source);
                insertStmt.setString(4, destination);
                insertStmt.setString(5, ticketClass);
                insertStmt.setString(6, age);
                insertStmt.setString(7, gender);
                insertStmt.setString(8, ph_number);
                insertStmt.setString(9, fare);
                insertStmt.executeUpdate();
            }
            System.out.println("Ticket booked successfully!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateFare(){
        try{
            System.out.print("Enter ticket ID to update fare: ");
            String ticketId = sc.nextLine();
            System.out.print("Enter new fare: ");
            String newFare = sc.nextLine();
            String updateQuery = "UPDATE RailwayTicketDetail SET fare= ? WHERE ticket_id = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
            updateStmt.setString(1, newFare);
            updateStmt.setString(2, ticketId);
            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Fare updated successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateClass(){
        try{
            System.out.print("Enter ticket ID to update Class: ");
            String ticketId1 = sc.nextLine();
            System.out.print("Enter new class: ");
            String newClass = sc.nextLine();
            String updateQuery1 = "UPDATE RailwayTicketDetail SET class = ? WHERE ticket_id = ?";
            PreparedStatement updateStmt1 = con.prepareStatement(updateQuery1);updateStmt1.setString(1, newClass);
            updateStmt1.setString(2, ticketId1);
            int rowsUpdated1 = updateStmt1.executeUpdate();
            if (rowsUpdated1 > 0) {
                System.out.println("Class updated successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateDestination(){
        try{
            System.out.print("Enter ticket ID to update Destination: ");
            String ticketId2 = sc.nextLine();
            System.out.print("Enter new Destination: ");
            String newDestination = sc.nextLine();
            String updateQuery2 = "UPDATE RailwayTicketDetail SET destination=? WHERE ticket_id = ?";
            PreparedStatement updateStmt2 = con.prepareStatement(updateQuery2);updateStmt2.setString(1, newDestination);
            updateStmt2.setString(2, ticketId2);
            int rowsUpdated2 = updateStmt2.executeUpdate();
            if (rowsUpdated2 > 0) {
                System.out.println("Class updated successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateAge(){
        try{
            System.out.print("Enter ticket ID to update Age: ");
            String ticketId3 = sc.nextLine();
            System.out.print("Enter new Age: ");
            String newAge = sc.nextLine();
            String updateQuery3= "UPDATE RailwayTicketDetail SET age= ? WHERE ticket_id = ?";
            PreparedStatement updateStmt3 = con.prepareStatement(updateQuery3);updateStmt3.setString(1, newAge);
            updateStmt3.setString(2, ticketId3);
            int rowsUpdated3 = updateStmt3.executeUpdate();
            if (rowsUpdated3 > 0) {
                System.out.println("Class updated successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updatePhoneNo(){
        try{
            System.out.print("Enter ticket ID to update ph_number: ");
            String ticketId4 = sc.nextLine();
            System.out.print("Enter new ph_number ");
            String newph_number = sc.nextLine();
            String updateQuery4 = "UPDATE RailwayTicketDetail SET ph_number= ?WHERE ticket_id = ?";
            PreparedStatement updateStmt4 = con.prepareStatement(updateQuery4);updateStmt4.setString(1, newph_number);
            updateStmt4.setString(2, ticketId4);
            int rowsUpdated4 = updateStmt4.executeUpdate();
            if (rowsUpdated4 > 0) {
                System.out.println("Class updated successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deleteTicket(){
        try{
            System.out.print("Enter ticket ID to delete: ");
            String deleteTicketId = sc.nextLine();
            String deleteQuery = "DELETE FROM RailwayTicketDetail WHERE ticket_id= ?";
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
            deleteStmt.setString(1, deleteTicketId);
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Ticket deleted successfully!");
            } else {
                System.out.println("Ticket not found!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void showAllTickets(){
        try{
            String selectQuery = "SELECT * FROM RailwayTicketDetail";
            Statement stmt = null;
            ResultSet resultSet = stmt.executeQuery(selectQuery);
            if (!resultSet.next()) {
                System.out.println("No tickets found!");
            }
            else
            {
                System.out.print(" ----- TICKET DETAILS ----- ");
                System.out.println();
                System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                String output = String.format(" %-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s", "Ticket_ID",
                        "Name","Source","Destination","Class","age","gender","ph_number","Fare");
                System.out.print(output);
                System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.println();
                while (resultSet.next())
                {
                    String output1 = String.format(" %-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s",resultSet.getString(1) ,resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9));
                    System.out.print(output1);
                    System.out.println();
                }
                System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
