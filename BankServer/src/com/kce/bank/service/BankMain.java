package com.kce.bank.service;
import java.sql.SQLException;
import java.util.Scanner;

import  com.kce.bank.dao.*;
public class BankMain {
	public static void calling() throws ClassNotFoundException, SQLException {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1 to create a new account.");
			System.out.println("Enter 2 to login to your account");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				BankDAO.insert();
				break;
			case 2:
				BankDAO.Login();
				break;
			default:
				System.out.println("Enter a valid option.");
			}
		  }
	public static void main(String[]args) throws ClassNotFoundException, SQLException {
	       calling();
	}
}


