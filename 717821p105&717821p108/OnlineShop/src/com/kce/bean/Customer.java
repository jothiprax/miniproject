package OnlineShop.src.com.kce.bean;
import java.util.*;

import OnlineShop.src.com.kce.dao.DatabaseConnection;
import OnlineShop.src.com.kce.services.Cart;
import OnlineShop.src.com.kce.services.Payment;
import OnlineShop.src.com.kce.services.Shop;

import java.io.*;
import java.sql.*;

public class Customer extends Shop {
	private int customerID;//Customer ID
	private Cart customerCart=new Cart();
	private int cartFlag=0;
	private int billPaidFlag=0;
	private int checkFlag=-1;
									//the Arraylist are used to store the valus of table for further use
	 ArrayList<Integer> pid=new ArrayList<Integer>(); 
	  ArrayList<String> name=new ArrayList<String>();
	 ArrayList<String> type=new ArrayList<String>();
	 ArrayList<Integer> qty=new ArrayList<Integer>();
	 ArrayList<Float> price=new ArrayList<Float>();
	
	private int products_Check;	//for checking whether the product table is empty or not
	
	public Customer(int custID,String passw)
	{
		customerID=custID;
		customerCart=new Cart();
		billPaidFlag=0;
		cartFlag=0;
	}
	public void CustomerPage()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		products_Check=this.initializeProducts(); //this statement always runs
		
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("WELCOME TO CUSTOMER SECTION\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - VIEW PRODUCTS LIST");//completed
			System.out.println("2 - SEARCH A PRODUCT NAMEWISE");//completed
			System.out.println("3 - SEARCH PRODUCTS TYPEWISE");//completed
			System.out.println("4 - ADD PRODUCT TO CART");//completed
			System.out.println("5 - REMOVE PRODUCT FROM CART");//completed
			System.out.println("6 - VIEW CART");//completed
			System.out.println("7 - PROCEED TO PAYMENT");
			System.out.println("8 - EDIT PROFILE");//completed
			System.out.println("9 - LOGOUT FROM SYSTEM");//completed
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
				this.viewProducts();
			else if(ch==2){
			
				this.searchNameWise();
			}
			else if(ch==3){
				
				this.searchTypeWise();}
			else if(ch==4)
			{
				this.addProducts();
			}
			else if(ch==5)
			{
				int rem;
				System.out.print("ENTER PRODUCT ID TO REMOVE FROM CART = ");
				rem=Integer.parseInt(br.readLine());
				customerCart.removeFromCart(rem);
				this.updateArrayList();
			}
			else if(ch==6)
				customerCart.viewCart();
			else if(ch==7)
			{
				this.proceedPayment(customerCart);
			}
			else if(ch==8)
				editProfile(customerID);
			else if(ch==9)
			{
				ch=this.checkExit();
				
				if(ch==0)
					ch=9;
			}
			else
				System.out.println("Wrong choice");
		}while(ch!=9);
	}
	private int checkExit()throws IOException
	{
		if(cartFlag==1)
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String chc;
			System.out.println("YOU HAVE A PENDING CART !");
			System.out.print("DO YOU WANT TO MAKE PAYMENT ( PRESS Y ) ELSE CANCEL THE CART ( PRESS N) : ");
			chc=br.readLine();
			if(chc.equalsIgnoreCase("Y"))
			{
				proceedPayment(customerCart);
				if(billPaidFlag!=1 && checkFlag==-1)
					return -1;
				else
					return 0;
			}
			else
			{
				customerCart.cancelCart();
				customerCart=new Cart();
				cartFlag=0;
				billPaidFlag=0;
			}
		}
		System.out.println("THANK YOU !");
		return 9;//to exit the customerPage
			
	}
	private void proceedPayment(Cart cart1)throws IOException
	{
		if(cartFlag==1)
		{
			String c_name=""; //Customer Name
			String b_add=""; // customer address
			String c_phn="";// customer phone number
			try
			{
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
				PreparedStatement ps=con.prepareStatement("select * from custinfo where custID=?");
				ps.setString(1, Integer.toString(customerID));
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					c_name=rs.getString(2);
					b_add=rs.getString(5);
					c_phn=rs.getString(6);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			Payment p=new Payment(cart1,c_name,b_add,c_phn);//for proceeding payment
			p.paymentPage();
			if(p.billPaid_f==1)//checking whether the payment is done or not 
				billPaidFlag=1;
			if(billPaidFlag==1)
			{
				customerCart=new Cart();//emptying the cart
				cartFlag=0;
				billPaidFlag=0;
				checkFlag=-2;
			}
		}
		else
			System.out.println("CART IS EMPTY! ");
	}
	//the  below functions are of private use only , not to be used by customer class
	private void updateArrayList()throws IOException
	{
		pid.clear();
		name.clear();
		type.clear();
		qty.clear();
		price.clear();
		initializeProducts();
	}
	
	public int searchProd(int x)throws IOException  
	{//searching the product based on id ,and returning the quantity
	
		int res=pid.indexOf(x);
		if(res!=-1)
		{
			return qty.get(res);
		}
		else
		{
			return -1;
		}
	}
	private void updateQty(int sub,int x)throws IOException 
	{//after customer buys a product the quantity gets updated
		try
		{
			int res=pid.indexOf(x);
			int min=qty.get(res);
			if(min-sub>0)
			{
				qty.set(res, min-sub);
			}
			else
				qty.set(res,0);
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("update products set Quantity=? where productID=?");
			ps.setString(1,Integer.toString(qty.get(res)));
			ps.setString(2, Integer.toString(x));
			int m=ps.executeUpdate();
			if(m==0)
				System.out.println("PRODUCT UPDATION FAILED !");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//*******************************************************************************************
	private void addProducts()throws IOException
	{//this for  adding products to cart
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String chc;
		Scanner sc = new Scanner(System.in);
		do
		{
			int p_id;
			String p_name,p_type;
			float p_price;
			int q_pur;
			
			int q_avail;
			System.out.print("ENTER PRODUCT ID TO ADD TO CART = ");
			p_id=sc.nextInt();
			q_avail=searchProd(p_id);
			if(q_avail==-1)
				System.out.println("PRODUCT NOT FOUND !");
			else
			{
				System.out.println("QUNATITY AVAILABLE = "+q_avail);
				System.out.println("ENTER QUANTITY TO PURCHASE = ");
				q_pur=Integer.parseInt(br.readLine());
				if(q_pur>q_avail)
					System.out.println("STOCK NOT AVAILABLE");
				else
				{
						updateQty(q_pur,p_id);
					
					//adding product to cart code begins below
					p_name=name.get(pid.indexOf(p_id));
					p_type=type.get(pid.indexOf(p_id));
					p_price=(float)(q_pur*(price.get(pid.indexOf(p_id))));
					
					customerCart.addToCart(p_id, p_name, p_type, q_pur, p_price);
					cartFlag=1;
				}
					
			}
			System.out.print("DO YOU WANT TO CONTINUE PRESS ( Y for yes, N for no)");
			chc=br.readLine();
		}while(chc.equalsIgnoreCase("Y"));
	}
	private int initializeProducts()
	{// this runs every time when a customer is logged in for fetching the value in products
		int x=0;
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			//*******
			//for counting the number of rows in result set
			if (rs.next() == false) {

        System.out.println("ResultSet in empty in Java");
      } else {
		x=rs.getRow();

        do {
			//*******
			pid.add(Integer.parseInt(rs.getString(1)));
			name.add(rs.getString(2));
			type.add(rs.getString(3));
			qty.add(Integer.parseInt(rs.getString(4)));
			price.add(Float.parseFloat(rs.getString(5)));
			
		}
			while(rs.next());
				
				
			
		}

	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x;
}

//To display the Products in the  Products Table 
	private void viewProducts()throws IOException
	{
		if(products_Check==0)
			System.out.println("PRODUCTS NOT AVAILABLE !");
		else
		{
			Products p = new Products();
			p.viewProducts();
	}
}
												//to Search a product based on  Name							
	private void searchNameWise()throws IOException
	{
		if(products_Check==0)
			System.out.println("PRODUCTS NOT AVAILABLE !");
		else
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			String sr;
			int res;
			String chc;
			do
			{
				System.out.print("ENTER PRODUCT NAME TO SEARCH : ");
				sr=sc.next();
				res=name.indexOf(sr);
				
				if(res==-1)
					System.out.println("PRODUCT NOT FOUND !");
				else
				{
					System.out.println("PRODUCT DETAILS ARE :\n");
					System.out.printf("PRODUCT ID         = %-5d\n",pid.get(res));
					System.out.printf("PRODUCT NAME       = %-20s\n",name.get(res));
					System.out.printf("PRODUCT TYPE       = %-20s\n", type.get(res));
					if(qty.get(res)!=0)
						System.out.printf("QUANTITY AVAILABLE = %-5d\n", qty.get(res));
					else
						System.out.printf("QUANTITY AVAILABLE = %-5s\n", "NOT IN STOCK");
					System.out.printf("PRODUCT PRICE      = %-10f\n",price.get(res));
				}
				System.out.print("PRESS Y to continue , N for exit : ");
				chc=br.readLine();
			
			}while(chc.equalsIgnoreCase("Y"));
			
		}
	}
	private void searchTypeWise()throws IOException
	{
		if(products_Check==0)
			System.out.println("PRODUCTS NOT AVAILABLE !");
		else
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String sr;
			int res;
			String chc;
			do
			{
				System.out.print("ENTER PRODUCT TYPE TO SEARCH : ");
				sr=br.readLine();
				res=type.indexOf(sr);
				if(res==-1)
					System.out.println("PRODUCT NOT FOUND !");
				else
				{
					System.out.println("PRODUCTS AVAILABLE ARE : \n");
					System.out.println("***********************************************************************************************************************\n");
					System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID","Product_Name","Product_Type","Product_Quantity","Product_Price");
					System.out.println("***********************************************************************************************************************\n");
					res=pid.size();
					for(int i=0;i<res;i++)
					{
						if(sr.equalsIgnoreCase(type.get(i)))
						{
							if(qty.get(i)!=0)
								System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n",pid.get(i),name.get(i),type.get(i),qty.get(i),price.get(i) );
							else
								System.out.printf("%-20d \t %-20s \t %-20s \t %-20s \t %-20f\n",pid.get(i),name.get(i),type.get(i),"NOT IN STOCK",price.get(i) );
						}
					}
					System.out.println("***********************************************************************************************************************\n");
				}
				System.out.print("PRESS Y to continue , N for exit : ");
				chc=br.readLine();
			
			}while(chc.equalsIgnoreCase("Y"));
		}
	}
	private static void editProfile(int custID)throws IOException
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
					ps=con.prepareStatement("update custinfo set Name = ? where custID=?");
					ps.setString(1, name);
					ps.setString(2, Integer.toString(custID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Age"))
				{
					ps=con.prepareStatement("update custinfo set Age = ? where custID=?");
					ps.setString(1, Integer.toString(age));
					ps.setString(2, Integer.toString(custID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Email"))
				{
					ps=con.prepareStatement("update custinfo set Email = ? where custID=?");
					ps.setString(1,email);
					ps.setString(2, Integer.toString(custID));
					x=ps.executeUpdate();
				}
				else if(s.equalsIgnoreCase("Address"))
				{
					ps=con.prepareStatement("update custinfo set Address = ? where custID=?");
					ps.setString(1, addr);
					ps.setString(2, Integer.toString(custID));
					x=ps.executeUpdate();
					
				}
				else if(s.equalsIgnoreCase("ContactNumber"))
				{
					ps=con.prepareStatement("update custinfo set ContactNumber = ? where custID=?");
					ps.setString(1, contact);
					ps.setString(2, Integer.toString(custID));
					x=ps.executeUpdate();
				}
				if(x!=0)
					System.out.println("INFORMATION UPDATED SUCCESSFULLY !");
			}
			else if(fc==0)
			{
				PreparedStatement ps=con.prepareStatement("update logininfo set password=? where userID=?");
				ps.setString(1,passw);
				ps.setString(2, Integer.toString(custID));
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
}
