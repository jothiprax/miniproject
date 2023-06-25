package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Hotel;
import com.kce.util.AlreadyBooked;
import com.kce.util.JDBCConnection;

public class HotelDetails extends Hotel{
    
    JDBCConnection jdbc =new JDBCConnection();
	public HotelDetails(int roomno, int floor, String status) {
		super(roomno, floor, status);
	}
	public HotelDetails() {
		super();
	}
	public int count=0;
	public void ShowDetails() throws Exception {
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("select roomno,floor from Hotel where status ='Not Booked'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("Room No: "+rs.getInt(1)+"    Floor: "+rs.getInt(2));
			count++;
		}
    }
	public void read() throws Exception {
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Hotel");
		ResultSet rs = ps.executeQuery();
		System.out.printf("%-10s%-10s%-10s\n","Roomno","Floor","BookedOrNot");
		while(rs.next()) {
			System.out.printf("%-10s%-10s%-10s\n",rs.getInt(1),rs.getInt(2),rs.getString(3));
		}
    }
    public void insert(int roomno,int floor,String status)throws Exception {
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into Hotel values(?,?,?)");
		ps.setInt(1,roomno);
		ps.setInt(2,floor);
		ps.setString(3,status);
		ps.execute();
    }
    public void update(int roomno) throws Exception {
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement(" update hotel set status='Booked' where roomno=?");
		ps.setInt(1, roomno);
		ps.execute();
    }
    public void updateVacate(int roomno) throws Exception {
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("update hotel set status=NULL where roomno=?");
		ps.setInt(1, roomno);
		ps.execute();
    }
    public void check(int roomno) throws Exception {
    	List<Integer> list=new ArrayList<>();
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("select roomno from Hotel where status ='Booked'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
		if(list.contains(roomno))throw new AlreadyBooked("Room you choosed is already booked.");
    }
    public int cont=0;
    public void checkVacate(int roomno) throws Exception {
    	List<Integer> list1=new ArrayList<>();
    	Connection con=jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("select roomno from Hotel where status ='Not Booked'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list1.add(rs.getInt(1));
		}
		
		if(list1.contains(roomno)) {
			cont++;
			System.out.println("Invalid room Number\n ReEnter:\n");
		}
    }
    
}
