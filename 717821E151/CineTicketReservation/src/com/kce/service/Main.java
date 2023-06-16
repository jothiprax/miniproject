package com.kce.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.kce.Bean.Details;
import com.kce.Bean.Reservation;
import com.kce.DAO.DAO;

public class Main extends DAO{
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
Reservation arr[]=new Reservation[5];
Scanner sc=new Scanner(System.in);
for(int i=1;i<3;i++) {
	System.out.println("Enter id:");
	int id=sc.nextInt();
	System.out.println("Enter name:");
	String name=sc.next();
	System.out.println("Enter age:");
	int age=sc.nextInt();
	System.out.println("Enter gender:");
	String gender=sc.next();
	arr[i]=new Reservation(id, name, age, gender);}
	insert(arr); 


Details arr1[]=new Details[5];
for(int i=1;i<3;i++) {
	System.out.println("Enter the no.of seats required:");
	int seat=sc.nextInt();
	System.out.println("The available movies are mentiones in the catalogue,choose one among them:");
	String movie=sc.next();
	System.out.println("Mention the class(1st=Rs.450/- 2nd=Rs.300/- 3rd=Rs.250/-)");
	String type=sc.next();
	arr1[i]=new Details(seat, movie, type);}
	insert1(arr1);
	display(); 
	
	//delete();
	

	}

	

}
