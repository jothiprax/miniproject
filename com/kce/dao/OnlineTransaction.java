package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.kce.bean.TransferBean;
import com.kce.util.DButil;

public class OnlineTransaction {
	Set<String> setacno=new HashSet<>();
public String GetSeqNo()
{
	// Generate Sequence number
	String id="";
	try {
		Random r=new Random();
		id = String.format("%04d", r.nextInt(10000));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return id;
}
public void deposit(String acno,float amt)
{
	try {
		//deposit query
		Connection con=DButil.getDBConnection();
		PreparedStatement pst=con.prepareStatement("select balance from BANK where acno=(?)");
		pst.setString(1, acno);
		ResultSet rs=pst.executeQuery();
		float oldbal=0.0f;
		float newbal=0.0f;
		while(rs.next())
		{
		 oldbal=Float.parseFloat(rs.getString(1));
		 newbal=oldbal+amt;
		}
        pst=con.prepareStatement("update BANK set balance=(?) where acno=(?)");
        pst.setString(1, String.valueOf(newbal));
        pst.setString(2,acno);
        pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public void withdraw(String acno,float amt)
{
	try {
		//withdraw query
		Connection con=DButil.getDBConnection();
		PreparedStatement pst=con.prepareStatement("select balance from BANK where acno=(?)");
		pst.setString(1, acno);
		ResultSet rs=pst.executeQuery();
		float oldbal=0.0f;
		float newbal=0.0f;
		while(rs.next())
		{
		 oldbal=Float.parseFloat(rs.getString(1));
		 newbal=oldbal-amt;
		}
        pst=con.prepareStatement("update BANK set balance=(?) where acno=(?)");
        pst.setString(1, String.valueOf(newbal));
        pst.setString(2,acno);
        pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public boolean ValidateAcc(String acno)
{
	//validate account number
	try {
		Connection con=DButil.getDBConnection();
		PreparedStatement pst=con.prepareStatement("select * from BANK");
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
        	setacno.add(rs.getString(1));
        }
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	if(setacno.contains(acno))
	return true;
	else
	return false;
}
public float findBal(String acno)
{
	//find balance
	try {
		Connection con=DButil.getDBConnection();
		PreparedStatement pst=con.prepareStatement("select * from BANK");
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
        	if(rs.getString(1).equals(acno))
        	{
        		return Float.parseFloat(rs.getString(3));
        	}
        }
        
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return 0.0f;
}
public  boolean TransferMoney(TransferBean t)
{	
	// Transaction query
	try {
	Connection con=DButil.getDBConnection();
	PreparedStatement pst=con.prepareStatement("insert into TRANSFER values(?,?,?,?,?)");
	pst.setString(1, t.getTraid());
	pst.setString(2, t.getFromacno());
	pst.setString(3, t.getToacno());
	pst.setString(4, t.getDate());
	pst.setString(5, t.getAmt());
	pst.executeUpdate();
	withdraw(t.getFromacno(),Float.parseFloat(t.getAmt()));
	deposit(t.getToacno(),Float.parseFloat(t.getAmt()));
     }
     catch(Exception e)
     {
	
     }
	return true;
}
}