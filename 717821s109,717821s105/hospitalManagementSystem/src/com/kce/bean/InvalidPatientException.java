package com.kce.bean;

public class InvalidPatientException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;

    public InvalidPatientException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
