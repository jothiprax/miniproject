package busRev;
import java.sql.*;
public class databaseConnection {

	private static final String url="jdbc:mysql://localhost:3306/busReservation";
	private static final String userName="root";
	private static final String password="Eagle_&$2004";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,userName,password);
		
	}

}
