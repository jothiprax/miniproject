package busRev;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	void booking() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name of our Passenger: ");
		passengerName=sc.next();
		System.out.println("Enter the bus no: ");
		busNo=sc.nextInt();
		System.out.println("Enter date (YYYY-MM-DD) in this format ");
		String dateInput=sc.next();
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		date=dateformat.parse(dateInput);
	}
	public boolean isAvailable() throws SQLException{
		BusDataObject busdo=new BusDataObject();
		BookingDAO bookingdao=new BookingDAO();
		int Buscapacity=busdo.getCapacity(busNo);
		int BookingCounter=bookingdao.getBookedCount(busNo,date);
		return BookingCounter>Buscapacity;
	}
	
	
	
	
	
	
	
	
	
	
}
