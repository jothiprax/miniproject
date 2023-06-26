package sample;
import java.util.Scanner;
public class RoomBooking {
  String  customername;
  String customerno;
  String address;
  String arrivaltime;
  String departuretime;
  int countofmembers;
public RoomBooking(String customername, String customerno, String address, String arrivaltime, String departuretime,
		int countofmembers) {
	super();
	this.customername = customername;
	this.customerno = customerno;
	this.address = address;
	this.arrivaltime = arrivaltime;
	this.departuretime = departuretime;
	this.countofmembers = countofmembers;
	
}
}
 class Main{
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter your name : ");
String cn=sc.nextLine();
System.out.println("Enter your Mobilenumber : ");
String m=sc.nextLine();
System.out.println("Enter your Address : ");
String a=sc.nextLine();
System.out.println("Enter your DayofArrival with time : ");
String arr=sc.nextLine();
System.out.println("Enter your DayofDeparture with time : ");
String dep=sc.nextLine();
System.out.println("Enter the number of Members : ");
int mem=sc.nextInt();
RoomBooking r=new RoomBooking(cn,m,a,arr,dep,mem);
RoomDetails rd=new RoomDetails();
rd.details();
rd.selectrooms(mem);



	}
}







