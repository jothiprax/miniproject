package COLAB;
public class Flight {
	private int flightNo;
	private String flightName;
	private int capacity;
	
	Flight(int no,boolean ac,int cap){
		this.flightNo = no;
		this.flightName = flightName;
		this.capacity = cap;
	}
	
	public int getBusNo(){
		return flightNo;
	}
	
	public String getFlightName(){
		return flightName;
	}
	public int getCapacity(){
		return capacity;
	}
	
	public void setflightName(String val) {
		flightName = val;
	}
	
	public void setCapacity(int cap) {
		capacity = cap;
	}
}
