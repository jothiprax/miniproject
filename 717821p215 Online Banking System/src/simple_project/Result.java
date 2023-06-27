
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Result //throws SQLException

{
	public void printResult()
	{
	try
	{
	Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root", "pass");
	PreparedStatement statement=connection1.prepareStatement("select * from accounts");
	ResultSet rs= statement.executeQuery();
	while(rs.next())
	{
		System.out.println(rs.getString(0) +" " +rs.getString(1)+" " + rs.getInt(2));
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
