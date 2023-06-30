package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.kce.util.ConnectionToDb;
import com.kce.util.ImproperValueException;

public class InsertItems implements Insert{
   
	  
	Connection con =ConnectionToDb.getConnection(); 
	PreparedStatement prSt;
	//insert function for doctor
	@Override
	public void InsertDoctor() {
		
		String query = "insert into doctors(DoctorID,DName,Qualification,Specialist,RoomNo,Hospital_Name,Hospital_Address) values(?,?,?,?,?,?,?)";
		     
	      try {
	           
	    	    prSt = con.prepareStatement(query);
	            // Take user input for insertion
	            Scanner input = new Scanner(System.in);	
	            
	            System.out.print("Enter the doctor-Id:  ");
	            int id = input.nextInt();
	            System.out.println();
	            
	            System.out.print("Enter the Doctor Name:  ");
	            String name = input.next();
	            System.out.println();
	            
	            System.out.print("Enter Qualification:  ");
	            String qual = input.next();
	            System.out.println();
	            
	            System.out.print("Enter Specialist type:  ");
	            String spl = input.next();
	            System.out.println();
	            
	           
	            System.out.print("Enter the RoomNO:  ");
	            int no = input.nextInt();
	            System.out.println();
	            
	            //updating the query with values
	            
	            prSt.setInt(1, id);
	            prSt.setString(2, name);
	            prSt.setString(3, qual);
	            prSt.setString(4, spl);
	            prSt.setInt(5, no);
	            prSt.setString(6,"KceHospital");
	            prSt.setString(7,"Myleripalayam Village, Othakkal Mandapam, Tamil Nadu 641032");
	            
	            int count = prSt.executeUpdate();
	            
	            if(count==1) {
	            	System.out.println(" RECORD INSERTED SUCCESSFULLY ");
	            }
	            	else{
	            		throw new ImproperValueException("Record was not inserted ,please check the data you have entered  !!!");
	            	}
	            
	       }
	            
	        catch (ImproperValueException e) {
					e.getMessage();	
				}   
	      catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("ID is already Present ,please check the data and enter a new ID");
				
				System.out.println(" If you wish to insert again , Please enter 1 ");
			    Scanner input = new Scanner(System.in);	
				int check = input.nextInt();
				
				if(check == 1) {
					
					new InsertItems().InsertDoctor();
						
				}
			}
	                   
	         catch (SQLException e) {
	            e.printStackTrace();
	            
	        } 
	        finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	                
	               
	            } catch(Exception ex){}
	        }
	}
		

		
	

	@Override
	//insert function for patient
	public void InsertPatient() {
		
		String query = "insert into patients(PatientID,PName,Gender,State_diseaseType,Age,Hospital_Name,Hospital_Address) values(?,?,?,?,?,?,?)";
	     
	      try {
	           
	    	    prSt = con.prepareStatement(query);
	            // Take user input for insertion
	            Scanner input = new Scanner(System.in);	
	            
	            System.out.print("Enter the patient-Id:  ");
	            int id = input.nextInt();
	            System.out.println();
	            
	            System.out.print("Enter the patient Name:  ");
	            String name = input.next();
	            System.out.println();
	            
	            System.out.print("Enter Gender:  ");
	            String gen = input.next();
	            System.out.println();
	            
	            System.out.print("Enter Disease_Type:  ");
	            String type = input.next();
	            System.out.println();
	            
	           
	            System.out.print("Enter the Age:  ");
	            int age = input.nextInt();
	            System.out.println();
	            
	            //updating the query with values
	            
	            prSt.setInt(1, id);
	            prSt.setString(2, name);
	            prSt.setString(3, gen);
	            prSt.setString(4, type);
	            prSt.setInt(5, age);
	            prSt.setString(6,"KceHospital");
	            prSt.setString(7,"Myleripalayam Village, Othakkal Mandapam, Tamil Nadu 641032");
	            
	            int count = prSt.executeUpdate();
	            
	            if(count==1) {
	            	System.out.println(" RECORD INSERTED SUCCESSFULLY ");
	            }
	            	else{
	            		throw new ImproperValueException("Record was not inserted ,please check the data u have entered  !!!");
	            	}
	            
	       }
	            
	        catch (ImproperValueException e) {
					e.getMessage();	
				}   
	      catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("ID is already Present ,please check the data ");
				
				System.out.println(" If you wish to insert again , Please enter 1 ");
			    Scanner input = new Scanner(System.in);	
				int check = input.nextInt();
				
				if(check == 1) {
					
					new InsertItems().InsertPatient();;
						
				}
			}
	                   
	         catch (SQLException e) {
	            e.printStackTrace();
	            
	        } 
	        finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	               
	            } catch(Exception ex){}
	        }
		
	
		
	}

	//insert function for Nurse
	public void InsertNurse() {
		
		String query = "insert into nurses(NurseID,Name,Hospital_Name,Hospital_Address) values(?,?,?,?)";
	     
	      try {
	           
	    	    prSt = con.prepareStatement(query);
	            // Take user input for insertion
	            Scanner input = new Scanner(System.in);	
	            
	            System.out.print("Enter the Nurse-Id:  ");
	            int id = input.nextInt();
	            System.out.println();
	            
	            System.out.print("Enter the Nurse Name:  ");
	            String name = input.next();
	            System.out.println();
	            
	            //updating the query with values
	            
	            prSt.setInt(1, id);
	            prSt.setString(2, name);
	            prSt.setString(3,"KceHospital");
	            prSt.setString(4,"Myleripalayam Village, Othakkal Mandapam, Tamil Nadu 641032");
	            
	            int count = prSt.executeUpdate();
	            
	            if(count==1) {
	            	System.out.println(" RECORD INSERTED SUCCESSFULLY ");
	            }
	            	else{
	            		throw new ImproperValueException("Record was not inserted ,please check the data u have entered  !!!");
	            	}
	            
	       }
	            
	        catch (ImproperValueException e) {
					e.getMessage();	
				}   
	      catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("ID is already Present ,please check the data ");
				
				System.out.println(" If you wish to insert again , Please enter 1 ");
			    try (Scanner input = new Scanner(System.in)) {
					int check = input.nextInt();
					
					if(check == 1) {
						
						new InsertItems().InsertNurse();
							
					}
				}
			}
	                   
	         catch (SQLException e) {
	            e.printStackTrace();
	            
	        } 
	        finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	               
	            } catch(Exception ex){}
	        }
		
		
		
		
		
	}

}
