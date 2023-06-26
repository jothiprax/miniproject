package com.kce.service;

import com.kce.bean.Menu;
import com.kce.bean.OrderedFoods;
import com.kce.dao.CustomerOrders;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.kce.util.FoodNotFoundException;
import com.kce.util.InvalidOptionException;
import com.kce.util.ItemNotFoundException;

public class Restaurant {
	private List<Menu> listOrder;
	public Map<String,Integer> map;
	public Restaurant() {
		super();
		listOrder = new ArrayList<Menu>();
		map=new LinkedHashMap<String,Integer>();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Restaurant res = new Restaurant();
		Menu menuCard = new Menu();
		menuCard.DisplayMenu();
		List<OrderedFoods> foodlist = new ArrayList<OrderedFoods>();
		
		String option="";
		
		//Customer Name
		System.out.println("Enter your Name : ");
		String CustomerName = sc.nextLine();
		while(!option.equals("exit"))
		{
			System.out.println(" A.Add a Food:");
			System.out.println(" B.Remove a Food:");
			System.out.println(" C.Update the Quantity Of Order:");
			System.out.println(" D.Show My Order Cart");
			System.out.println(" E.Confirm the Order:");
			System.out.println(" F.Exit");
			char choice;
			System.out.println("Enter Your Choice : ");
			choice=sc.nextLine().charAt(0);
			choice=Character.toUpperCase(choice);
			if(choice>='A' && choice<='F')
			{
				if(choice=='A')
				{
					
					int itemnum=-1;
					int quantity;
					while(itemnum!=0)
					{
						System.out.println("Enter the Food Number(1-18) to Select :    Or     Select  '0'  to  exit");
						itemnum=sc.nextInt();
						if(itemnum>=0 && itemnum<=18)
						{
							if(itemnum==0)
							{
								sc.nextLine();
								break;
							}
							else if(itemnum==1)
							{
								String foodName="Chappathi";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==2)
							{
								String foodName="Dosa";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==3)
							{
								String foodName="Idly";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==4)
							{
								String foodName="Paratha";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==5)
							{
								String foodName="Poori";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==6)
							{
								String foodName="Veg Briyani";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==7)
							{
								String foodName="Veg Fried Rice";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==8)
							{
								String foodName="Veg Noodles";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==9)
							{
								String foodName="Barbeque Chicken";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
								
							}
							
							else if(itemnum==10)
							{
								String foodName="Chicken Briyani";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==11)
							{
								String foodName="Chicken Fried Rice";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==12)
							{
								String foodName="Chicken Noodles";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==13)
							{
								String foodName="Egg Paratha";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==14)
							{
								String foodName="Grilled Chicken";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==15)
							{
								String foodName="Mutton Briyani";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==16)
							{
								String foodName="Mutton Fried Rice";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==17)
							{
								String foodName="Mutton Noodles";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
							
							else if(itemnum==18)
							{
								String foodName="Tandoori Chicken";
								System.out.println("Enter  The number Of Quantity for  "+foodName+" : ");
								quantity=sc.nextInt();
								res.map.put(foodName,quantity);
							}
						
						}
						else
						{
							throw new ItemNotFoundException();
						}
					}
				}
				else if(choice=='B')
				{
					
					System.out.printf("%-20s %-20s %-20s\n","FoodId","Food Name","Food Quantity");
					int fid=1;
					for(Map.Entry<String, Integer> entry : res.map.entrySet())
					{
						System.out.printf("%-20s %-20s %-20s\n",fid,entry.getKey(),entry.getValue());
						fid++;
					}
					System.out.println("Enter Food Id to Remove");
					int n=sc.nextInt();
					sc.nextLine();
					if(n<=res.map.size())
					{
						String fname="";
						int i=1;
						for(Map.Entry<String, Integer> entry : res.map.entrySet())
						{
							if(i==n)
							{
								 fname=entry.getKey();
							}
							i++;
						}
						res.map.remove(fname);
					}
					else
					{
						throw new FoodNotFoundException();
					}
							
				}
				
				else if(choice=='C')
				{
					
					
					System.out.printf("%-20s %-20s %-20s\n","FoodId","Food Name","Food Quantity");
					int fid=1;
					for(Map.Entry<String, Integer> entry : res.map.entrySet())
					{
						System.out.printf("%-20s %-20s %-20s\n",fid,entry.getKey(),entry.getValue());
						fid++;
					}
					System.out.println("Enter ItemNumber  to Update Quantity  : ");
					int n=sc.nextInt();
					sc.nextLine();
					if(n<=res.map.size())
					{
						String fname="";
						int i=1;
						int quantity=0;
						for(Map.Entry<String, Integer> entry : res.map.entrySet())
						{
							if(i==n)
							{
								 fname=entry.getKey();
								 System.out.println("Enter Quantity for "+fname+" : ");
								 quantity=sc.nextInt();
								 sc.nextLine();
								 res.map.put(fname, quantity);
							}
							i++;
						}
	
					}
					else
					{
						throw new FoodNotFoundException();
					}
					

				}
				
				else if(choice=='D')
				{
					if(res.map.size()==0)
					{
						System.out.println("Your  Cart  Is  empty");
					}
					else 
					{
						System.out.printf("%-20s %-20s \n","Item Name","Item Quantity");
						for(Map.Entry<String, Integer> entry : res.map.entrySet())
						{
							System.out.printf("%-20s %-20s \n",entry.getKey(),entry.getValue());
						}
						System.out.println();
					}
				}
				
				
				
				else if(choice=='E')
				{
					for(Map.Entry<String, Integer> entry : res.map.entrySet())
					{
						Menu menu = new Menu(entry.getKey());
						int quantity=entry.getValue();
						OrderedFoods ofs = new OrderedFoods(menu,quantity);
						foodlist.add(ofs);
					}
					System.out.println("Menu added");
					CustomerOrders custOrder = new CustomerOrders(CustomerName,foodlist);
					System.out.println(CustomerName+"'s   Order   Cart : ");
					custOrder.DisplayOrders();
					custOrder.addToOrders();
					System.out.println("The Total Bill Amount For Your Order == "+custOrder.TotalBillAmount());
				}
				else if(choice=='F')
				{
					System.out.println("ThankYou  Visit  Again!!!");
					try {
			    		Class.forName("com.mysql.jdbc.Driver");
			 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			 			Statement stmt = con.createStatement();
			 			stmt.executeUpdate("DELETE from  userorder");
			 			con.close();
			 			option="exit";
			    	 }catch(Exception e)
			    	 {
			    		 System.out.println(e);
			    	 }
					
				}
				
				
			}
			else
			{
				throw new InvalidOptionException();
			}
		}
		
	}
}
