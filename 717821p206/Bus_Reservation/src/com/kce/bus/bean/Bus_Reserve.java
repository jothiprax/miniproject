package com.kce.bus.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kce.bus.util.DButil;

public class Bus_Reserve {

	public int Bus_No;
	public String Bus_Name;
	public String Driver_Name;
	public int Capacity;
	public String Acc_NonAc;

	public void getReserve() {
		Connection con=DButil.getConnection();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select *from Bus_Details");
			ResultSet rs =pst.executeQuery();
			System.out.println("Bus Details:");
			System.out.printf("%-10s%-20s%-20s%-10s%-10s\n","Bus_No","Bus_Name","Driver_Name","Capacity","Ac_NonAc");
			while(rs.next())
			{
				System.out.printf("%-10s%-20s%-20s%-10s%-10s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
						}
	       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
