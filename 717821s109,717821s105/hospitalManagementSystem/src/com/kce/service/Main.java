package com.kce.service;


import java.util.Scanner;

import com.kce.dao.DPdao;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add patient");
            System.out.println("2. Update patient");
            System.out.println("3. Delete patient");
            System.out.println("4. Display Details of Patient");
            System.out.println("5. Add doctor");
            System.out.println("6. Update doctor");
            System.out.println("7. Delete doctor");
            System.out.println("8. Display Details of Doctor");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            DPdao d = new DPdao();
            switch (choice) {
                case 1:
                    d.addPatient();
                    break;
                case 2:
                    d.updatePatient();
                    break;
                case 3:
                    d.deletePatient();
                    break;
                case 4:
                	d.DisplayPatientdetails();
                	break;
                case 5:
                    d.addDoctor();
                    break;
                case 6:
                    d.updateDoctor();
                    break;
                case 7:
                    d.deleteDoctor();
                    break;
                case 8:
                	d.DisplayDoctordetails();
                	break;   
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
        }
        sc.close();
    }
}