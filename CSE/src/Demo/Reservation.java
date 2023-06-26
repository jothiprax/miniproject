package Demo;

public class Reservation {
	private int reservationNumber;
    private Flight flight;
    private Passenger passenger;

    public Reservation(int reservationNumber, Flight flight, Passenger passenger) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.passenger = passenger;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
