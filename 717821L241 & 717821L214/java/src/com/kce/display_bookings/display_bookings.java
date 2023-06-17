package com.kce.display_bookings;
import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
public class display_bookings {
	public void display_book()
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			//int flag=0;
			System.out.print("Enter the UserName: ");
			String username=sc.next();
			String query="select * from bookings where username='"+username+"'";
            Statement s=connection.createStatement();
            ResultSet row=s.executeQuery(query);
            System.out.println("\t--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\tUSERNAME\t||NAME\t\t||NO_OF_PERSON\t||DATE\t\t||TIME\t\t||MOVIE_NAME\t\t\t\t||PRICE\t\t");
            System.out.println("\t----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			if(row.next())
			{
					System.out.print("\t"+row.getString(1)+"\t\t||"+row.getString(2)+"\t\t||"+row.getInt(3)+"\t\t||"+row.getString(4)+"\t||"+row.getString(5)+"\t||"+row.getString(6)+"\t||"+row.getDouble(7)+"\n");
					System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println("\t\t\t\t-------------------------------");
                System.out.println("\t\t\t\tNo Booking available.....!!!!!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
