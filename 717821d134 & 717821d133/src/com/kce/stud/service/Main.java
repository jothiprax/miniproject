package com.kce.stud.service;
import java.util.Scanner;

import com.kce.stud.dao.*;

 class InvalidPassword extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6292895976447304725L;

	public InvalidPassword(String a) {
		super(a);
	}
}
public class Main {
	public static Scanner sc= new Scanner (System.in);
	public static void options() {
		System.out.println("1. Inserting the data");
		System.out.println("2. Updating the Data");
		System.out.println("3. Deleting the Rows");
		System.out.println("4. Deleting the Table");
		System.out.println("5. Display the Data");
		System.out.println("6. Quit");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("1->Login");
		System.out.println("2->SignIn");
		System.out.println("Enter your choice:");
		int c=sc.nextInt();
		if(c==2) {
			while(true) {
				System.out.println("Login:");
				System.out.println("Enter the UserName:");
				String user=sc.next();
				System.out.println("Enter the Password:");
				String pass=sc.next();
				Login l=new Login(user,pass);
				if(Logindao.Login(l)==1) {
					continue;
				}
				else {
					break;
				}

			}
		}
		else {
			try {
				while(true) {
					System.out.println("Enter the UserName:");
					String username=sc.next();
					System.out.println("Enter the Password:");
					String password=sc.next();

					if(!password.contains("@")) {
						throw new InvalidPassword("Not Valid EmailId");

					}
					else {
						System.out.println("Enter the StaffId:");
						String StaffId=sc.next();
						StaffSignIn s=new StaffSignIn(username,password,StaffId);
						Logindao.StaffSignIn(s);
						break;
					}
				}
			}catch(InvalidPassword e) {
				System.out.println(e);
				System.exit(0);
			}
		}

		
		options();
		
while (true) {
		int choice;
		System.out.println("Enter the choice:");
		choice = sc.nextInt();
		sc.nextLine(); 
		switch (choice) {
		case 1:
			System.out.println("Enter the Number of Records to be inserted:");
			Attendancedao.insertdata(sc.nextInt());
			break;
		case 2:
			Attendancedao.updatedata(sc.next(),sc.nextInt());
			break;
		case 3:
			System.out.println("Enter the ID to be deleted:");
			Attendancedao. deletedata(sc.nextInt());
			break;
		case 4:
			Attendancedao. deleteTable();
			break;
		case 5:
			Attendancedao. viewdetails();
			break;
		case 6:
			System.out.println("Thank You!!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice....");
			break;
		}
	}
}
}

