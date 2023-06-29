package com.kce.hotel.dao;
import com.kce.hotel.bean.Room;
import com.kce.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class RoomDetails {
	public void insertDetails() {
		try {   
			int num,i;
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the number Room Details: ");
				 num=sc.nextInt();
				sc.nextLine();
			   Room room[]= new Room [num];
			   for(i=0;i<num;i++) {
			 System.out.println("Enter Room number : ");
			 String no=sc.nextLine();
			 System.out.println("Enter Room Type : ");
			 String roomtype=sc.nextLine();
			 System.out.println("Enter Status : ");
			 String status=sc.nextLine();
			 System.out.println("Enter CostPerDay : ");
			 int cost=sc.nextInt();
			   room[i]=new Room(no,roomtype,status,cost);
			   sc.nextLine();
			   }
			  //Establishing connection
			   Connection con=DBUtil.getConnection();
			   PreparedStatement stmt=con.prepareStatement("insert into Room values(?,?,?,?)");
			   for(i=0;i<num;i++) {
				   stmt.setString(1, room[i].getRoomNumber());
				   stmt.setString(2, room[i].getRoomType());
				   stmt.setString(3, room[i].getStatus());
				   stmt.setInt(4, room[i].getCostPerDay());
				   stmt.executeUpdate();
			   }
			   System.out.println("Details Inserted");
			   stmt.close();
			   con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		}
	//to delete
	public void deleteDetails() {
		System.out.println("Enter the Room number to be deleted:");
		try {
		Scanner sc=new Scanner(System.in);
	    String no=sc.nextLine();	
		//Establishing connection
		   Connection con=DBUtil.getConnection();
	 	   PreparedStatement stmt=con.prepareStatement("delete from Room where Status='"+no+"'");
		   stmt.executeUpdate();
		   System.out.println("Details Deleted Successfully");
		   displayRoomDetails();
		   stmt.close();
		   con.close();
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//to display
	public void displayRoomDetails() {
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Room");
			ResultSet rs = stmt.executeQuery();
			System.out.printf("%-15s%-15s%-15s%-15s","Room Number","RoomType","Status","CostPerDay");
            System.out.println();
			while (rs.next()) {
			System.out.printf("%-15s%-15s%-15s%-15s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
		     System.out.println();		
		    }
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		public void UpdateRoomDetails(String rnum) {
			try {
				Connection con = DBUtil.getConnection();
				PreparedStatement stmt = con.prepareStatement("UPDATE Room SET Status ='Booked' where RoomNumber='"+rnum+"'");
				stmt.executeUpdate();		
				RoomDetails r1=new RoomDetails();
				r1.displayRoomDetails();
				stmt.close();
				stmt.close();
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
