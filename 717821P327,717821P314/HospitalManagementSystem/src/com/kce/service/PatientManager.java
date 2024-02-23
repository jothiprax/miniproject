package com.kce.service;


import com.kce.bean.Patient;
import com.kce.dao.PatientDAO;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// Class to manage patients
public class PatientManager {
    private PatientDAO patientDAO;

    public PatientManager() {
        Connection connection;
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Database connection error: " + e.getMessage());
        }
        patientDAO = new PatientDAO(connection);
    }

    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
        System.out.println("Patient added successfully!");
    }

    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
        System.out.println("Patient updated successfully!");
    }

    public void deletePatient(int patientId) {
        patientDAO.deletePatient(patientId);
        System.out.println("Patient deleted successfully!");
    }

    public void displayAllPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        for (Patient patient : patients) {
            System.out.println("Patient ID: " + patient.getPatientId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println();
        }
    }
}
