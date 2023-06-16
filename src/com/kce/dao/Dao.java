package com.kce.dao;



	import java.util.*;
	import java.beans.Statement;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	//import com.kce.bean.Admin;
	import com.kce.bean.Bus;
	import com.kce.bean.Localbus;
	import com.kce.bean.Routebus;
	
	import com.kce.util.Connectivityclass;

	public class Dao {
	         //Admin a=new Admin();
	         public Dao()
	         {
	         }
	      
	         Bus b=new Bus();
	         Localbus lb=new Localbus();
	         Routebus rb=new Routebus();
	         Connectivityclass cc=new Connectivityclass();
	         public void registerKey(int key,String name,String password)
	         {
	        	 try
	        	 {
	        		 Connection con=Connectivityclass.createConnection();
	        		 String query ="insert into register(key,name,password)";
	        		 Statement ps= (Statement) con.prepareStatement(query);
	        		ps.execute();
	        		
	        		 
	        	 }
	        	 catch(Exception e)
	        	 {
	        		 e.printStackTrace();
	        	 }
	         }
	         public int checkKey(int key1,String password)
	         {
	        	 int kl=0;
	        	 try
	        	 {
	        		 Connection con=Connectivityclass.createConnection();
	        		 String query="select password from register where key=?";
	        		 PreparedStatement ps1= con.prepareStatement(query);
	        		 ps1.setInt(1,key1);
	        		 ResultSet rs=ps1.executeQuery();
	        		 String pass=rs.getString(1);
	        		 if(pass.equals(password))
	        			  kl=1;
	        		 else 
	        			 kl=0;
	        		
	        	 }
	        	 catch(Exception e)
	        	 {
	        		 e.printStackTrace();
	        	 }
	        	 return kl;
	         }
		    public void updateLocal()
		    {
		    	String newbusStand=lb.getMainBusStand();
		    	String busNum=lb.getBusNumber();
		    	String query="update localBus set mainBusStand= ? where busNumber= ?";
		    	try
		    	{
		    	Connection con=Connectivityclass.createConnection();
		    	PreparedStatement ps2=con.prepareStatement(query);
		    	ps2.setString(1,newbusStand);
		    	ps2.setString(2,busNum);
		    	ps2.execute();
		    	System.out.println("updated sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    }
		    public void deleteLocal()
		    {
		    	String busNum=lb.getBusNumber();
		    	String query=" delete from localBus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps3=con.prepareStatement(query);
		    		ps3.setString(1,busNum);
		    		ps3.execute();
		    		System.out.println("deleted sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void insertLocal()
		    {
		    	String query ="insert into localBus values(?,?,?,?,?,?,?,?)";
		    	try{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps4=con.prepareStatement(query);
		    		ps4.setString(1,lb.getBusName());
		    		ps4.setString(2,lb.getBusNumber());
		    		ps4.setDouble(3,lb.getDepTiming());
		    		ps4.setDouble(4,lb.getArrTiming());
		    		ps4.setString(5,lb.getRoute());
		    		ps4.setString(6,lb.getStartingPlace());
		    		ps4.setString(7,lb.getEndingPlace());
	          		ps4.setString(8,lb.getMainBusStand());
	          		ps4.execute();
	          		System.out.println("Inserted sucessfully");
	          		
		    		
		    		
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void displayLocal()
		    {
		    	String query="select * from localBus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps5=con.prepareStatement(query);
		    		ps5.setString(1,lb.getBusNumber());
		    		ResultSet rst =ps5.executeQuery();
		    		while(rst.next())
		    		{
		    			System.out.println("NAME = "+rst.getString(1));
		    			System.out.println("NUMBER = "+rst.getString(2));
		    			System.out.println("DEPARTURE TIME = "+rst.getDouble(3));
		    			System.out.println("ARRIVAL TIME = "+rst.getDouble(4));
		    			System.out.println("ROUTE = "+rst.getString(5));
		    			System.out.println("STARTING PLACE = "+rst.getString(6));
		    			System.out.println("ENDING PLACE = "+rst.getString(7));
		    			System.out.println("MAIN BUS STAND = "+rst.getString(8));

		    			
		    		}

		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		 
		       public void updateRoute()
		    {
		    	Double newreturntime=rb.getReturnTime();
		    	String busNum=rb.getBusNumber();
		    	String query="update routeBus set returntime= ? where busNumber= ?";
		    	try
		    	{
		    	Connection con=Connectivityclass.createConnection();
		    	PreparedStatement ps2=con.prepareStatement(query);
		    	ps2.setDouble(1,newreturntime);
		    	ps2.setString(2,busNum);
		    	ps2.execute();
		    	System.out.println("updated sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    }
		    public void deleteRoute()
		    {
		    	String busNum=lb.getBusNumber();
		    	String query=" delete from routeBus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps3=con.prepareStatement(query);
		    		ps3.setString(1,busNum);
		    		ps3.execute();
		    		System.out.println("deleted sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void insertRoute()
		    {
		    	String query ="insert into localBus values(?,?,?,?,?,?,?,?)";
		    	try{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps4=con.prepareStatement(query);
		    		ps4.setString(1,rb.getBusName());
		    		ps4.setString(2,rb.getBusNumber());
		    		ps4.setDouble(3,rb.getDepTiming());
		    		ps4.setDouble(4,rb.getArrTiming());
		    		ps4.setString(5,rb.getRoute());
		    		ps4.setString(6,rb.getStartingPlace());
		    		ps4.setString(7,rb.getEndingPlace());
	          		ps4.setDouble(8,rb.getReturnTime());
	          		ps4.execute();
	          		System.out.println("Inserted sucessfully");
	          		
		    		
		    		
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void displayRoute()
		    {
		    	String query="select * from localBus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps5=con.prepareStatement(query);
		    		ps5.setString(1,lb.getBusNumber());
		    		ResultSet rst =ps5.executeQuery();
		    		while(rst.next())
		    		{
		    			System.out.println("NAME = "+rst.getString(1));
		    			System.out.println("NUMBER = "+rst.getString(2));
		    			System.out.println("DEPARTURE TIME = "+rst.getDouble(3));
		    			System.out.println("ARRIVAL TIME = "+rst.getDouble(4));
		    			System.out.println("ROUTE = "+rst.getString(5));
		    			System.out.println("STARTING PLACE = "+rst.getString(6));
		    			System.out.println("ENDING PLACE = "+rst.getString(7));
		    			System.out.println("RETURN TIME = "+rst.getDouble(8));

		    			
		    		}

		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void updateBus()
		    {
		    	String newroute=b.getRoute();
		    	String busNum=rb.getBusNumber();
		    	String query="update Bus set route= ? where busNumber= ?";
		    	try
		    	{
		    	Connection con=Connectivityclass.createConnection();
		    	PreparedStatement ps2=con.prepareStatement(query);
		    	ps2.setString(1,newroute);
		    	ps2.setString(2,busNum);
		    	ps2.execute();
		    	System.out.println("updated sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    }
		    public void deleteBus()
		    {
		    	String busNum=b.getBusNumber();
		    	String query=" delete from Bus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps3=con.prepareStatement(query);
		    		ps3.setString(1,busNum);
		    		ps3.execute();
		    		System.out.println("deleted sucessfully");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void insertBus()
		    {
		    	String query ="insert into Bus values(?,?,?,?,?,?,?,?)";
		    	try{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps4=con.prepareStatement(query);
		    		ps4.setString(1,b.getBusName());
		    		ps4.setString(2,b.getBusNumber());
		    		ps4.setDouble(3,b.getDepTiming());
		    		ps4.setDouble(4,b.getArrTiming());
		    		ps4.setString(5,b.getRoute());
		    		ps4.setString(6,b.getStartingPlace());
		    		ps4.setString(7,b.getEndingPlace());
	          		ps4.execute();
	          		System.out.println("Inserted sucessfully");
	          		
		    		
		    		
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		    public void displayBus()
		    {
		    	String query="select * from Bus where busNumber=?";
		    	try
		    	{
		    		Connection con=Connectivityclass.createConnection();
		    		PreparedStatement ps5=con.prepareStatement(query);
		    		ps5.setString(1,b.getBusNumber());
		    		ResultSet rst =ps5.executeQuery();
		    		while(rst.next())
		    		{
		    			System.out.println("NAME = "+rst.getString(1));
		    			System.out.println("NUMBER = "+rst.getString(2));
		    			System.out.println("DEPARTURE TIME = "+rst.getDouble(3));
		    			System.out.println("ARRIVAL TIME = "+rst.getDouble(4));
		    			System.out.println("ROUTE = "+rst.getString(5));
		    			System.out.println("STARTING PLACE = "+rst.getString(6));
		    			System.out.println("ENDING PLACE = "+rst.getString(7));
		    		

		    			
		    		}

		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		   
		
		 
		
}