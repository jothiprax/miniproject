package com.kce.bean;
public class Batsman extends Player {
	//contains special variables runs to calculate runs
	private int Runs;
	
	//Constructor which refers to its super class
	public Batsman(int matchNo,String playerRole,String teamName, String playerName, int jerseyNo,int Runs) {
		super(matchNo,playerRole,teamName, playerName, jerseyNo);
		this.Runs=Runs;
	}
	
	//Getters and Setters to get runs and save it
	public int getRuns() {
		return Runs;
	}
	public void setRuns(int runs) {
		Runs = runs;
	}
	
	@Override //this is passed to the insert method in InsertValues Class
	public String toString() {
		return  getMatchNo()+","+getPlayerRole()+","+ getRuns() + "," + getTeamName() + ","+ getPlayerName() + "," + getJerseyNo();
	}
}

