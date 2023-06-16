package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.InventoryException;
import com.kce.bean.InventoryItem;
import com.kce.util.DatabaseConnection;

public class InventoryItemDAO {
	public void addItem(InventoryItem item) throws InventoryException {
        validateItem(item);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO items (item_name, quantity) VALUES (?, ?)")) {
            statement.setString(1, item.getItemName());
            statement.setInt(2, item.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new InventoryException("Failed to add item: " + e.getMessage());
        }
    }

    public void updateItem(InventoryItem item) throws InventoryException {
        validateItem(item);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE items SET item_name = ?, quantity = ? WHERE item_id = ?")) {
            statement.setString(1, item.getItemName());
            statement.setInt(2, item.getQuantity());
            statement.setInt(3, item.getItemId());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new InventoryException("Item not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to update item: " + e.getMessage());
        }
    }

    public void deleteItem(int itemId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?")) {
            statement.setInt(1, itemId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 0) {
                throw new InventoryException("Item not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to delete item: " + e.getMessage());
        }
    }

    public InventoryItem getItem(int itemId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?")) {
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String itemName = resultSet.getString("item_name");
                int quantity = resultSet.getInt("quantity");
                return new InventoryItem(itemId, itemName, quantity);
            } else {
                throw new InventoryException("Item not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to retrieve item: " + e.getMessage());
        }
    }

    private void validateItem(InventoryItem item) throws InventoryException {
        if (item.getItemName().isEmpty()) {
            throw new InventoryException("Item name cannot be empty");
        }

        if (item.getQuantity() < 0) {
            throw new InventoryException("Quantity cannot be negative");
        }
    }


}
