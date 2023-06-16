package com.kce.textile.service;
import java.util.*;
import com.kce.textile.dao.*;
class InvalidChoiceException extends Exception
{
	public String toString()
	{
		return "Invalid Choice";
	}
}
public class TextileMain 
{

	public static void main(String[] args) 
	{
		try
		{
		String sss="";
		do
		{
		Scanner sc=new Scanner(System.in);
		TextileDAO.createDetailTable();
		TextileDAO.createAmountTable();
		System.out.println("\n\n\n---Welcome to TEXTILE MANAGEMENT---");
		System.out.println("1.Insert Yarn Details");
		System.out.println("2.Insert Warp Details");
		System.out.println("3.Insert Meter Details");
		System.out.println("4.Update Yarn Details");
		System.out.println("5.Update Warp Details");
		System.out.println("6.Update Meter Details");
		System.out.println("7.Monthly statement");
		System.out.println("8.Display All");
		int choice;
		System.out.println("Enter Your Choice:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Getting into Yarn Detail");
			TextileDAO.insertTextile_Yarn();
			break;
		case 2:
			System.out.println("Getting into Warp Details");
			System.out.println(TextileDAO.insertTextile_Warp());
			break;
		case 3:
			System.out.println("Getting into Meter Detail");
			System.out.println(TextileDAO.insertMeter());
			break;
		case 4:
			System.out.println("Getting into Update Yarn");
			TextileDAO.update_Yarn();
			break;
		case 5:
			System.out.println("Getting into Update Warp");
			TextileDAO.update_Warp();
			break;
		case 6:
			System.out.println("Getting into Update Meter");
			TextileDAO.update_Meter();
			break;
		case 7:
			System.out.println("Monthly Statement");
			TextileDAO.monthly();
			break;
		case 8:
			System.out.println("DISPLAYING TABLE");
			TextileDAO.display();
			break;
			default:
				throw new InvalidChoiceException();
				//break;
				
		}
		System.out.println("Type YES if you want to continue");
		sc.nextLine();
		sss=sc.nextLine();
		}while(sss.equals("YES"));
		}
		catch(InvalidChoiceException e)
		{
			System.out.println(e);
		}
	
	}
}
