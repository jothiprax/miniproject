package sports;
//package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.dao.GamesDao;
import com.kce.util.DBUtil;
public class Games {
	public  void insert(int a) {
		try {
			Scanner sc = new Scanner(System.in);
		GamesDao[] arr = new GamesDao[a];
		for (int i = 0; i < a; i++) {
		System.out.println("Enter Serial_no: ");
		int serial_no = sc.nextInt();
		System.out.println("Enter Game name: ");
		String gamename = sc.next();
		
		arr[i] = new GamesDao(serial_no, gamename);
		}

		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into Games values(?,?)");
		for (int i = 0; i < a; i++) {
		stmt.setInt(1, arr[i].getserial_no());
		stmt.setString(2, arr[i].getgamename());
		
		stmt.executeUpdate();
		}
		//con.close();
	     //displayTable();
		System.out.println("Data Inserted successfully");
		sc.close();
		} catch (SQLException e) {
		System.out.println(e);
		} 
		}

		public  void update() {
		try {
			Scanner sc = new Scanner(System.in);
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("UPDATE Games SET gamename = ? WHERE serial_no = ?");
		System.out.println("Enter serial_no: ");
		 int serial_no = sc.nextInt();
		System.out.println("Enter game name: ");
		 String gamename = sc.nextLine();
		stmt.setInt(1, serial_no);
		stmt.setString(2, gamename);
		int rowsAffected = stmt.executeUpdate();
		if (rowsAffected > 0) {
		System.out.println("Update successful");
		} else {
		System.out.println("No records found for the given serial no ");
		}
		con.close();
		sc.close();
		} catch (SQLException e) {
		System.out.println(e);
		}
		}

		public  void delete() {
		try {
			Scanner sc = new Scanner(System.in);
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM GamesDao WHERE name = ?");
		System.out.println("Enter game name: ");
		String gamename = sc.next();
		stmt.setString(1, gamename);
		displayTable();
		int rowsAffected = stmt.executeUpdate();
	     
		if (rowsAffected > 0) {
		System.out.println("Delete successful");
		} else {
		System.out.println("No records found for the given game name");
		}
		//con.close();
		sc.close();
		} catch (SQLException e) {
		System.out.println(e);
		}
		}
		public  void displayTable() {
			try {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM StudentDao");
			ResultSet rs = stmt.executeQuery();

			System.out.println("Game Details:");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-17s | %-17s|%n", "serial_no", "gamename");
			while (rs.next()) {

			System.out.printf("| %-17s | %-17s |%n",rs.getInt(1),rs.getString(2));
			}

			rs.close();
			
			//con.close();
			} catch (SQLException e) {
			System.out.println(e);
			}
			}
}
