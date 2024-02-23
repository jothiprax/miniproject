package KCE;

 
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

 
public class Add_products
{
  
 
static void addProduct (Connection conn, String id, String name,
			     double price) throws SQLException
  {
    
PreparedStatement stmt = null;
    
try
    {
      
stmt =
	conn.
	prepareStatement
	("insert into products(id, name, price)values(?, ?, ?)");
      
stmt.setString (1, id);
      
stmt.setString (2, name);
      
stmt.setDouble (3, price);
      
stmt.executeUpdate ();
      
System.out.println ("Product added successfully.");
    
} finally
    {
      
if (stmt != null)
	stmt.close ();
    
}
  
}

}
