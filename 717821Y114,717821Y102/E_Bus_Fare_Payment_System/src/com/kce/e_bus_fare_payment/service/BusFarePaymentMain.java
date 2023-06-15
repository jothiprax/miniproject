package com.kce.e_bus_fare_payment.service;

import com.kce.e_bus_fare_payment.dao.*;
import java.util.*;
public class BusFarePaymentMain {
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			displayMenu();
			int choice =sc.nextInt();
		switch(choice) {
		case 1:
			WalletDAO.activateWallet();
			break;
		case 2:
			BankAccountDAO.addBankAccount();
			break;
		case 3:
			AddMoneyToWallet.addMoneyToWallet();
			break;
		case 4:
			PaymentDAO.payBusFare();
			break;
		case 5:
			return;
		default:
			System.out.println("Enter correct choice");
			continue;
		}
		
	}
	}
	public static void displayMenu() {
		System.out.println("1.Activate Wallet");
		System.out.println("2.Add Bank Account to Wallet");
		System.out.println("3.Add Money to Wallet from Bank Account");
		System.out.println("4.Pay using Wallet");
		System.out.println("5.Exit");
		System.out.println("Enter choice:");
		
	}
	
	

}
