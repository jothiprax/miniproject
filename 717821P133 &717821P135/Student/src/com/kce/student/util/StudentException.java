package com.kce.student.util;

public class StudentException extends Exception{

	public StudentException(String message) {
		super(message);
	}
	public String toString() {
		return "StudentException :"+getMessage();
	}
    
}
