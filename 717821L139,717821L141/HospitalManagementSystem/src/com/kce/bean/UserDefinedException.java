package com.kce.bean;

public class UserDefinedException extends Exception{
	private int errorCode;

    public UserDefinedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}


