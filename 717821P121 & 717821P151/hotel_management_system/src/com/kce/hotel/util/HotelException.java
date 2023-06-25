package com.kce.hotel.util;

public class HotelException extends Exception{
    public String toString(){
        return "The Hotel Id is unavailable! \n Please enter another Id.";
    }
}
