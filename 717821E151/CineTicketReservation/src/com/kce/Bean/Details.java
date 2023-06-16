package com.kce.Bean;

public class Details {
	private int seat;
	private String movie;
	private String type;
	private int rate;
	
	
	public Details(int seat, String movie, String type) {
		super();
		this.seat = seat;
		this.movie = movie;
		this.type = type;
		
		
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getRate() {
		if(type.equals("1st")) {
			return this.rate=seat*450;}
				else if(type.equals("2nd")) {
					return this.rate=seat*300;}
				else{
					return this.rate=seat*250;}
		
	}

	

}
