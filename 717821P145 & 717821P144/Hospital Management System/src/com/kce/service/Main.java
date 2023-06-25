package com.kce.service;
import com.kce.bean.*;
import com.kce.*;
import com.kce.dao.*;
import java.util.*;
public class Main {
 private static Scanner sc = new Scanner(System.in);
 private static Scanner sc1 = new Scanner(System.in);
 private static List<Hospital> hospitals = new ArrayList<>();
 private static List<Patient> patients = new ArrayList<>();
 public static void main(String args[]) {
 System.out.println("Hospital Management System!");
 System.out.println();
 int repeat;
 do {
 System.out.println("Do you want to manage Patients?, Enter 1");
 System.out.println("Do you want to manage Hospitals?, Enter 2");
 int mainChoice = sc.nextInt();
 if (mainChoice == 1) {
 System.out.println("Do you want to add a Patient then, press 1");
 System.out.println("Check about the particular Patient, press 2");
 System.out.println("To View all the patients, press 3");
 System.out.println("To Update the Patient Health status!, press 4");
 System.out.println("To discharge the Patient, press 5");
 int PatientChoice = sc.nextInt();
 if (PatientChoice == 1)
 createPatient();
 else if (PatientChoice == 2)
 particularPatient();
 else if (PatientChoice == 3)
 allPatient();
 else if (PatientChoice == 4)
 updatePatient();
 else
 dischargePatient();
 } else {
 System.out.println("To create a New Hospital ward, press 1");
 System.out.println("To Update an existing ward, press 2");
 System.out.println("To Delete an existing ward, press 3");
 System.out.println("To view a Ward, press 4");
 int resortChoice = sc.nextInt();
 if (resortChoice == 1)
 createWard();
 else if (resortChoice == 2)
 updateWard();
 else if (resortChoice == 3)
 deleteWard();
 else
 getWard();
 }
 System.out.println("Do you want to continue your work? Press 1 for Yes, 0 for No");
 repeat = sc.nextInt();
 } while (repeat == 1);
 }
 public static void createWard() {
 System.out.println("Enter the resort id");
 int id = sc.nextInt();
 System.out.println("Enter the resort name");
 String name = sc1.nextLine();
 System.out.println("Enter the resort location");
 String location = sc1.nextLine();
 Hospital resort = new  Hospital(id, name, location);
 hospitals.add(resort);
 System.out.println("Resort created successfully!");
 }
 public static void  updateWard() {
 System.out.println("Enter the resort id");
 int id = sc.nextInt();
 Hospital resort = findHospitalById(id);
 if (resort != null) {
 System.out.println("Enter the new resort name");
 String name = sc1.nextLine();
 System.out.println("Enter the new resort location");
 String location = sc1.nextLine();
 resort.setName(name);
 resort.setLocation(location);
 System.out.println("Resort updated successfully!");
 } else {
 System.out.println("Resort not found!");
 }
 }
 public static void  deleteWard() {
 System.out.println("Enter the resort id");
 int id = sc.nextInt();
 Hospital hospital = findHospitalById(id);
 if (hospital != null) {
 hospitals.remove(hospital);
 System.out.println("Resort deleted successfully!");
 } else {
 System.out.println("Resort not found!");
 }
 }
 public static void  getWard() {
 System.out.println("Enter the resort id");
 int id = sc.nextInt();
 Hospital resort = findHospitalById(id);
 if (resort != null) {
 System.out.println("Resort ID: " + resort.getId());
 System.out.println("Resort Name: " + resort.getName());
 System.out.println("Resort Location: " + resort.getLocation());
 } else {
 System.out.println("Resort not found!");
 }
 }
 public static void createPatient() {
 System.out.println("Enter the Patient id");
 int id = sc.nextInt();
 System.out.println("Enter the Patient name");
 String name = sc1.nextLine();
 System.out.println("Enter the Patient Disease");
 String disease = sc1.nextLine();
 Patient guest = new Patient(id, name, disease);
 patients.add(guest);
 System.out.println("Patient admitted successfully!");
 }
 public static void particularPatient() {
 System.out.println("Enter the Patient id");
 int id = sc.nextInt();
 Patient g = findPatientById(id);
 if (g != null) {
 System.out.println("Patient ID: " + g.getId());
 System.out.println("Guest Name: " + g.getName());
 System.out.println("Patient Disease: " + g.getdisease());
 } else {
 System.out.println("Patient not found!");
 }
 }
 public static void allPatient() {
 System.out.println("List of all Patients:");
 for ( Patient patient : patients) {
 System.out.println("Patient ID: " + patient.getId());
 System.out.println("Patient Name: " + patient.getName());
 System.out.println("Patient Disease: " + patient.getdisease());
 }
 }
 public static void updatePatient() {
 System.out.println("Enter the patient id");
 int id = sc.nextInt();
 Patient guest = findPatientById(id);
 if (guest != null) {
 System.out.println("Enter the new patient name");
 String name = sc1.nextLine();
 System.out.println("Enter the patient's Disease");
 String email = sc1.nextLine();
 guest.setName(name);
 guest.setdisease(email);
 System.out.println("Pateint updated successfully!");
 } else {
 System.out.println("Patient not found!");
 }
 }
 public static void dischargePatient() {
 System.out.println("Enter the Patient id");
 int id = sc.nextInt();
 Patient patient = findPatientById(id);
 if (patient != null) {
	 patients.remove(patient);
 System.out.println("Patient discharged successfully!");
 } else {
 System.out.println("Patient not found!");
 }
 }
 private static Hospital findHospitalById(int id) {
 for (Hospital hospital : hospitals) {
 if (hospital.getId() == id) {
 return hospital;
 }
 }
 return null;
 }
 private static Patient findPatientById(int id) {
 for (Patient patient : patients) {
 if (patient.getId() == id) {
 return patient;
 }
 }
 return null;
 }
}


