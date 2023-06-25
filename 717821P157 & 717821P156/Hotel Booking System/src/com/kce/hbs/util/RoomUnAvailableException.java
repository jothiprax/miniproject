package com.kce.hbs.util;

public class RoomUnAvailableException extends Exception {
    @Override
    public String toString() {
        return "Room not Available! Chose another Room...";
    }
}
