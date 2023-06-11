package com.kce.util;

public class MatchNotFoundException extends Exception {
	public MatchNotFoundException(){
		super("Invalid Match Number");	//Passes the string to the constructor of the EXCEPTION CLASS
	}
	private static final long serialVersionUID = 1L;
}

