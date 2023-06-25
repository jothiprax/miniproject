package com.kce.bean;

public class Ticket {
    private int ticketNumber;
    private String passengerName;
    private int trainNumber;
    private String journeyDate;

    public Ticket(int ticketNumber, String passengerName, int trainNumber, String journeyDate) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.journeyDate = journeyDate;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    @Override
    public String toString() {
        return "Ticket Number: " + ticketNumber +
                "\nPassenger Name: " + passengerName +
                "\nTrain Number: " + trainNumber +
                "\nJourney Date: " + journeyDate;
    }
}
