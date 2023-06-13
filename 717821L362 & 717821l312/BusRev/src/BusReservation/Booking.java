package BusReservation;
import java.util.*;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	public String passengername;
	public int busno;
	public Date date;
	
	public Booking(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the passenger name:");
		passengername = sc.nextLine();
		System.out.println("Enter the Bus No:");
		busno=sc.nextInt();
		System.out.println("Enter date dd-MM-yyyy");
		String dateInput=sc.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date =dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAvailable()throws SQLException {
		
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		int capacity=busdao.getCapacity(busno);
		
		int booked = bookingdao.getBookedCount(busno,date);
		return booked<capacity;
	}
} 
