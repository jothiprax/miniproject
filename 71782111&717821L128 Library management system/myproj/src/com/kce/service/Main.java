package com.kce.service;

import java.sql.SQLException;

import java.util.Scanner;

import com.kce.Dao.BookDetailsDAO;
import com.kce.Dao.BorrowerDetailsDAO;
import com.kce.Dao.OverdueException;
import com.kce.bean.BorrowerDetails;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Enter 1 for Updation: ");
		System.out.println("Enter 2 if you want to borrow: ");
		int choose = sc.nextInt();
		while (true) {
			if (choose == 1) {

				System.out.println("--------------------------------------------------------------------------------------------------------------------");
				System.out.println("Enter the choice for updation:");
				System.out.println("1. Insert records");
				System.out.println("2. Update records");
				System.out.println("3. Delete records");
				System.out.println("4. Show records");
				System.out.println("5. Exit");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:

					System.out.println("Enter the Number of Records to be inserted:");
					BookDetailsDAO.insert(sc.nextInt());

					break;

				case 2:
					BookDetailsDAO.update();
					break;

				case 3:
					BookDetailsDAO.delete();
					break;

				case 4:
					BookDetailsDAO.displayTable();
					break;

				case 5:
					System.out.println("Thank You!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice....");
					break;
				}

			} else if (choose == 2) {
				while (true) {
					System.out.println("Enter the Choice");
					System.out.println("1. Borrower: ");
					System.out.println("2. Delete Rows");
					System.out.println("3. Update Data");
					System.out.println("4. Display Borrower Details");
					System.out.println("5. Exit");
					int choice = sc.nextInt();
					sc.nextLine();

					switch (choice) {
					case 1:
						BookDetailsDAO.displayTable();

						System.out.println("Enter borrower id: ");
						int Borrowerid=sc.nextInt();
						System.out.println("Enter the borrower name: ");
						String Borrowername=sc.next();
						System.out.println("Enter borrower phone number: ");
						String BorrowerphNo = sc.next();
						System.out.println("Enter the due date: ");
						String due_date = sc.next();
						
						System.out.println("Details of Borrower Collected Successfully!!!");					
						BorrowerDetails borrowerDetails = new  BorrowerDetails(Borrowerid,Borrowername,BorrowerphNo,due_date);
						BorrowerDetailsDAO.Borrower(borrowerDetails);
						break;
					case 2:
						BorrowerDetailsDAO.deleteRows();
						break;
					case 3:
						BorrowerDetailsDAO.update();
						break;
					case 4:
						BorrowerDetailsDAO.displayTable();
						break;

					case 5:
						System.out.println("Thank You!");
						System.exit(0);
						break;



					default:

						System.out.println("Invalid choice...Try again!");
						break;
					}

					System.out.println("--------------------------------------------------------------------------------------------------------------------------");

					
				}
			}}}}
