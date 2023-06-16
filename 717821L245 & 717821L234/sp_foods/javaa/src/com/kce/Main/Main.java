package com.kce.Main;
import com.kce.connection.*;
import com.kce.customercheck.*;
import com.kce.customer.*;
import com.kce.orders.*;
import com.kce.ordersdao.*;
import com.kce.customerdao.*;
import com.kce.login.login;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		connection.createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.print("\n-----------WELCOME TO SP_FOODS-------------\n");
		while(true)
		{
            System.out.println("--WELCOME TO FOOD ORDERING SYSTEM--");
			customercheck c=new customercheck();
			c.checkaccount();
		}
	}
}
