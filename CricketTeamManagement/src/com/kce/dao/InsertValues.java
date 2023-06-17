package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.util.DBConnection;


public class InsertValues {
	
	//method that inserts values in the database in the score table and player table
	public static void insertValues(String str) {
		String arr[]=str.split(",");	//Splitting the passed values and store in the respected variables
		
		int runs=0,wickets=0;
		
		String role=arr[1];
		
		if(role.equalsIgnoreCase("Batsman")||role.equalsIgnoreCase("Wicketkeeper")) {
			runs=Integer.parseInt(arr[2]);
		}
		else if(role.equalsIgnoreCase("Bowler")) {
			wickets=Integer.parseInt(arr[2]);
		}
		else if(role.equalsIgnoreCase("AllRounder")) {
			runs=Integer.parseInt(arr[2]);
			wickets=Integer.parseInt(arr[6]);
		}
		
		int matchNo=Integer.parseInt(arr[0]);
		String teamName=arr[3];
		String playerName=arr[4];
		int jerseyNo=Integer.parseInt(arr[5]);
		
		try {
			Connection con=DBConnection.getConnection();
			
			PreparedStatement stmtPlayer=con.prepareStatement("insert into player(Team_Name,Player_Name,Jersey_No,Player_Role,Match_No)values(?,?,?,?,?)");
			stmtPlayer.setString(1,teamName);
			stmtPlayer.setString(2, playerName);
			stmtPlayer.setInt(3, jerseyNo);
			stmtPlayer.setString(4,role);
			stmtPlayer.setInt(5, matchNo);
			stmtPlayer.executeUpdate();
			
			PreparedStatement stmtScore=con.prepareStatement("insert into score(Match_No,Jersey_No,Runs,Wickets,Team_Name)values(?,?,?,?,?)");
			stmtScore.setInt(1, matchNo);
			stmtScore.setInt(2, jerseyNo);
			stmtScore.setInt(3, runs);
			stmtScore.setInt(4, wickets);
			stmtScore.setString(5,teamName);
			stmtScore.executeUpdate();
			
			System.out.println("Values has been inserted into record successfully.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

