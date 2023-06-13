package com.kce.service;

import java.util.Scanner;

import com.kce.bean.*;
import com.kce.dao.*;
import com.kce.util.*;

public class Display {
	
	static int matchno;
	static int jersey;
	static String team;
	static String name;
	
	static Scanner sc=new Scanner(System.in);
	static Player obj=null;
	
	public static void insertDisplay(){
		System.out.print("Enter the follwing Details to be Inserted:\n");
		System.out.print("Enter the Match Number:");
		matchno=Integer.parseInt(sc.next());
		Validate.validatematch(matchno);
		System.out.print("Enter the Player Role:");
		String role=sc.next();
		System.out.print("Enter the Team Name:");
		sc.nextLine();
		team=sc.nextLine();
		System.out.print("Enter the Player Name:");
		name=sc.nextLine();
		System.out.print("Enter the Jersey Number:");
		jersey=sc.nextInt();
		
			if(role.equalsIgnoreCase("Bowler")) {
				System.out.print("Enter the Wickets Taken:");
				int wickets=sc.nextInt();
			    obj=new Bowler(matchno, role, team, name, jersey, wickets);
				InsertValues.insertValues(obj.toString());
			}
			else if(role.equalsIgnoreCase("Batsman")) {
				System.out.print("Enter the Runs Scored:");
				int runs=sc.nextInt();
				obj=new Batsman(matchno,role,team,name,jersey,runs);
				InsertValues.insertValues(obj.toString());
			}
			else if(role.equalsIgnoreCase("WicketKeeper")) {
				System.out.print("Enter the Runs Scored:");
				int runs=sc.nextInt();
				obj=new WicketKeeper(matchno,role,team,name,jersey,runs);
				InsertValues.insertValues(obj.toString());
			}
			else if(role.equalsIgnoreCase("AllRounder")) {
				System.out.print("Enter the Runs Scored:");
				int runs=sc.nextInt();
				System.out.print("Enter the Wickets Taken:");
				int wickets=sc.nextInt();
				obj=new AllRounder(matchno,role,team,name,jersey,runs,wickets);
				InsertValues.insertValues(obj.toString());
			}
			else {
				System.out.println("Invalid Role\n");
			}
	}
	
