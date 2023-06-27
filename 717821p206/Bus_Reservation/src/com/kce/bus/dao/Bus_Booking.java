package com.kce.bus.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.kce.bus.util.DButil;
public class Bus_Booking {
	String Passenger_name;
	String City_Name;
	int BusNo;
	java.sql.Date date;
	public int userOption=1;
	Scanner sc=new Scanner(System.in);
	public void getBooking() {
	while(userOption==1)
	{
		System.out.println("You want Booking enter 1 or else enter 2 : ");
		int userOption=sc.nextInt(); 
		sc.nextLine();
		if(userOption==2)
		{
			break;
		}
		if(userOption==1)
		{
			System.out.println("Welcome to Bus Booking.....");
			System.out.println("Enter your Details....");
			System.out.println("Enter your name");
			String Passenger_name=sc.nextLine();
			System.out.println("Enter your Travel date");
			String Travel_Date=sc.next();
			sc.nextLine();
			System.out.println("Enter city name");
			String City_Name=sc.nextLine();
			System.out.println("Enter Bus No");
			int BusNo=sc.nextInt();
			
			
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
			try {
				date = new java.sql.Date(dateFormat.parse(Travel_Date).getTime());
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}
			Connection con=DButil.getConnection();
			PreparedStatement pst;
			try {
				pst = con.prepareStatement("select Capacity from Bus_Details where Bus_No = ?");
				pst.setInt(1, BusNo);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					int capacity=rs.getInt(1);
					//System.out.println(BusNo);
					if(capacity != 0)
					{
						
						pst = con.prepareStatement("update Bus_Details set Capacity=? where Bus_No=?");
						//capacity -= 1;
						pst.setInt(1,capacity-1);
						pst.setInt(2,BusNo);
						pst.executeUpdate();
						pst = con.prepareStatement("insert into Booking values(?,?,?,?)");
						pst.setString(1,Passenger_name);
						pst.setDate(2, date);
						pst.setString(3,City_Name);
						pst.setInt(4,BusNo);
						pst.executeUpdate();
					}
					else {
						System.out.println("Seats are not available...Please book another bus or another Date");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			 
		 
	}

	}

}
