package busreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
 static String passengerName;
static int busNo;
static Date date;
Booking() throws ParseException
{
	Scanner d= new Scanner(System .in);
	System .out.println("Enter the Passenger Name :    ");
	passengerName=d.nextLine();
	System.out.println("Enter the busNo :");
	busNo=d.nextInt();
	System .out.println("Enter the date  dd-mm-yyyy :");
	String dataInput=d.next();
	SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
	date=dateformat.parse(dataInput);
	
	
}
public boolean isAvailable() throws Exception
{
	BusDao b1=new BusDao();
	int capacity=b1.getcapacity(busNo);
	BookingDao h= new BookingDao();
	int booked= h.getBookedCount(busNo,date);
	return  booked <capacity ;
}

}
