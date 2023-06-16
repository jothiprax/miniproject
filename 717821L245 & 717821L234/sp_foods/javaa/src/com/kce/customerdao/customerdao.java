package com.kce.customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.customer.customer;

public class customerdao {
	public customerdao()
	  {
	    
	  }
	  public boolean cdetails(customer c)
	  {
	    try
	    {
	      Connection connection=com.kce.connection.connection.createConnection();
	      String query="insert into customer values(?,?,?,?,?,?)";
	      PreparedStatement p1=connection.prepareStatement(query);
	      p1.setString(1, customer.getUsername());
	      p1.setString(2, customer.getPassword());
	      p1.setString(3, customer.getName());
	      p1.setInt(4,customer.getAge());
	      p1.setLong(5, customer.getMobile_no());
	      p1.setString(6, customer.getAddress());
	      int row=p1.executeUpdate();
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