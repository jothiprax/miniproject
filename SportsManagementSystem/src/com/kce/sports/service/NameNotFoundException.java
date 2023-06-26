package com.kce.sports.service;

public class NameNotFoundException extends Exception{
	public NameNotFoundException(String pname) {
		super(pname);
		System.out.println("Enter the names for all");
	}
}
