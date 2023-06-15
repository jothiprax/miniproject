package COLAB;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	int flightNo;
	int passportNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter Flight no: ");
		flightNo = scanner.nextInt();
		System.out.println("Enter your Passport Number: ");
		passportNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public boolean isAvailable()  throws SQLException{
		
	FlightDAO flightdao = new FlightDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = flightdao.getCapacity(flightNo);

		int booked = bookingdao.getBookedCount(flightNo,date);
		
		return booked<capacity;
		
	}
}