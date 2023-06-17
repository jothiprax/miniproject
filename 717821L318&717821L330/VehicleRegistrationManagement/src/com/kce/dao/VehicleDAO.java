package com.kce.dao;

import com.kce.bean.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
	private static Connection connection;

	public VehicleDAO(Connection connection) {
		VehicleDAO.connection = connection;
	}

	public void addVehicle(Vehicle vehicle) throws SQLException {
		String query = "INSERT INTO vehicle (vin,ownername, brand, model,vehicleno,color, phone_number, email, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, vehicle.getVin());
			statement.setString(2, vehicle.getOwnerName());
			statement.setString(3, vehicle.getBrand());
			statement.setString(4, vehicle.getModel());

			statement.setString(5, vehicle.getVehicleNo());
			statement.setString(6, vehicle.getColor());
			statement.setString(7, vehicle.getPhoneNumber());
			statement.setString(8, vehicle.getEmail());
			statement.setString(9, vehicle.getDate());

			statement.executeUpdate();
		}

	}

	public void updateVehicle(Vehicle vehicle) throws SQLException {
		String query = "UPDATE vehicle SET vin=?, ownername = ?, brand = ?, model = ?,vehicleno=?,color=?, phone_number = ?, email = ?, date = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, vehicle.getVin());
			statement.setString(2, vehicle.getOwnerName());
			statement.setString(3, vehicle.getBrand());
			statement.setString(4, vehicle.getModel());

			statement.setString(5, vehicle.getVehicleNo());
			statement.setString(6, vehicle.getColor());
			statement.setString(7, vehicle.getPhoneNumber());
			statement.setString(8, vehicle.getEmail());
			statement.setString(9, vehicle.getDate());
			statement.setInt(10, vehicle.getId());
			statement.executeUpdate();
		}
	}

	public void deleteVehicle(int vehicleId) throws SQLException {
		String query = "DELETE FROM vehicle WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, vehicleId);
			statement.executeUpdate();
		}
	}

	public static Vehicle getVehicleById(int vehicleId) throws SQLException {
		String query = "SELECT * FROM vehicle WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, vehicleId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Vehicle vehicle = new Vehicle();
					vehicle.setId(resultSet.getInt("id"));
					vehicle.setOwnerName(resultSet.getString("ownername"));
					vehicle.setBrand(resultSet.getString("brand"));
					vehicle.setModel(resultSet.getString("model"));
					vehicle.setColor(resultSet.getString("color"));
					vehicle.setPhoneNumber(resultSet.getString("phone_number"));
					vehicle.setEmail(resultSet.getString("email"));

					vehicle.setDate(resultSet.getString("date"));
					return vehicle;
				}
			}
		}
		return null;
	}

	public List<Vehicle> getAllVehicle() throws SQLException {
		List<Vehicle> vehicles = new ArrayList<>();
		String query = "SELECT * FROM vehicle";
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(resultSet.getInt("id"));
				vehicle.setOwnerName(resultSet.getString("ownername"));
				vehicle.setBrand(resultSet.getString("brand"));
				vehicle.setModel(resultSet.getString("model"));
				vehicle.setColor(resultSet.getString("color"));
				vehicle.setPhoneNumber(resultSet.getString("phone_number"));
				vehicle.setEmail(resultSet.getString("email"));

				vehicle.setDate(resultSet.getString("date"));

				vehicles.add(vehicle);
			}
		}
		return vehicles;
	}
}