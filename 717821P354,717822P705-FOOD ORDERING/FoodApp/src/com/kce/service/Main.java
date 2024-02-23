package com.kce.service;
import java.sql.SQLException;
import java.util.*;

import com.kce.dao.History;
import com.kce.dao.Order;
import com.kce.dao.password_manager;
import com.kce.util.StatusManager;
import com.kce.util.UserException;
import com.kce.util.Welcome;

public class Main {
	public static void main(String[] args) throws Exception {
	@SuppressWarnings("resource")
	Scanner sc=new Scanner (System.in);
	Order order=new Order();
	History history=new History();
	StatusManager status=new StatusManager();
	Welcome welcome=new Welcome();
	System.out.println("WELCOME TO FOOD ORDER CONSOLE:\n");
	System.out.println("ENTER \n1.SIGUP\n2.LOGIN");
	int f=0;
	while(true) {
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		welcome.Login();
		f=1;
		break;
	case 2:
		welcome.Sigup();
		f=2;
		break;
	default:
		System.out.println("INVALID CHOICE....");
	}
	if(f==0)
	{
		System.out.println("NO ACCOUNTS DETECTED.....");
		Main.main(null);
	}
	else
	{
		System.out.println("1.PLACE ORDER\n2.ADMIN_ONLY");
		int choice2=sc.nextInt();
		if(choice2==2)
		{
			System.out.println("ENTER THE PASSWORD:");
			int password=sc.nextInt();
			if(password_manager.ManagerPasswordCheck(password))
			{
				System.out.println("********************WELCOME ADMIN********************");
				System.out.println("1.ENTER MENU\n2.DISPLAY ORDERS3.EXIT");
				int admin_choice=sc.nextInt();
				switch(admin_choice)
				{
				case 1:
					order.get_menu();
					break;
				case 2:
					order.display_order();
					break;
				case 3:
					Main.main(null);
				}
			}
			else
			{
				System.out.println("WRONG PASSWORD RETURNING TO HOME....");
				Main.main(null);
			}
		}
		else
		{
			switch(choice2)
			{
			case 1:
				order.place_order();
				break;
			}
		}
	}
	}
	}
}
