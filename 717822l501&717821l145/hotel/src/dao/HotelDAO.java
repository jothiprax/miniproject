package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;

public class HotelDAO implements HotelDAOInterface {
     Connection connection;

   

    @Override
    public boolean isRoomAvailable() {
        boolean roomAvailable = false;

        try {
            // Execute SQL query to check room availability
        	connection = DBConnection.createDBConnection();
            String query = "SELECT COUNT(*) FROM HotelRooms WHERE freeRooms >0";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Check if any available rooms found
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                roomAvailable = (count > 0);
            }

            // Close result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomAvailable;
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}