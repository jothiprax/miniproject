package com.kce.bean;

public class Localbus extends Bus {
	private String mainBusStand;
	public Localbus()
    {
  	  
    }
    
    public Localbus(String busName,String busNumber,double depTiming,double arrTiming,String route,String startingPlace,String endingPlace,String mainBusStand)
    {
  	  super(busName,busNumber,depTiming,arrTiming,route,startingPlace,endingPlace);
  	  this.mainBusStand=mainBusStand;
  	  
    }
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public double getDepTiming() {
		return depTiming;
	}
	public void setDepTiming(double depTiming) {
		this.depTiming = depTiming;
	}
	public double getArrTiming() {
		return arrTiming;
	}
	public void setArrTiming(double arrTiming) {
		this.arrTiming = arrTiming;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getStartingPlace() {
		return startingPlace;
	}
	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}
	public String getEndingPlace() {
		return endingPlace;
	}
	public void setEndingPlace(String endingPlace) {
		this.endingPlace = endingPlace;
	}

	public String getMainBusStand() {
		return mainBusStand;
	}

	public void setMainBusStand(String mainBusStand) {
		this.mainBusStand = mainBusStand;
	}
    
}
