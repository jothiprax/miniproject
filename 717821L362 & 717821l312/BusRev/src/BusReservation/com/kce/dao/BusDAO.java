package BusReservation.com.kce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusReservation.DBconnection;

public class BusDAO {
	 public void displayBusInfo() throws SQLException{
	    	String query ="select * from bus";
	    Connection con=DBconnection.getConnection();
	    Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery(query);
	    System.out.println("Bus No\t AC\tCapacity");
	   // System.out.println("");
	    while(rs.next()) {
	    	System.out.println(" "+rs.getInt(1)+" \t "+rs.getString(2)+"\t   "+rs.getInt(3));
	    	
	    	/*System.out.println("Bus No: "+ rs.getInt(1));
	    	if(rs.getInt(2)==0)
	    		System.out.println("AC: no ");
	    	else
	    		System.out.println("AC: yes ");
	    	System.out.println("Capacity: "+rs.getInt(3));*/
	    }
	    System.out.println("----------------------------------");
	    }
	    
	    public int getCapacity(int id)throws SQLException{
	    	String query="select capacity from bus where id=" +id;
	    	Connection con=DBconnection.getConnection();
	    	Statement st=con.createStatement();
	        ResultSet rs=st.executeQuery(query);
	        rs.next();
	        return rs.getInt(1);
	    }
}
