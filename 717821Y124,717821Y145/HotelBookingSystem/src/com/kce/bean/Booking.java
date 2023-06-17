package com.kce.bean;

import java.util.Date;

public class Booking {
    private int id;
    private Date checkInDate;
    private Date checkOutDate;
    private Customer customer;
    private Room room;

    public Booking(Date checkInDate, Date checkOutDate, Customer customer, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customer = customer;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
