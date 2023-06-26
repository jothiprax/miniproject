package com.kce.service;

public class Admin_Exception extends Exception {
	public Admin_Exception(String Email) {
		if (!(Email.equalsIgnoreCase("admin@kce.ac.in"))) {
			System.out.println(
					"------- ------ ------ ------ --------\n\tEnter correct Admin Email\n\tAccess Denied.\n-------------------X------------------");
			System.exit(0);
		}
	}
}
