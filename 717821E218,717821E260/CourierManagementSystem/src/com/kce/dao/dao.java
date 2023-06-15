package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bean.Courier;
import com.kce.service.DBUtil;


public class dao {
	 
    private Connection connection;
    private PreparedStatement statement;
    
    
    public void disconnect() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    
    // Create a new courier entity
    public void createCourier(Courier courier) throws SQLException {
        String sql = "INSERT INTO courier (id, name) VALUES (?, ?)";
        Connection connection = DBUtil.createConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, courier.getId());
        statement.setString(2, courier.getName());
        statement.executeUpdate();
    }
    
    // Read a courier entity by ID
    public Courier readCourier(int id) throws SQLException {
        String sql = "SELECT * FROM courier WHERE id = ?";
        Connection connection = DBUtil.createConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Courier courier = new Courier();
            courier.setId(resultSet.getInt("id"));
            courier.setName(resultSet.getString("name"));
            return courier;
        }
        return null;
    }
    
    // Update a courier entity
    public void updateCourier(Courier courier) throws SQLException {
        String sql = "UPDATE courier SET name = ? WHERE id = ?";
        Connection connection = DBUtil.createConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1, courier.getName());
        statement.setInt(2, courier.getId());
        statement.executeUpdate();
    }
    
    // Delete a courier entity
    public void deleteCourier(int id) throws SQLException {
        String sql = "DELETE FROM courier WHERE id = ?";
        Connection connection = DBUtil.createConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
