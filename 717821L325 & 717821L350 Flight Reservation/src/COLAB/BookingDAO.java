package COLAB;

import java.util.Date;
import java.sql.*;
public class BookingDAO {

	public int getBookedCount(int flightNo,Date date) throws SQLException{
		
		String query = "select count(passenger_name) from book where flight_no=? and travel_date=?";
		Connection con = Main.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, flightNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	public void addBooking(Booking booking) throws SQLException{
		String query = "Insert into book values(?,?,?,?)";
		Connection con = Main.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.flightNo);
		pst.setInt(3,booking.passportNo);
		pst.setDate(4, sqldate);
		
		pst.executeUpdate();
		
	}
}
