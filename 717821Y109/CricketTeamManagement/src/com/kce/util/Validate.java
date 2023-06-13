package com.kce.util;

import java.util.Scanner;

public class Validate{
	
	static String username="ADMIN";
	static String password="PASSWORD";
	
	//method to validate the match number
	public static void validatematch(int matchNo) {
		try {
		if(matchNo<1||matchNo>3)
			throw new MatchNotFoundException();
			}catch(MatchNotFoundException e) {
				System.out.println(e);
				System.exit(1);
				}
		}
	
	//method to validate the player role
	public static boolean validateUser() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("Only Admin can perform this operation.\nEnter user name:");
		String name=sc.nextLine();
		System.out.print("Enter the password:");
		String pass=sc.nextLine();
		return (username.equals(name)&&password.equals(pass));
		}
	
	//method to check does it contains String value or numeric value
	@SuppressWarnings("unused")
	public static boolean validatString(String str) {
		for(int i=0;i<str.length();i++) {
			return(Character.isAlphabetic(str.charAt(i)));
		}
		return false;
	}
	
}