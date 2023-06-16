package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.InventoryException;
import com.kce.bean.Order;
import com.kce.util.DatabaseConnection;

public class OrderDAO {
	public void addOrder(Order order) throws InventoryException {
        validateOrder(order);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (item_id, quantity) VALUES (?, ?)")) {
            statement.setInt(1, order.getItemId());
            statement.setInt(2, order.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new InventoryException("Failed to add order: " + e.getMessage());
        }
    }

    public void deleteOrder(int orderId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?")) {
            statement.setInt(1, orderId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 0) {
                throw new InventoryException("Order not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to delete order: " + e.getMessage());
        }
    }

    public Order getOrder(int orderId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?")) {
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int itemId = resultSet.getInt("item_id");
                int quantity = resultSet.getInt("quantity");
                return new Order(orderId, itemId, quantity);
            } else {
                throw new InventoryException("Order not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to retrieve order: " + e.getMessage());
        }
    }

    private void validateOrder(Order order) throws InventoryException {
        if (order.getQuantity() < 0) {
            throw new InventoryException("Quantity cannot be negative");
        }
    }


}
