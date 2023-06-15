package com.kce.e_bus_fare_payment.dao;

import java.sql.*;
import java.util.*;
import com.kce.e_bus_fare_payment.bean.BankAccount;
import com.kce.e_bus_fare_payment.util.*;

public class BankAccountDAO extends BankAccount{
	public static void addBankAccount(){
		Scanner sc=new Scanner(System.in);
		Connection con=DBUtil.getDBConnection();
		BankAccount ba=new BankAccount();sc.next();
		System.out.println("Enter Account number:");
		ba.setAccountNumber(sc.next());
		System.out.println("Enter Account Holder name:");
		ba.setAccountHolderName(sc.next());
		System.out.println("Enter mobile number:");
		ba.setMobileNumber(sc.next());
		ba.setBalance(10000);
		sc.close();
		try{
			if(ba.getAccountNumber().length()!=10) {
				throw new InvalidAccountNumber();
			}
		PreparedStatement pst=con.prepareStatement("insert into bankaccount values(?,?,?,?)");
		pst.setString(1,ba.getAccountNumber());
		pst.setString(2,ba.getAccountNumber());
		pst.setString(3, ba.getMobileNumber());
		pst.setInt(4, ba.getBalance());
		pst.execute();
		}catch(InvalidAccountNumber e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			
		}
		
	}

}
