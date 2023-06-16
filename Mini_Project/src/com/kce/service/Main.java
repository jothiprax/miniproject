package com.kce.service;
import java.util.Scanner;

import com.kce.dao.LoginAccessDao;
import com.kce.dao.MedicineDetailsDao;
class emailidNotValidException extends Exception{
	public emailidNotValidException (String s) {
		super(s);
	}
}
public class Main {
	public static void showOption() {
		System.out.println("Inserting the records");
		System.out.println("Updating the Data");
		System.out.println("Deleting the Rows");
		System.out.println("Deleting the Table");
		System.out.println("Display the Data");
		System.out.println("Buy Medicine");
		System.out.println("Quit");
	}
	static Scanner sc= new Scanner (System.in);
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("If New User Select 1 else Select 2");
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
			System.out.println("Enter the choice:");
			choice = sc.nextInt();
			sc.nextLine(); 
			switch (choice) {
			case 1:
				System.out.println("Enter the Number of Records to be inserted:");
				MedicineDetailsDao.insertValues(sc.nextInt());
				break;
			case 2:
				MedicineDetailsDao.updateRecord();
				break;
			case 4:
				MedicineDetailsDao. deleteRows();
				break;
			case 5:
				MedicineDetailsDao. deleteTable();
				break;
			case 7:
				MedicineDetailsDao. buyMedicine();
				break;
			case 8:
				System.out.println("Thank You!");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}
