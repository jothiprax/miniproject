package com.kce.util;

public class RoomsUnavailableException extends Exception {
	public RoomsUnavailableException(){
		super("Rooms Unavailable\nOnly 5 rooms can be booked by customer.");	
	}
}

