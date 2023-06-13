package com.kce.dao;

import com.kce.bean.Hospital;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
	private Connection connection;

	public HospitalDAO(Connection connection) {
		this.connection = connection;
	}

	public void addHospital(Hospital hospital) throws SQLException {
		String query = "INSERT INTO hospital (name, location, capacity, phone_number, email, director_name, emergency_contact, website, established_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, hospital.getName());
			statement.setString(2, hospital.getLocation());
			statement.setInt(3, hospital.getCapacity());
			statement.setString(4, hospital.getPhoneNumber());
			statement.setString(5, hospital.getEmail());
			statement.setString(6, hospital.getDirectorName());
			statement.setString(7, hospital.getEmergencyContact());
			statement.setString(8, hospital.getWebsite());
			statement.setString(9, hospital.getEstablishedDate());

			statement.executeUpdate();
		}
	}

	public void updateHospital(Hospital hospital) throws SQLException {
		String query = "UPDATE hospital SET name = ?, location = ?, capacity = ?, phone_number = ?, email = ?, director_name = ?, emergency_contact = ?, website = ?, established_date = ? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, hospital.getName());
			statement.setString(2, hospital.getLocation());
			statement.setInt(3, hospital.getCapacity());
			statement.setString(4, hospital.getPhoneNumber());
			statement.setString(5, hospital.getEmail());
			statement.setString(6, hospital.getDirectorName());
			statement.setString(7, hospital.getEmergencyContact());
			statement.setString(8, hospital.getWebsite());
			statement.setString(9, hospital.getEstablishedDate());
			statement.setInt(10, hospital.getId());

			statement.executeUpdate();
		}
	}

	public void deleteHospital(int hospitalId) throws SQLException {
		String query = "DELETE FROM hospital WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, hospitalId);
			statement.executeUpdate();
		}
	}

	public Hospital getHospitalById(int hospitalId) throws SQLException {
		String query = "SELECT * FROM hospital WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, hospitalId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Hospital hospital = new Hospital();
					hospital.setId(resultSet.getInt("id"));
					hospital.setName(resultSet.getString("name"));
					hospital.setLocation(resultSet.getString("location"));
					hospital.setCapacity(resultSet.getInt("capacity"));
					hospital.setPhoneNumber(resultSet.getString("phone_number"));
					hospital.setEmail(resultSet.getString("email"));
					hospital.setDirectorName(resultSet.getString("director_name"));
					hospital.setEmergencyContact(resultSet.getString("emergency_contact"));
					hospital.setWebsite(resultSet.getString("website"));
					hospital.setEstablishedDate(resultSet.getString("established_date"));
					return hospital;
				}
			}
		}

		return null;
	}

	public List<Hospital> getAllHospitals() throws SQLException {
		List<Hospital> hospitals = new ArrayList<>();
		String query = "SELECT * FROM hospital";

		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Hospital hospital = new Hospital();
				hospital.setId(resultSet.getInt("id"));
				hospital.setName(resultSet.getString("name"));
				hospital.setLocation(resultSet.getString("location"));
				hospital.setCapacity(resultSet.getInt("capacity"));
				hospital.setPhoneNumber(resultSet.getString("phone_number"));
				hospital.setEmail(resultSet.getString("email"));
				hospital.setDirectorName(resultSet.getString("director_name"));
				hospital.setEmergencyContact(resultSet.getString("emergency_contact"));
				hospital.setWebsite(resultSet.getString("website"));
				hospital.setEstablishedDate(resultSet.getString("established_date"));

				hospitals.add(hospital);
			}
		}

		return hospitals;
	}
}
