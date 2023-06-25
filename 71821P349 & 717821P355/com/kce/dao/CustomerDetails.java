package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kce.bean.Customer;
import com.kce.util.JDBCConnection;
public class CustomerDetails extends Customer{
    public CustomerDetails(String name, int noOfPerson, String address, String phno) {
		super(name, noOfPerson, address, phno);
	}

	public CustomerDetails() {
		super();
	}
	  public void insert(String name,int noOfPerson,String address,String phno)throws Exception {
		  JDBCConnection jdbc =new JDBCConnection();
		  Connection con=jdbc.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Customer values(?,?,?,?)");
			ps.setString(1,name);
			ps.setInt(2,noOfPerson);
			ps.setString(3,address);
			ps.setString(4,phno);
		    ps.execute();
	    }
	  public void read() throws Exception {
		  JDBCConnection jdbc =new JDBCConnection();
	    	Connection con=jdbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			System.out.printf("%-20s%-20s%-20s%-20s\n","Name" , "NoOfPerson",  "Address" , "PhoneNumber");
			while(rs.next()) {
				System.out.printf("%-20s%-20s%-20s%-20s\n",rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			}
	    }
	  
}
