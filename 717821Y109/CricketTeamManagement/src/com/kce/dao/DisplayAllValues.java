package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

import com.kce.util.DBConnection;

public class DisplayAllValues implements DisplayAll {
	
	static Connection con=DBConnection.getConnection();
	
	// method 1-to display the schedule table
	public  void displayAllMatchDetails() {
		System.out.println("\t\t\t\t\t\t\tSchedule \n");
		try {
			PreparedStatement stmt=con.prepareStatement("select * from schedules;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %15s %15s %15s %15s %15s\n","MatchNo","OuTeam","Opponent","Venue","MatchDate","MatchTime");
			while(rs.next()) {
				
				fmt.format("%5s %17s %16s %16s %15s %13s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
}
	
	//method 2-to display the score table
	public  void displayAllScoreDetails() {
		System.out.println("\t\t\t\t\tScore Table\n");
		try {
			PreparedStatement stmt=con.prepareStatement("select * from score order by Match_No;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %5s %5s %5s %5s\n","MatchNo","JerseyNo","Runs","Wickets","TeamName");
			while(rs.next()) {
				
				fmt.format("%5s %7s %5s %5s %12s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
}
	
	//method 3-to display the Player table
	public  void displayAllPlayerDetails() {
		System.out.println("\t\t\t\t\tPlayer Table\n");
		try {
			PreparedStatement stmt=con.prepareStatement("select Match_No,Team_Name,Player_Name,Jersey_No,Player_Role from player order by Match_No;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %15s %20s %15s %15s \n","MatchNo","TeamName","PlayerName","JerseyNo","PlayerRole");
			while(rs.next()) {
				
				fmt.format("%5s %15s %20s %15s %15s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
			System.out.println(fmt);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			}
}

}

