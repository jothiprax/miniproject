
package Service;
import Bean.*;
import Dao.EventManager;
import Util.*;
import java.sql.*;
import java.util.ArrayList;
// Main class
public class Main {
    public static void main(String[] args) {
        // CRUD Operations: Creating, Reading, Updating, Deleting events
        EventManager eventManager = new EventManager();

        Conference conference1 = new Conference(1, "Tech Conference", "2023-07-15", "10:00 AM", 100);
        if (EventService.validateEvent(conference1)) {
            eventManager.createEvent(conference1);
        }

        Event event = eventManager.readEvent(1);
        if (event != null) {
            event.displayEventDetails();
        } else {
            System.out.println("Event not found.");
        }

        conference1.setEventTime("11:00 AM");
        if (EventService.validateEvent(conference1)) {
            eventManager.updateEvent(conference1);
        }

        event = eventManager.readEvent(1);
        if (event != null) {
            event.displayEventDetails();
        } else {
            System.out.println("Event not found.");
        }

        eventManager.deleteEvent(1);
        event = eventManager.readEvent(1);
        if (event != null) {
            event.displayEventDetails();
        } else {
            System.out.println("Event not found.");
        }

        // Handling OverbookingException
        Conference conference2 = new Conference(2, "Business Conference", "2023-08-20", "2:00 PM", 50);
        try {
            conference2.registerAttendee();
            conference2.registerAttendee();
            conference2.registerAttendee();
        } catch (OverBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        conference2.displayConferenceDetails();
    }
}
