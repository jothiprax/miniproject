package com.kce.sports.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.kce.sports.bean.*;
import com.kce.sports.util.*;

public class SportsQuery {
	private Connection con = SportsCon.getDBConnection();
	public void addPlayerDetails(Players p) {
		try {
			PreparedStatement st = con.prepareStatement("insert into players values(?,?,?,?,?,?,?,?)");
			st.setString(1, p.getPname());
			st.setString(2, p.getSalary());
			st.setString(3, p.getPosition());
			st.setInt(4,p.getAge());
			st.setInt(5,p.getJersey_no());
			st.setInt(6, p.getGoals());
			st.setString(7, p.getNationality());
			st.setString(8, p.getContract());
			st.executeUpdate();
			System.out.println("Successfully inserted the player details !!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addMedicDetails(Medic m) {
		try {
			PreparedStatement st = con.prepareStatement("insert into medic values(?,?,?,?,?)");
			st.setString(1, m.getPname());
			st.setString(2, m.getCondition());
			st.setString(3, m.getAvailability());
			st.setInt(4, m.getAge());
			st.setString(5, m.getTrainer());
			st.executeUpdate();
			System.out.println("Successfully inserted the medic details !!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addStaffDetails(Staffs s) {
		try {
			PreparedStatement st = con.prepareStatement("insert into staffs values(?,?,?,?,?,?)");
			st.setString(1,s.getName());
			st.setString(2, s.getRole());
			st.setString(3, s.getSalary());
			st.setInt(4, s.getAge());
			st.setInt(5, s.getPhone_no());
			st.setString(6, s.getContract());
			st.executeUpdate();
			System.out.println("Successfully inserted the staff details !!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addFixtures(Fixtures f) {
		try {
			PreparedStatement st = con.prepareStatement("insert into fixtures values(?,?,?,?,?,?)");
			st.setString(1, f.getMatch());
			st.setString(2, f.getDate());
			st.setString(3, f.setTime());
			st.setString(4, f.getVenue());
			st.setString(5, f.getScore());
			st.setString(6, f.getResult());
			st.executeUpdate();
			System.out.println("Successfully inserted the fixtures !!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void removePlayerDetails(String pname) {
		try {
			PreparedStatement st = con.prepareStatement("delete from players where pname = ?");
			st.setString(1, pname);
			st.executeUpdate();
			System.out.println("Successfully removed the player !!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeMedicDetails(String pname) {
		try {
			PreparedStatement st = con.prepareStatement("delete from medic where pname = ?");
			st.setString(1, pname);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeStaffDetails(String name) {
		try {
			PreparedStatement st = con.prepareStatement("delete from staffs where name = ?");
			st.setString(1, name);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeFixtureDetails(String match) {
		try {
			PreparedStatement st = con.prepareStatement("delete from fixtures where match = ?");
			st.setString(1, match);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayPlayerDetails() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from players");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6)+" | "+rs.getString(7)+" | "+rs.getString(8));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayMedicDetails() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from medic");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getString(5));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayStaffDetails() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from staffs");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getInt(5)+" | "+rs.getString(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayFixtures() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from fixtures");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void playerCount() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(pname) from players");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void getGoals(String pname) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select goals from players where pname = "+pname);
			System.out.println(rs.getInt(1));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void StaffCount() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(name) from staffs");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void individualPlayerDetails(String detail,String pname) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select "+detail+" from players where pname ="+pname);
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void individualStaffDetails(String detail,String name) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select "+detail+" from staffs where name ="+name);
			while(rs.next()) {
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void individualMedicDetails(String detail,String pname) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select "+detail+" from medic where pname ="+pname);
			while(rs.next()) {

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void individualFixtures(String detail,String match) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select "+detail+" from fixtures where match ="+match);
			while(rs.next()) {

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void PlayerValue(String detail, String value) {
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from players where "+detail+" = "+value);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getString(8));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void MedicValue(String detail, String value) {
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from medic where "+detail+" = "+value);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void StaffValue(String detail, String value) {
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from staffs where "+detail+" = "+value);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void FixtureValue(String detail, String value) {
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from fixtures where "+detail+" = "+value);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePlayerDetails(int n, String pname, String detail) {
		PreparedStatement st;
		try {
			switch(n) {
				case 1:
					String salary = detail;
					st = con.prepareStatement("update players set salary = ? where pname = ?");
					st.setString(1, salary);
					st.setString(2, pname);
					st.executeUpdate();
				case 2:
					String position = detail;
					st = con.prepareStatement("update players set position = ? where pname = ?");
					st.setString(1, position);
					st.setString(2, pname);
					st.executeUpdate();
				case 3:
					int age = Integer.parseInt(detail);
					st = con.prepareStatement("update players set age = ? where pname = ?");
					st.setInt(1, age);
					st.setString(2, pname);
					st.executeUpdate();
				case 4:
					int jersey_no = Integer.parseInt(detail);
					st = con.prepareStatement("update players set jersey_no = ? where pname = ?");
					st.setInt(1, jersey_no);
					st.setString(2, pname);
					st.executeUpdate();
				case 5:
					int goals = Integer.parseInt(detail);
					st = con.prepareStatement("update players set goals = ? where pname = ?");
					st.setInt(1, goals);
					st.setString(2, pname);
					st.executeUpdate();
				case 6:
					String nationality = detail;
					st = con.prepareStatement("update players set nationality = ? where pname = ?");
					st.setString(1, nationality);
					st.setString(2, pname);
					st.executeUpdate();
				case 7:
					String contract = detail;
					st = con.prepareStatement("update players set contract = ? where pname = ?");
					st.setString(1, contract);
					st.setString(2, pname);
					st.executeUpdate();
				default:
					System.out.println("INVALID OPTION !!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMedicDetails(int n, String pname, String detail) {
		PreparedStatement st;
		try {
			switch(n) {
				case 1:
					String condition = detail;
					st = con.prepareStatement("update medic set condition = ? where pname = ?");
					st.setString(1, condition);
					st.setString(2, pname);
					st.executeUpdate();
				case 2:
					String availability = detail;
					st = con.prepareStatement("update medic set availability = ? where pname = ?");
					st.setString(1, availability);
					st.setString(2, pname);
					st.executeUpdate();
				case 3:
					int age = Integer.parseInt(detail);
					st = con.prepareStatement("update medic set age = ? where pname = ?");
					st.setInt(1, age);
					st.setString(2, pname);
					st.executeUpdate();
				case 4:
					String trainer = detail;
					st = con.prepareStatement("update medic set trainer = ? where pname = ?");
					st.setString(1, trainer);
					st.setString(2, pname);
					st.executeUpdate();
				default:
					System.out.println("INVALID OPTION !!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStaffDetails(int n, String name, String detail) {
		PreparedStatement st;
		try {
			switch(n) {
				case 1:
					String role = detail;
					st = con.prepareStatement("update staffs set role = ? where name = ?");
					st.setString(1, role);
					st.setString(2, name);
					st.executeUpdate();
				case 2:
					String salary = detail;
					st = con.prepareStatement("update staffs set salary = ? where name = ?");
					st.setString(1, salary);
					st.setString(2, name);
					st.executeUpdate();
				case 3:
					int age = Integer.parseInt(detail);
					st = con.prepareStatement("update staffs set age = ? where name = ?");
					st.setInt(1, age);
					st.setString(2, name);
					st.executeUpdate();
				case 4:
					int phone_number = Integer.parseInt(detail);
					st = con.prepareStatement("update staffs set phone_number = ? where name = ?");
					st.setInt(1, phone_number);
					st.setString(2, name);
					st.executeUpdate();
				case 5:
					String contract = detail;
					st = con.prepareStatement("update staffs set contract = ? where name = ?");
					st.setString(1, contract);
					st.setString(2, name);
					st.executeUpdate();
				default:
					System.out.println("INVALID OPTION !!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateFixture(int n, String match, String detail) {
		PreparedStatement st;
		try {
			switch(n) {
				case 1:
					String date = detail;
					st = con.prepareStatement("update fixtures set date = ? where match = ?");
					st.setString(1, date);
					st.setString(2, match);
					st.executeUpdate();
				case 2:
					String time = detail;
					st = con.prepareStatement("update fixtures set time = ? where match = ?");
					st.setString(1, time);
					st.setString(2, match);
					st.executeUpdate();
				case 3:
					String venue = detail;
					st = con.prepareStatement("update fixtures set venue = ? where match = ?");
					st.setString(1, venue);
					st.setString(2, match);
					st.executeUpdate();
				case 4:
					String score = detail;
					st = con.prepareStatement("update fixtures set score = ? where match = ?");
					st.setString(1, score);
					st.setString(2, match);
					st.executeUpdate();
				case 5:
					String result = detail;
					st = con.prepareStatement("update fixtures set result = ? where match = ?");
					st.setString(1, result);
					st.setString(2, match);
					st.executeUpdate();
				default:
					System.out.println("INVALID OPTION !!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}