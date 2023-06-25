package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kce.bean.Patient;
public class PatientDAO {
private Connection connection;
 public PatientDAO(Connection connection) {
 this.connection = connection;
 }
 public void createPatient(Patient guest) throws SQLException {
 String query = "INSERT INTO patient (name, disease) VALUES (?, ?)";
 try (
		 PreparedStatement statement = connection.prepareStatement(query)) {
 statement.setString(1, Patient.getName());
 statement.setString(2, Patient.getdisease());
 statement.executeUpdate();
 }
 }
 public Patient getPatientById(int id) throws SQLException {
 String query = "SELECT * FROM guests WHERE id = ?";
 try (PreparedStatement statement = connection.prepareStatement(query)) {
 statement.setInt(1, id);
 try (ResultSet resultSet = statement.executeQuery()) {
 if (resultSet.next()) {
 String name = resultSet.getString("name");
 String disease = resultSet.getString("disease");
 return new Patient(id, name, disease);
 }
 }
 }
 return null; // Guest not found
 }
 public List<Patient> getAllPatient() throws SQLException {
 List<Patient> patients = new ArrayList<>();
 String query = "SELECT * FROM patient";
 try (PreparedStatement statement = connection.prepareStatement(query);
 ResultSet resultSet = statement.executeQuery()) {
 while (resultSet.next()) {
 int id = resultSet.getInt("id");
 String name = resultSet.getString("name");
 String email = resultSet.getString("email");
 patients.add(new Patient(id, name, email));
 }
 }
 return patients;
 }
 public void updatePatient(Patient patient) throws SQLException {
 String query = "UPDATE guests SET name = ?, email = ? WHERE id = ?";
 try (PreparedStatement statement = connection.prepareStatement(query)) {
 statement.setString(1, patient.getName());
 statement.setString(2, patient.getdisease());
 statement.setInt(3, patient.getId());
 statement.executeUpdate();
 }
 }
 public void dischargePatient(int id) throws SQLException {
 String query = "DELETE FROM patient WHERE id = ?";
 try (PreparedStatement statement = connection.prepareStatement(query)) {
 statement.setInt(1, id);
 statement.executeUpdate();
 }
 }
}
