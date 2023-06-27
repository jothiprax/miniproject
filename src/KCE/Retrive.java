package KCE;

 
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

 
public class Retrive
{
  
 
static Product getProduct (Connection conn,
				String id) throws SQLException,
    ProductNotFoundException
  {
    
PreparedStatement stmt = null;
    
ResultSet rs = null;
    
try
    {
      
stmt = conn.prepareStatement ("select * from products where id=?");
      
stmt.setString (1, id);
      
rs = stmt.executeQuery ();
      
if (rs.next ())
	{
	  
String productId = rs.getString ("id");
	  
String name = rs.getString ("name");
	  
double price = rs.getDouble ("price");
	   
Product product = new Product (productId, name, price);
	   
return product;
	 
}
      else
	{
	  
throw new ProductNotFoundException ("Product not found with ID: " +
					       id);
	
}
    
}
    finally
    {
      
if (rs != null)
	rs.close ();
      
if (stmt != null)
	stmt.close ();
    
}
  
}

}
