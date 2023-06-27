package com.kce.dao;

import com.kce.bean.Ticket;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class TicketDAO {
    public static List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        Connection connection = DBUtil.getConnection();

        String selectQuery = "SELECT * FROM tickets";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int ticketId = resultSet.getInt("ticket_id");
            int trainId = resultSet.getInt("train_id");
            String passengerName = resultSet.getString("passenger_name");
            Ticket ticket = new Ticket(ticketId, trainId, passengerName);
            tickets.add(ticket);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return tickets;
    }

    public void addTicket(Ticket ticket) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String insertQuery = "INSERT INTO tickets (ticket_id, train_id, passenger_name) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, ticket.getTicketId());
        statement.setInt(2, ticket.getTrainId());
        statement.setString(3, ticket.getPassengerName());
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    public static void deleteTicket(int ticketId) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String deleteQuery = "DELETE FROM tickets WHERE ticket_id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, ticketId);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }
public void viewAllTickets() throws SQLException {
    List<Ticket> tickets = null;
	try {
		tickets = TicketDAO.getAllTickets();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    System.out.println("----- All Tickets -----");
    for (Ticket ticket : tickets) {
        ticket.displayDetails();
        System.out.println();
    }
}

public void cancelTicket(Scanner scanner) throws SQLException {
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
