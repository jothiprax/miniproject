package com.kce.service;

public class CheckingException extends Exception{
public CheckingException(String s)
{
	super(s);
	System.out.println("Enter the details of employee");
}
}
