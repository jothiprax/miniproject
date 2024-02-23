package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.util.ConnectionToDb;
import com.kce.util.ImproperValueException;

public class DeleteItems implements Delete {

	Connection con =ConnectionToDb.getConnection(); 
	PreparedStatement prSt;
	@Override
	//delete function for doctor
	public void DeleteDoctor() {
	
		String query = "DELETE from doctors where DoctorID=?";
		
		try {
            
            prSt = con.prepareStatement(query);
            
            // Take user input for deletion
            Scanner input = new Scanner(System.in);	
            
            System.out.print("Enter the DoctorID:  ");
            int DocID = input.nextInt();
            System.out.println();
            
            prSt.setInt(1,DocID);
            
            int rowAffected = prSt.executeUpdate();
            if(rowAffected!=1) {
          	  try {
          		  throw new ImproperValueException("Invalid inputs");
          	  }
          	  catch(ImproperValueException ae) {
          		  System.out.println(ae.getMessage());
          		  System.out.println("check the inputs you have entered");
        		  System.out.println(" If you wish to delete again , Please enter 1 ");
			      Scanner sc = new Scanner(System.in);	
				  int check = sc.nextInt();
				
				  if(check == 1) {
					
					new DeleteItems().DeleteDoctor();
						
				}
        	  }
          	  
         	  
           }
            else {
            System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println(" Record deleted successfully ");
            }
            
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }				
    }
		
		
	//delete function for patient
	@Override
	public void DeletePatient() {
	
		
		String query = "DELETE from patients where PatientID=?";
		
		try {
            
            prSt = con.prepareStatement(query);
            
            // Take user input for deletion
            Scanner input = new Scanner(System.in);	
            
            System.out.print("Enter the PatientID:  ");
            int PatientID = input.nextInt();
            System.out.println();
            
            prSt.setInt(1,PatientID);
            
            int rowAffected = prSt.executeUpdate();
            if(rowAffected!=1) {
          	  try {
          		  throw new ImproperValueException("Invalid inputs");
          	  }
          	  catch(ImproperValueException ae) {
          		  System.out.println(ae.getMessage());
          		  System.out.println("check the inputs you have entered");
        		  System.out.println(" If you wish to delete again , Please enter 1 ");
			      Scanner sc = new Scanner(System.in);	
				  int check = sc.nextInt();
				
				  if(check == 1) {
					
					new DeleteItems().DeletePatient();
						
				}
        	  }
          	  
         	   
           }
            else {
            System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println(" Record deleted successfully ");
            }
            
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }	
	
	
		
		
		
	}

	@Override
	//delete function for Nurse
	public void DeleteNurse() {
		
		
		String query = "DELETE from nurses where NurseID=?";
		
		try {
            
            prSt = con.prepareStatement(query);
            
            // Take user input for deletion
            Scanner input = new Scanner(System.in);	
            
            System.out.print("Enter the NurseID:  ");
            int NurseID = input.nextInt();
            System.out.println();
            
            prSt.setInt(1,NurseID);
            
            int rowAffected = prSt.executeUpdate();
            if(rowAffected!=1) {
          	  try {
          		  throw new ImproperValueException("Invalid inputs");
          	  }
          	  catch(ImproperValueException ae) {
          		  System.out.println(ae.getMessage());
          		  System.out.println("check the inputs you have entered");
          		  System.out.println(" If you wish to delete again , Please enter 1 ");
			      Scanner sc = new Scanner(System.in);	
				  int check = sc.nextInt();
				
				  if(check == 1) {
					
					new DeleteItems().DeleteNurse();
						
				}
          	  }
         	  
           }
            else {
            System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println(" Record deleted successfully ");
            }
            
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }	
		
			
		
	}

}
