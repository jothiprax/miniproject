package busRev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {
	public int getBookedCount(int busNo,Date date ) throws SQLException{
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","Pari@123");
		PreparedStatement st=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		st.setInt(1, busNo);
		st.setDate(2, sqldate);
		ResultSet rs=st.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	}
	public void addBooking(Booking book) throws SQLException{
		String query="Insert into booking values(?,?,?)";
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","Pari@123");
		java.sql.Date sqldate=new java.sql.Date(book.date.getTime());
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, book.passengerName);
		st.setInt(2, book.busNo);
		st.setDate(3, sqldate);
		st.executeUpdate();
}
}
