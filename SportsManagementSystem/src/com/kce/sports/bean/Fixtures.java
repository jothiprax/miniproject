package com.kce.sports.bean;

public class Fixtures {
	private String match;
	private String date;
	private String time;
	private String venue;
	private String score;
	private String result;
	public Fixtures(String match,String date,String time,String venue,String score,String result) {
		this.match = match;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.score = score;
		this.result = result;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String setTime() {
		return time;
	}
	public void getTime(String time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "matchFixtures [Match = "+match+", Date = "+date+", Time = "+time+", Venue = "+venue+", Score = "+score+", Result = "+result+"]";
	}
	public void matchFixtures() {
		System.out.println(toString());
	}
}
