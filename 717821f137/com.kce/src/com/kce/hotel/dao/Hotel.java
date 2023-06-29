package com.kce.hotel.dao;
import java.sql.SQLException;
import java.util.Scanner;
public class Hotel {
	RoomDetails r1=new RoomDetails();
	PaymentDetails p1=new PaymentDetails();
	CustomerDetails c1=new CustomerDetails();
	
public void intro() {
	Hotel h1=new Hotel();
	System.out.printf("Welcome to ANDHAMAN HOTEL\n");
	System.out.println("The Room Details are:\n");	
	r1.displayRoomDetails();
	System.out.println("\nWould you like to reserve a room?\n If yes type Y else type N");
	Scanner sc=new Scanner(System.in);
	String choice=sc.nextLine();
	String option1="y";
	String option2="n";
	if(choice.equalsIgnoreCase(option1)) {
		c1.insertDetails();
	}
	if(choice.equalsIgnoreCase(option1)) {
		System.out.println("Enter the Room number of the room you would like to book:");
		String Roomno=sc.nextLine();
    	r1.UpdateRoomDetails(Roomno);	
	}
	if(choice.equalsIgnoreCase(option1)) {
		h1.pay();		
	}
	if(choice.equalsIgnoreCase(option2)) {
		System.out.println("Thank you for your visit.We'll see you again!!");

	}
	
}
public void pay() {
	System.out.println("\nKindly finish the payment process:");
	p1.insertDetails();
	System.out.println("\nSummary: \n");
	c1.displayCustomerDetails();
	
}
}
