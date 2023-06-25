package airline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class connectionclass {
	    private static final  String URL = "jdbc:mysql://localhost:3306/flight_reservation";
	    private static final  String USERNAME = "root";
	    private static final  String PASSWORD = "root";
	    private Connection connection;

	    public Connection getConnection(int a) throws SQLException {
	        try {
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            System.out.println("You're Connected with database!");
	        } catch (SQLException e) {
	            System.err.println("Error occur in connecting with  database: " + e.getMessage());
	        }
	       return connection;
	    }
	    public Connection getConnection() throws SQLException {
	        try {
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } catch (SQLException e) {
	            System.err.println("Error occur in connecting with database: " + e.getMessage());
	        }
	       return connection;
	    }

	    public void closeConnection() {
	        try {
	            connection.close();
	            System.out.println("Connection closed.");
	        } catch (SQLException e) {
	            System.err.println("Error closing the connection: " + e.getMessage());
	        }
	    }

}