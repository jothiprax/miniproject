package com.kce.util;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.dao.DButil;
public class User {
	private String TeamName;
	private String CaptainName;
	private String CoachName;
	private String ContactNumber;
	private String Email;
	private String address;
	public User(String address, String TeamName, String CoachName, String ContactNumber, String Email, String CaptainName) {
		super();
		this.TeamName = TeamName;
		this.CaptainName = CaptainName;
		this.CoachName = CoachName;
		this.ContactNumber = ContactNumber;
		this.Email = Email;
		this.address = address;
	}
	 public User() {
	}
	public void UserDetails() throws ClassNotFoundException, SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter your TeamName:");
			  String a = sc.nextLine();
			  System.out.println("Enter your team CaptainName:");
			  String b = sc.nextLine();
			  System.out.println("Enter your team CoachName:");
			  String c = sc.nextLine();
			  System.out.println("Enter your team ContactNumber:");
			  String d = sc.nextLine();
			  System.out.println("Enter your team Email:");
			  String e = sc.nextLine();
			  System.out.println("Enter your team address");
			   String f = sc.nextLine();
			   System.out.println("Enter the Entryfee amount to pay:");
			   int amt = sc.nextInt();
			   Connection con = DButil.getConnections();
			   Statement stat2 = con.createStatement();
				ResultSet rs2 =  stat2.executeQuery("select * from Volleyball Union select * from Cricket Union select * from Football Union select * from Hockey Union select * from Kabaddi");
					while(rs2.next()) {
						 if(amt==(rs2.getInt(4))) {
				 System.out.println("Payement is sucessfull!");
				System.out.println("Registeration is successfull!");
				break;
					}
					}
			    Connection con1 = DButil.getConnections();
				PreparedStatement stmt = con1.prepareStatement("insert into RegisterationDetails values(?,?,?,?,?,?)");
			  stmt.setString(1,a);	
			  stmt.setString(2,b);
			  stmt.setString(3,c);
			  stmt.setString(4,d);
			  stmt.setString(5,e);
			  stmt.setString(6,f);
			  stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	  public void Registeration() throws ClassNotFoundException, SQLException{
		System.out.println("Enter the SportsName:");
		try (Scanner sc = new Scanner(System.in)) {
			String sports = sc.nextLine();
			switch(sports) {
			case "Volleyball":{
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
			ResultSet rs =  stat.executeQuery("select * from Volleyball");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
				+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
				}
				Statement stat1 = con.createStatement();
				System.out.println("Enter the TournamentName you want to register:");
				String a = sc.nextLine();
				ResultSet rs1 =  stat1.executeQuery("select TournamentName from Volleyball");
		        int count=0;
				while(rs1.next()) {
					 if(a.equals(rs1.getString(1))){
						 count++;
					  }
				}
				if(count==1) {
					System.out.println("Registeration is available");
					System.out.println("Enter your team Details to register:");
				}
				else {
					System.out.println("TournamentName is Not Valid!");
				}
				User ud = new User(a, a, a, a, a, a);
				ud.UserDetails();
				break;
			}
			case "Cricket":{
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from Cricket");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
				}
				System.out.println("Enter the TournamentName you want to register:");
				String a = sc.next();
				Statement stat1 = con.createStatement();
				ResultSet rs1 =  stat1.executeQuery("select TournamentName from Cricket");
		        int count=0;
				while(rs1.next()) {
					 if(a.equals(rs1.getString(1))){
						 count++;
					  }
				}
				if(count==1) {
					System.out.println("Registeration is available");
					System.out.println("Enter your team Details to register:");
				}
				else {
					System.out.println("TournamentName is Not valid");
				}
				User ud = new User(a, a, a, a, a, a);
				ud.UserDetails();
				break;
				}
			case "Football":{
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from Football");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
				}
				System.out.println("Enter the TournamentName you want to register:");
				String a = sc.nextLine();
				Statement stat1 = con.createStatement();
				ResultSet rs1 =  stat1.executeQuery("select TournamentName from Football");
		        int count=0;
				while(rs1.next()) {
					 if(a.equals(rs1.getString(1))){
						 count++;
					  }
				}
				if(count==1) {
					System.out.println("Registeration is available");
					System.out.println("Enter your team Details to register:");
				}
				else {
					System.out.println("TournamentName is Not valid");
				}
				User ud = new User(a, a, a, a, a, a);
				ud.UserDetails();
				break;
			}
			case "Hockey":{
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from Hockey");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
				}
				System.out.println("Enter the TournamentName you want to register:");
				String a = sc.nextLine();
				Statement stat1 = con.createStatement();
				ResultSet rs1 =  stat1.executeQuery("select TournamentName from Hockey");
		        int count=0;
				while(rs1.next()) {
					 if(a.equals(rs1.getString(1))){
						 count++;
					  }
				}
				if(count==1) {
					System.out.println("Registeration is available");
					System.out.println("Enter your team Details to register:");
				}
				else {
					System.out.println("TournamentName is Not valid!");
				}
				User ud = new User(a, a, a, a, a, a);
				ud.UserDetails();
				break;
			}
			case "Kabaddi":{
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from Kabaddi");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
				}
				System.out.println("Enter the TournamentName you want to register:");
				String a = sc.nextLine();
				Statement stat1 = con.createStatement();
				ResultSet rs1 =  stat1.executeQuery("select TournamentName from Kabaddi");
		        int count=0;
				while(rs1.next()) {
					 if(a.equals(rs1.getString(1))){
						 count++;
					  }
				}
				if(count==1) {
					System.out.println("Registeration is available");
					System.out.println("Enter your team Details to register:");
				}
				else {
					System.out.println("TournamentName is Not valid");
				}
				User ud = new User(a, a, a, a, a, a);
				ud.UserDetails();
				break;
			}
			default:
				System.out.println("The sportsName is not available!");
				}
		}
	}
	}

