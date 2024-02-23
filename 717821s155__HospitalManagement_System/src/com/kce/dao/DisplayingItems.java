package com.kce.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

import com.kce.util.ConnectionToDb;

public class DisplayingItems implements DisplayAll {
  
	
	Connection con =ConnectionToDb.getConnection(); 
	@Override
	//select function for Doctors
	public void displayAllDoctors() {
		
		System.out.println("\t\t\t\t\t\t\t Doctor List \n");
		try {
			PreparedStatement stmt=con.prepareStatement("select * from doctors;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%17s %18s %22s %22s %15s %26s %55s \n","DoctorID","DoctorName","Qualification","Specialist","Room_No","Hospital_Name","Hospital_Address");
			while(rs.next()) {
				
				fmt.format("%15s %17s %20s %25s %15s %25s %75s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
}
		
	public void DisplayRecordByDoctorId() {
		
		try {
			PreparedStatement stmt=con.prepareStatement("select * from doctors where DoctorID = ?");
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" Enter the DoctorID :");
			int i = sc.nextInt();
			
			stmt.setInt(1, i);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name =rs.getString(2);
				String qual = rs.getString(3);
				String spl = rs.getString(4);
				int no = rs.getInt(5);
				String hname=rs.getString(6);
				String add = rs.getString(7);
				
			
				System.out.printf(" DoctorID : %d , DoctorName : %s  Qualification : %s , Specialist : %s , RoomNo : %d, Hospital_Name : %s, Hospital_Address : %s",id,name,qual,spl,no,hname,add);
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
		
		
	}
		
	

	@Override
	//select function for patients
	public void displayAllPatients() {
		
		System.out.println("\t\t\t\t\t\t\t Patient List \n");
		try {
			PreparedStatement stmt=con.prepareStatement("select * from patients;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%17s %18s %18s %25s %15s %26s %55s \n","PatientID","PatientName","Gender","Disease_Type","Age","Hospital_Name","Hospital_Address");
			while(rs.next()) {
				
				fmt.format("%15s %17s %20s %25s %15s %25s %75s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
		
}

	@Override
	//select function for nurse
	public void displayAllNurses() {
		
		
		System.out.println("\t\t\t\t\t\t\t Nurse List \n");
		try {
			PreparedStatement stmt=con.prepareStatement("select * from nurses;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%17s %16s %26s %39s \n","NurseID","NurseName","Hospital_Name","Hospital_Address");
			while(rs.next()) {
				
				fmt.format("%15s %17s %25s %75s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
		
		}
	
	public void DisplayRecordByPatientId() {
		
		try {
			PreparedStatement stmt=con.prepareStatement("select * from patients where PatientID = ?;");
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" Enter the PatientID :");
			int i = sc.nextInt();
			
			stmt.setInt(1, i);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name =rs.getString(2);
				String gen = rs.getString(3);
				String dtype = rs.getString(4);
				int no = rs.getInt(5);
				String hname=rs.getString(6);
				String add = rs.getString(7);
				
			System.out.printf(" PatientID : %d , PatientName : %s  Gender : %s , DiseaseType : %s , Age : %d, Hospital_Name : %s, Hospital_Address : %s",id,name,gen,dtype,no,hname,add);
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
		
		
	}
	
	public void DisplayRecordByNurseId() {
		
		try {
			PreparedStatement stmt=con.prepareStatement("select * from nurses where NurseID = ?;");
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" Enter the NurseID :");
			int i = sc.nextInt();
			
			stmt.setInt(1, i);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name =rs.getString(2);
				String hname=rs.getString(3);
				String add = rs.getString(4);
				
			System.out.printf(" NurseID : %d , NurseName : %s , Hospital_Name : %s, Hospital_Address : %s",id,name,hname,add);
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
		
		
	}
	
	

}
