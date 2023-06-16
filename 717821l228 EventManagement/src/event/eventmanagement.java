package event;

import java.sql.*;
import java.sql.DriverManager;

public class eventmanagement {

	    private static final String DB_URL = "jdbc:mysql://localhost/event_management";
	    private static final String DB_USER = "username";
	    private static final String DB_PASSWORD = "password";

	    public static void main(String[] args) {
	        Connection conn = null;
	        try {
	            // Connect to the database
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	            System.out.println("Connected to the database");

	            // Create tables if they don't exist
	            createTables(conn);

	            // Insert some sample data
	            insertSampleData(conn);

	            // Retrieve and display events
	            displayEvents(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the connection
	            if (conn != null) {
	                try {
	                    conn.close();
	                    System.out.println("Disconnected from the database");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    private static void createTables(Connection conn) throws SQLException {
	        Statement stmt = conn.createStatement();

	        // Create the event table
	        String createEventTable = "CREATE TABLE IF NOT EXISTS events ("
	                + "id INT AUTO_INCREMENT PRIMARY KEY,"
	                + "name VARCHAR(100) NOT NULL,"
	                + "date DATE NOT NULL,"
	                + "location VARCHAR(100) NOT NULL,"
	                + "description VARCHAR(255)"
	                + ")";
	        stmt.executeUpdate(createEventTable);

	        stmt.close();
	    }

	    private static void insertSampleData(Connection conn) throws SQLException {
	        Statement stmt = conn.createStatement();

	        // Insert sample events
	        String insertEvent1 = "INSERT INTO events (name, date, location, description) VALUES "
	                + "('Event 1', '2023-06-20', 'Location 1', 'Sample event 1')";
	        stmt.executeUpdate(insertEvent1);

	        String insertEvent2 = "INSERT INTO events (name, date, location, description) VALUES "
	                + "('Event 2', '2023-06-25', 'Location 2', 'Sample event 2')";
	        stmt.executeUpdate(insertEvent2);

	        stmt.close();
	    }

	    private static void displayEvents(Connection conn) throws SQLException {
	        Statement stmt = conn.createStatement();

	        // Retrieve events from the database
	        String selectEvents = "SELECT * FROM events";
	        ResultSet rs = stmt.executeQuery(selectEvents);

	        // Display events
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            Date date = rs.getDate("date");
	            String location = rs.getString("location");
	            String description = rs.getString("description");

	            System.out.println("Event ID: " + id);
	            System.out.println("Name: " + name);
	            System.out.println("Date: " + date);
	            System.out.println("Location: " + location);
	            System.out.println("Description: " + description);
	            System.out.println();
	        }

	        rs.close();
	        stmt.close();
	    }

}
