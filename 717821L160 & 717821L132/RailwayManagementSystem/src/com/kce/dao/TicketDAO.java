package com.kce.dao;

import com.kce.bean.Ticket;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    public static List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Vaishu@06");

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

    public static void addTicket(Ticket ticket) throws SQLException {
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
}