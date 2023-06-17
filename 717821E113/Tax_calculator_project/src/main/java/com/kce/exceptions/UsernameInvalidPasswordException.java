package com.kce.exceptions;

public class UsernameInvalidPasswordException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public UsernameInvalidPasswordException(String message) {
		super(message);
		
	}
	
}
