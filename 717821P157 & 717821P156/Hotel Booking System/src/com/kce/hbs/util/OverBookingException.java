package com.kce.hbs.util;

public class OverBookingException extends Exception {

    @Override
    public String toString() {
        return "Sorry! All rooms are Booked";
    }
}
