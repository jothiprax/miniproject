package Service;
import Bean.*;
import Util.*;
import java.sql.*;
import java.util.ArrayList;

//Service class for data validation
public class EventService {
 public static boolean validateEvent(Event event) {
     // Perform data validations
     if (event.getEventName() == null || event.getEventName().isEmpty()) {
         System.out.println("Invalid event name.");
         return false;
     }

     if (event.getEventDate() == null || event.getEventDate().isEmpty()) {
         System.out.println("Invalid event date.");
         return false;
     }

     if (event.getEventTime() == null || event.getEventTime().isEmpty()) {
         System.out.println("Invalid event time.");
         return false;
     }

     return true;
 }
}