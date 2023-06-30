package com.kce.service;

import java.util.Scanner;
import com.kce.dao.*;

public class PerformOperation {
	
	
	DisplayingItems DI = new DisplayingItems();
	
	public void DoctorDetails() {
		
		System.out.println("Enter the type of operation to perform : \n \n Press '1' : to display all record \n\n Press '2' : to display record by ID \n\n Press '3' : to insert a record \n\n Press '4' : to update a record \n\n Press '5' : to delete a record \n\n Press '6' : to exit");
		Scanner input = new Scanner(System.in);
		  
		int choice = input.nextInt();	
		
		switch(choice) {
		
		case 1:
			System.out.println(" Displaying all records ");
			
			DI.displayAllDoctors();
			break;
			
		case 2:
			
			System.out.println(" Displaying record by ID ");
			
			DI.DisplayRecordByDoctorId();
			break;
			
		case 3:
			System.out.println(" Insert a new record ");
			
			InsertItems IT = new InsertItems();
			IT.InsertDoctor();
		    break;
		    
		case 4:
			System.out.println("Update an existing record ");
			
			UpdateItems up = new UpdateItems();
		    up.UpdateDoctor();
		    break;
		    
		case 5:
			System.out.println("Delete an existing record ");
			
			DeleteItems DI = new DeleteItems();
			DI.DeleteDoctor();
			break;
			
		case 6:
			System.out.println(" Thankyou ");
			return;
			
		default:
			System.out.println(" Invalid choice ");
			return;
		}
	
	}

	
public void PatientDetails() {
		
		System.out.println("Enter the type of operation to perform : \n \n Press '1' : to display all record \n\n Press '2' : to display record by ID \n\n Press '3' : to insert a record \n\n Press '4' : to update a record \n\n Press '5' : to delete a record \n\n Press '6' : to exit");
		Scanner input = new Scanner(System.in);
		  
		int choice = input.nextInt();	
		
		switch(choice) {
		
		case 1:
			System.out.println(" Displaying all records ");
			
			DI.displayAllPatients();
			break;
			
		case 2:
			
			System.out.println(" Displaying record by ID ");
			
			DI.DisplayRecordByPatientId();
			break;
			
		case 3:
			System.out.println(" Insert a new record ");
			
			InsertItems IT = new InsertItems();
			IT.InsertPatient();
		    break;
		    
		case 4:
			System.out.println("Update an existing record ");
			
			UpdateItems up = new UpdateItems();
		    up.UpdatePatient();
		    break;
		    
		case 5:
			System.out.println("Delete an existing record ");
			
			DeleteItems DI = new DeleteItems();
			DI.DeletePatient();
			break;
			
		case 6:
			System.out.println(" Thankyou ");
			return;
			
		default:
			System.out.println(" Invalid choice ");
			return;
		}
	
	}

public void NurseDetails() {
	
	System.out.println("Enter the type of operation to perform : \n \n Press '1' : to display all record \n\n Press '2' : to display record by ID \n\n Press '3' : to insert a record \n\n Press '4' : to update a record \n\n Press '5' : to delete a record \n\n Press '6' : to exit");
	Scanner input = new Scanner(System.in);
	  
	int choice = input.nextInt();	
	
	switch(choice) {
	
	case 1:
		System.out.println(" Displaying all records ");
		
		DI.displayAllNurses();
		break;
		
	case 2:
		
		System.out.println(" Displaying record by ID ");
		
		DI.DisplayRecordByNurseId();
		break;
		
	case 3:
		System.out.println(" Insert a new record ");
		
		InsertItems IT = new InsertItems();
		IT.InsertNurse();
	    break;
	    
	case 4:
		System.out.println("Update an existing record ");
		
		UpdateItems up = new UpdateItems();
	    up.UpdateNurse();
	    break;
	    
	case 5:
		System.out.println("Delete an existing record ");
		
		DeleteItems DI = new DeleteItems();
		DI.DeleteNurse();
		break;
		
	case 6:
		System.out.println(" Thankyou ");
		return;
		
	default:
		System.out.println(" Invalid choice ");
		return;
	}

}

}
