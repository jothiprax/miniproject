package com.kce.dao;

public abstract class DisplayParticular {
	
	abstract public  void getValues(int jersey);
	abstract public  void getTotalRuns(int jersey);
	abstract public  void getTotalWickets(int jersey) ;
	abstract public  void getRunsfromMatch(int jersey,int match);
	abstract public  void getWicketsfromMatch(int jersey,int match);
	abstract public  void displayMatchDetails(int matchNo);
	abstract public void getPlayerScoreinMatch(int jetsey,int matchno);
	abstract public void getScoreBoardOfAMatch(int match);
	abstract public void getBestBattingPlayer();
	abstract public void getBestBowlingPlayer();
	abstract public void getHighestScorePlayer();
	abstract public void getHighestWicketTaker();

}
