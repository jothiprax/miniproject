package com.kce.bean;


public class Player {
	
	//Declaring the private variables to achieve encapsulation
	private int matchNo;
	private String playerRole;
	private String teamName;
	private String playerName;
	private int jerseyNo;
	
	//Constructors that contains the values to be passed
	public Player(int matchNo,String playerRole,String teamName, String playerName, int jerseyNo) {
		this.matchNo=matchNo;
		this.playerRole=playerRole;
		this.teamName = teamName;
		this.playerName = playerName;
		this.jerseyNo = jerseyNo;
	}
	
	//Getter and Setter
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getJerseyNo() {
		return jerseyNo;
	}
	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}
	public String getPlayerRole() {
		return playerRole;
	}
	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}
	public int getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}

}


