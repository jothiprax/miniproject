package com.kce.cab.service;


import com.kce.cab.dao.*;
import java.util.*;
class CabMain {
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
					carDAO.createDetailTable();
					break;
					case 2:
					System.out.println("Inserting into table");
					carDAO.insert();
					break;
					case 3:
						System.out.println("Displaying");
					carDAO.display();
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

