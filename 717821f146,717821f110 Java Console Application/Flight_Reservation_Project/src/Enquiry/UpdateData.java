package Enquiry;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionAirLine;
import java.sql.ResultSet;
import Main.MainBooking;
public class UpdateData {
	public static void register()throws SQLException {
		String query1="insert into customer values(?,?,?,?,?,?,?)";
		String query2="insert into CustomerPassport values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst1=ConnectionAirLine.connect().prepareStatement(query1);
		PreparedStatement pst2=ConnectionAirLine.connect().prepareStatement(query2);
		//table 1
		pst1.setString(1,MainBooking.passenger.getName());
		pst1.setString(2,MainBooking.passenger.getEducation());
		pst1.setString(3,MainBooking.passenger.getClasstype());
		pst1.setString(4,MainBooking.passenger.getBookId());
		pst1.setString(5,MainBooking.passenger.getFrom());
		pst1.setString(6,MainBooking.passenger.getDestination());
		pst1.setString(7,MainBooking.passenger.getBookId());
		//table 2
		pst2.setString(1,MainBooking.passenger.getCountry());
		pst2.setInt(2,MainBooking.passenger.getAge());
		pst2.setBoolean(3,MainBooking.passenger.isFIRs());
		pst2.setString(4,MainBooking.passenger.getVisaType());
		pst2.setString(5,MainBooking.passenger.getReligion());
		pst2.setString(6,MainBooking.passenger.getBookId());
		pst2.setString(7,MainBooking.passenger.getfName());
		pst2.setString(8,MainBooking.passenger.getmName());
		pst2.setDate(9,Date.valueOf(MainBooking.passenger.getDob()));
		pst1.executeUpdate();
		pst2.executeUpdate();
		ConnectionAirLine.connect().close();
		
	}
	public static void display(String id)throws SQLException {
		PreparedStatement st=ConnectionAirLine.connect().prepareStatement("select CustomerPassport.id,customer.cname,CustomerPassport.age,CustomerPassport.visaType,customer.classtype,customer.takeoff,customer.landing,CustomerPassport.FIR from customer inner join CustomerPassport on customerPassport.id=? and customer.id=?");
		st.setString(1,id);
		st.setString(2,id);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			System.err.println("register Id: "+rs.getString(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("Age  : "+rs.getInt(3));
			System.out.println("Visa-type :"+rs.getString(4));
			System.out.println("Class(Business\'Economy) :"+rs.getString(5));
			System.out.println("takeoff :"+rs.getString(6));
			System.out.println("Landing :"+rs.getString(7));
			System.out.println("CriminalRecord: "+rs.getBoolean(8));
		}
			ConnectionAirLine.connect().close();
	}
	public static boolean cancelation(String id)throws SQLException {
		PreparedStatement st=ConnectionAirLine.connect().prepareStatement("delete from customer where id=?");
		boolean test=st.execute("delete from customerPassport where id='"+id+"'");
		ConnectionAirLine.connect().close();
		return test;
	}
}
