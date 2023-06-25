package com.kce.service;

import java.util.Scanner;

import com.kce.dao.CustomerDetails;

public class InputClass {
	Scanner sc=new Scanner(System.in);
     public InputClass() {
		super();
	}
     String name;
     int noOfPerson;
     String address;
     String phno;
	public void getinput() throws Exception{
		try {
		System.out.println("Enter your name:");
        name=sc.nextLine();
		}
        catch(Exception e) {
        	System.out.println("Invalid name");
        	name=sc.nextLine();
        }
		try {
			System.out.println("Enter number of persons going to stay:");
			noOfPerson=sc.nextInt();
			sc.nextLine();
		}
		catch(Exception e) {
        	System.out.println("Invalid detail");
        	noOfPerson=sc.nextInt();
        	sc.nextLine();
        }
		try {
			System.out.println("Enter your address:");
        address=sc.nextLine();
        }
		catch(Exception e) {
        	System.out.println("Invalid address");
        	 address=sc.nextLine();
        }
		try {
			System.out.println("Enter your contact number:");
        phno=sc.nextLine();
        }
		catch(Exception e) {
        	System.out.println("Invalid phno");
        	phno=sc.nextLine();
        }
		CustomerDetails cus=new CustomerDetails();
		cus.insert(name,noOfPerson,address,phno);
     }
	public String username;
	public String pass;
	public void MasterInput() {
		System.out.println("UserName: ");
		username=sc.nextLine();
		System.out.print("Password: ");
		pass=sc.nextLine();
	}
}
