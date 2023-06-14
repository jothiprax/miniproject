package com.kce.e_bus_fare_payment.util;


public class InvalidAccountNumber extends Exception{

	private static final long serialVersionUID = -32467554532380989L;

	//Valid Account number contains 10 digits
	public InvalidAccountNumber() {
		super("Invalid Account Number.Enter valid Account Number");
	}
	
}
