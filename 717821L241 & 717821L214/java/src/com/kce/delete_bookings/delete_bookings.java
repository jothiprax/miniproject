package com.kce.delete_bookings;
import java.sql.*;
import java.util.Scanner;
import com.kce.accounts.accounts;
import com.kce.bookings.bookings;
public class delete_bookings {
	public boolean delete_book()
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			String query="delete from bookings where username='"+username+"'";
            PreparedStatement s=connection.prepareStatement(query);
            int row=s.executeUpdate();
			if(row!=0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
