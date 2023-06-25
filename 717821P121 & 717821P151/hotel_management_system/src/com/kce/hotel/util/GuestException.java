package com.kce.hotel.util;

public class GuestException extends Exception{
public String toString(){
    return "The Guest Id is unavailable! \n Please enter another Id.";
}
}
