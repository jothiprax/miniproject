package Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionAirLine {
	public static Connection connect;
	public static Connection connect()throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/airLine";
		String name="root";
		String pass="sanjayss";
		connect=DriverManager.getConnection(url,name,pass);
		return connect;
	}
}
