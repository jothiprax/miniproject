package com.kce.bean;

	import java.util.*;

	import com.kce.dao.Dao;

	public class Admin
	{
		int key=0;
		Scanner sc = new Scanner(System.in);
		Dao d = new Dao();

		public void register()
		{
			System.out.print("ENTER YOUR NAME: ");
		String name=sc.nextLine();
		 class FormatException {
			//custom Exception class
			public FormatException()
				{
					System.out.println("please enter valid name!!!!kindly dont use numbers or spcial characters for your name");
				}
		}

		System.out.println();
		System.out.print("ENTER YOUR MOBILE NUMBER: ");
		String mob_no=sc.nextLine();
		System.out.println();
		System.out.print("ENTER YOUR EMAIL ID: ");
		String em = sc.nextLine();
		System.out.println();
		System.out.print("ENTER YOUR PASSWORD: ");
		String pwd=sc.nextLine();
		System.out.println();
		key++;
		d.registerKey(key,name,pwd);
		System.out.println("YOU ARE SUCESSFULLY REGISTERED!!\nYOUR NAME IS YOUR USERNAME\n YOUR  KEY IS "+key);
		}
		public void login()
		{
			System.out.print("ENTER YOUR KEY: ");
			int ekey=sc.nextInt();
			System.out.println();
			System.out.print("ENTER YOUR USERNAME: ");
			String username=sc.nextLine();
			System.out.println();
			System.out.print("ENTER YOUR PASSWORD: ");
			String password=sc.nextLine();
			System.out.println();
			int check=d.checkKey(key,password);
			if(check==1)
				System.out.println("Log in sucessful!");
			else
				System.out.println("!!WRONG CREDENTIALS!!/nplease enter correct credentials!!");
			}}



