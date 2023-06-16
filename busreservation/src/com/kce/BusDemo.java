package com.kce;
import java.util.*;
import java.sql.*;
public class BusDemo {
    public static void main(String [] args) throws SQLException {
    	BusDAO busdao = new BusDAO();
    	busdao.displayBusInfo();
    	Scanner sc = new Scanner (System.in);
    	int userOpt = 1;
    	
    	while(userOpt == 1) {
    		System.out.println("\nEnter 1 to book seat and 2 to exit: ");
    		userOpt = sc.nextInt();
    		if( userOpt == 1) {
    			Booking booking = new Booking();
    			if(booking.isAvailable()) {
    				BookingDAO bookingdao = new BookingDAO();
    				bookingdao.addBooking(booking);
    				System.out.println("Congratulations! Your Seat Booked Successfully");
    			}else
    			{
    				System.out.println("OOPS!\nSeats are Filled.Try it on another day\nTHANK YOU");
    			}
    		}
             
    	}
    }
}


