package com.service;

public class TicketDetails {
	private String ticket_id;
	private String name;
	private String movieName;
	private String theatreName;
	private String ticketClass;
	private String time;
	private String gender;
	private String phoneNumber;
	private String ticketFare;
	public TicketDetails(String ticket_id, String name, String movieName, String theatreName, String ticketClass,
			String time, String gender, String phoneNumber, String ticketFare) {
		super();
		this.ticket_id = ticket_id;
		this.name = name;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.ticketClass = ticketClass;
		this.time = time;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.ticketFare = ticketFare;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(String ticketFare) {
		this.ticketFare = ticketFare;
	}
}
