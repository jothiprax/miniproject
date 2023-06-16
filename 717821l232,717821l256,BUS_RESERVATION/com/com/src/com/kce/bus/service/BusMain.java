package com.kce.bus.service;
import com.kce.bus.dao.*;
import java.util.*;

import javax.sound.midi.SysexMessage;
public class BusMain {

	public static void main(String[] args) 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice");
			System.out.println("Enter 1 to createTable\nEnter 2 to insert into table\nEnter 3 to display");
			int n=sc.nextInt();
			switch(n)
			{
			case 1:
		    System.out.println("Creating Table");
			BusDAO.createDetailTable();
			break;
			case 2:
			System.out.println("Inserting into table");
			BusDAO.insert();
			break;
			case 3:
				System.out.println("Displaying");
			BusDAO.display();
			break;
			default:
				System.out.println("Invalid input");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
