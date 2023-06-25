package project;

import java.sql.SQLException;
import java.util.Scanner;

public class demo {
	public static void main(String[] args) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		switch(a)
		{
		case 1:
		for(int i=1;i<10;i++)
		{
			int number=sc.nextInt();
			sc.nextLine();
			String holder=sc.nextLine();
			double balance=sc.nextDouble();
			sc.nextLine();
			BankSystem b=new BankSystem(number,holder,balance);
			b.add();
		}
			break;
		case 2:
			BalanceCheck bc=new BalanceCheck();
			bc.checkbalance();
			break;
		case 3:
			Deposit dp=new Deposit();
			try {
				dp.Depositbalance();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			break;
		case 4:
			newAccount na=new newAccount();
		   na.nofund();
		   break;
		}
		}
	}

