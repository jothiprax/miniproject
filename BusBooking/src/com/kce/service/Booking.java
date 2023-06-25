package com.kce.service;

import com.kce.dao.BookingDao;
import com.kce.dao.BusDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
    public static String passengerName;
    public static int busNo;
    public static Date date;
    public Booking() throws ParseException
    {
        Scanner d= new Scanner(System .in);
        System .out.println("Enter the Passenger Name :    ");
        passengerName=d.nextLine();
        System.out.println("Enter the busNo :");
        busNo=d.nextInt();
        System .out.println("Enter the date  dd-mm-yyyy :");
        String dataInput=d.next();
        SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
        date=dateformat.parse(dataInput);


    }
    public boolean isAvailable() throws Exception
    {
        BusDao b1=new BusDao();
        int capacity=b1.getcapacity(busNo);
        BookingDao h= new BookingDao();
        int booked= h.getBookedCount(busNo,date);
        return  booked <capacity ;
    }

}
