package demojdc;
import java.sql.*;
public class jdbcconnection {
public static void main(String args[]) throws Exception
{
	try
	{

	Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc","root","Deepika@123");
	Statement st=c.createStatement();

ResultSet rs=st.executeQuery("select * from student;");
while(rs.next())
{
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
}
	System.out.println("hdsfghdcd");
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
	
}
