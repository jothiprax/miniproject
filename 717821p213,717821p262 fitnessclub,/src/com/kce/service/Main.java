package com.kce.service;
import java.util.*;

import com.kce.bean.Login;
import com.kce.bean.Remove;
import com.kce.bean.Updatetrainer;
import com.kce.bean.Gettname;
import com.kce.dao.Checkup;
import com.kce.dao.Insertdetails;
import com.kce.dao.Selectid;
import com.kce.dao.Selecttrainer;
import com.kce.dao.Setid;
import com.kce.util.Excep;
public class Main {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int mid = 0,mage = 0,toption,t=0,x=0,z=0,q=0;
	long mnumber = 0,mwnumber = 0;
	String mname = null,mgender = null,username = null,password = null,city = null,address = null,mjoindate = null,tname = null;
	while(t==0)
	{
	System.out.println("---------WELCOME TO FITNESS HEALTH CLUB--------");
	System.out.println("1.create gym account");
	System.out.println("2.login");
	System.out.println("3.DISCONTINUE FROM FITNESSCLUB");
	System.out.println("4.exists");
	System.out.println("enter your option:");
	int op=sc.nextInt();
	switch(op)
	{
	case 1:
		System.out.println("Fill The Following Procedure:");
		Selectid si=new Selectid();
		mid=si.gettid();
		if(mid==0)
		{
			mid=1;
		}
		else
		{
			mid+=1;
		}
		System.out.println("enter your name:");
		sc.nextLine();
		mname=sc.nextLine();
		System.out.println("enter your age");
		mage=sc.nextInt();
		System.out.println("enter your sex");
		sc.nextLine();
		mgender=sc.nextLine();
		System.out.println("enter your phone number");
		mnumber=sc.nextLong();
		System.out.println("enter your whatsapp number");
		mwnumber=sc.nextLong();
		System.out.println("enter your join date");
		sc.nextLine();
		mjoindate=sc.nextLine();
		System.out.println("if you want trainer");
		System.out.println("select your option");
		System.out.println("1.need trainer");
		System.out.println("2.don't need trainer");
		toption=sc.nextInt();
		Selecttrainer st=new Selecttrainer();
		sc.nextLine();
		if(toption==1)
		{
			tname=st.gettname(mgender);
		}
		else
		{
			tname="myself";
		}
		int r=si.gettid(); 
		if(r==0)
		{
			System.out.println("enter username");
			username=sc.nextLine();
			System.out.println("enter password");
		    password=sc.nextLine();
		}
		else
		{
			Checkup up=new Checkup();
			while(x==0)
			{
			System.out.println("enter username");
			username=sc.nextLine();
			System.out.println("enter password");
		    password=sc.nextLine();
		    x=up.cc(username,password);
		    if(x==0)
		    {
		    	System.out.println("Invalid USERNAME AND PASSWORD");
		    }
		    else
		    {
		    	System.out.println("Successfully added username and password");
		    }
			}
		}
		System.out.println("enter the city");
		city=sc.nextLine();
		System.out.println("enter your address");
		address=sc.nextLine();
		Insertdetails in=new Insertdetails();
		in.insertd(mid,mname,mage,mgender,mnumber,mwnumber,mjoindate,tname,username,password,city,address);
		Setid sii=new Setid();
		sii.setd(1,tname);
		x=0;
	break;
	case 2:
		sc.nextLine();
		Selectid s=new Selectid();
		int w=s.gettid();
		if(w==0)
		{
			System.out.println("First you have to create gym account then you can login.");
		}
		else
		{
		while(z==0)
		{
		System.out.println("enter your correct user name");
		username=sc.nextLine();
		System.out.println("enter your correct pass word");
		password=sc.nextLine();
		Login l=new Login();
		Checkup c=new Checkup();
		z=c.cc(username,password);
		if(z==1)
		{
			System.out.println("Invalid username and password");
			z=0;
		}
		else if(z==0)
		{
			l.loginmethod(username,password);
			z=1;
		}
		}
		}
		z=0;
	break;
	case 3:
		Selectid ss=new Selectid();
		int ww=ss.gettid();
		if(ww==0)
		{
			System.out.println("you are not one person in this fitnessclub, bacause database is empty right now");
		}
		else
		{
		while(q==0)
		{
			sc.nextLine();
			System.out.println("enter your correct user name");
			username=sc.nextLine();
			System.out.println("enter your correct pass word");
			password=sc.nextLine();
			Checkup c=new Checkup();
			Remove rm=new Remove();
			Gettname up=new Gettname();
			Updatetrainer upda=new Updatetrainer();
			tname=up.getname(username,password);
			q=c.cc(username,password);
			if(q==0)
			{
				rm.dis(username,password);
				System.out.println("Successfully removed");
				upda.upd(tname);
				q=1;
			}
			else if(q==1)
			{
				System.out.println("Invalid username and password");
				q=0;
			}
		}
		}
		q=0;
		break;
	case 4:
		t=1;
	break;
	default:
			System.out.println("invalid input");
       }
	}
	}
}
