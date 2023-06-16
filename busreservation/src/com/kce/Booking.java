package com.kce;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.SQLException;

public class Booking {
     String passengerName;
     int busNo;
     Date date;
     Booking(){
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter name of the passesnger: ");
    	 passengerName =sc.next();
    	 System.out.println("Enter Bus no: ");
    	 busNo = sc.nextInt();
    	 System.out.println("Enter booking date dd-mm-yyyy: ");
    	 String dateInput = sc.next();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
     }
	public  boolean isAvailable()throws SQLException {
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);
		
		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
}
