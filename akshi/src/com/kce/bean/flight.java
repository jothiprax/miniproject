package com.kce.bean;


public class flight {

	

  private int flightid;

     private String airline;

     private String origin;

     private String destination;

     private int departuretime;

     private int arrivaltime;

     private int duration;

     private int capacity;

     private int availableseats;

     private double fare;

     

     public flight() {

      

     }

     public flight(int flightid,String airline,String origin,String destination, int departuretime, int arrivaltime, int duration, int capacity,int availableseats, double fare)

     {

      this.flightid=flightid;

      this.airline=airline;

      this.origin=origin;

      this.destination=destination;

      this.departuretime=departuretime;

      this.arrivaltime=arrivaltime;

      this.duration=duration;

      this.capacity=capacity;

      this.availableseats=availableseats;

      this.fare=fare;

     }

     public int getFlightid() {

      return flightid;

     }

     public void setFlightid(int flightid) {

      this.flightid=flightid;

     }

     public String getAirline() {

      return airline;

     }

     public void setAirline(String airline) {

      this.airline=airline;

     }

     public String getOrigin(){

      return origin;

     }

     public void setOrigin(String origin){

      this.origin=origin;

     }

     public String getDestination(){

      return destination;

     }

     public void setDestination(String destination){

      this.destination=destination;

     }

     public int getDeparturetime(){

      return departuretime;

     }

     public void setDeparturetime(int departuretime){

      this.departuretime=departuretime;

     }

     public int getArrivaltime(){

      return arrivaltime;

     }

     public void setArrivaltime(int arrivaltime){

      this.arrivaltime=arrivaltime;

     }

     public int getDuration(){

      return duration;

     }

     public void setDuration(int duration){

      this.duration=duration;

     }

     public int getCapacity(){

      return capacity;

     }

     public void setCapacity(int capacity){

      this.capacity=capacity;

     }

     public int getAvailableseats(){

      return availableseats;

     }

     public void setAvailableseats(int availableseats){

      this.availableseats=availableseats;

     }

     public Double getFare(){

      return fare;

     }

     public void setFare(double fare){

      this.fare=fare;

     }

}
