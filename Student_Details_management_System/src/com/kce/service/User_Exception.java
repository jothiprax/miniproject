package com.kce.service;

public class User_Exception extends Exception {

	public User_Exception(String role) {
		if (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Admin"))) {
			System.out.println(
					"------- ------ ------ ------ --------\n\tEnter correct Role\n\tAccess Denied.\n-------------------X------------------");
			System.exit(0);
		}
	}
}
