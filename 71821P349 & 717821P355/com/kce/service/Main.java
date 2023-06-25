package com.kce.service;
import java.util.Scanner;

import com.kce.dao.CustomerDetails;
import com.kce.dao.HotelDetails;
import com.kce.util.RoomUnAvailbleException;

public class Main{
	public static void main(String args[])throws Exception {
		Scanner sc=new Scanner(System.in);
		InputClass in=new InputClass();
		String username;
		String pass;
		HotelDetails h=new HotelDetails();
		CustomerDetails c=new CustomerDetails();
		System.out.println("Welcome to our Hotel");
		while(true) {
		System.out.println();
		System.out.println("1.Master login");
		System.out.println("2.Customer login");
		System.out.println("3.exit");
		System.out.println("\nchoose the logintype : ");
		try {
		int ch=sc.nextInt();
		sc.nextLine();
		if(ch==1) {
		   in.MasterInput();
			if(in.username.equals("master")&&in.pass.equals("master123")) {
				System.out.println("Hotel Details");
				h.read();
				System.out.println( );
				System.out.println("customer Details");
				System.out.println( );
				c.read();
			}
			else {
				System.out.println("Invalid credentials..");
				System.out.println("ReEnter the credentials:");
				 in.MasterInput();
			}
		}
		else if (ch==2){
			while(true) {
		System.out.println("Available Rooms are:\n");
		h.ShowDetails();
		if(h.count==0)throw new RoomUnAvailbleException("All Rooms are Booked.");
		System.out.println("\n\n1.Room Booking");
		System.out.println("1.Room Vacation");
		System.out.println("3.exit");
		System.out.println("\nenter the choice:");
		int choice=sc.nextInt();
		if(choice==1) {
		System.out.println("Enter the room number you want to book:");
		int roomnum=sc.nextInt();
		h.check(roomnum);
		in.getinput();
		h.update(roomnum);
		System.out.println("Room Booked successfully\n\n");
		}
		else if(choice==2) {
			System.out.println("Enter the room number you want to vacate:");
			int roomnum=sc.nextInt();
			h.checkVacate(roomnum);
			h.updateVacate(roomnum);
			if(h.cont==0)
			System.out.println("Room vacated successfully\n\n");
		}
		else {
			System.out.println("Exited....");
			System.exit(0);
		}
			}
		}
		else {
			System.out.println("Exited....");
			System.exit(0);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}}
	}
	
