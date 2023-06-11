package com.kce.service;
import java.util.Scanner;

import com.kce.Dao.LoginAccessDao;
import com.kce.Dao.MedicinesDao;
class emailidNotValidException extends Exception{
	public emailidNotValidException (String s) {
		super(s);
	}
}

public class Main {


	public static void showOption() {
		System.out.println("1. Inserting the records");
		System.out.println("2. Updating the Data");
		System.out.println("3. Deleting the Record");
		System.out.println("4. Deleting the Rows");
		System.out.println("5. Deleting the Table");
		System.out.println("6. Display the Data");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("7. Buy Medicine");
		System.out.println("8. Quit");
	}

	static Scanner sc= new Scanner (System.in);
	public static void main(String[] args) throws ClassNotFoundException {

		System.out.println("If NewUser Select 1 else Select 2");
		int Selection=sc.nextInt();
		if(Selection==2) {
			while(true) {
				System.out.println("Login:");
				System.out.println("Enter the UserName:");
				String user=sc.next();
				System.out.println("Enter the Password:");
				String pass=sc.next();
				Login l=new Login(user,pass);
				if(LoginAccessDao.Login(l)==1) {
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
					System.out.println("Enter the EmailId:");
					String emailid=sc.next();

					if(!emailid.contains("@")) {
						throw new emailidNotValidException("Not Valid EmailId");

					}
					else {
						System.out.println("Enter the Password:");
						String password=sc.next();
						SignIn s=new SignIn(username,emailid,password);
						LoginAccessDao.SignIn(s);
						break;
					}
				}
			}catch(emailidNotValidException e) {
				System.out.println(e);
				System.exit(0);
			}
		}

		showOption();
		while (true) {
			int choice;
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Enter the choice:");
			choice = sc.nextInt();
			sc.nextLine(); 
			switch (choice) {
			case 1:
				System.out.println("Enter the Number of Records to be inserted:");
				MedicinesDao.insertValues(sc.nextInt());
				break;
			case 2:
				MedicinesDao.updateRecord();
				break;
			case 3:
				System.out.println("Enter the ID to be deleted:");
				MedicinesDao. deleteRecord(sc.nextInt());
				break;
			case 4:
				MedicinesDao. deleteRows();
				break;
			case 5:
				MedicinesDao. deleteTable();
				break;
			case 6:
				MedicinesDao. showDetails();
				break;
			case 7:
				MedicinesDao. buyMedicine();
				break;
			case 8:
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