package com.kce.service;
import java.util.*;
import java.sql.*;
import com.kce.Dao.*;
import com.kce.util.BedNotSufficientException;

public class Main {
public static void main(String[] args) throws SQLException, BedNotSufficientException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		AdminDao p=new AdminDao();
		p.createDischargeDetails();
		p.createPatientDetails();
		p.createPaymentDetails();
		System.out.println("HOSPITAL MANAGEMENT SYSTEM");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Enter a option for your need:");
		System.out.println("1.Admit the patient");
		System.out.println("2.Discharge the patient");
		System.out.println("3.Bill Generation");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			p.admitPatient();
			System.out.println("The beds availability is");
			p.showOccupancy();
			break;
		case 2:
			p.createDischargeDetails();
			p.dischargePatient();
			break;
		case 3:
			p.generateBill();
			break;
		}
}
}
