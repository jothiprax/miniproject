package busRev;
import java.util.Scanner;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class BusDemo {

	public static void main(String[] args)  {
	
		
		BusDataObject busdataobject=new  BusDataObject();
		try {
		busdataobject.displayBusInformation();
	
		Scanner input =new Scanner(System.in);
		int userOption=1;
		while(userOption==1) {
			System.out.println("Enter 1 for seat booking\n      2 for Exit:-");//Visible to passengers
			userOption=input.nextInt();
			if(userOption==1) {
				booking book=new booking();
				if(book.isAvailable()) {
//				System.out.println("Ready for Booking Dear Passenger :");
				  BookingDAO  bookingdao =new BookingDAO();
				  bookingdao.addBooking(book);
				System.out.println("Get Ready for enjoying your journey:");
			}
				else {
					System.out.println("OOPs the seat is full please try another date else another bus ");
				}
			}
			
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
