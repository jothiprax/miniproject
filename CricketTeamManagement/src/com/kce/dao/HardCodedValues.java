package com.kce.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.util.DBConnection;


public class HardCodedValues {
	//Creating Connection variable statically.
	static Connection con=DBConnection.getConnection();
	
	public static void hardCodedvalues() {
		try {
		//Statement variable is created and they has been batched together and the executed
		Statement stmt=con.createStatement();
		
		//these 3 lines of code is used to create the three tables
		stmt.addBatch("create table schedules (Match_No int,OurTeam varchar(20),Opponent varchar(20),Venue varchar(20),Match_Date Date,Match_Time varchar(10),primary key(Match_No))");
		stmt.addBatch("create table Player(Team_Name varchar(20),Player_Name varchar(30),Jersey_No int,Player_Role varchar(15),Match_No int,primary key(Jersey_No,Team_Name),foreign key(Match_No)references schedules(Match_No))");
		stmt.addBatch("create table score(Match_No int,Jersey_No int,Runs int,Wickets int,Team_Name varchar (20),primary key(Jersey_No,Team_Name),foreign key(Match_No)references schedules(Match_No))");
		
		//these 3 lines are used to insert values in the "SCHEDULE TABLE" only these 3 matches are allowed
		stmt.addBatch("insert into schedules(Match_No,OurTeam,Opponent,Venue,Match_Date,Match_Time)values(1,'India','Austrila','Chennai','2022-09-20','3:00pm')");
		stmt.addBatch("insert into schedules(Match_No,OurTeam,Opponent,Venue,Match_Date,Match_Time)values(2,'India','Austrila','Mumbai','2022-09-22','3:00pm')");
		stmt.addBatch("insert into schedules(Match_No,OurTeam,Opponent,Venue,Match_Date,Match_Time)values(3,'India','Austrila','Kolkata','2022-09-25','3:00pm')");
		
		stmt.executeBatch(); //executing the above queries
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
