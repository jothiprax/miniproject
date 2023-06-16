package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.InventoryException;
import com.kce.bean.InventoryLevel;
import com.kce.util.DatabaseConnection;

public class InventoryLevelDAO {
	public void addLevel(InventoryLevel level) throws InventoryException {
        validateLevel(level);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO inventory_levels (item_id, quantity) VALUES (?, ?)")) {
            statement.setInt(1, level.getItemId());
            statement.setInt(2, level.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new InventoryException("Failed to add inventory level: " + e.getMessage());
        }
    }

    public void updateLevel(InventoryLevel level) throws InventoryException {
        validateLevel(level);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE inventory_levels SET quantity = ? WHERE level_id = ?")) {
            statement.setInt(1, level.getQuantity());
            statement.setInt(2, level.getLevelId());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new InventoryException("Inventory level not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to update inventory level: " + e.getMessage());
        }
    }

    public void deleteLevel(int levelId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM inventory_levels WHERE level_id = ?")) {
            statement.setInt(1, levelId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 0) {
                throw new InventoryException("Inventory level not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to delete inventory level: " + e.getMessage());
        }
    }

    public InventoryLevel getLevel(int levelId) throws InventoryException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM inventory_levels WHERE level_id = ?")) {
            statement.setInt(1, levelId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int itemId = resultSet.getInt("item_id");
                int quantity = resultSet.getInt("quantity");
                return new InventoryLevel(levelId, itemId, quantity);
            } else {
                throw new InventoryException("Inventory level not found");
            }
        } catch (SQLException e) {
            throw new InventoryException("Failed to retrieve inventory level: " + e.getMessage());
        }
    }

    private void validateLevel(InventoryLevel level) throws InventoryException {
        if (level.getQuantity() < 0) {
            throw new InventoryException("Quantity cannot be negative");
        }
    }


}
