package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Ticket;
//import com.kce.util.DBUtil;

	public class TicketDAO {
	    private static final Statement DBUtil = null;

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

