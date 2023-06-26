package com.kce.service;
import java.util.*;
import com.kce.bean.*;
import com.kce.bean.Account;
import com.kce.bean.Current_Account;
import com.kce.bean.User;
import com.kce.dao.AccountNumberGenerator;
import com.kce.dao.DatabaseOperations;
import com.kce.dao.Jdbc;
import com.kce.dao.Validation;
import com.kce.util.InvalidCredentialsException;
import com.kce.util.InvalidDOBException;
import com.kce.util.InvalidEmailException;
import com.kce.util.InvalidInputException;
import com.kce.util.InvalidMobileNumberException;
import com.kce.util.UserNameUnavailableException;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Variable Initialization
		int option=0;
		String name = null;
		String gender = null;
		String dob = null;
		String mobile_no = null;
		String address;
		String email = null;
		String userName = null;
		String password = null;
		String account_no = null;
		float amount;
		int type = 0;
		while(true) {
		System.out.println("                                         -----------------                                                    ");
		System.out.println("1.Create an Account");
		System.out.println("2.Login");
		System.out.println("3.Login as Admin");
		System.out.println("4.Exit form the page");
		option = sc.nextInt();
		switch(option)
		{
		//Creating Account
		case 1:
			System.out.println("1.Current Account");
			System.out.println("2.Savings Account");
			try {
				System.out.println("Enter Account type:");
				type = sc.nextInt();
				if(type != 1 && type != 2)
					throw new InvalidInputException("Enter 1 or 2");
			}
			catch(InvalidInputException e)
			{
				System.err.println(e.getMessage());
				break;
			}
			
			System.out.println("Enter your name   :");
			name = sc.next();
			System.out.println("Enter your address:");
			address = sc.next();
			try {
				System.out.println("Enter your email  :");
				email = sc.next();
				if(!email.contains("@")||!email.contains("."))
					throw new InvalidEmailException("Enter valid Email address");
			}
			catch(InvalidEmailException e)
			{
				System.err.println(e);
				break;
			}
			System.out.println("Enter your gender :");
			gender = sc.next();
			try {
				System.out.println("Enter your mobile_no:");
				mobile_no = sc.next();
				if(mobile_no.length() != 10)
					throw new InvalidMobileNumberException("Enter Valid Mobile Number");
			}
			catch(InvalidMobileNumberException e)
			{
				System.err.println(e);
				break;
			}
			try {
				System.out.println("Enter your DOB(dd/mm/yyyy):");
				dob = sc.next();
				if(!dob.matches("\\d+/\\d+/\\d+"))
					throw new InvalidDOBException("Enter Valid date format");
			}
			catch(InvalidDOBException e)
			{
				System.err.println(e);
				break;
			}
			AccountNumberGenerator ang=new AccountNumberGenerator();
			account_no = ang.getAccountNumber();
			System.out.println("Your account number:"+account_no);
			System.out.println("Don't Forget");
			try {
				System.out.println("Enter a username:");
				userName = sc.next();
				Validation v=new Validation();
				if(!v.userNameAvailable(userName))
					throw new UserNameUnavailableException("Enter different username");
			}
			catch(UserNameUnavailableException e)
			{
				System.err.println(e);
			}
			System.out.println("Enter password:");
			password=sc.next();
			User user = new User(name, gender, dob, mobile_no, address, email, userName, password, account_no);
			Jdbc jdbc = new Jdbc();
			jdbc.DatacaseConnectionUser(user);
			if(type == 1) {
				Current_Account account=new Current_Account(user, 0);
				jdbc.DatacaseConnectionCurrentAccount(account);
			}
			else if(type == 2)
			{
				Savings_Account account=new Savings_Account(user, 0, 6);
				jdbc.DatacaseConnectionSavingsAccount(account);
			}
			System.out.println("Account Created Successfully!!!");
			break;
			
		//Account Login
		case 2:
			Validation v=new Validation();
			DatabaseOperations d=new DatabaseOperations();
			System.out.println("Enter a username:");
			userName = sc.next();
			System.out.println("Enter password:");
			password=sc.next();
			try {
				if(!v.checkCredentials(userName, password))
					throw new InvalidCredentialsException("Enter Correct Username Password");
			}
			catch(InvalidCredentialsException e)
			{
				System.out.println(e);
			}
			while(true) {
			account_no=d.getAccountNo(userName);
			System.out.println("1.Credit Amount");
			System.out.println("2.Amount Transfer");
			System.out.println("3.View Balance");
			System.out.println("4.Exit from this page");
			option = sc.nextInt();
			if(option == 1)
			{
				System.out.println("Enter the amount to Credit:");
				amount = sc.nextFloat();
				float CurrAmount = d.getBalance(account_no);
				amount = amount+CurrAmount;
				d.addAmount(account_no, amount);
				System.out.println("Amount Credited");
				continue;
			}
			else if(option == 2)
			{
				System.out.println("Enter the account number to transfer:");
				String receiver_account_no = sc.next();
				System.out.println("Enter the amount to transfer:");
				amount = sc.nextFloat();
				float senderBalance = d.getBalance(account_no);
				if(senderBalance < amount)
				{
					System.out.println("Balance Insufficient");
					System.out.println("Current Balance:"+d.getBalance(account_no));
					continue;
				}
				else
				{
					if(d.Transaction(account_no, amount, receiver_account_no)==1)
					{
						System.out.println("Transaction successful!");
						continue;
					}
					else
					{
						System.out.println("Transaction failed!");
						continue;
					}
				}
			}
			else if(option == 3)
			{
				System.out.println("Your current Balance:");
				System.out.println(d.getBalance(account_no));
				continue;
			}
			else if(option == 4)
			{
				break;
			}
			else
			{
				try {
					throw new InvalidInputException("Enter Valid Option");
					}
					catch(InvalidInputException e)
					{
						System.err.println(e.getMessage());
					}
			}
		}
		break;
		case 3:
			System.out.println("Enter admin password:");
			password = sc.next();
			if(!password.equals("admin")) {
				System.err.println("Invalid Password");
				break;
			}
			DatabaseOperations d1=new DatabaseOperations();
			while(true) {
			System.out.println("1.UserDetails");
			System.out.println("2.Transactions");
			System.out.println("3.Exit from the page");
			option = sc.nextInt();
			if(option == 1)
			{
				d1.getUserDetails();
			}
			else if(option == 2)
			{
				d1.getTransactions();
			}
			else if(option == 3)
			{
				break;
			}
			else
			{
				System.err.println("Invalid Option");
			}
			}
			break;
		case 4:
			System.out.println("------------For support,call : 9878787543------------");
			System.exit(0);
			break;
		default:
			try {
			throw new InvalidInputException("Enter Valid Option");
			}
			catch(InvalidInputException e)
			{
				System.err.println(e.getMessage());
			}
			}
		}
	}
}
