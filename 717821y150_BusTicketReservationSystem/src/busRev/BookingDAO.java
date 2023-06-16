package busRev;
import java.util.Date;
import java.sql.*;
public class BookingDAO {
	public int getBookedCount(int busNo,Date date )throws SQLException{
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con=databaseConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		st.setInt(1, busNo);
		st.setDate(2, sqldate);
		ResultSet rs=st.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	public void addBooking(booking book) throws SQLException{
		String query="Insert into booking values(?,?,?)";
		Connection con =databaseConnection.getConnection();
		java.sql.Date sqldate=new java.sql.Date(book.date.getTime());
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, book.passengerName);
		st.setInt(2, book.busNo);
		st.setDate(3, sqldate);
		st.executeUpdate();
	
	}
}
