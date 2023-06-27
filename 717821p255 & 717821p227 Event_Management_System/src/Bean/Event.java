package Bean;
import Service.*;
import Util.*;
import java.sql.*;
import java.util.ArrayList;

// Entity/Model classes
public class Event {
    protected int eventId;
    protected String eventName;
    protected String eventDate;
    protected String eventTime;

    public Event(int eventId, String eventName, String eventDate, String eventTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    // Getters and setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Time: " + eventTime);
    }
}

