package com.kce.service;


import com.kce.bean.Patient;
import com.kce.service.PatientManager;

import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientManager patientManager = new PatientManager();

        while (true) {
            System.out.println("----- Hospital Management System -----");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    Patient patient = new Patient(patientId, name, age);
                    patientManager.addPatient(patient);
                    break;
                case 2:
                    System.out.print("Enter Patient ID to update: ");
                    int updatePatientId = scanner.nextInt();
                    System.out.print("Enter updated Patient Name: ");
                    String updatedName = scanner.next();
                    System.out.print("Enter updated Patient Age: ");
                    int updatedAge = scanner.nextInt();
                    Patient updatedPatient = new Patient(updatePatientId, updatedName, updatedAge);
                    patientManager.updatePatient(updatedPatient);
                    break;
                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int deletePatientId = scanner.nextInt();
                    patientManager.deletePatient(deletePatientId);
                    break;
                case 4:
                    patientManager.displayAllPatients();
                    break;
                case 5:
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
