package com.kce.dao;

import com.kce.bean.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.util.DBUtil;

public class TicketDAO {
    private Connection connection;

    public TicketDAO() {
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bookTicket(Ticket ticket) {
        String query = "INSERT INTO tickets (ticket_number, passenger_name, train_number, journey_date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ticket.getTicketNumber());
            statement.setString(2, ticket.getPassengerName());
            statement.setInt(3, ticket.getTrainNumber());
            statement.setString(4, ticket.getJourneyDate());

            statement.executeUpdate();
            System.out.println("Ticket booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelTicket(int ticketNumber) {
        String query = "DELETE FROM tickets WHERE ticket_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ticketNumber);

            statement.executeUpdate();
            System.out.println("Ticket canceled successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ticket getTicketByNumber(int ticketNumber) {
        String query = "SELECT * FROM tickets WHERE ticket_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ticketNumber);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Ticket ticket = new Ticket(resultSet.getInt("ticket_number"),
                        resultSet.getString("passenger_name"),
                        resultSet.getInt("train_number"),
                        resultSet.getString("journey_date"));
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
