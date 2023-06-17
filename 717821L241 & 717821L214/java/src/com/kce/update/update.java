package com.kce.update;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import com.kce.bookings.bookings;
public class update {
	public update()
	{
		
	}
	public void updatenoofpersons(int noofpersons)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			String query1="update bookings set price=0.00";
			double price =noofpersons*250;
			String query="update bookings set no_of_persons="+noofpersons+",price="+price+" where username='"+username+"'";
			PreparedStatement s1=connection.prepareStatement(query1);
			PreparedStatement s=connection.prepareStatement(query);
            int row1=s1.executeUpdate();
            int row=s.executeUpdate();
            if(row!=0&&row!=0)
            {
            	System.out.println();
            	System.out.println("******SUCCESFULLY UPDATED******");
            }
            else
            {
            	System.out.println("******NOT UPDATED******");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updatemoviename(String moviename)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			String query="update bookings set moviename='"+moviename+"' where username='"+username+"'";
			PreparedStatement s=connection.prepareStatement(query);
            int row=s.executeUpdate();
            if(row!=0)
            {
            	System.out.println();
            	System.out.println("******SUCCESFULLY UPDATED******");
            }
            else
            {
            	System.out.println("******NOT UPDATED******");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updatedate(String date3)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter the UserName: ");
			String username=sc.next();
			String query="\tupdate bookings set date="+date3+" where username='"+username+"'";
			PreparedStatement s=connection.prepareStatement(query);
            int row=s.executeUpdate();
            if(row!=0)
            {
            	System.out.println();
            	System.out.println("******SUCCESFULLY UPDATED******");
            }
            else
            {
            	System.out.println("******NOT UPDATED******");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updatetime(String time)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			String query="update bookings set time='"+time+"' where username='"+username+"'";
			PreparedStatement s=connection.prepareStatement(query);
            int row=s.executeUpdate();
            if(row!=0)
            {
            	System.out.println();
            	System.out.println("******SUCCESFULLY UPDATED******");
            }
            else
            {
            	System.out.println("******NOT UPDATED******");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}