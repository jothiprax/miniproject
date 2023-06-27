package Util;

import Bean.*;
import Service.*;

// User-defined exception: OverbookingException
public class OverBookingException extends Exception {
    public OverBookingException(String message) {
        super(message);
    }
}
