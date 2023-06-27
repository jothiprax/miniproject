package busRev;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class booking {

		// TODO Auto-generated method stub
		String passengerName;
		int busNo;
		Date date;
		booking() throws ParseException
		{
			Scanner input1=new Scanner(System.in);
			System.out.println("Enter name of our Passenger: ");
			passengerName=input1.next();
			System.out.println("Enter the bus no: ");
			busNo=input1.nextInt();
			System.out.println("Enter date (YYYY-MM-DD) in this format ");
			String dateInput=input1.next();
			//this dateInput we want to convert in DateFormat so That's y we use SimpleDateFormat.
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
//			MM for Month
//			mm for minutes
			date=dateformat.parse(dateInput);
		}
		public boolean isAvailable() throws SQLException{
			BusDataObject busdo=new BusDataObject();
			BookingDAO bookingdao=new BookingDAO();
			int Buscapacity=busdo.getCapacity(busNo);
			int BookingCounter=bookingdao.getBookedCount(busNo,date);
			return BookingCounter<Buscapacity;
		}

	

}
