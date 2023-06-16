package com.kce.bookingsdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import com.kce.connection.connection;
import com.kce.bookings.bookings;
public class bookingsdao {
	public bookingsdao()
	{
		
	}
	public boolean book(bookings booking)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			double price;
			String query="insert into bookings(username,name,no_of_persons,date,time,moviename,price) values(?,?,?,?,?,?,?)";
			PreparedStatement p=connection.prepareStatement(query);
			p.setString(1, bookings.getUsername());
			p.setString(2,bookings.getName());
			p.setInt(3,bookings.getNo_of_persons());
			p.setString(4,bookings.getDate());
			p.setString(5,bookings.getTime());
			p.setString(6,bookings.getMoviename());
			price=bookings.getNo_of_persons()*250;
			p.setDouble(7,price);
			int row=p.executeUpdate();
			if(row==0)
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}