package sample;

import java.util.Scanner;

public class RoomDetails {

	void details() {
		System.out.println("--------------------------------------------------");
		System.out.println("WELCOME TO THE NEW VIEW ");
		System.out.println("Categories of Rooms Available With Ranges :  ");
		System.out.println("1) STANDARD ROOMS ");
		System.out.println("2) DOUBLECOT ROOMS");
		System.out.println("3) DELUXE ROOMS");
		System.out.println("--------------------------------------------------");
		
	}
	void selectrooms(int mem) {
	RoomsCategory rc=new RoomsCategory();
		Scanner sc=new Scanner(System.in);
		int n=0;
		int choice;
		while(n!=-1) {
			System.out.println("ENTER ROOM CHOICE (1,2,3) : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("[YOU HAVE SELECTED THE STANDARD ROOMS]");
				rc.Standardroom( mem);
				break;
			case 2:
				System.out.println("[YOU HAVE SELECTED THE DOUBLECOT ROOMS]");
				rc.Doublecot(mem);
				break;
			case 3:	
				System.out.println("[YOU HAVE SELECTED THE DELUXE ROOMS]");
				rc.deluxeroom(mem);
				break;
			default:
				System.out.println("[YOUR CHOICE IS OUT OF CATEGORY]");
			
			}
			System.out.println("Please Enter -1 for not interested : ");
			n=sc.nextInt();
			if(n==-1) {
				System.out.println("THANKYOU...MOST WELCOME...");
			}
		}
		}
}
