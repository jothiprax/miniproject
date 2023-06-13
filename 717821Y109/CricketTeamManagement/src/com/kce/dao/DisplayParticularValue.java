package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

import com.kce.util.DBConnection;


public class DisplayParticularValue extends DisplayParticular {
	//Creating Connection variable statically.
	static Connection con=DBConnection.getConnection();
	
	//method 1-to get all details about the player using jersey number.
	public void getValues(int jersey) {
		try {
			Formatter fmt=new Formatter();
			fmt.format("%5s %15s %12s %7s %10s %12s %13s\n","Match_No","PlayerName","JerseyNo","Runs","Wickets","TeamName","Opponent");
			PreparedStatement stmt=con.prepareStatement("select distinct player.Match_No,player.Player_Name,score.Runs,score.Wickets,player.Team_Name,schedules.Opponent  from player inner join score on player.Jersey_No=score.Jersey_No inner join schedules on schedules.Match_No=player.Match_No where player.Jersey_No=?");
			stmt.setInt(1,jersey );
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				fmt.format("%5s %15s %12s %8s %10s %12s %15s\n",rs.getInt(1),rs.getString(2),jersey,rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));}
			System.out.println(fmt);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 2-to get the total runs scored by a player in the series 
	public void getTotalRuns(int jersey) {
		try {
			PreparedStatement stmt=con.prepareStatement("select sum(runs) from score where jersey_no=?");
			stmt.setInt(1, jersey);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
		System.out.println("Total runs scored by jersey_no "+jersey+" is "+rs.getInt(1));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 3-to get the total wickets taken by the player in the series
	public void getTotalWickets(int jersey) {
		try {
			PreparedStatement stmt=con.prepareStatement("select sum(wickets) from score where jersey_no=?");
			stmt.setInt(1, jersey);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
				System.out.println("Total wickets by jersey_no "+jersey+" is "+rs.getInt(1));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 4-to get the runs scored by a player in particular match
	public void getRunsfromMatch(int jersey,int match) {
		try {
			PreparedStatement stmt=con.prepareStatement("select runs from score where jersey_no=? and Match_No=?");
			stmt.setInt(1, jersey);
			stmt.setInt(2, match);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
				System.out.println("Total runs scored by jersey_no "+jersey+" in match "+match+" is "+rs.getInt(1));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 5-to get the wickets taken by a player in a particular match
	public void getWicketsfromMatch(int jersey,int match) {
		try {
			PreparedStatement stmt=con.prepareStatement("select wickets from score where jersey_no=? and Match_No=?");
			stmt.setInt(1, jersey);
			stmt.setInt(2, match);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
				System.out.println("Total Wickets taken by jersey_no "+jersey+" in match "+match+" is "+rs.getInt(1));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 6-to display all details about a particular match
	public void displayMatchDetails(int matchNo) {
		try {
			PreparedStatement stmt=con.prepareStatement("select * from schedules where Match_No=?");
			stmt.setInt(1, matchNo);
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %15s %15s %15s %15s %15s\n","MatchNo","OurTeam","Opponent","Venue","MatchDate","MatchTime");
			while(rs.next()) {
				
				fmt.format("%5s %17s %16s %15s %15s %14s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6));
			}
			System.out.println(fmt);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 7-to display the score values of a particular player in a particular match
	public void getPlayerScoreinMatch(int jetsey,int matchno) {
		try {
			PreparedStatement stmt=con.prepareStatement("select * from score where jersey_no=? and match_no=?");
			stmt.setInt(1, jetsey);
			stmt.setInt(2, matchno);
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %5s %5s %5s %5s\n","MatchNo","JerseyNo","Runs","Wickets","TeamName");
			while(rs.next()) {
				
				fmt.format("%5s %10s %5s %7s %7s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			System.out.println(fmt);		
		    }
		catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	//method 8-to display the total score board of the match
		public void getScoreBoardOfAMatch(int match) {
			try {
				PreparedStatement stmt=con.prepareStatement("Select distinct player.player_name,score.* from score inner join player on player.jersey_no=score.jersey_no where score.match_no=?");
				stmt.setInt(1, match);
				Formatter fmt=new Formatter();
				fmt.format("%5s  %5s %5s %5s\n","PlayerName","Jersey No","Runs","Wicket","TeamName");
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					fmt.format("%5s %15s %5s %5s\n",rs.getString(1),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
				}
				System.out.println(fmt);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	//method 9-to display the player with highest   score
	public void getBestBattingPlayer() {
		try {
			PreparedStatement stmt=con.prepareStatement("select * from score where runs=(select max(runs) from score) order by Match_No desc limit 1;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %5s %5s  %5s\n","MatchNo","JerseyNo","Runs","TeamName");
			while(rs.next()) {
				
				fmt.format("%5s %7s %10s  %5s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5));
			}
			System.out.println(fmt);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 10-to display the with best bowling figure in an innings
	public void getBestBowlingPlayer() {
		try {
			PreparedStatement stmt=con.prepareStatement("select * from score where wickets=(select max(wickets) from score) order by Match_No desc limit 1;");
			ResultSet rs=stmt.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%5s %5s %5s \n","MatchNo","JerseyNo","Wickets","TeamName");
			while(rs.next()) {
				
				fmt.format("%5s %7s %10s \n",rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getString(5));
			}
			System.out.println(fmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 11-to display the best batter in the series
	public void getHighestScorePlayer() {
		try {
			PreparedStatement stmt1=con.prepareStatement(" select Jersey_No,sum(runs) from score group by Jersey_No order by sum(runs);");
			ResultSet rs1=stmt1.executeQuery();
			int jerseyno = 0,runs=0;
			while(rs1.next()) {
		    jerseyno=rs1.getInt(1);
			runs=rs1.getInt(2);}
			PreparedStatement stmt2=con.prepareStatement("select  player_name from player where jersey_no=? limit 1");
			stmt2.setInt(1, jerseyno);
			ResultSet rs2=stmt2.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%10s %15s\n","PlayerName","TotalRuns");
			while(rs2.next())
			fmt.format("%10s %15s\n",rs2.getString(1), runs);
			System.out.println(fmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method 12-to display the best bowler in the series
	public void getHighestWicketTaker() {
		try {
			PreparedStatement stmt1=con.prepareStatement(" select Jersey_No,sum(wickets) from score group by Jersey_No order by sum(wickets);");
			ResultSet rs1=stmt1.executeQuery();
			int jerseyno = 0,wickets=0;
			while(rs1.next()) {
		    jerseyno=rs1.getInt(1);
			wickets=rs1.getInt(2);}
			PreparedStatement stmt2=con.prepareStatement("select  player_name from player where jersey_no=? limit 1");
			stmt2.setInt(1, jerseyno);
			ResultSet rs2=stmt2.executeQuery();
			Formatter fmt=new Formatter();
			fmt.format("%10s %15s\n","PlayerName","TotalWickets");
			while(rs2.next())
			fmt.format("%10s %15s\n",rs2.getString(1), wickets);
			System.out.println(fmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}

