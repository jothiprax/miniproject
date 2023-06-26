package com.kce.musicstore.bean;

import java.sql.SQLException;
import java.util.Scanner;

import com.kce.musicstore.dao.Classic;
import com.kce.musicstore.dao.Folk;
import com.kce.musicstore.dao.Pop;
import com.kce.musicstore.dao.Rock;

public class Sell {
   @SuppressWarnings({ "resource", "static-access" })
public static void selling() throws ClassNotFoundException, SQLException {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Which genre?");
		System.out.println("1. Rock\n2. Classic\n3. Folk\n4. Pop");
		int genre = sc.nextInt();
		sc.nextLine();
		System.out.println("*****Music Details*****");
		System.out.println("Music Name: ");
		String mname = sc.nextLine();
		System.out.println("Singer: ");
		String singerName = sc.nextLine();
		System.out.println("Language: ");
		String mlan= sc.nextLine();
		System.out.println("Cost: ");
		double mcost = sc.nextDouble();
		System.out.println("How many Music Records you want to sell?");
		int num = sc.nextInt();
		if(genre==1) {
			Rock rock = new Rock(mname,singerName,mlan,mcost,num);
			rock.sell();
		}
		else if(genre==2) {
			Classic classic = new Classic(mname,singerName,mlan,mcost,num);
			classic.sell();
		}
		else if(genre==3) {
			Folk folk = new Folk(mname,singerName,mlan,mcost,num);
			folk.sell();
		}
		else if(genre==4) {
			Pop pop = new Pop(mname,singerName,mlan,mcost,num);
			pop.sell();
		}
		else {
			System.out.println("Please enter vaild choice!!");
			selling();
		}
   }
}
