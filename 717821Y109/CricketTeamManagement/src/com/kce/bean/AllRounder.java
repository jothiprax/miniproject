package com.kce.bean;

public class AllRounder extends Player{
	//contains special variables runs and wickets
	private int runs;
	private int wickets;
	
	//Constructor which refers to its super class
	public AllRounder(int matchNo,String playerRole,String teamName, String playerName, int jerseyNo, int runs, int wickets) {
		super(matchNo,playerRole,teamName, playerName, jerseyNo);
		this.runs = runs;
		this.wickets = wickets;
	}
	
	//Getters and Setters
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	@Override //this is passed to the insert method in InsertValues Class
	public String toString() {
		return getMatchNo()+","+getPlayerRole()+","+getRuns() +","+ getTeamName() + "," + getPlayerName() + "," + getJerseyNo()+","+ getWickets();
	}
	
}
