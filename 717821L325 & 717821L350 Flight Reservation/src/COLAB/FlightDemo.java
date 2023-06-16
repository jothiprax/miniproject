package COLAB;
import java.util.Scanner;
public class FlightDemo {

	public static void main(String[] args)  {
		
		FlightDAO flightdao = new FlightDAO();
		
		try {
			flightdao.displayBusInfo();
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
					
			while(userOpt==1) {
				System.out.println("Enter 1 to Book and 0 to exit");
				userOpt = scanner.nextInt();
				if(userOpt == 1) {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
		
					else
						System.out.println("Sorry. Flight is full. Try another date.");
				}
				else if(userOpt== 0) {
					System.out.println("You have Exited Successfully");
				}
				else {
					System.out.println("Invalid choice! you have to give 1 for booking ticket and 0 to exit");
				}
			}
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}