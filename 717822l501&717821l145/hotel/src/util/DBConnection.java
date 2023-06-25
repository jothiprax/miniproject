package util;import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;



public class DBConnection {
    static Connection connection;

    public static Connection createDBConnection() {
        try {
            // Load the Oracle JDBC driver
        	final String DBUrl="jdbc:oracle:thin:@localhost:1521:XE";
        	final String USER="717822l501@kce.ac.in";
        	final String PASS="@Akilesh2003";
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            connection = DriverManager.getConnection(DBUrl,USER,PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error establishing the database connection");
            e.printStackTrace();
        }
		return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection");
            e.printStackTrace();
        }
    }
}
