package busreservation;
import java.util.Scanner;
public class Busdemo {
public static void main(String[] a) throws Throwable
{
	BusDao b= new BusDao();
	b.displayBusInfo();
	int userOpt=1;
	try (Scanner d = new Scanner(System .in)) {
		while(userOpt==1)
		{
			System.out.println("Enter 1to Book and 2 to exit :");
			userOpt=d.nextInt();
			if(userOpt==1)
			{
				Booking b1= new Booking();
				if(b1.isAvailable())
				{
					BookingDao b2=new BookingDao();
					b2.addBooking(b1);
					System.out.println("<<<<<<<<<<<<<<<<<YOUR BOOKING IS CONFIRMED>>>>>>>>>>>>>");
					
				}
				else
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<SORRY, BUS IS FULL , TRY ANOTHER DATE OR BUS>>>>>>>>>>>>>>>>>>");
				
			}
		}
	}
}
}
