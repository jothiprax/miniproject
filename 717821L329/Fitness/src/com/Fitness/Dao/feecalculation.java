package com.Fitness.Dao;
import java.util.*;
public class feecalculation {
public double feecal(double fee) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter :"+"\n"+"1-week"+"\n"+"2-month"+"\n"+"3-year");
	int opt=sc.nextInt();
	double cal=0.00;
	switch(opt) {
	case 1:
		System.out.println("Enter the number of Weeks ......");
		int week=sc.nextInt();
		cal=week*fee;
		break;
	case 2:
		System.out.println("Enter the number of Months ......");
		int month=sc.nextInt();
		cal=month*4*fee;
		break;
	case 3:
		System.out.println("Enter the number of Years ......");
		int year=sc.nextInt();
		cal=year*52*fee;
		break;
	}return cal;
}
}
