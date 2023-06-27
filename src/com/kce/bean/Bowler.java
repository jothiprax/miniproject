package com.kce.bean;

public class Bowler extends Player{
	//contains special variables wickets because bowler hould take wickets
	private int wickets;
	
	//Constructor which refers to its super class
	public Bowler(int matchNo,String playerRole,String teamName, String playerName, int jerseyNo,int wickets) {
		super(matchNo,playerRole,teamName, playerName, jerseyNo);
		this.wickets=wickets;
	}
	
	//Getters and Setters
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	@Override	//this is passed to the insert method in InsertValues Class
	public String toString() {
		return  getMatchNo()+","+getPlayerRole()+","+getWickets() + ","+ getTeamName() + ","+ getPlayerName() + "," + getJerseyNo();
	}
	
}