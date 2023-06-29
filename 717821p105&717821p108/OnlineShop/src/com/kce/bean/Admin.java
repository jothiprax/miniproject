package OnlineShop.src.com.kce.bean;
import java.sql.*;
import OnlineShop.src.com.kce.dao.DatabaseConnection;
import OnlineShop.src.com.kce.services.Shop;

import java.io.*;
public class Admin extends Shop {
	private int adminID;
	private String password;
	public Admin(int x,String y)
	{
		adminID=x;
		password=y;
	}
	public void AdminPage()throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n==============================================================");
		System.out.println("WELCOME TO ADMIN SECTION\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - MANAGE PRODUCTS");//completed
			System.out.println("2 - ADD CUSTOMERS");//completed
			System.out.println("3 - REMOVE CUSTOMERS");//completed
			System.out.println("4 - EDIT PROFILE");//completed
			System.out.println("5 - VIEW REGISTERED CUSTOMERS");//completed
			System.out.println("6 - LOGOUT FROM SYSTEM");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{
				Products ob=new Products();
				ob.ProductsPage();
			}
			else if(ch==2)
			{
				addCustomer();
			}
			else if(ch==3)
			{
				removeCustomer();
			}
			else if(ch==4)
			{
				editProfile(adminID);
			}
			else if(ch==5)
			{
				viewCustomers();
			}
			else if(ch==6)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice");
		}while(ch!=6);
		
	}
	private static void editProfile(int adminID)throws IOException
	{
		try
		{
			int x=0;
		String chc;

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int fc=-1;
		String name="",email="",addr="",contact="",passw="";
		int age=0;
		int ch=0;
		do
		{
			System.out.println("************************************************************");
			System.out.println("1 - EDIT NAME");
			System.out.println("2 - EDIT AGE");
			System.out.println("3 - EDIT EMAIL ID");
			System.out.println("4 - EDIT ADDRESS");
			System.out.println("5 - EDIT CONTACT NUMBER");
			System.out.println("6 - CHANGE PASSWORD");
			System.out.println("7 - EXIT");
			System.out.println("************************************************************");
			System.out.print("Enter choice : ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{
				System.out.print("ENTER NEW NAME : ");
				name=br.readLine();
				s="Name";
				fc=1;
			}
			else if(ch==2)
			{
				System.out.print("ENTER AGE : ");
				age=Integer.parseInt(br.readLine());
				s="Age";
				fc=1;
			}
			else if(ch==3)
			{
				System.out.print("ENTER NEW EMAIL ID : ");
				email=br.readLine();
				s="Email";
				fc=1;
			}
			else if(ch==4)
			{
				System.out.print("ENTER ADDRESS : ");
				addr=br.readLine();
				s="Address";
				fc=1;
			}
			else if(ch==5)
			{
				System.out.print("ENTER NEW CONTACT NUMBER : ");
				contact=br.readLine();
				s="ContactNumber";
				fc=1;
			}
			else if(ch==6)
			{
				System.out.print("ENTER NEW PASSWORD : ");
				passw=br.readLine();
				s="password";
				fc=0;
			}
			else if(ch==7)
			{
				System.out.println("Thank you");
				break;
			}
			else
				System.out.println("Wrong choice");
			if(fc==1)
			{
				PreparedStatement ps;
				if(s.equalsIgnoreCase("Name"))
				{
					ps=con.prepareStatement("update admininfo set Name = ? where AdminID=?");
					ps.setString(1, name);
					ps.setString(2, Integer.toString(adminID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Age"))
				{
					ps=con.prepareStatement("update admininfo set Age = ? where AdminID=?");
					ps.setString(1, Integer.toString(age));
					ps.setString(2, Integer.toString(adminID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Email"))
				{
					ps=con.prepareStatement("update admininfo set Email = ? where AdminID=?");
					ps.setString(1,email);
					ps.setString(2, Integer.toString(adminID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Address"))
				{
					ps=con.prepareStatement("update admininfo set Address = ? where AdminID=?");
					ps.setString(1, addr);
					ps.setString(2, Integer.toString(adminID));
					x=ps.executeUpdate();
					
				}
				else if(s.equalsIgnoreCase("ContactNumber"))
				{
					ps=con.prepareStatement("update admininfo set ContactNumber = ? where AdminID=?");
					ps.setString(1, contact);
					ps.setString(2, Integer.toString(adminID));
					x=ps.executeUpdate();
				}
				if(x!=0)
					System.out.println("INFORMATION UPDATED SUCCESSFULLY !");
			}
			else if(fc==0)
			{
				PreparedStatement ps=con.prepareStatement("update logininfo set password=? where userID=?");
				ps.setString(1,passw);
				ps.setString(2, Integer.toString(adminID));
				x=ps.executeUpdate();
				if(x!=0)
					System.out.println("PASSWORD CHANGED SUCCESSFULLY !");
				
			}
			System.out.print("Do you want to continue ( Y for yes, N for No ) : ");
			chc=br.readLine();
			
			
		}while(chc.equalsIgnoreCase("Y"));
		}
		catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
	}
	private static void viewCustomers()throws IOException
	{
		int cid,age;
		String name,email,addr,contact;
		
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from custinfo");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
			
			//*******
			
			{
				System.out.println("**********************************************************************************************************************************************************************\n");
				System.out.printf("%-20s \t %-20s \t %-10s \t %-20s \t %-30s \t %-20s\n","CUSTOMER_ID","NAME","AGE","EMAIL","ADDRESS","CONTACT_NUMBER");
				System.out.println("**********************************************************************************************************************************************************************\n");
				while(rs.next())
				{
					cid=Integer.parseInt(rs.getString(1));
					name=rs.getString(2);
					age=Integer.parseInt(rs.getString(3));
					email=rs.getString(4);
					addr=rs.getString(5);
					contact=rs.getString(6);
					System.out.printf("%-20d \t %-20s \t %-10d \t %-20s \t %-30s \t %-20s\n",cid,name,age,email,addr,contact);
				}
				System.out.println("*********************************************************************************************************************************************************************\n");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static void addCustomer()throws IOException
	{
		Shop.registerCustomer();
	}
	private static void removeCustomer()throws IOException
	{
		//delete record from both custinfo and logininfo
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x=0,y=0;
		int cid;
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop ","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from custinfo");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
			if(rs.last()) {
				x=rs.getRow();
				rs.beforeFirst();
			}
			//*******
			if(x==0)
				System.out.println("NO CUSTOMERS AVAIALABLE");
			else
			{
				System.out.print("Enter customer ID to delete : ");
				cid=Integer.parseInt(br.readLine());
				PreparedStatement ps1=con.prepareStatement("delete from custinfo where custID=?");
				PreparedStatement ps2=con.prepareStatement("delete from logininfo where userID=?");
				ps1.setString(1, Integer.toString(cid));
				ps2.setString(1, Integer.toString(cid));
				x=ps1.executeUpdate();
				y=ps2.executeUpdate();
				if(x!=0 && y!=0)
					System.out.println("CUSTOMER INFO DELETED SUCCESSFULLY !");
				else
					System.out.println("CUSTOMER INFO NOT FOUND !");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
