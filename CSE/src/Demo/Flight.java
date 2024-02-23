package Demo;

public class Flight {
	private int flightNumber;
    private String airline;
    private String source;
    private String destination;

    public Flight(int flightNumber, String airline, String source, String destination) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

