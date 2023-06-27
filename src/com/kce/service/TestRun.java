package com.kce.service;

import java.util.Formatter;
import java.util.Scanner;

import com.kce.dao.HardCodedValues;
import com.kce.util.Validate;

public class TestRun{
	
	static char ch;
	static int choice;
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[]) {
		
		//HardCodedValues.hardCodedvalues();//run this line only when you run it first time
		//using formatter to align the words for index page
		Formatter fmt1=new Formatter();
		fmt1.format("%70s %90s ", "WELCOME\n\n","This is a Cricket Team Management Application\n\n\n");
		System.out.println(fmt1);
		
		//Constrains to the user
		System.out.println("Note:\nThe table CREATION is hardcoded and cannot be changed.\nBe careful with Player Role because "
				+ "the Batsman and wicketkeeper cannot Bowl and Bowler cannot Bat.This is Done to show Inheritance.\n"
				+ "The table Schedule can only be viewed. Match 1 Details alone filled in all Tables. \n");
		
		//this is the part the loops
		label:
			
		while(true) {
			
			System.out.println("\nSelect the operation you want to perform:\n1.Insert Values\n2.Retrive Values\n"
					+ "3.Update Values\n4.Delete Values\n5.Exit\nEnter your choice:");
			choice=sc.nextInt();
			
		switch(choice) {

			case 1:  
				
				if(!Validate.validateUser()) {
				System.out.println("You Don't have permission.");
				continue label;
				}
				else {
					Display.insertDisplay();
				}
				
				System.out.println("Do You want to Continue [Y/N]");
				ch=sc.next().charAt(0);
				if(ch=='y'||ch=='Y')
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}

			case 2: 
				
				Display.valueDisplay();
				
				System.out.println("Do You want to Continue [Y/N]");
				ch=sc.next().charAt(0);
				if(ch=='y'||ch=='Y')
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}

			case 3: 

				if(!Validate.validateUser()) {
				System.out.println("You don't have permission.");
				continue label;
				}
				else {
					Display.updateDisplay();
					}
				
				System.out.println("Do You want to Continue [Y/N]");
				ch=sc.next().charAt(0);
				if(ch=='y'||ch=='Y') 
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}
			
			case 4: 
				
				if(!Validate.validateUser()) {
				System.out.println("You don't have permission.");
				continue label;
				}
				else {
					Display.deleteDisplay();
					}
				
				System.out.println("Do You want to Continue [Y/N]");
				ch=sc.next().charAt(0);
				if(ch=='y'||ch=='Y') 
				{
					break;
				}
				else {
					System.out.println("\t\t\t\t\t\t\t\tTHANK YOU! ");
					System.exit(0);
				}
			
			case 5:
				System.out.print("\t\t\t\t\t\t\t\tTHANK YOU! ");
				System.exit(0);
			
			default: 
				
				System.out.println("Invalid Choice ");
				continue label;
				
			}
		}
	
	}
	
}
