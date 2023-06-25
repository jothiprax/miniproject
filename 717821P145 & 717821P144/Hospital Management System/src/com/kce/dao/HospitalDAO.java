package com.kce.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bean.Hospital;
public class HospitalDAO {
 private Connection connection;
 public HospitalDAO() throws SQLException {
 // Establishing database connection
 connection = 
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","21p145");
 }
 // CRUD operations using prepared statement
 public void createResort(Hospital hospital) throws SQLException {
 String sql = "INSERT INTO resorts (id, name, location) VALUES (?, ?, ?)";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setInt(1, hospital.getId());
 statement.setString(2, hospital.getName());
 statement.setString(3, hospital.getLocation());
 statement.executeUpdate();
 }
 public void updateResort(Hospital hospital) throws SQLException {
 String sql = "UPDATE resorts SET name = ?, location = ? WHERE id = ?";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setString(1, hospital.getName());
 statement.setString(2, hospital.getLocation());
 statement.setInt(3, hospital.getId());
 statement.executeUpdate();
 }
 public void deleteResort(int id) throws SQLException {
 String sql = "DELETE FROM resorts WHERE id = ?";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setInt(1, id);
 statement.executeUpdate();
 }
 public Hospital getResortById(int id) throws SQLException {
 String sql = "SELECT * FROM hospitals WHERE id = ?";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setInt(1, id);
 ResultSet resultSet = statement.executeQuery();
 if (resultSet.next()) {
 String name = resultSet.getString("name");
 String location = resultSet.getString("location");
 return new Hospital(id, name, location);
 }
 return null;
 }
}