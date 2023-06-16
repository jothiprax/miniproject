package busreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
            private static final String url="jdbc:mysql://localhost:3306/busdetails";
            private static final String userName="root";
            private static final String password="123";
            public static Connection getconnection() throws SQLException
            {
            	return DriverManager.getConnection(url,userName,password);
            	
            }
}
