package com.kce.util;

// User defined Exception Class
public class InvalidExpenseException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidExpenseException(String message) {
        super(message);
    }
}
