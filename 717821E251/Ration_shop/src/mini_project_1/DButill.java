package mini_project_1;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
public class DButill 
{
  public static Connection getConnection() throws SQLException
  {

	return DriverManager.getConnection("jdbc:mysql://localhost:3306/ration_shop","root","sr@123");
  }
}
