package com.kce.hotel.util;
public class OverbookingException extends Exception {
	private static final long serialVersionUID = 1L;
	public OverbookingException(String message){
        super(message);
    }
}
