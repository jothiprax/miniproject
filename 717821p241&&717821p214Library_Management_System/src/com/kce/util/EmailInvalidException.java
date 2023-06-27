package com.kce.util;

public class EmailInvalidException extends Exception{
	public String toString() {
		return "Not a valid email or use official college email id\n Process Redirection to home page";
	}

}
