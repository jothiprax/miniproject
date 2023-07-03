package com.kce.flight.util;

@SuppressWarnings("serial")
public class InSufficientAvailabilityException extends Exception{
public InSufficientAvailabilityException(String msg) {
	super(msg);
}
public String toString() {
	return "InSufficientSeats_Exceptions";
}
}
