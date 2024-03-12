package com.kce.musicstore.dao;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.musicstore.bean.Choice;
import com.kce.musicstore.util.DBUtil;

public class Pop {
	private static String name;
	private static String singer;
	private static String language;
	private static double cost;
	private static int available;
	@SuppressWarnings("static-access")
	public Pop(String name,String singer,String language,double cost,int available) {
		this.name=name;
		this.singer=singer;
		this.language=language;
		this.cost=cost;
		this.available=available;
	}
	static Scanner sc = new Scanner(System.in);
	public Pop() {
		
	}
	private static Connection con;
	private static PreparedStatement psmt;
	private static ResultSet rs;
	public static void sell() throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("insert into Pop values(?,?,?,?,?)");
		psmt.setString(1, name);
		psmt.setString(2, singer);
		psmt.setString(3, language);
		psmt.setDouble(4, cost);
		psmt.setInt(5, available);
		psmt.executeUpdate();
		psmt.close();
		System.out.println("Successfully selled!");
		System.out.println("Do you  want to continue?\n1. Yes\n2. No");
		int choice = sc.nextInt();
		if(choice==1) {
			Choice.choice();
		}
		else {
			System.out.println("*****Visit Again*****");
		}
	}
	public static void buy(String sname,int quantity) throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("update Pop set available = available - ? where name=?");
		psmt.setInt(1, quantity);
		psmt.setString(2, sname);
		psmt.executeUpdate();
		psmt.close();
		System.out.println("Successfully Bought!");
		System.out.println("Do you  want to continue?\n1. Yes\n2. No");
		int choice1= sc.nextInt();
		if(choice1==1) {
			Choice.choice();
		}
		else {
			System.out.println("*****Visit Again*****");
		}
	}
	public static void showList() throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("select * from Pop");
		rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("Music Name: "+rs.getString(1)+" |Singer: "+rs.getString(2)+" |Lang: "+rs.getString(3)+" |Cost: "+rs.getDouble(4)+" |Available: "+rs.getInt(5));
		}
	}
	public static void searchByName(String ch) throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("select * from Pop where name=?");
		psmt.setString(1, ch);
		rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("Music Name: "+rs.getString(1)+" |Singer: "+rs.getString(2)+" |Lang: "+rs.getString(3)+" |Cost: "+rs.getDouble(4)+" |Available: "+rs.getInt(5));
		}
	}
	public static void searchBySinger(String singerName) throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("select * from Pop where singer=?");
		psmt.setString(1, singerName);
		rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("Music Name: "+rs.getString(1)+" |Singer: "+rs.getString(2)+" |Lang: "+rs.getString(3)+" |Cost: "+rs.getDouble(4)+" |Available: "+rs.getInt(5));
		}
	}
	public static void searchByLang(String lang) throws ClassNotFoundException, SQLException {
		con=DBUtil.getConnection();
		psmt=con.prepareStatement("select * from Pop where language=?");
		psmt.setString(1, lang);
		rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("Music Name: "+rs.getString(1)+" |Singer: "+rs.getString(2)+" |Lang: "+rs.getString(3)+" |Cost: "+rs.getDouble(4)+" |Available: "+rs.getInt(5));
		}
	}
}
