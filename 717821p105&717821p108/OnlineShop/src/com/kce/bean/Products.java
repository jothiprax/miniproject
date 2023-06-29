package OnlineShop.src.com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OnlineShop.src.com.kce.dao.DatabaseConnection;

import java.io.*;

public class Products {
	private int pid,qty;
	private String name,type;
	private float price;
	public void ProductsPage()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Products ob=new Products();
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("\nWELCOME TO PRODUCTS MANAGEMENT PAGE\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - ADD PRODUCTS");//completed
			System.out.println("2 - REMOVE PRODUCTS");//completed
			System.out.println("3 - ALTER PRODUCT INFO");//completed
			System.out.println("4 - VIEW ALL PRODUCTS");//completed
			System.out.println("5 - SEARCH A PARTICULAR PRODUCT");//completed
			System.out.println("6 - EXIT PAGE");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
				ob.addProducts();
			else if(ch==2)
				ob.removeProducts();
			else if(ch==3)
				ob.alterProduct();
			else if(ch==4)
				ob.viewProducts();
			else if(ch==5)
				ob.searchProduct();
			else if(ch==6)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice ");
		}while(ch!=6);
		
	}
	private void alterProduct()throws IOException
	{
		int x=0;
		int ch1;
		String chd2,chd1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
			if(rs.last()) {
				x=rs.getRow();
				rs.beforeFirst();
			}
			//*******
			if(x==0)
				System.out.println("NO PRODUCTS AVAIALABLE");
			else
			{
				do
				{
					System.out.print("enter product ID to update info : ");
					pid=Integer.parseInt(br.readLine());
					int flag=0;
					while(rs.next())
					{
						if(Integer.parseInt(rs.getString(1))==pid)
						{
							flag=1;
							name=rs.getString(2);
							type=rs.getString(3);
							qty=Integer.parseInt(rs.getString(4));
							price=Float.parseFloat(rs.getString(5));
							do
							{
								System.out.println("FETCHED PRODUCT INFO :\n");
								System.out.printf("Product ID   = %-5d\n", pid);
								System.out.printf("Product Name = %-20s\n", name);
								System.out.printf("Product Type = %-20s\n", type);
								System.out.printf("Quantity     = %-5d\n",qty);
								System.out.printf("Price        = %-10f\n", price);
								System.out.println("\n1 - UPDATE PRODUCT NAME\n");
								System.out.println("\n2 - UPDATE PRODUCT TYPE\n");
								System.out.println("\n3 - UPDATE PRODUCT QUANTITY\n");
								System.out.println("\n4 - UPDATE PRICE\n");
								System.out.print("\nEnter choice : ");
								ch1=Integer.parseInt(br.readLine());
								if(ch1==1)
								{
									System.out.print("ENTER NEW NAME : ");
									name=br.readLine();
								}
								else if(ch1==2)
								{
									System.out.print("ENTER NEW TYPE : ");
									type=br.readLine();
								}
								else if(ch1==3)
								{
									System.out.print("ENTER NEW QUANTITY : ");
									qty=Integer.parseInt(br.readLine());
								}
								else if(ch1==4)
								{
									System.out.print("ENTER NEW PRICE : ");
									price=Float.parseFloat(br.readLine());
								}
								System.out.print("DO YOU WANT TO CONTINUE PRESS ( Y for yes , N for No ) : ");
								chd2=br.readLine();
							}while(chd2.equalsIgnoreCase("Y"));
							PreparedStatement ps1=con.prepareStatement("update products set Name = ? where productID=?");
							ps1.setString(1, name);
							ps1.setString(2, Integer.toString(pid));
							
							PreparedStatement ps2=con.prepareStatement("update products set Type = ? where productID=?");
							ps2.setString(1, type);
							ps2.setString(2, Integer.toString(pid));
							
							PreparedStatement ps3=con.prepareStatement("update products set Quantity = ? where productID=?");
							ps3.setString(1, Integer.toString(qty));
							ps3.setString(2, Integer.toString(pid));
							
							PreparedStatement ps4=con.prepareStatement("update products set Price = ? where productID=?");
							ps4.setString(1, Float.toString(price));
							ps4.setString(2, Integer.toString(pid));
							int x1,x2,x3,x4;
							x1=ps1.executeUpdate();
							x2=ps2.executeUpdate();
							x3=ps3.executeUpdate();
							x4=ps4.executeUpdate();
							if(x1>0 && x2>0 && x3>0 && x4>0)
								System.out.println("PRODUCT INFO UPDATED SUCCESSFULLY !");
							
						}
					}
					if(flag==0)
						System.out.println("PRODUCT NOT FOUND !");
					System.out.print("DO YOU WANT TO CONTINUE ( Y for yes , N for no )");
					chd1=br.readLine();
					rs.beforeFirst();
			}while(chd1.equalsIgnoreCase("Y"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private void searchProduct()throws IOException
	{
		int flag=0;
		int x=0;
		String ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
		
			//*******
			
				do
				{
					System.out.println("Enter product ID to search : ");
					pid=Integer.parseInt(br.readLine());
					PreparedStatement ps1=con.prepareStatement("select * from products where productID=?");
					ps1.setString(1,Integer.toString(pid));
					ResultSet rs1=ps1.executeQuery();
					flag=0;
					while(rs1.next())
					{
						if(Integer.parseInt(rs1.getString(1))==pid)
						{
							System.out.printf("Product ID   =  %-5d\n",Integer.parseInt(rs1.getString(1)));
							System.out.printf("Product Name =  %-20s\n",rs1.getString(2));
							System.out.printf("Product Type =  %-20s\n",rs1.getString(3));
							System.out.printf("Quantity     =  %-5d\n",Integer.parseInt(rs1.getString(4)));
							System.out.printf("Price        =  %-10f\n",Float.parseFloat(rs1.getString(5)));
							flag=1;
							break;
						}
					}
					if(flag==0)
						System.out.println("PRODUCT NOT FOUND !");
					System.out.print("Do you want to continue, press Y for 'yes' N for 'no' : ");
					ch=br.readLine();
				}while(ch.equalsIgnoreCase("Y"));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println();
	
	}
	private void removeProducts()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x=0;
		String ch;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("delete from products where productID=?");
			do
			{
			System.out.print("Enter product ID which you want to delete : ");
			pid=Integer.parseInt(br.readLine());
			ps.setString(1,Integer.toString(pid));
			x=ps.executeUpdate();
			if(x==0)
				System.out.println("PRODUCT NOT FOUND !");
			else
				System.out.println("PRODUCT DELETED SUCCESSFULLY !");
			System.out.print("Do you want to continue ( Y for YES, N for NO ): ");
			ch=br.readLine();
			
			}while(ch.equalsIgnoreCase("Y"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private void addProducts()throws IOException
	{
		int res;
		String ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*****************************************************\n");
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("insert into products(productID,Name,Type,Quantity,Price) values(?,?,?,?,?)");
			do
			{
				pid=setPid();
				System.out.println("Product ID = "+pid);
				System.out.print("Enter Name : ");
				name=br.readLine();
				System.out.print("Enter Type : ");
				type=br.readLine();
				System.out.print("Enter Quantity : ");
				qty=Integer.parseInt(br.readLine());
				System.out.print("Enter price : ");
				price=Float.parseFloat(br.readLine());
				ps.setString(1, Integer.toString(pid));
				ps.setString(2, name);
				ps.setString(3,type);
				ps.setString(4, Integer.toString(qty));
				ps.setString(5, Float.toString(price));
				res=ps.executeUpdate();
				if(res>0)
					System.out.println("PRODUCT ADDED SUCCESSFULLY !\n");
				System.out.print("Do you want to continue ( Y for yes , N for NO )");
				ch=br.readLine();
			}while(ch.equalsIgnoreCase("Y"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void viewProducts()
	{
		
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
			
			//*******
			
			
			{
				System.out.println("The products are : \n");
				System.out.println("****************************************************************************************************************************\n");
				System.out.printf("%-15s \t %-20s \t %-20s \t %-15s \t %-15s\n","Product ID","Name","Type","Quantity","Price");
				System.out.println("****************************************************************************************************************************\n");
				while(rs.next())
				{
					pid=Integer.parseInt(rs.getString("productID"));
					name=rs.getString("Name");
					type=rs.getString("Type");
					qty=Integer.parseInt(rs.getString("Quantity"));
					price=Float.parseFloat(rs.getString("Price"));
					System.out.printf("%-15d \t %-20s \t %-20s \t %-15d \t %-15f\n",pid,name,type,qty,price);
				}
				System.out.println("****************************************************************************************************************************\n");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static int setPid()
	{
		int y=999;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select productID from products");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				y=Integer.parseInt(rs.getString("productID"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return y+1; 
	}
}
