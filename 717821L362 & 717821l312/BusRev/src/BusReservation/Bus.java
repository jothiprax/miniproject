package BusReservation;

public class Bus {
	private int busno;
	private boolean ac;
	private int capacity;

	Bus(int no,boolean ac,int cap){
	this.busno=no;
	this.ac=ac;
	this.capacity=cap;
	}

	public int getbusno() {
		return busno;
	}
	public boolean getAc() {
		return ac;
	}
	
	public int getCapacity(){
	return capacity;
	}
	public void setCapacity(int cap){
	capacity=cap;
	}
	public void setAc(boolean val) {
		ac=val;
	}
	
	
}
