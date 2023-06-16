package com.kce.bookings;
public class bookings {
	static String username;
	static String name;
	static int no_of_persons;
	static String date;
	static String time;
	static String moviename;
	public bookings(String username, String name, int no_of_persons, String date, String time, String moviename) {
		super();
		this.username = username;
		this.name = name;
		this.no_of_persons = no_of_persons;
		this.date = date;
		this.time = time;
		this.moviename = moviename;
	}
	public static String getUsername() {
		return username;
	}
	public static String getName() {
		return name;
	}
	public static int getNo_of_persons() {
		return no_of_persons;
	}
	public static String getDate() {
		return date;
	}
	public static String getTime() {
		return time;
	}
	public static String getMoviename() {
		return moviename;
	}
}
