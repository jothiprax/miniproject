package Enquiry;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionAirLine;
public class CheckLoginInfo {
	public static boolean validRegister(String name,String id) throws SQLException {
		Statement stmt=ConnectionAirLine.connect().createStatement();
		ResultSet rs=stmt.executeQuery("select customer.cname,CustomerPassport.id from customer inner join CustomerPassport on customer.cname='"+name+"' and CustomerPassport.id='"+id+"'" );
		int flag=0;
		while(rs.next()) {
			if((rs.getString(1)+"").equals(name) && (rs.getString(2)+"").equals(id)) {
				flag=1;
				}
			}
		ConnectionAirLine.connect().close();
			if(flag==1)
				return true;
			else
				return false;
	}
}
