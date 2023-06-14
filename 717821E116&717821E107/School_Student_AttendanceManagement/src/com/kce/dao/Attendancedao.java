package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.kce.bean.Attendance;
import com.kce.util.DbUtil;
public class Attendancedao {
	public static Scanner sc=new Scanner(System.in);
	public static void insertdata(int temp) throws ClassNotFoundException {
		try {
			int n =temp;
			Attendance[] arr=new Attendance[n];
			for(int i=0;i<n;i++) {
				System.out.println("Enter StudentId:");
				int studId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name:");
				String studname=sc.next();
				System.out.println("Enter Department:");
				String dept=sc.next();
				System.out.println("Enter Present/Absent:");
				String pA=sc.next();
				System.out.println("Enter Date:");
				String date=sc.next();
				arr[i]=new Attendance( studId, studname,dept,pA,date);
			}
            Connection con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Attendance VALUES (?, ?, ?,?,?)");
			for (int i = 0; i < temp; i++) {
				stmt.setInt(1,arr[i].getStudId());
				stmt.setString(2, arr[i].getStudname());
				stmt.setString(3, arr[i].getDept());
				stmt.setString(4, arr[i].getPA());
				stmt.setString(5, arr[i].getDate());
				stmt.executeUpdate();
}
			System.out.println("Data is Inserted Successfully.......");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void deletedata(int studId) throws ClassNotFoundException {
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Attendance WHERE studid = ?");
			stmt.setInt(1,studId);
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Row is Deleted Successfully........");
			} else {
				System.out.println("No row found with the specified ID.");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void viewdetails() throws ClassNotFoundException {
		try {
			Connection con = DbUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Attendance");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	public static void deleteTable() throws ClassNotFoundException {
		try {
			Connection con = DbUtil.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("DROP TABLE Attendance");
			System.out.println("Table is Dropped Successfully........");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void updatedata(String PA,int studId) throws ClassNotFoundException {
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement Stmt = con.prepareStatement( "UPDATE Attendance SET = ? WHERE studid = ?");
			Stmt.setString(1,PA);
			Stmt.setInt(2,studId);
			int rows =Stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Record updated successfully.");
			} else {
				System.out.println("No record found with the specified ID.");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
