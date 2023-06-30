package com.kce.musicstore.bean;

import com.kce.musicstore.dao.Classic;
import com.kce.musicstore.dao.Folk;
import com.kce.musicstore.dao.Pop;
import com.kce.musicstore.dao.Rock;

import java.sql.SQLException;
import java.util.Scanner;

public class Buy {
@SuppressWarnings({ "static-access", "resource" })
public static void buying() throws ClassNotFoundException, SQLException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Which genre?");
	System.out.println("1. Rock\n2. Classic\n3. Folk\n4. Pop");
	int genre2 = sc.nextInt();
	if(genre2==1) {
		System.out.println("Which feature you want?");
		System.out.println("1. Search by first letter of Music's name.\n2. Search by Music's Singer.\n3. Search by Music's lang.\n4. Show All.");
		int option = sc.nextInt();
		sc.nextLine();
		Rock rock2 = new Rock();
		if(option==1) {
			System.out.println("rock");
			System.out.println("Enter Music's name:");
			String mname1 = sc.nextLine();
			rock2.searchByName(mname1);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name11 = sc.nextLine();
			int num11 = sc.nextInt();
			rock2.buy(name11, num11);
		}else if(option==2) {
			System.out.println("Enter Music's singer:");
			String singerName1 = sc.nextLine();
			rock2.searchBySinger(singerName1);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name12 = sc.nextLine();
			int num12 = sc.nextInt();
			rock2.buy(name12, num12);
		}else if(option==3) {
			System.out.println("Enter Music's Language:");
			String language1 = sc.nextLine();
			rock2.searchByLang(language1);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name13 = sc.nextLine();
			int num13 = sc.nextInt();
			rock2.buy(name13, num13);
		}else if(option==4){
			rock2.showList();
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name14 = sc.nextLine();
			int num14 = sc.nextInt();
			rock2.buy(name14, num14);
		}
		else {
			System.out.println("Please enter valid choice!!");
			buying();
		}
	}
	else if(genre2==2) {
		Classic classic2 = new Classic();
		System.out.println("Which feature you want?");
		System.out.println("1. Search by first letter of Music's name.\n2. Search by Music's Singer.\n3. Search by Music's lang.\n4. Show All.");
		int option2 = sc.nextInt();
		sc.nextLine();
		if(option2==1) {
			System.out.println("Enter Music's name:");
			String mname2 = sc.nextLine();
			classic2.searchByName(mname2);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name21 = sc.nextLine();
			int num21 = sc.nextInt();
			classic2.buy(name21, num21);
		}else if(option2==2) {
			System.out.println("Enter Music's singer:");
			String singerName2 = sc.nextLine();
			classic2.searchBySinger(singerName2);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name22 = sc.nextLine();
			int num22 = sc.nextInt();
			classic2.buy(name22, num22);
		}else if(option2==3) {
			System.out.println("Enter Music's Language:");
			String language2 = sc.nextLine();
			classic2.searchByLang(language2);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name23 = sc.nextLine();
			int num23 = sc.nextInt();
			classic2.buy(name23, num23);
		}else if(option2==4){
			classic2.showList();
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name24 = sc.nextLine();
			int num24 = sc.nextInt();
			classic2.buy(name24, num24);
		}
		else {
			System.out.println("Please enter valid choice!!");
			Choice.choice();
		}
	}
	else if(genre2==3) {
		Folk folk2 = new Folk();
		System.out.println("Which feature you want?");
		System.out.println("1. Search by first letter of Music's name.\n2. Search by Music's Singer.\n3. Search by Music's lang.\n4. Show All.");
		int option3 = sc.nextInt();
		sc.nextLine();
		if(option3==1) {
			System.out.println("Enter Music's name:");
			String mname3 = sc.nextLine();
			folk2.searchByName(mname3);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name31 = sc.nextLine();
			int num31 = sc.nextInt();
			folk2.buy(name31, num31);
		}else if(option3==2) {
			System.out.println("Enter Music's singer:");
			String singerName3 = sc.nextLine();
			folk2.searchBySinger(singerName3);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name32 = sc.nextLine();
			int num32 = sc.nextInt();
			folk2.buy(name32, num32);
		}else if(option3==3) {
			System.out.println("Enter Music's Language:");
			String language3 = sc.nextLine();
			folk2.searchByLang(language3);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name33 = sc.nextLine();
			int num33 = sc.nextInt();
			folk2.buy(name33, num33);
		}else if(option3==4){
			folk2.showList();
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name34 = sc.nextLine();
			int num34 = sc.nextInt();
			folk2.buy(name34, num34);
		}
		else {
			System.out.println("Please enter valid choice!!");
			Choice.choice();
		}
	}
	else if(genre2==4){
		System.out.println("Which feature you want?");
		System.out.println("1. Search by first letter of Music's name.\n2. Search by Music's Singer.\n3. Search by Music's lang.\n4. Show All.");
		int option4 = sc.nextInt();
		sc.nextLine();
		Pop pop2 = new Pop();
		if(option4==1) {
			System.out.println("Enter Music's name:");
			String mname4 = sc.nextLine();
			pop2.searchByName(mname4);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name41 = sc.nextLine();
			int num41 = sc.nextInt();
			pop2.buy(name41, num41);
		}else if(option4==2) {
			System.out.println("Enter Music's singer:");
			String singerName4 = sc.nextLine();
			pop2.searchBySinger(singerName4);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name42 = sc.nextLine();
			int num42 = sc.nextInt();
			pop2.buy(name42, num42);
		}else if(option4==3) {
			System.out.println("Enter Music's Language:");
			String language4 = sc.nextLine();
			pop2.searchByLang(language4);
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name43 = sc.nextLine();
			int num43 = sc.nextInt();
			pop2.buy(name43, num43);
		}else if(option4==4){
			pop2.showList();
			System.out.println("Enter Music's name and quantity you want to buy: ");
			String name44 = sc.nextLine();
			int num44 = sc.nextInt();
			pop2.buy(name44, num44);
		}
		else {
			System.out.println("Please enter valid choice!!");
			Choice.choice();
		}
	}
	else {
		System.out.println("Please enter valid choice!!");
		buying();
	}
}
}
