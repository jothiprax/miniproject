package Bean;

import Util.OverBookingException;
public class Conference extends Event {
    private int maxAttendees;
    private int registeredAttendees;

    public Conference(int eventId, String eventName, String eventDate, String eventTime, int maxAttendees) {
        super(eventId, eventName, eventDate, eventTime);
        this.maxAttendees = maxAttendees;
        this.registeredAttendees = 0;
    }

    // Getters and setters
    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public int getRegisteredAttendees() {
        return registeredAttendees;
    }

    public void setRegisteredAttendees(int registeredAttendees) {
        this.registeredAttendees = registeredAttendees;
    }

    public void incrementRegisteredAttendees() {
        registeredAttendees++;
    }

    public void decrementRegisteredAttendees() {
        registeredAttendees--;
    }

    // User-defined exception: OverbookingException
    public void registerAttendee() throws OverBookingException {
        if (registeredAttendees < maxAttendees) {
            incrementRegisteredAttendees();
            System.out.println("Attendee successfully registered!");
        } else {
            throw new OverBookingException("Event is already full. Cannot register more attendees.");
        }
    }

    public void displayConferenceDetails() {
        displayEventDetails();
        System.out.println("Max Attendees: " + maxAttendees);
        System.out.println("Registered Attendees: " + registeredAttendees);
    }
}


