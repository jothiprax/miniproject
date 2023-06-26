package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.util.ConnectionToDb;
import com.kce.util.ImproperValueException;

public class UpdateItems implements Update{
	
	
	Connection con =ConnectionToDb.getConnection(); 
	PreparedStatement prSt;
	String field;
	

	@Override
	//update function for doctor
	public void UpdateDoctor() {
		
		
		Scanner sc = new Scanner(System.in);
		 // Take user input for update
		
		System.out.print("Enter the DoctorID to be updated ");
		int id=sc.nextInt();
		
		System.out.print("\nChoose the field name you want to be updated by entering the appropriate integer:\n\n Press '1':  DoctorName \n Press '2' :Qualification\n Press '3': Specialist\n Press '4': RoomNo");
		System.out.println();
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			field="DName";
			break;
			
		case 2:
			field = "Qualification";
			break;
			
		case 3:
			field = "Specialist";
			break;
			
		case 4:
			field = "RoomNo";
			break;
		
		default:
			System.out.println("Invalid input");
			return;
		}
				
		sc.nextLine();
		
		System.out.print("\nEnter the value you want to be updated: ");
		String value=sc.nextLine();
		
		
     String query = "UPDATE doctors SET "+field+" = ? WHERE DoctorID = ?";
		
		try {
			prSt = con.prepareStatement(query);
            
            
            // Take user input for insertion
          
            prSt.setString(1,value );
            prSt.setInt(2, id);
 
            int rowAffected = prSt.executeUpdate();
            if(rowAffected!=1) {
          	  try {
          		  throw new ImproperValueException("Invalid inputs");
          	  }
          	  catch(ImproperValueException ae) {
          		  System.out.println(ae.getMessage());
          	  }
         	   System.out.println("check the inputs you have entered");
         	   
         	  System.out.println(" If you wish to update again , Please enter 1 ");
		      Scanner in = new Scanner(System.in);	
			  int check = in.nextInt();
			
			  if(check == 1) {
				
				new UpdateItems().UpdateDoctor();;
					
			}
           }
            else {
            System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println(" Updated Successfully ");
            }
  		
            
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		
		
	}	
		
		
	

	@Override
	//update function for patient
	public void UpdatePatient() {
		
		
		Scanner sc = new Scanner(System.in);
		 // Take user input for update
		
		System.out.print("Enter the PatientID to be updated ");
		int id=sc.nextInt();
		
		System.out.print("\nChoose the field name you want to be updated by entering the appropriate integer:\n\n Press '1':  PatientName \n Press '2' :Gender\n Press '3': Disease_Type\n Press '4': Age");
		System.out.println();
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			field="PName";
			break;
			
		case 2:
			field = "Gender";
			break;
			
		case 3:
			field = "State_diseaseType";
			break;
			
		case 4:
			field = "Age";
			break;
			
		default: 
			
			System.out.println("Invalid Choice ");
			return;
		}
				
		sc.nextLine();
		
		System.out.print("\nEnter the value you want to be updated: ");
		String value=sc.nextLine();
		
		
    String query = "UPDATE patients SET "+field+" = ? WHERE PatientID = ?";
		
		try {
			prSt = con.prepareStatement(query);
           
           
           // Take user input for insertion
         
           prSt.setString(1,value );
           prSt.setInt(2, id);

           int rowAffected = prSt.executeUpdate();
           if(rowAffected!=1) {
         	  try {
         		  throw new ImproperValueException("Invalid inputs");
         	  }
         	  catch(ImproperValueException ae) {
         		  System.out.println(ae.getMessage());
         	  }
        	   System.out.println("check the inputs you have entered");
        	   
        	   System.out.println(" If you wish to update again , Please enter 1 ");
			      Scanner in = new Scanner(System.in);	
				  int check = in.nextInt();
				
				  if(check == 1) {
					
					new UpdateItems().UpdatePatient();;
						
				}
          }
           else {
           System.out.println(String.format("Row affected %d", rowAffected));
           System.out.println(" Updated Successfully ");
           }
 		
           
		}
		
		
		catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
		
		
	}	

	@Override
	//update function for nurse
	public void UpdateNurse(){ {
		
		Scanner sc = new Scanner(System.in);
		 // Take user input for update
		
		System.out.print("Enter the NurseID to be updated ");
		int id=sc.nextInt();
		
		
				
		sc.nextLine();
		
		System.out.print("\nEnter the value of name field you want to update: ");
		String value=sc.nextLine();
		
		
   String query = "UPDATE nurses SET Name = ? WHERE NurseID = ?";
		
		try {
			prSt = con.prepareStatement(query);

			prSt.setString(1,value );
			prSt.setInt(2, id);

          int rowAffected = prSt.executeUpdate();
          if(rowAffected!=1) {
        	  try {
        		  throw new ImproperValueException("Invalid inputs");
        	  }
        	  catch(ImproperValueException ae) {
        		  System.out.println(ae.getMessage());
        	  }
       	   System.out.println("check the inputs you have entered");
       	   
       	  System.out.println(" If you wish to update again , Please enter 1 ");
	      Scanner in = new Scanner(System.in);	
		  int check = in.nextInt();
		
		  if(check == 1) {
			
			new UpdateItems().UpdateNurse();;
				
		}
         }
          else {
          System.out.println(String.format("Row affected %d", rowAffected));
          System.out.println(" Updated Successfully ");
          }
		
         
		}
		catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
	
	}

	}
}