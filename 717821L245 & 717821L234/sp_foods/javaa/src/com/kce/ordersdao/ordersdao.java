package com.kce.ordersdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.orders.orders;
public class ordersdao {
  public ordersdao()
  {
    
  }
  public boolean odetails(orders o)
  {
    try
    {
      Connection connection=com.kce.connection.connection.createConnection();
      String query="insert into customer values(?,?,?)";
      PreparedStatement p=connection.prepareStatement(query);
      p.setString(1, orders.getUsern());
      p.setString(2, orders.getItem());
      p.setInt(3,orders.getQty());
      int row=p.executeUpdate();
      if(row==0)
      {
        return false;
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return true;
  }
}
