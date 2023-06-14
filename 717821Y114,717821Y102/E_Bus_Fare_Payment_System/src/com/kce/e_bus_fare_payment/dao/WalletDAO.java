package com.kce.e_bus_fare_payment.dao;

import com.kce.e_bus_fare_payment.bean.Wallet;
import com.kce.e_bus_fare_payment.util.*;
import java.sql.*;

public class WalletDAO extends Wallet{
	
	public static void activateWallet()throws Exception{
		Wallet wt=new Wallet();
		Connection con=DBUtil.getDBConnection();
		PreparedStatement pst=con.prepareStatement("insert into wallet values('null',?,?)");
		wt.setWalletId(1001);
		wt.setWalletBalance(0);
		pst.setInt(1,wt.getWalletId());
		pst.setInt(2,wt.getWalletBalance());
		pst.execute();
		System.out.println("Wallet Activated Succcessfully!");
	}
	

}
