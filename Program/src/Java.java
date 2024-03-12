
class Java {
    protected String eventName;
    protected Date eventDate;
    protected int capacity;
    protected int attendance;

    public Event(String eventName, Date eventDate, int capacity) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.capacity = capacity;
        this.attendance = 0;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Capacity: " + capacity);
        System.out.println("Attendance: " + attendance);
    }
}

// MovieEvent class extending Event
class MovieEvent extends Event {
    private String movieName;
    private int duration;

    public MovieEvent(String eventName, Date eventDate, int capacity, String movieName, int duration) {
        super(eventName, eventDate, capacity);
        this.movieName = movieName;
        this.duration = duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Movie Name: " + movieName);
        System.out.println("Duration: " + duration + " minutes");
    }
}

// Custom exception for overbooking
class OverbookingException extends Exception {
    public OverbookingException(String message) {
        super(message);
    }
}

// Event Manager class
class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Event List:");
            for (Event event : events) {
                event.displayEventDetails();
                System.out.println("--------------------");
            }
        }
    }

    public Event findEvent(String eventName) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event;
            }
        }
        return null;
    }

    public void updateEventAttendance(String eventName, int newAttendance) throws OverbookingException {
        Event event = findEvent(eventName);
        if (event == null) {
            System.out.println("Event not found.");
        } else {
            int currentAttendance = event.getAttendance();
            int availableCapacity = event.getCapacity() - currentAttendance;
            if (newAttendance > availableCapacity) {
                throw new OverbookingException("Overbooking not allowed. Available capacity: " + availableCapacity);
            }
            event.setAttendance(newAttendance);
            System.out.println("Attendance updated successfully.");
        }
    }

    public void deleteEvent(String eventName) {
        Event event = findEvent(eventName);
        if (event == null) {
            System.out.println("Event not found.");
        } else {
            events.remove(event);
            System.out.println("Event deleted successfully.");
        }
    }
}

// Main class
public class MovieRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();

        while (true) {
            System.out.println("1. Add Event");
            System.out.println("2. Display All Events");
            System.out.println("3. Update Event Attendance");
            System.out.println("4. Delete Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (yyyy-MM-dd): ");
                    String eventDateStr = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Duration (in minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Date eventDate;
                    try {
                        eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(eventDateStr);
                        Event movieEvent = new MovieEvent(eventName, eventDate, capacity, movieName, duration);
                        eventManager.addEvent(movieEvent);
                        System.out.println("Event added successfully.");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Event not added.");
                    }
                    break;

                case 2:
                    eventManager.displayAllEvents();
                    break;

                case 3:
                    System.out.print("Enter Event Name: ");
                    String eventNameToUpdate = scanner.nextLine();
                    System.out.print("Enter New Attendance: ");
                    int newAttendance = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    try {
                        eventManager.updateEventAttendance(eventNameToUpdate, newAttendance);
                    } catch (OverbookingException e) {
                        System.out.println("OverbookingException: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Event Name: ");
                    String eventNameToDelete = scanner.nextLine();
                    eventManager.deleteEvent(eventNameToDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}

