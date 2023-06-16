package com.kce.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.kce.dao.CURD_operation;
import com.kce.util.DBConnection;
import com.kce.util.RoomsUnavailableException;

public class Main {
	public static void main(String args[]) throws RoomsUnavailableException {
		try {
			Connection con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			stmt.addBatch("create table hotel(name varchar(30),hotelId int,City varchar(30),phoneNumber varchar(10),noofrooms int,primary key(hotelId));");
			stmt.addBatch(" create table Customer(Customername varchar(30),hotelId int,BookingId int,roomno int,NoOfDays int,bookdate date,primary key(BookingId),foreign key(hotelId) references hotel(hotelId));");
			stmt.executeBatch();
		}
		catch(Exception e) {e.getStackTrace();}
			Scanner sc=new Scanner(System.in);
			System.out.println("\t\t\tHotel Management System");
			System.out.println("1. Inserting the records");
			System.out.println("2. Deleting the Record");
			System.out.println("3. Display the Data");
			int Selection=sc.nextInt();
			switch(Selection) {
			case 1:
				System.out.println("Enter 1 to Insert in Hotel table\nEnter 2 to Insert in Customer table");
				int choice=Integer.parseInt(sc.nextLine());
				if(choice==1) {
					System.out.println("Enter the Hotel Details:");
					CURD_operation.InsertHotel(sc.nextLine(), sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextInt());
				}
				else if(choice==2) {
					System.out.println("Enter the Customer Details:");
					System.out.println("Room type 1:Noraml,Room type2:Delux,Room type 3:Suite");
					CURD_operation.InsertCustomer(sc.nextLine(), sc.nextInt(), sc.nextInt(),sc.nextInt(), sc.nextInt(), sc.nextLine(),sc.nextLine());
				}
				break;
			case 2:
				System.out.println("What table Record you want to delete:");
				System.out.println("Enter 1 to Delete in Hotel table\nEnter 2 to Delete in Customer table");
				int choice1=Integer.parseInt(sc.nextLine());
				if(choice1==1) {
					System.out.println("Enter the HotelId:");
					CURD_operation.DeleteHotel(sc.nextInt());
				}
				else if(choice1==2) {
					System.out.println("Enter the Customer Details:");
					CURD_operation.DeleteCustomer(sc.nextInt());
				}
				break;
			case 3:
				System.out.println("What table Record you want to Retrive:");
				System.out.println("Enter 1 to Retrive from Hotel table\nEnter 2 to Retrive from Customer table");
				int choice2=Integer.parseInt(sc.nextLine());
				if(choice2==1) {
					CURD_operation.RetriveCustomer();
				}
				else if(choice2==2) {
					CURD_operation.RetriveHotel();
				}
				break;
				
			}
		}
	}

