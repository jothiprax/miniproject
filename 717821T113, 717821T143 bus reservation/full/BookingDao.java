package busreservation;

import java.util.Date;
import java.sql.SQLException;
import java.sql.*;
public class BookingDao {

	public int getBookedCount(int busNo, Date date)  throws Exception 
	{
		
		String query="select count(passenger_name) from booking where bus_no= ? and travel_date=? ";
		Connection con =dbconnection.getconnection();
		PreparedStatement ps= con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		ps.setInt(1,busNo);
		ps.setDate(2,sqldate);
		ResultSet rs =ps.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	}

public void addBooking(Booking b) throws Exception
{String query ="Insert into booking values(?,?,?)";
	Connection con =dbconnection.getconnection();
	PreparedStatement ps= con.prepareStatement(query);
	java.sql.Date sqldate=new java.sql.Date(Booking.date.getTime());
	try {
		ps.setString(1, Booking.passengerName);
	
		ps.setInt(2, Booking.busNo);
		ps.setDate(3, sqldate);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ps.executeUpdate();
}

	
	

	
	
}
