package com.kce.bean;

public class WicketKeeper extends Batsman{
	
	/*Constructor which refers to its super class for this alone refers to batsman and  for batsman it is
	 player so it uses multilevel inheritance */
	
	public WicketKeeper(int matchNo,String playerRole,String teamName, String playerName, int jerseyNo, int Runs) {
		super(matchNo,playerRole,teamName, playerName, jerseyNo, Runs);
	}

	@Override		//this is passed to the insert method in InsertValues Class
	public String toString() {
		return getMatchNo()+","+ getPlayerRole() +","+ getRuns() + "," + getTeamName() + ","+ getPlayerName() + "," + getJerseyNo();
	}
	
}

