package com.kce.musicstore.bean;

import java.sql.SQLException;
import java.util.Scanner;

public class Choice {
@SuppressWarnings("resource")
public static void choice() throws ClassNotFoundException, SQLException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Which feature you want?");
	System.err.println("1. Sell\n2. Buy");
	int feature = sc.nextInt();
	if(feature==1) {
		Sell.selling();
	}
	else if(feature==2){
		Buy.buying();
	}
	else {
		System.err.println("Please enter valid choice!!");
		choice();
	}
}
}
