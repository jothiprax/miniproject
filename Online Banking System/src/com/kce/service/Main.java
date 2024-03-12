package com.kce.service;
import java.util.*;
import com.kce.dao.*;
public class Main {
public static void call() {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the Option Number");
	System.out.println("1. For new Account creation");
	System.out.println("2. Online Banking");
	//System.out.println("3. Manager login");
	char option=sc.next().charAt(0);
	switch(option) {
	case '1':BankDAO.createAccount();break;
	case '2':BankDAO.login();break;
}sc.close();
	
}
	
	public static void main(String[] args) {
		System.out.println("WELCOME TO YOUR BANK"+"\n\n");
		Main.call();
		
	}

}
