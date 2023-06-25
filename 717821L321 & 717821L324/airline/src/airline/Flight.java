package airline;
import java.util.*;
public class Flight {
	    private String flightNumber;
	    private String originCity;
	    private String destinationCity;
	    private int capacity;

	    public String getFlightNumber() {
	        return flightNumber;
	    }

	    public void setFlightNumber(String flightNumber) {
	        this.flightNumber = flightNumber;
	    }

	    public String getOriginCity() {
	        return originCity;
	    }

	    public void setOriginCity(String originCity) {
	        this.originCity = originCity;
	    }

	    public String getDestinationCity() {
	        return destinationCity;
	    }

	    public void setDestinationCity(String destinationCity) {
	        this.destinationCity = destinationCity;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }

	    @Override
	    public String toString() {
	        return "Flight Number: " + flightNumber +
	                "\nOrigin: " + originCity +
	                "\nDestination: " + destinationCity +
	                "\nTotal capacity: " + capacity;
	    }
	}

