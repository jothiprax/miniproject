package com.kce.bean;
import com.kce.dao.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SportsDetails {
public void Volleyball() throws SQLException, ClassNotFoundException {
   Connection con = DButil.getConnections();
	PreparedStatement stmt = con.prepareStatement("insert into Volleyball values(?,?,?,?,?)");
  stmt.setString(1,"July 15-18,2023");
  stmt.setString(2,"Tamil Nadu Volleyball Championship");
  stmt.setString(3,"Jawaharlal Nehru Stadium,Chennai,Tamil Nadu");
  stmt.setInt(4,500);
  stmt.setInt(5,100000);
  stmt.executeUpdate();
  stmt.setString(1,"August 5-7,2023");
  stmt.setString(2,"Puducherry Volleyball Cup");
  stmt.setString(3,"Indira Gandhi Sports Complex,Puducherry,Tamil Nadu");
  stmt.setInt(4,400);
  stmt.setInt(5,80000);
  stmt.executeUpdate();
  stmt.setString(1,"september 2-4,2023");
  stmt.setString(2,"Tamil Nadu Coastal Classic");
  stmt.setString(3,"Rameswaram Sports Complex,Rameswaram,Tamil Nadu");
  stmt.setInt(4,700);
  stmt.setInt(5,70000);
  stmt.executeUpdate();
  stmt.setString(1,"October 15-17,2023");
  stmt.setString(2,"Coimbatore Volleyball League");
  stmt.setString(3,"PSG Tech Indoor Stadium,Coimbatore,Tamil Nadu");
  stmt.setInt(4,600);
  stmt.setInt(5,150000);
  stmt.executeUpdate();
  stmt.setString(1,"December 8-10,2023");
  stmt.setString(2,"Corporate Cup");
  stmt.setString(3,"SDAT Indoor Stadium,Chennai,Tamil Nadu");
  stmt.setInt(4,1000);
  stmt.setInt(5,160000);
  stmt.executeUpdate();
}
public void Cricket() throws SQLException, ClassNotFoundException {
	 Connection con = DButil.getConnections();
	PreparedStatement stmt = con.prepareStatement("insert into Cricket values(?,?,?,?,?)");
	  stmt.setString(1,"August 1 - September 15,2023");
	  stmt.setString(2,"Tamil Nadu Premier League(TNPL)");
	  stmt.setString(3,"Various stadiums across Tamil Nadu");
	  stmt.setInt(4,20000);
	  stmt.setInt(5,2000000);
	  stmt.executeUpdate();
	  stmt.setString(1,"November 10-20,2023");
	  stmt.setString(2,"Tamil Nadu Corporate Cricket Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,8000);
	  stmt.setInt(5,900000);
	  stmt.executeUpdate();
	  stmt.setString(1,"January 5 - February 15,2024");
	  stmt.setString(2,"Tamil Nadu Inter-District Cricket Tournament");
	  stmt.setString(3,"Various district venues in Tamil Nadu");
	  stmt.setInt(4,7000);
	  stmt.setInt(5,600000);
	  stmt.executeUpdate();
	  stmt.setString(1,"March 1-10,2024");
	  stmt.setString(2,"Tamil Nadu School Cricket Tournament");
	  stmt.setString(3,"Coimbatore");
	  stmt.setInt(4,1000);
	  stmt.setInt(5,100000);
	  stmt.executeUpdate();
	  stmt.setString(1,"April 5 - May 20,2024");
	  stmt.setString(2,"Tamil Nadu Cricket League(TNCL)");
	  stmt.setString(3,"Madurai");
	  stmt.setInt(4,10000);
	  stmt.setInt(5,1000000);
	  stmt.executeUpdate();
}
public void Football() throws SQLException, ClassNotFoundException {
	 Connection con = DButil.getConnections();
	PreparedStatement stmt = con.prepareStatement("insert into Football values(?,?,?,?,?)");
	  stmt.setString(1,"August 1 - October 31,2023");
	  stmt.setString(2,"Tamil Nadu Football League (TNFL)");
	  stmt.setString(3,"Various stadiums across Tamil Nadu");
	  stmt.setInt(4,20000);
	  stmt.setInt(5,2000000);
	  stmt.executeUpdate();
	  stmt.setString(1,"January 5 - February 15,2024");
	  stmt.setString(2,"TamilNadu College Football Tournament");
	  stmt.setString(3,"Coimbatore");
	  stmt.setInt(4,8000);
	  stmt.setInt(5,900000);
	  stmt.executeUpdate();
	  stmt.setString(1,"November 10-20,2023");
	  stmt.setString(2,"Tamil Nadu Inter-District Football Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,7000);
	  stmt.setInt(5,600000);
	  stmt.executeUpdate();
	  stmt.setString(1,"March 1-10,2024");
	  stmt.setString(2,"Tamil Nadu Women's Football League (TNWFL)");
	  stmt.setString(3,"Madurai");
	  stmt.setInt(4,1000);
	  stmt.setInt(5,100000);
	  stmt.executeUpdate();
	  stmt.setString(1,"April 5 - May 20,2024");
	  stmt.setString(2,"Tamil Nadu Corporate Football Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,10000);
	  stmt.setInt(5,1000000);
	  stmt.executeUpdate();
}
public void Hockey() throws SQLException, ClassNotFoundException {
	 Connection con = DButil.getConnections();
	PreparedStatement stmt = con.prepareStatement("insert into Hockey values(?,?,?,?,?)");
	  stmt.setString(1,"August 1 - October 31,2023");
	  stmt.setString(2,"Tamil Nadu Hockey League (TNHL)");
	  stmt.setString(3,"Various stadiums across Tamil Nadu");
	  stmt.setInt(4,10000);
	  stmt.setInt(5,1000000);
	  stmt.executeUpdate();
	  stmt.setString(1,"November 10-20,2023");
	  stmt.setString(2,"Tamil Nadu Inter-District Hockey Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,8000);
	  stmt.setInt(5,800000);
	  stmt.executeUpdate();
	  stmt.setString(1,"January 5 - February 15,2024");
	  stmt.setString(2,"TamilNadu College Hockey Tournament");
	  stmt.setString(3,"Coimbatore");
	  stmt.setInt(4,7000);
	  stmt.setInt(5,600000);
	  stmt.executeUpdate();
	  stmt.setString(1,"March 1-10,2024");
	  stmt.setString(2,"Tamil Nadu Women's Hockey League(TNWHL)");
	  stmt.setString(3,"Madurai");
	  stmt.setInt(4,20000);
	  stmt.setInt(5,900000);
	  stmt.executeUpdate();
	  stmt.setString(1,"April 5 - May 20,2024");
	  stmt.setString(2,"Tamil Nadu Corporate Hockey Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,30000);
	  stmt.setInt(5,2500000);
	  stmt.executeUpdate();
}
public void Kabaddi() throws SQLException, ClassNotFoundException {
	 Connection con = DButil.getConnections();
	PreparedStatement stmt = con.prepareStatement("insert into Kabaddi values(?,?,?,?,?)");
	  stmt.setString(1,"September 1 - October 31,2023");
	  stmt.setString(2,"Tamil Nadu Kabaddi League(TNKL)");
	  stmt.setString(3,"Various stadiums across Tamil Nadu");
	  stmt.setInt(4,20000);
	  stmt.setInt(5,1000000);
	  stmt.executeUpdate();
	  stmt.setString(1,"November 10-20,2023");
	  stmt.setString(2,"Tamil Nadu Inter-District Kabaddi Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,1000);
	  stmt.setInt(5,100000);
	  stmt.executeUpdate();
	  stmt.setString(1,"January 5 - February 15,2024");
	  stmt.setString(2,"Tamil Nadu College Kabaddi Tournament");
	  stmt.setString(3,"Coimbatore");
	  stmt.setInt(4,7000);
	  stmt.setInt(5,600000);
	  stmt.executeUpdate();
	  stmt.setString(1,"March 1-10,2024");
	  stmt.setString(2,"Tamil Nadu Women's Kabaddi League(TNWKL)");
	  stmt.setString(3,"Madurai");
	  stmt.setInt(4,5000);
	  stmt.setInt(5,500000);
	  stmt.executeUpdate();
	  stmt.setString(1,"April 5 - May 20, 2024");
	  stmt.setString(2,"Tamil Nadu Corporate Kabaddi Championship");
	  stmt.setString(3,"Chennai");
	  stmt.setInt(4,10000);
	  stmt.setInt(5,1000000);
	  stmt.executeUpdate();
}
public void Insert() throws ClassNotFoundException, SQLException {
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the SportsName you want to insert:");
		String SportsName = sc.nextLine();
		System.out.println("Enter the Date:");
   String Date = sc.nextLine();
   System.out.println("Enter the TournamentName:");
   String Tournament = sc.nextLine();
   System.out.println("Enter the Venue:");
   String Venue = sc.nextLine();
   System.out.println("Enter the Entryfee:");
   int Entryfee = sc.nextInt();
   System.out.println("Enter the Prices:");
   int Prices = sc.nextInt();
		  if(SportsName.equals("Volleyball")) {
			 Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("insert into Volleyball values(?,?,?,?,?)");
			stmt.setString(1,Date);
			stmt.setString(2,Tournament);
			stmt.setString(3,Venue);
			stmt.setInt(4,Entryfee);
			stmt.setInt(5,Prices);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Volleyball");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		  }
		  else if(SportsName.equals("Cricket")){
			 Connection con = DButil.getConnections();
				PreparedStatement stmt = con.prepareStatement("insert into Cricket values(?,?,?,?,?)");
				stmt.setString(1,Date);
				stmt.setString(2,Tournament);
				stmt.setString(3,Venue);
				stmt.setInt(4,Entryfee);
				stmt.setInt(5,Prices);
				stmt.executeUpdate();
				Connection con1 = DButil.getConnections();
				Statement stat = con1.createStatement();
				ResultSet rs = stat.executeQuery("select * from Cricket");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
			 }
		 }
		  else if(SportsName.equals("Football")){
			 Connection con = DButil.getConnections();
				PreparedStatement stmt = con.prepareStatement("insert into Football values(?,?,?,?,?)");
				stmt.setString(1,Date);
				stmt.setString(2,Tournament);
				stmt.setString(3,Venue);
				stmt.setInt(4,Entryfee);
				stmt.setInt(5,Prices);
				stmt.executeUpdate();
				Connection con1 = DButil.getConnections();
				Statement stat = con1.createStatement();
				ResultSet rs = stat.executeQuery("select * from Football");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
			 }
		 }
		  else if(SportsName.equals("Hockey")){
			 Connection con = DButil.getConnections();
				PreparedStatement stmt = con.prepareStatement("insert into Hockey values(?,?,?,?,?)");
				stmt.setString(1,Date);
				stmt.setString(2,Tournament);
				stmt.setString(3,Venue);
				stmt.setInt(4,Entryfee);
				stmt.setInt(5,Prices);
				stmt.executeUpdate();
				Connection con1 = DButil.getConnections();
				Statement stat = con1.createStatement();
				ResultSet rs = stat.executeQuery("select *  from Hockey");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
			 }
		 }
		  else if(SportsName.equals("Kabaddi")){
			 Connection con = DButil.getConnections();
				PreparedStatement stmt = con.prepareStatement("insert into Kabaddi values(?,?,?,?,?)");
				stmt.setString(1,Date);
				stmt.setString(2,Tournament);
				stmt.setString(3,Venue);
				stmt.setInt(4,Entryfee);
				stmt.setInt(5,Prices);
				stmt.executeUpdate();
				Connection con1 = DButil.getConnections();
				Statement stat = con1.createStatement();
				ResultSet rs = stat.executeQuery("select * from Kabaddi");
				while(rs.next()) {
					System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
							+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
			 }
		 }
		  else{
			 System.out.println("Enter a valid SportsName");
		 }
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public void Update() throws ClassNotFoundException, SQLException {
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the SportsName to Update:");
		String SportsName = sc.nextLine();
		System.out.println("Enter the date:");
		String Date = sc.nextLine();
		System.out.println("Enter the TournamentName:");
		String TournamentName = sc.nextLine();
		System.out.println("Enter the Venue:");
		String venue = sc.nextLine();
		System.out.println("Enter the Entryfee:");
		int Entryfee = sc.nextInt();
		System.out.println("Enter the Prices:");
		int Prices = sc.nextInt();
		if(SportsName.equals("Volleyball")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("update Volleyball set Date= ?,Venue= ?,Entryfee= ?,Prices= ? where TournamentName= ?");
			stmt.setString(1,Date);
			stmt.setString(2,venue);
			stmt.setInt(3,Entryfee);
			stmt.setInt(4,Prices);
			stmt.setString(5,TournamentName);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Volleyball");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		}
		else if(SportsName.equals("Cricket")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("Update Cricket set Date= ?,Venue= ?,Entryfee= ?,Prices= ? where TournamentName= ?");
			stmt.setString(1,Date);
			stmt.setString(2,venue);
			stmt.setInt(3,Entryfee);
			stmt.setInt(4,Prices);
			stmt.setString(5,TournamentName);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Cricket");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		}
		else if(SportsName.equals("Football")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("Update Football set Date = ?,Venue= ?,Entryfee= ?,Prices= ? where TournamentName= ?");
			stmt.setString(1,Date);
			stmt.setString(2,venue);
			stmt.setInt(3,Entryfee);
			stmt.setInt(4,Prices);
			stmt.setString(5,TournamentName);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Football");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		}
		else if(SportsName.equals("Hockey")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("Update Hockey set Date= ?,Venue= ?,Entryfee= ?,Prices= ? where TournamentName= ?");
			stmt.setString(1,Date);
			stmt.setString(2,venue);
			stmt.setInt(3,Entryfee);
			stmt.setInt(4,Prices);
			stmt.setString(5,TournamentName);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Hockey");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		}
		else if(SportsName.equals("Kabaddi")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("Update Kabaddi set Date= ?,Venue= ?,Entryfee= ?,Prices= ? where TournamentName= ?");
			stmt.setString(1,Date);
			stmt.setString(2,venue);
			stmt.setInt(3,Entryfee);
			stmt.setInt(4,Prices);
			stmt.setString(5,TournamentName);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from kabaddi");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
		}
		else {
			System.out.println("Enter a valid SportsName");
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public void Delete() throws ClassNotFoundException, SQLException {
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the SportsName you want to delete:");
		String name = sc.nextLine();
		System.out.println("Enter the Date to Delete:");
		String Date = sc.nextLine();
		if(name.equals("Volleyball")) {
		Connection con = DButil.getConnections();
		PreparedStatement stmt = con.prepareStatement("delete from Volleyball where Date= ?");
		stmt.setString(1,Date);
		stmt.executeUpdate();
		Connection con1 = DButil.getConnections();
		Statement stat = con1.createStatement();
		ResultSet rs = stat.executeQuery("select * from Volleyball");
		while(rs.next()) {
			System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
					+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
 }
		}
		else if(name.equals("Hockey")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("delete from Hockey where Date= ?");
			stmt.setString(1,Date);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select *  from Hockey");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
			}
		else if(name.equals("Cricket")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("delete from Cricket where Date= ?");
			stmt.setString(1,Date);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Hockey");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
			}
		else if(name.equals("Football")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("delete from Football where Date= ?");
			stmt.setString(1,Date);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select * from Football");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
			}
		else if(name.equals("Kabaddi")) {
			Connection con = DButil.getConnections();
			PreparedStatement stmt = con.prepareStatement("delete from Kabaddi where Date= ?");
			stmt.setString(1,Date);
			stmt.executeUpdate();
			Connection con1 = DButil.getConnections();
			Statement stat = con1.createStatement();
			ResultSet rs = stat.executeQuery("select *  from Kabaddi");
			while(rs.next()) {
				System.out.println("Date:"+rs.getString(1)+"--> "+"TournamentName:"+rs.getString(2)+"--> "+"Venue:"
						+rs.getString(3)+"--> "+"Entryfee:"+rs.getInt(4)+"--> "+"Prices:"+rs.getInt(5));
		 }
			}
		else {
			System.out.println("Enter a valid SportsName");
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
}
}