	public static void valueDisplay() {
		
		System.out.println("\nSelect what you want to retrive:\n");
		System.out.println("1.To Display whole table");
		System.out.println("2.To Display particular value");
		System.out.print("\nEnter your choice:");
		int a=sc.nextInt();
		
		if(a==1) {
			DisplayAllValues object=new DisplayAllValues();
			System.out.println("Select the Table to be displayed:\n1.SCHEDULE\n2.PLAYER\n3.SCORE");
			System.out.print("\nEnter your choice:");
			int b=sc.nextInt();
			if(b==1)
		    object.displayAllMatchDetails();
			else if(b==2)
			object.displayAllPlayerDetails();
			else if(b==3)
			object.displayAllScoreDetails();
			else {
				System.out.println("Invalid choice");
			}
		}
		else if(a==2) {
			DisplayParticular object=new DisplayParticularValue();
			System.out.println("\nSelect what you want to Retrive:");
			System.out.print("1.Total Runs of a player in series\n2.Total Wickets taken by a player in series\n3."
					+ "Runs scored by player in a match\n4.Wickets taken by a player in a match\n5.Details of a particular Match"
					+ "\n6.All details of a particular player in all match\n7.All player details of a particular match\n8.All Details "
					+ "of a player in particular match\n9.Most Runs in series\n10.Most wickets in series\n11.Best Batting Performance"
					+ " \n12.Best Bowling Performance\n");
			System.out.print("\nEnter your choice:");
			int b=sc.nextInt();
			switch(b) {
			case 1:
				System.out.println("Enter the Jersey Number:");
			    jersey=sc.nextInt();
				object.getTotalRuns(jersey);
				break;
			case 2:
				System.out.println("Enter the Jersey Number:");
				jersey=sc.nextInt();
				object.getTotalWickets(jersey);
				break;
			case 3:
				System.out.println("Enter the Jersey Number:");
				jersey=sc.nextInt();
				System.out.println("Enter the Match Number:");
				matchno=sc.nextInt();
				Validate.validatematch(matchno);
				object.getRunsfromMatch(jersey, matchno);
				break;
			case 4:
				System.out.println("Enter the Jersey Number:");
				jersey=sc.nextInt();
				System.out.println("Enter the Match Number:");
				matchno=sc.nextInt();
				Validate.validatematch(matchno);
				object.getWicketsfromMatch(jersey, matchno);
				break;
			case 5:
				System.out.println("Enter the Match Number:");
				matchno=sc.nextInt();
				Validate.validatematch(matchno);
				object.displayMatchDetails(matchno);
				break;
			case 6:
				System.out.println("Enter the Jersey Number:");
				jersey=sc.nextInt();
				object.getValues(jersey);
				break;
			case 7:
				System.out.println("Enter the Match Number:");
				matchno=sc.nextInt();
				Validate.validatematch(matchno);
				object.getScoreBoardOfAMatch(matchno);
				break;
			case 8:
				System.out.println("Enter the Jersey Number:");
				jersey=sc.nextInt();
				System.out.println("Enter the Match Number:");
				matchno=sc.nextInt();
				Validate.validatematch(matchno);
				object.getPlayerScoreinMatch(jersey, matchno);
				break;
			case 9:
				object.getBestBattingPlayer();
				break;
			case 10:
				object.getBestBowlingPlayer();
				break;
			case 11:
				object.getHighestScorePlayer();
				break;
			case 12:
				object.getHighestWicketTaker();
				break;
			}
			}
			
		else {
			System.out.println("Invalid Choice");
		}
	}
	
public static void updateDisplay() {	
	System.out.println("Select the Table you want to Update.\n1.Player\n2.Score");
	System.out.print("Enter your choice:");
	int choice=sc.nextInt();
	sc.nextLine();
	System.out.print("\nEnter the value you want to be updated:");
	String updateValue=sc.nextLine();
	System.out.print("\nEnter the field name you want to be updated:");
	String updateField=sc.nextLine();
	System.out.print("\nEnter the condition field:");
	String conditionField=sc.nextLine();
	System.out.print("\nEnter the condition value:");
	String conditionValue=sc.nextLine();
	String query="";
	if(choice==1) {
	if(Validate.validatString(updateValue)&&Validate.validatString(conditionValue))
	query="update player set "+updateField+" = '"+updateValue+"' where "+conditionField+" = '"+conditionValue+"';";
	else if(Validate.validatString(updateValue)) 
    query="update player set "+updateField+" = '"+updateValue+"' where "+conditionField+" = "+Integer.parseInt(conditionValue)+";";
	else if(Validate.validatString(conditionValue))
	query="update player set "+updateField+" = "+Integer.parseInt(updateValue)+" where "+conditionField+" = '"+conditionValue+"';";
	else if(!(Validate.validatString(updateValue)&&Validate.validatString(conditionValue)))
	query="update player set "+updateField+" = "+Integer.parseInt(updateValue)+" where "+conditionField+" = "+Integer.parseInt(conditionValue)+";";
	Update.updateValue(query);
	}
	else if(choice==2) {
		if(Validate.validatString(updateValue)&&Validate.validatString(conditionValue))
			query="update score set "+updateField+" = '"+updateValue+"' where "+conditionField+" = '"+conditionValue+"';";
			else if(Validate.validatString(updateValue)) 
		    query="update score set "+updateField+" = '"+updateValue+"' where "+conditionField+" = "+Integer.parseInt(conditionValue)+";";
			else if(Validate.validatString(conditionValue))
			query="update score set "+updateField+" = "+Integer.parseInt(updateValue)+" where "+conditionField+" = '"+conditionValue+"';";
			else if(!(Validate.validatString(updateValue)&&Validate.validatString(conditionValue)))
			query="update score set "+updateField+" = "+Integer.parseInt(updateValue)+" where "+conditionField+" = "+Integer.parseInt(conditionValue)+";";
			Update.updateValue(query);
	}
	else {
		System.out.println("Invalid choice");
	}
	}
	public static void deleteDisplay() {
		System.out.print("\nEnter the follwing Details to get Deleted:\n");
		System.out.print("Enter the Match Number:");
		matchno=sc.nextInt();
		System.out.print("Enter the Jersey Number:");
		jersey=sc.nextInt();
		Delete.delete(matchno, jersey);
	}
	}

