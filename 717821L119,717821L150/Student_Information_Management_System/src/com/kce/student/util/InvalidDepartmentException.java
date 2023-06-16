package com.kce.student.util;

public class InvalidDepartmentException extends Exception //User defined exception
{
	public InvalidDepartmentException(String s)
	{
		super(s);
	}
}