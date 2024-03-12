package com.kce.bank.util;

public class UserException extends Exception{
	String Exception;
	public UserException(String a) {
		Exception = a;
	}
	public String toString() {
		return Exception;
	}

}
