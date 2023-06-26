package KCE;

 
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

 
public class Delete
{
  
static void deleteProduct (Connection conn, String id) throws SQLException,
    ProductNotFoundException
  {
    
PreparedStatement stmt = null;
    
try
    {
      
Retrive.getProduct (conn, id);
      
stmt = conn.prepareStatement ("delete from products where id=?");
      
stmt.setString (1, id);
      
int rows = stmt.executeUpdate ();
       
if (rows > 0)
	{
	  
System.out.println ("Product deleted successfully.");
	
}
      else
	{
	  
throw new ProductNotFoundException ("Product not found with ID: " +
					       id);
	
}
    
 
}
    finally
    {
      
if (stmt != null)
	stmt.close ();
    
}
  
}

}


