package com.kce.service;
import java.util.Scanner;
import com.kce.Dao.MedicinesDao;
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