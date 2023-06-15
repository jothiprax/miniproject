package COLAB;
import java.sql.*;

public class FlightDAO {
	public void displayBusInfo() throws SQLException {
		String query = "Select * from Flight";
		Connection con = Main.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("'Welcome to FLIGHT RESERVATION SYSTEMS'\n\nAVAILABLE FLIGHTS:");
		while(rs.next()) {
			System.out.println("Flight_No: " + rs.getInt(1)+"| Flight_Name: "+rs.getString(2)+"| Capacity: " + rs.getInt(3));
		}
		System.out.println("********************************************************************************");
	}
	public int getCapacity(int id) throws SQLException {
		String query = "Select capacity from Flight";
		Connection con = Main.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}