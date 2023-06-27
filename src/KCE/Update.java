package KCE;

 
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

 
public class Update
{
  
static void updateProduct (Connection conn, String id, String newName,
			      double newPrice) throws SQLException,
    ProductNotFoundException
  {
    
PreparedStatement stmt = null;
    
try
    {
      
Retrive.getProduct (conn, id);
      
stmt =
	conn.
	prepareStatement ("update products set name=?,price=? where id=?");
      
stmt.setString (1, newName);
      
stmt.setDouble (2, newPrice);
      
stmt.setString (3, id);
      
int rows = stmt.executeUpdate ();
       
if (rows > 0)
	{
	  
System.out.println ("Product updated successfully.");
	
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


