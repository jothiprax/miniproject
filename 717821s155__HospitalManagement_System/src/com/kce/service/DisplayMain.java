package com.kce.service;
import com.kce.dao.*;
import java.util.*;
public class DisplayMain {
	
	
	static PerformOperation pop = new PerformOperation();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println("\t\t****************************************");
		  System.out.println("			  HOSPITAL MANAGEMENT			");
		  System.out.println("\t\t****************************************");
		  
		  System.out.println("\n\n");
		  
		  System.out.println("	HELLO USER !! HOPE YOUR ARE DOING FINE !\n\n We have Three types of data in our database\n\n You can perform CRUD operation on the databases for understanding the Hospital Management System data" );
		  System.out.println(" If you a blank output then it means the record your are finding is not available");
		  Boolean b = true;
		  while(b) {
		  System.out.println("	\n Enter the input type you want to perform operations \n\n\n Press 1 : For Doctor related queries \n\n Press 2 : for Patients \n\n Press 3 : for Nurses \n");
		  
		  
		  Scanner input = new Scanner(System.in);
		  
		 int choice = input.nextInt();
		 
		 switch(choice) {
		 
		 case 1:
			 System.out.println(" You have selected Doctor's Section \n\n");
			 pop.DoctorDetails();
			 
			 System.out.println(" \nIf you wish to continue Press 'Y' else Press 'N' ");
			
				char ch=input.next().charAt(0);
				if(ch=='y'||ch=='Y') 
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}
			 
			 
		 case 2:
			 System.out.println(" You have selected Patient's Section \n\n");
			 pop.PatientDetails();
			 
			 System.out.println("\n If you wish to continue Press 'Y' else Press 'N' ");
				
			 char ch1=input.next().charAt(0);
			 if(ch1=='y'||ch1=='Y') 
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}
			 
			 
		 case 3:
			 System.out.println(" You have selected Nurse's Section \n\n");
			 pop.NurseDetails();
			 
			 System.out.println("\n If you wish to continue Press 'Y' else Press 'N' ");
				
				char ch2=input.next().charAt(0);
				if(ch2=='y'||ch2=='Y') 
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					b=false;
					System.exit(0);
				}
			 break;
			 
		 default:
			 System.out.println(" INVALID CHOICE ");
			 return;
		 }
				  
		  	  
	}

}}
