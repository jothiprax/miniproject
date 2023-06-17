package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.kce.bean.*;
import com.kce.util.BedNotSufficientException;
import com.kce.util.DBUtil;

public class AdminDao {
	private static Connection con;
	 private static PreparedStatement pstmt;
	 private static Scanner sc=new Scanner(System.in);
	 private static ResultSet rs;
	 private static ResultSet rs1;
	 private static ResultSet rs2;
	 private static Statement stmt;
	 PaymentDetails p= new PaymentDetails();
	 //CREATING TABLES IF NOT EXISTS
	 public void createDischargeDetails()throws ClassNotFoundException,SQLException{
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate("create table if not exists DischargeDetails(admissionNo int,dateOfDischarge varchar(10))"); 
	 }
	 public void createPaymentDetails()throws ClassNotFoundException,SQLException{
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate("create table if not exists PaymentDetails(disease varchar(20),testsRequired varchar(100),totalCost int)"); 
	 }
	 public void createPatientDetails()throws ClassNotFoundException,SQLException{
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate("create table if not exists PatientDetails(admissionNo int,name varchar(50), bloodGroup varchar(50),disease varchar(30),dateOfJoin varchar(10))");
		 }
	 //INSERTING PAYMENT DETAILS WHICH INDICATES TEST COSTS
	 public void insertPaymentDetails()throws ClassNotFoundException,SQLException{
		 Connection con=DBUtil.getConnection();
		 pstmt = con.prepareStatement(" insert into PaymentDetails values(?,?,?)");
	        System.out.println("Disease:");
	        pstmt.setString(1,sc.next());
	        System.out.println("Test required:");
	        pstmt.setString(2,sc.next());
	        sc.nextLine();
	        System.out.println("Total Cost:");
	        pstmt.setInt(3,sc.nextInt());
	        pstmt.executeUpdate();
	        }
	 //THIS METHOD IS USED TO ADMIT PATIENTS BY GETTING THE VALUES TO THE PATIENT DETAILS TABLE AND IT CHECKS IF THE HOSPITAL HAS THE BED TO ADMIT PATIENT
	 public void admitPatient() throws SQLException,BedNotSufficientException{
			try{
				Connection con=DBUtil.getConnection(); 
	        if(p.getOccupiedBed() == Hospital.noOfBed){
	            throw new BedNotSufficientException("Beds not available. Can't admit patient.");
	        }
	        else{
	            System.out.println("Patient admitted successfully.");
	            p.occupiedBed++;
	        }
	        pstmt = con.prepareStatement(" insert into PatientDetails values(?,?,?,?,?)");
	        System.out.println("Admission number:");
	        pstmt.setInt(1,sc.nextInt());
	        System.out.println("Name:");
	        pstmt.setString(2,sc.next());
	        System.out.println("Blood Group:");
	        pstmt.setString(3,sc.next());
	        System.out.println("Disease:");
	        pstmt.setString(4,sc.next());
	        System.out.println("Date:");
	        pstmt.setString(5,sc.next());
	        pstmt.executeUpdate();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
			System.out.println("data inserted successfully");
		}
	 //THIS METHOD CHECKS IF THERE IS A BED OCCUPIED BY THE PATIENT AND WHEN WE ARE DISCHARGING THEM OCCUPIED BED WILL BE DECREMENTED
		 public void dischargePatient(){
		        if(p.getOccupiedBed() == 0){
		            System.out.println("No patients to discharge.");
		        }
		        else{
		            System.out.println("Patient discharged successfully.");
		           p.occupiedBed--;
		        }
		    }
		 //THIS METHOD IS TO GET DISCHARGE DETAILS TO STORE IT IN DISCHARGEDETAILS TABLE
		 public void insertDischargeDetails()throws ClassNotFoundException,SQLException{
			 Connection con=DBUtil.getConnection();
			 pstmt = con.prepareStatement(" insert into DischargeDetails values(?,?)");
		        System.out.println("Adimission number:");
		        pstmt.setInt(1,sc.nextInt());
		        System.out.println("Date of discharge:");
		        pstmt.setString(2,sc.next());
		        pstmt.executeUpdate();
		        }
		 //THIS METHOD WILL SHOW THE CURRENT STATUS OF BED AVAILABILITY
		 public void showOccupancy(){
		        System.out.println("Total Beds: " + Hospital.noOfBed);
		        System.out.println("Occupied Beds: " + p.occupiedBed);
		        System.out.println("Available Beds: " + (Hospital.noOfBed - p.occupiedBed));
		    }
		 //THIS METHOD IS TO PRINT DETAILS OF HOSPITAL TABLE IN THE BILL
		 public void patientBill(int adno) throws SQLException, ClassNotFoundException {
			 Connection con=DBUtil.getConnection();
			 pstmt=con.prepareStatement("Select * from PatientDetails where admissionNo=?");
			
			 pstmt.setInt(1, adno);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
						StringBuilder bill=new StringBuilder();
						bill.append("---------------------------------------------------------------------------------------").append("\n");
						bill.append("|                                    HOSPITAL RECIPT                                  |").append("\n");
						bill.append("---------------------------------------------------------------------------------------").append("\n");
						bill.append("Admission No: ").append(rs.getInt(1)).append("\n");
						bill.append("Patient Name: ").append(rs.getString(2)).append("\n");
						bill.append("Blood Group: ").append(rs.getString(3)).append("\n");
				        bill.append("Disease: ").append(rs.getString(4)).append("\n");
				        bill.append("Date of join: ").append(rs.getString(5)).append("\n");
				        System.out.print(bill.toString());
					
			 }
		 }
		 //THIS METHOD IS TO PRINT DETAILS OF DISCHARGE DETAILS TABLE IN THE BILL
		 public void DischargeBill(int adno) throws ClassNotFoundException, SQLException {
			 Connection con=DBUtil.getConnection();
			 pstmt=con.prepareStatement("Select dateOfDischarge from DischargeDetails where admissionNo=?");
			 pstmt.setInt(1, adno);
			 rs=pstmt.executeQuery();
			while(rs.next()) {
				StringBuilder bill=new StringBuilder();
						 bill.append("Date of discharge: ").append(rs.getString("dateOfDischarge")).append("\n");
						 bill.append("---------------------------------------------------------------------------------------").append("\n");
						 System.out.print(bill.toString());
					
				
			 }
		 }
		 //THIS METHOD IS TO PRINT DETAILS OF PAYMENT DETAILS TABLE IN THE BILL
		 public void PaymentBill(String dis) throws ClassNotFoundException,SQLException {
			 Connection con=DBUtil.getConnection();
			 pstmt=con.prepareStatement("Select * from PaymentDetails where disease=?");
			 pstmt.setString(1, dis);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
						StringBuilder bill=new StringBuilder();
						bill.append("---------------------------------------------------------------------------------------").append("\n");
						bill.append(String.format("| %-65s | %-15s |\n","Test","Price"));
						bill.append("---------------------------------------------------------------------------------------").append("\n");
						bill.append(String.format("| %-65s | %-15d |\n",rs.getString("testsRequired"),rs.getInt("totalcost")));
						bill.append("---------------------------------------------------------------------------------------").append("\n");
						System.out.println(bill.toString());
					}
		 }
		 //THIS METHOD IS TO GENERATE BILL
		 public void generateBill() throws ClassNotFoundException,SQLException {
			 System.out.println("Admission number for the patient to display bill");
			 int adno=sc.nextInt();
			 System.out.println("Enter the disease of the patient to display bill");
		      String dis=sc.next();
			 AdminDao a=new AdminDao();
			 a.patientBill(adno);
			 a.DischargeBill(adno);
		      a.PaymentBill(dis);
		 }
}
