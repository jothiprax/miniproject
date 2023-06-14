package com.kce.e_bus_fare_payment.dao;

import com.kce.e_bus_fare_payment.bean.Payment;
import com.kce.e_bus_fare_payment.util.DBUtil;

import java.util.*;
import java.sql.*;

public class PaymentDAO extends Payment{
	public static void payBusFare() throws Exception{
		Payment pm=new Payment();
		System.out.println("Enter wallet ID of Receiver:");
		//This receiver ID can be scanned from QR of Bus Conductor
		Scanner sc=new Scanner(System.in);
		pm.setRecipientId(sc.nextInt());
		Connection con=DBUtil.getDBConnection();
		System.out.println("Enter Boarding place:");
		pm.setBoardingPoint(sc.nextLine());
		System.out.println("Enter Destination place");
		pm.setDestinationPoint(sc.nextLine());
		System.out.println("Enter bus fare:");
		pm.setBusFare(sc.nextInt());
		PreparedStatement pst=con.prepareStatement("insert into payment values(?,?,?,?)");
		pst.setString(1, pm.getBoardingPoint());
		pst.setString(2, pm.getDestinationPoint());
		pst.setInt(3, pm.getBusFare());
		pst.setString(4, pm.getBoardingPoint()+" to "+pm.getDestinationPoint());
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Wallet");
		st.executeUpdate("update wallet set walletBalance=rs.getInt(3)-pm.getBusFare() where walletId=pm.getSenderId()");
		System.out.println("Payment Done Successfully!");
	}

}
