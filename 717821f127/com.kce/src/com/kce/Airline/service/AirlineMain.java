package com.kce.Airline.service;
import com.kce.Airline.dao.*;
import java.util.*;
public class AirlineMain extends Thread{

	public static void main(String[] args) {
		AirlineDetailss a1=new AirlineDetailss();
		PassengerDetailss p1=new PassengerDetailss();
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		a1.insert(a);
		a1.displayTable();
		int count=0;
		int number=1;
		System.out.println("Do you want to procced with Booking");
		System.out.println("Enter 1 for Booking and 2 for exit");
		number=sc.nextInt();
		if(number==1) {
		while(number==1) {
			count++;
			//System.out.println("Enter 1 for Booking and 2 for exit");
		
		p1.insertPassengerDetails();
		
		
		
		System.out.println("Do you want to continue?");
		System.out.println("Enter 1 for Booking and 2 for exit");
		number=sc.nextInt();
		
		}
		}else {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Visit Again");
			System.exit(0);
			
		}
		p1.displayPassengerTable();
		p1.paymentdetails(count);
		
		
		p1.delete();
				
		
		
		
		
		
		
		
		

	}

}
