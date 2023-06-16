import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBase {
public static  Connection getConnection() throws SQLException, ClassNotFoundException{
	String a="root";
	String b="Harish1810@,";
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus",a,b);
	return con;
}
}
