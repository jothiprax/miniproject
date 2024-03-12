package com.kce.util;

import java.util.Scanner;

import com.kce.dao.History;

public class StatusManager {
	Scanner sc=new Scanner(System.in);
	History history=new History();
	int menu_attempts=0;
public int order_status()
{
	
	System.out.println("********************ENTER 1 IF DELIVERED********************");
	int status=sc.nextInt();
	return status;
}
public int menu_attempts()
{
	menu_attempts++;
	return menu_attempts;
}
public void setMenu_attempts(int menu_attempts) {
	this.menu_attempts = menu_attempts;
}
public 	void update_order_status(int status)
{
	if(status==0)return ;
	history.order_placing_history();
}
}
