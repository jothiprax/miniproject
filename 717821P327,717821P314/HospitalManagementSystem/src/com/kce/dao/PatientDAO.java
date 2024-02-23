package com.kce.dao;


import com.kce.bean.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object for patient operations
public class PatientDAO {
    private Connection connection;

    public PatientDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPatient(Patient patient) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO patients (patient_id, name, age) VALUES (?, ?, ?)");
            statement.setInt(1, patient.getPatientId());
            statement.setString(2, patient.getName());
            statement.setInt(3, patient.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    public void updatePatient(Patient patient) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE patients SET name = ?, age = ? WHERE patient_id = ?");
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setInt(3, patient.getPatientId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new PatientNotFoundException("Patient not found with ID: " + patient.getPatientId());
            }
        } catch (SQLException e) {
            System.out.println("Error updating patient: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    public void deletePatient(int patientId) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM patients WHERE patient_id = ?");
            statement.setInt(1, patientId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new PatientNotFoundException("Patient not found with ID: " + patientId);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    public List<Patient> getAllPatients() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Patient> patients = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM patients");
            while (resultSet.next()) {
                int patientId = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Patient patient = new Patient(patientId, name, age);
                patients.add(patient);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving patients: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement or result set: " + e.getMessage());
            }
        }
        return patients;
    }
}
