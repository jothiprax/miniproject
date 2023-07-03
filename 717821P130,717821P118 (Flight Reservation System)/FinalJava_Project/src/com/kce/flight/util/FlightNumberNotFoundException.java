package com.kce.flight.util;

@SuppressWarnings("serial")
public class FlightNumberNotFoundException extends Exception {
	public FlightNumberNotFoundException(String msg) {
		super(msg);
	}

	public String toString() {
		return "FlightNumberNotFoundException";
	}
}
