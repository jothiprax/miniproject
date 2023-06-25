//This Flight Reservation console Application was created By team:Sanjay.S,Ashokkumar.M
package Main;
import java.util.Scanner;
import PassengersList.Passengers;
import PassengersList.CriminalRecord;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import Enquiry.*;
public class MainBooking {
	public static Passengers passenger;
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		System.out.print("*******************************************************************************************\n*");
		System.err.print("                         Welcome to Tesla Airline Ticket booking...                      ");System.out.println("*");
		System.out.println("*******************************************************************************************\n");
		System.out.println("*********************************Tesla AirLine TicketBooking*******************************\n");
		boolean test=true;
		do {
		try {
		while(test) {
			System.out.println("If you are already a passenger please enter => 1\nIf you are new user please => 2\nDisplay Details enter => 3\n"
					+ "for Cancelation enter =>4");
			int choice=in.nextInt();
			in.nextLine();
		switch(choice) {
		case 1:
			System.out.println("enter your name");
			String name=in.nextLine();
			System.out.println("Enter your Id");
			String bookid=in.nextLine();
			if(CheckLoginInfo.validRegister(name,bookid)) {
				System.out.println("=== \tWelcome sir/ma'am\t ===");
			}
			else {
				System.err.println("!!!!!!!!! Sorry No Details Found Here !!!!!");
			}
			break;
		case 2:
			System.out.println("********************Passengers Infomation*************");
			passenger=new Passengers();
			System.err.println("FirstName and LastName:*");
			passenger.setName(in.nextLine().trim());
			System.err.println("Age:*");
			passenger.setAge(in.nextInt());
			in.nextLine();
			System.err.println("FatherName:*");
			passenger.setfName(in.nextLine());
			System.err.println("MotherName:*");
			passenger.setmName(in.nextLine());
			System.err.println("Date-Of-Birth:*(yyyy-mm-dd)");
			passenger.setDob(in.nextLine());
			System.out.println("Education:");
			passenger.setEducation(in.nextLine().trim());
			System.out.println("Religion:");
			passenger.setReligion(in.nextLine().trim());
			System.err.println("Any FIRs Register: (true/false)*");
			passenger.setFIRs(in.nextBoolean());
			in.nextLine();
			System.err.println("Country_name:*");
			passenger.setCountry(in.nextLine().trim());
			System.err.println("visaType :*");
			passenger.setVisaType(in.nextLine().trim());
			System.out.println("classtype (Business/Economy)");
			passenger.setClasstype(in.nextLine().trim());
			System.err.println("From:*");
			passenger.setFrom(in.nextLine().trim());
			System.err.println("Destination:*");
			passenger.setDestination(in.nextLine().trim());
			System.out.print("Your Passenger ID:");
			System.err.println(passenger.getBookId()+" remind it");
			UpdateData.register();
			break;
		case 3:
			System.out.println("Enter your PassengerId:");
			String Id=in.nextLine();
			UpdateData.display(Id);
			break;
		case 4:
			System.out.println("Enter your Name:");
			name=in.nextLine();
			System.out.println("Enter Id:");
			Id=in.nextLine();
			if(CheckLoginInfo.validRegister(name, Id)) {
				if(!UpdateData.cancelation(Id)) {
					System.out.println("Successfully Cancelled");
				}
				else {
					System.err.println("Sorry Sir we can't cancel!!May you not entered the Data Try Again.");
			}
			}
			break;
		default:
			System.err.println("uhm I think you enter the wrong one!!\nTry again");
			}
			System.out.println("Are wish to vist further more Sir? yes/no");
			String sample=in.nextLine().trim();
			if(sample.equalsIgnoreCase("yes"))
				test=true;
			else
				test=false;
		}
		}
		catch(CriminalRecord e) {
			System.err.print(e);
		}
		catch(NoSuchElementException e) {
			System.err.println("you're done somThing wrong!!!");
		}
		catch(SQLException e) {
			System.out.println(e);
			System.err.println("Sorry for inconvinience, There is problem from our Side. TryAgain!!!");
		}
		finally {
			System.out.println("Thank you for visiting our website :)");
			in.close();
			}
		}while(test);
		}
	}
