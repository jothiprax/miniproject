package airline;

public class Reservation extends Flight {
	    private String reservationId;
	    private Flight flight;
	    private Passenger passenger;
	    private String seatNumber;
	    private int totalSeats;
	    private int currentpassengerCount;

	    public String getReservationId() {
	        return reservationId;
	    }

	    public void setReservationId(String reservationId) {
	        this.reservationId = reservationId;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public void setFlight(Flight flight) {
	        this.flight = flight;
	    }

	    public Passenger getPassenger() {
	        return passenger;
	    }

	    public void setPassenger(Passenger passenger) {
	        this.passenger = passenger;
	    }

	    public String getSeatNumber() {
	        return seatNumber;
	    }

	    public void setSeatNumber(String seatNumber) {
	        this.seatNumber = seatNumber;
	    }
	    public int getTotalSeats() {
	        return totalSeats;
	    }

	    public void setTotalSeats(int totalSeats) {
	        this.totalSeats= totalSeats;
	    }

	    public int getCurrentPassengerCount() {
	        return currentpassengerCount;
	    }

	    public void setCurrentPassengerCount(int currentpassengerCount) {
	        this.currentpassengerCount = currentpassengerCount;
	    }

	    @Override
	    public String toString() {
	        return "Reservation ID: " + reservationId +"\nFlight: " + flight.getFlightNumber() + "\nPassenger: " + passenger.getName() +"\nSeat Number: " + seatNumber+"\ntotalreservedSeats:"+totalSeats+"\ncurrentpassengerCount:"+currentpassengerCount;
	    }
	}

