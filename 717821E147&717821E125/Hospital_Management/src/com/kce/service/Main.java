package com.kce.service;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.DAO.PatientDetailsDAO;
import com.kce.bean.DoctorDetailsDAO;
public class Main {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	System.out.println("If you are a Doctor enter 1");
     System.out.println("If you are a patient enter 2");
     DoctorDetailsDAO d = new DoctorDetailsDAO();
     PatientDetailsDAO p = new PatientDetailsDAO();
     Scanner ip = new Scanner(System.in);
int press = ip.nextInt();
while (true) {
	if (press == 1) {

		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter the choice:");
		System.out.println("1. Insert records");
		System.out.println("2. Update records");
		System.out.println("3. Delete records");
		System.out.println("4. Show records");
		System.out.println("5. Exit");

		int choice = ip.nextInt();
		ip.nextLine();

		switch (choice) {
		case 1:

			d.create();

			break;

		case 2:
			System.out.println("Enter the Number of Record to be insert:"); 
			d.insertValues(ip.nextInt()); 
			break;

		case 3:
			d.update(ip.nextInt());
			break;

		case 4:
			d.showDetails();
			break;

		case 5:
			System.out.println("Thank You!!!!"); 
			System.exit(0);
			break;

		default:
			System.out.println("Invalid choice....");
			break;
		}

	} else if (press == 2) {
		while (true) {
			System.out.println("Enter the Choice");
			System.out.println("1. patient: ");
			System.out.println("2. insert rows ");
			System.out.println("3. update data");
			System.out.println("4. delete");
			System.out.println("5.showdetails");
			System.out.println("6.exit");
			int choice = ip.nextInt();
			ip.nextLine();

			switch (choice) {
			case 1:

				System.out.println("Enter id: ");
				int id = ip.nextInt();
				System.out.println("Enter the  patient Name: ");
				String name = ip.next();
				System.out.println("Enter gender: ");
				String gender = ip.next();
				System.out.println("Enter the entrydate: ");
				String entrydate= ip.next();
				System.out.println("Enter the exitdate: ");
				String exitdate = ip.next();
				String discharge = entrydate+exitdate;
				System.out.println("You are completely alright");
				break;
			case 2:
				p.insertValues(ip.nextInt());
				break;
			case 3:
				p.update(ip.nextInt());
				break;

			case 4:
				p.delete(ip.nextInt());
				break;
			case 5:
				p.showDetails();
				break;
			case 6:
				System.out.println("Thank You!");
                default:
				System.out.println("Invalid choice....");
				break;
			}

			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		}
	}
}}}

