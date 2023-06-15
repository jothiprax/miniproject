package com.kce.e_bus_fare_payment.service;

import java.sql.*;
import java.util.*;
import com.kce.e_bus_fare_payment.util.DBUtil;

public class AddMoneyToWallet {
	public static void addMoneyToWallet() throws Exception{
		
		Scanner sn=new Scanner(System.in);
		Connection con=DBUtil.getDBConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Wallet");
		System.out.println("Enter amount to be added in Wallet");
		int amount=sn.nextInt();
		st.execute("UPDATE Wallet SET balance="+amount+rs.getInt(3)+" where walletId="+rs.getInt(2));
		System.out.println("Money Added to Wallet");
	}

}
