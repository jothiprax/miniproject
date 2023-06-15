package BusReservation; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
public class BusDemo {
	 public static void main(String[] args){
		BusDAO busdao=new BusDAO();
		try {
		busdao.displayBusInfo();
		  int userOpt=1;
		  Scanner sc=new Scanner(System.in);
		  
		
		  while(userOpt==1){
		System.out.println("Enter 1 to Booking and 2 to Not Booking");
		userOpt=sc.nextInt();
		if(userOpt==1){
		
			Booking booking = new Booking();
			if(booking.isAvailable()) {
				BookingDAO bookingdao=new BookingDAO();
				bookingdao.addBooking(booking);
				System.out.println("Your booking is confirmed");
				System.out.println("");
				
			}else 
				System.out.println("Sorry.Bus is full.Try another bus or date.");
			}
		   }
		 
		 }
		catch(Exception e) {
			System.out.println(e);
		}
		
}
}
