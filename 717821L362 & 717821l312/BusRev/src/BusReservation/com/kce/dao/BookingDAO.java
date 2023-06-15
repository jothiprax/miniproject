package BusReservation.com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import BusReservation.Booking;
import BusReservation.DBconnection;

public class BookingDAO {
	 public int getBookedCount(int busno, Date date)throws SQLException{
		  
		   String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		   
		   Connection con=DBconnection.getConnection();
		   PreparedStatement pst=con.prepareStatement(query);
		  java.sql.Date sqldate=new java.sql.Date(date.getTime());
		   pst.setInt(1,busno);
		  pst.setDate(2,sqldate);
		  
		  ResultSet rs= pst.executeQuery();
		  rs.next();
		  return rs.getInt(1);
	   }
	   public void addBooking(Booking booking) throws SQLException{
		   String query = "Insert into booking values(?,?,?)";
		   Connection con=DBconnection.getConnection();
		   java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		   PreparedStatement pst=con.prepareStatement(query);
		   pst.setString(1,booking.passengername);
		   pst.setInt(2,booking.busno);
		   pst.setDate(3, sqldate);
		   pst.executeUpdate();
	   }
}
