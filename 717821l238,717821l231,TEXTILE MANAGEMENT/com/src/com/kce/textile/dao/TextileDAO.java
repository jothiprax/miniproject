package com.kce.textile.dao;
import com.kce.textile.util.*;


import java.sql.*;
import java.sql.Date;
import java.util.*;
public class TextileDAO 
{
	
		public static boolean createDetailTable()
		{
			try
			{
			Connection connect=DBUtil.createConnection();
			Statement s=connect.createStatement();
			String query="create table tex(Transaction_id int PRIMARY KEY,Date date,Details varchar(20) NULL,Brand_Name varchar(20) NULL,Quality varchar(20) NULL,In_Yarn_kg double(9,2) NULL,Out_Yarn_kg double(9,2) NULL,Balance_Yarn double(9,2) NULL,In_Warp_meter double(9,2) NULL,Out_Warp_meter double(9,2) NULL,Balance_Meter double(9,2) NULL)";
			int row=s.executeUpdate(query);
			System.out.println(row);
			if(row==0)
				return false;
			else
				return true;
			}
			catch(Exception e)
			{
				//System.out.println(e);
			}
			return false;
		}
		public static boolean createAmountTable()
		{
			try
			{
			Connection connect=DBUtil.createConnection();
			Statement s=connect.createStatement();
			String query="create table Amount(Transaction_id int PRIMARY KEY,Debit double(9,2) NULL,Credit double(9,2) NULL,Balance double(9,2) NULL,CGST double(9,2),SGST double(9,2),Final_Amount double(9,2),Total double(9,2))";
			int row=s.executeUpdate(query);  
			if(row==0)
				return false;
			else
				return true;
			}
			catch(Exception e)
			{
				//System.out.println(e);
			}
			return false;
		}
		public static  boolean insertTextile_Warp()
		{
			try
			{
				Scanner sc=new Scanner(System.in);
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				double am=0;
				ResultSet r1=s.executeQuery("select * from Amount");
				double Total=0.00;
				while(r1.next())
				{
					if(r1.getDouble(4)!=0.00)
						am=r1.getDouble(4);
					else
						am=0.00;
					if(r1.getDouble(8)!=0.00)
					    Total=r1.getDouble(8);
					else
						Total=0.00;
				}
				r1.close();
				ResultSet r=s.executeQuery("select * from tex");
				int i=0;
				double balmtr=0;
				double balkg=0;
				while(r.next())
				{
					i=r.getInt(1);
					if(r.getDouble(11)!=0.00)
							balmtr=r.getDouble(11);
					else
						balmtr=0.00;
					if(r.getDouble(8)!=0.00)
					      balkg=r.getDouble(8);
					else
						balkg=0.00;
				}
				r.close();
				System.out.println("Enter the Date:");
				String da=sc.nextLine();
				System.out.println("Enter the Warp Detail:");
				String s1=sc.nextLine();
				System.out.println("Enter the Warp Meter:");
				double warp_mtr=sc.nextDouble();
				String query1="insert into tex(Transaction_id,Date,Details,Balance_Yarn,In_Warp_Meter,Balance_Meter)values("+(i+1)+",'"+da+"','"+s1+"',"+balkg+","+warp_mtr+","+(balmtr+warp_mtr)+")";
				String query2="insert into Amount(Transaction_id,Balance,Total)values("+(i+1)+","+am+","+Total+")";
				s.executeUpdate(query2);
				int row=s.executeUpdate(query1);
				if(row==0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}
		public static  boolean insertTextile_Yarn()
		{
			try
			{
				System.out.println("Enter the Yarn Details to be added");
				Scanner sc=new Scanner(System.in);
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				ResultSet r1=s.executeQuery("select * from Amount");
				double am=0;
				double Total=0;
				while(r1.next())
				{
					if(r1.getDouble(4)!=0.00)
						am=r1.getDouble(4);
					else
						am=0.00;
					if(r1.getDouble(8)!=0.00)
						Total=r1.getDouble(8);
					else
						Total=0.00;
				}
				r1.close();
				int i=0;
				double balkg=0;
				double balmtr=0;
				ResultSet r=s.executeQuery("select * from tex");
				while(r.next())
				{
					i=r.getInt(1);
					if(r.getDouble(11)!=0.00)
							balmtr=r.getDouble(11);
					else
						balmtr=0.00;
					if(r.getDouble(8)!=0.00)
					      balkg=r.getDouble(8);
					else
						balkg=0.00;
			
				}
				r.close();
				System.out.println("Enter the Date:");
				String da=sc.nextLine();
				System.out.println("Enter the Details about the Yarn");
				String s1=sc.nextLine();
				System.out.println("Enter the Brand Name");
				String s2=sc.nextLine();
				System.out.println("Enter the Quality Type");
				String s3=sc.nextLine();
				System.out.println("Enter the Kg:");
				double is_mtr=sc.nextDouble();
				String query1="insert into tex(Transaction_id,Date,Details,Brand_name,Quality,In_Yarn_kg,Balance_Yarn,Balance_Meter)values("+(i+1)+",'"+da+"','"+s1+"','"+s2+"','"+s3+"',"+is_mtr+","+(balkg+is_mtr)+","+(balmtr)+")";
				String query2="insert into Amount(Transaction_id,Balance,Total)values("+(i+1)+","+am+","+Total+")";
				s.executeUpdate(query2);
				int row=s.executeUpdate(query1);
				if(row==0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}
		public static  boolean insertMeter()
		{
			try
			{
			System.out.println("Enter the Meter Details to be added");
			Scanner sc=new Scanner(System.in);
			Connection connect=DBUtil.createConnection();
			Statement s=connect.createStatement();
			ResultSet r1=s.executeQuery("select * from Amount");
			double am=0;
			double final_amount=0.00;
			while(r1.next())
			{
				if(r1.getDouble(4)!=0.00)
					am=r1.getDouble(4);
				else
					am=0.00;
				if(r1.getDouble(8)!=0.00)
					final_amount=r1.getDouble(8);
				else
					final_amount=0.00;
			}
			r1.close();
			ResultSet r=s.executeQuery("select * from tex");
			int i=0;
			double balkg=0;
			double balmtr=0;
			while(r.next())
			{
			
				i=r.getInt(1);
				if(r.getDouble(11)!=0.00)
						balmtr=r.getDouble(11);
				else
					balmtr=0.00;
				if(r.getDouble(8)!=0.00)
				      balkg=r.getDouble(8);
				else
					balkg=0.00;
			}
			r.close();
			System.out.println("Enter the Date:");
			String da=sc.nextLine();
			System.out.println("Enter the Details about the Meter");
			String s1=sc.nextLine();
			System.out.println("Enter the Meter");
			double out_mtr=sc.nextDouble();
			double final_mtr=balmtr-out_mtr;
			System.out.println("Enter the pic value");
			double pic_value=sc.nextDouble();
			double out_kg=out_mtr*(pic_value/1000);
			double final_kg=balkg-out_kg;
			System.out.println("Enter the pic rate");
			double rate=sc.nextDouble();
			double out_am=out_mtr*rate;
			double final_am=am+(out_mtr*rate);
			double cgst=out_am*0.025;
			double sgst=out_am*0.025;
			double final_=out_am+cgst+sgst;
			double Total=final_+final_amount;
			String query1="insert into tex(Transaction_id,Date,Details,Out_Yarn_kg,Balance_Yarn,Out_Warp_meter,Balance_Meter)values("+(i+1)+",'"+da+"','"+s1+"',"+out_kg+","+final_kg+","+out_mtr+","+final_mtr+")";
			String query2="insert into Amount(Transaction_id,Credit,Balance,CGST,SGST,Final_Amount,Total)values("+(i+1)+","+out_am+","+final_am+","+sgst+","+sgst+","+final_+","+Total+")";
			s.executeUpdate(query2);
			int row=s.executeUpdate(query1);
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public static void ad(double bal_yarn,double update_kg,int j)
	{
			try
			{
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				//System.out.println(j);
				s.execute("update tex set Balance_Yarn="+(bal_yarn+update_kg)+"where Transaction_id="+j);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public static boolean update_Yarn()
	{
		
		try
		{
		Scanner sc=new Scanner(System.in);
		Connection connect=DBUtil.createConnection();
		Statement s=connect.createStatement();
		System.out.println("Enter the Trasaction on the event to be updated");
		int t_id=sc.nextInt();
		ResultSet r1=s.executeQuery("select * from tex where Transaction_id="+t_id);
		double ddd=0;
		while(r1.next())
		{
			ddd=r1.getDouble(6);
		}
		r1.close();
		double update_kg1=sc.nextDouble();
		double update_kg=update_kg1-ddd;
		s.executeUpdate("update tex set In_Yarn_kg="+update_kg1+" where Transaction_id="+t_id);
		ResultSet r=s.executeQuery("select * from tex where Transaction_id>="+t_id);
		int j=t_id;
		while(r.next())
		{
			double bal_yarn=r.getDouble(8);
			ad(bal_yarn,update_kg,t_id++);
			//s.execute("update tex set Balance_Yarn="+(bal_yarn+update_kg)+"where Transaction_id="+(j++));
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public static void ad1(double bal_yarn,double update_kg,int j)
	{
			try
			{
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				System.out.println(bal_yarn+" "+update_kg);
				s.execute("update tex set Balance_Meter="+(bal_yarn+update_kg)+"where Transaction_id="+j);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public static boolean update_Warp()
	{
		
		try
		{
		Scanner sc=new Scanner(System.in);
		Connection connect=DBUtil.createConnection();
		Statement s=connect.createStatement();
		System.out.println("Enter the Trasaction on the event to be updated");
		int t_id=sc.nextInt();
		ResultSet r1=s.executeQuery("select * from tex where Transaction_id="+t_id);
		double ddd=0;
		while(r1.next())
		{
			ddd=r1.getDouble(9);
		}
		r1.close();
		System.out.println("Enter the warp meter");
		double update_kg1=sc.nextDouble();
		double update_kg=update_kg1-ddd;
		s.executeUpdate("update tex set In_Warp_meter="+update_kg1+" where Transaction_id="+t_id);
		ResultSet r=s.executeQuery("select * from tex where Transaction_id>="+t_id);
		int j=t_id;
		while(r.next())
		{
			double bal_yarn=r.getDouble(11);
			ad1(bal_yarn,update_kg,t_id++);
			//s.execute("update tex set Balance_Yarn="+(bal_yarn+update_kg)+"where Transaction_id="+(j++));
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public static void ad3(double bal_meter,double update_totalmeter,double bal_kg,double updatekg,double t_id)
	{
			try
			{
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				//System.out.println(j);
				System.out.println(bal_meter+"  "+update_totalmeter);
				s.execute("update tex set Balance_Meter="+(bal_meter-update_totalmeter)+"where Transaction_id="+t_id);
				s.execute("update tex set Balance_Yarn="+(bal_kg-updatekg)+"where Transaction_id="+t_id);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public static void ad4(double bal,double newbalance,double tot,double balancediff,double t_id)
	{
			try
			{
				Connection connect=DBUtil.createConnection();
				Statement s=connect.createStatement();
				//System.out.println(bal+" "+newbalance);
				//System.out.println(tot+" "+balancediff);
				s.execute("update Amount set Balance="+(bal+newbalance)+"where Transaction_id="+t_id);
				s.execute("update Amount set Total="+(tot+balancediff)+"where Transaction_id="+t_id);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public static boolean update_Meter()
	{
		
		try
		{
		Scanner sc=new Scanner(System.in);
		Connection connect=DBUtil.createConnection();
		Statement s=connect.createStatement();
		System.out.println("Enter the Trasaction on the event to be updated");
		int t_id=sc.nextInt();
		ResultSet r1=s.executeQuery("select * from tex where Transaction_id="+t_id);
		double outwarp=0,outyarnkg=0.00;
		while(r1.next())
		{
			outyarnkg=r1.getDouble(7);
			outwarp=r1.getDouble(10);
		}
		r1.close();
		ResultSet r2=s.executeQuery("select * from Amount where Transaction_id="+t_id);
		double credit=0,finalamount=0.00;
		while(r2.next())
		{
			credit=r2.getDouble(3);
			finalamount=r2.getDouble(7);
		}
		r2.close();
		System.out.println("Enter the Updated Meter");
		double update_meter=sc.nextDouble();
		System.out.println("Enter the pic of new Meter");
		double pic=sc.nextDouble();
		double newoutkg=update_meter*(pic/1000);
		double updatekg=newoutkg-outyarnkg;
		System.out.println("Enter the pic rate");
		double rate=sc.nextDouble();
		double newcredit=update_meter*rate;
		double cgst=newcredit*0.025;
		double sgst=newcredit*0.025;
		double final_am=cgst+sgst+newcredit;
		double newbalance=newcredit-credit;
		double balancediff=final_am-finalamount;
		s.executeUpdate("update Amount set Credit="+newcredit+"where Transaction_id="+t_id);
		s.executeUpdate("update Amount set CGST="+cgst+"where Transaction_id="+t_id);
		s.executeUpdate("update Amount set SGST="+sgst+"where Transaction_id="+t_id);
		s.executeUpdate("update Amount set Final_Amount="+final_am+"where Transaction_id="+t_id);
		//s.executeUpdate("update tex set ="+newoutkg+"where Transaction_id="+t_id);
		s.executeUpdate("update tex set Out_Yarn_kg="+newoutkg+"where Transaction_id="+t_id);
		double update_totalmeter=update_meter-outwarp;
		s.executeUpdate("update tex set Out_Warp_meter="+update_meter+" where Transaction_id="+t_id);
		ResultSet r=s.executeQuery("select * from tex where Transaction_id>="+t_id);	
		double j=t_id;
		while(r.next())
		{
			System.out.println(t_id);
			double bal_meter=r.getDouble(11);
			double bal_kg=r.getDouble(8);
			ad3(bal_meter,update_totalmeter,bal_kg,updatekg,t_id++);
			
		}	
		r.close();
		ResultSet rr=s.executeQuery("select * from Amount where Transaction_id>="+j);
		System.out.println("dh");
		while(rr.next())
		{
			//System.out.println("amount");
			double bal=rr.getDouble(4);
			double tot=rr.getDouble(8);
			//System.out.println("ibusiv");
			ad4(bal,newbalance,tot,balancediff,j++);
		}
		rr.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public static boolean display()
	{
		try
		{
			
		Connection connect=DBUtil.createConnection();
		Statement s=connect.createStatement();
		ResultSet r1=s.executeQuery("select * from tex inner join Amount on tex.Transaction_id=Amount.Transaction_id");
	    System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-10s\n","Transaction_id","Date","Details","BrandName","Quality","In_Yarn_kg","Out_Yarn_kg","Balance_Yarn_kg","In_Warp_meter","Out_Warp_meter","Balance_Warp_meter","Debit","Credit","Balance","CGST","SGST","FINAL AMOUNT","Total");
		while(r1.next())
	    {
			System.out.printf("%-15d %-15s %-20s %-15s %-15s %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f %-20.2f %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f %-10.2f\n",r1.getInt(1),r1.getString(2),r1.getString(3),r1.getString(4),r1.getString(5),r1.getDouble(6),r1.getDouble(7),r1.getDouble(8),r1.getDouble(9),r1.getDouble(10),r1.getDouble(11),r1.getDouble(13),r1.getDouble(14),r1.getDouble(15),r1.getDouble(16),r1.getDouble(17),r1.getDouble(18),r1.getDouble(19));
	    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public static boolean monthly()
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		Connection connect=DBUtil.createConnection();
		Statement s=connect.createStatement();
		System.out.println("Enter the Starting Date:");
		String date1=sc.nextLine();
		System.out.println("Enter the Ending Date:");
		String date2=sc.nextLine();
		String sss="select SUM(Out_Warp_meter),SUM(Debit),SUM(Credit),SUM(Balance),SUM(CGST),SUM(SGST),SUM(FINAL_AMOUNT) from tex inner join Amount on tex.Transaction_id=Amount.Transaction_id where date(Date)>='"+date1+"'AND date(Date)<='"+date2+"'";
		ResultSet r=s.executeQuery(sss);
		//ResultSet r=s.executeQuery("select SUM(Out_Warp_meter),SUM(Debit),SUM(Credit),SUM(Balance),SUM(CGST),SUM(SGST),SUM(FINAL_AMOUNT),SUM(Total) from tex innner join Amount on tex.Transaction_id=Amount.Transaction_id where data(Date)>='"+date1+"' AND date(Date)<='"+date2+"'");
		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n","Out_Warp_meter","Debit","Credit","CGST","SGST","FINAL AMOUNT");
		while(r.next())
	    {
			double tot=r.getDouble(7)-4000;
			System.out.printf("%-15.2f %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f\n",r.getDouble(1),r.getDouble(2),r.getDouble(3),r.getDouble(5),r.getDouble(6),tot);
	    }
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
}
