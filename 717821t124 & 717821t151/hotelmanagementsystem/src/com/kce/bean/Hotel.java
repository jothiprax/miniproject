package com.kce.bean;

public class Hotel {
    private String name;
    private int roomNo;
    private double price;

    public Hotel() {
    }

    public Hotel(String name, int roomNo, double price) {
        this.name = name;
        this.roomNo = roomNo;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
