package mini_project_1;
import java.util.*;
import java.sql.*;
public class ration_process 
{
	Scanner sc=new Scanner(System.in);
	
	
	
	public boolean no_match()throws SQLException
	{
		return false;
	}
	   
	public boolean check_aadharNo() throws SQLException
	{
		try {
		int aadharNo=sc.nextInt();
		int rationNo=sc.nextInt();
		String name=sc.next();
		user_info u=new user_info(aadharNo,rationNo,name);
		Connection con=DButill.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from ration_shop");
		boolean checking=false;
		while(rs.next())
		{
			int a_no=rs.getInt(1);
			int r_no=rs.getInt(2);
			String user_name=rs.getString(3);
			if(a_no==u.getAadharNo() && r_no==u.getRationNo() && user_name.equals(u.getName()))
			{
				checking=true;
				break;
			}
		}
		
		if(checking==true)
		{
			System.out.println("              ");
			System.out.println("You can proceed");
			return true;
		}
		else
		{
			System.out.println("No match found!!!");
			System.exit(0);
			return no_match();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.exit(0);
			return false;
		}
		
		
		
	
	
}
	
   public boolean display_products() throws SQLException
   {
	   if(check_aadharNo())
	   {
	   Connection con=DButill.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from products_available");
		int s_no=1;
		while(rs.next())
		{
		
			System.out.println(s_no+". "+rs.getString(1)+" (Price: "+rs.getDouble(2)+") (Scale: "+rs.getDouble(3)+")1");
			s_no++;
		}
		
		return true;
		
	   }
	   else {
		  
		   return false;
	   }
   }
  
   public double[] buy()throws SQLException
   {
	   try
	   {
	   
	   int count=0;
	   System.out.println("              ");
	   System.out.println("Per day you can buy 2 Products only");
	   System.out.println("                            ");
	   
	   int checking_value=0;
	   double[] arr_option=new double[4];
	   while(count<2)
	   {
		   
		   System.out.print("Choose the option: ");
		   int buy_option=sc.nextInt();
		   arr_option[count]=buy_option;
		  
		   count++;
		   if(checking_value!=buy_option)
		   {
			   checking_value=buy_option;
			   
	   switch(buy_option)
	   {
	   case 1:
		   System.out.println("You have choosed rise");
		   System.out.println("Rice is free for all");
		   System.out.println("Scale of Rice: 4kg");
		   System.out.println("              ");
		   break;
	   case 2:
		   System.out.println("You have choosed sugar");
		   System.out.println("Cost of sugar is: 13.5/kg");
		   System.out.println("Scale of Sugar: 2kg");
		   System.out.println("              ");
		   break;
	   case 3:
		   System.out.println("You have choosed wheat");
		   System.out.println("Cost of Wheat is: 7.5/kg");
		   System.out.println("Scale of Wheat: 10kg");
		   System.out.println("              ");
		   break;
	   case 4:
		   System.out.println("You have choosed Kerosene");
		   System.out.println("Cost of kerosene is: 13.6/litre");
		   System.out.println("Scale of Kerosene: 15/litre");
		   System.out.println("              ");
		   break;
	   case 5:
		   System.out.println("You have choosed Toor Dhal");
		   System.out.println("Cost of sugar is: 30/kg");
		   System.out.println("Scale of Toor: 1/kg");
		   System.out.println("              ");
		   break;
	   case 6:
		   System.out.println("You have choosed Oil");
		   System.out.println("Cost of oil is: 13.5/litre");
		   System.out.println("Scale of Oil: 1/lite");
		   System.out.println("              ");
		   break;
	   default:
		   System.out.println("You have choosed wrong option!!Please Select corect option");
		   System.out.println("              ");
		    return buy();
		   
	   
	   }
		   }
		   else 
		   {	   
			 System.out.println("You have already choosed this product choose again");
			 return buy();
			  
		   }
		    
	   }
	   
	   return arr_option;
	   
	   }
	   catch(Exception e)
	   {
		  System.out.println(e); 
		  return null;
	   }
	   
   }
   public double[] cal(double[] arr_option) throws SQLException 

   {
	 
	try {
	  
	   System.out.println("NOTE: Enter Given Limit of Scale");
	   System.out.println("              ");
	   

		   System.out.print("Enter the scale of the product "+(1)+": ");
		   int scale=sc.nextInt();
		   if(scale>0)
		   {
		   Connection con=DButill.getConnection();
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("select cost from products_available where user_option="+arr_option[0]);
		   double price=0.0;
		 while(rs.next()) {
			 price=rs.getDouble(1);
		 }
		 
		   System.out.println("Actual price:"+price);
		   int int_option=(int)arr_option[0];
		   switch(int_option)
		   {
		   case 1:
			   if(scale<=4)
			   {
			   System.out.println("The cost is free");
			   System.out.println("              ");
			   arr_option[2]=price*scale;
			   }
			   else
			   {
				   System.out.println("              ");
				   System.out.println("Sorry the limit is 4kg only.Choose the given Limit!!!");  
				   System.out.println("              ");
				   cal(arr_option);
			   }
			   break;
		   case 2:
			   if( scale<=2)
			   {
			   System.out.println("Pay the cost of: "+price*scale);
			   System.out.println("              ");
			   arr_option[2]=price*scale;
			   }
			   else 
			   {
				System.out.println("Sorry the limit is 2kg only.Choose the given Limit");   
				System.out.println("              ");
				cal(arr_option);
			   }
			   break;
		   case 3:
			   if(scale<=10.0)
			   {
				   System.out.println("Pay the cost of: "+price*scale);  
				   System.out.println("              ");
				   arr_option[2]=price*scale;
			   }
			   else
			   {
				   System.out.println("Sorry the limit is 10kg only.Choose the given Limit");
				   System.out.println("              ");
				   cal(arr_option);
			   }
			   break;
		   case 4:
			   if(scale<=15.0)
			   {
				   System.out.println("Pay the cost of: "+price*scale);
				   System.out.println("              ");
				   arr_option[2]=price*scale;
			   }
			   else
			   {
				   System.out.println("Sorry the limit is 15litres only.Choose the given Limit");
				   System.out.println("              ");
				   cal(arr_option);
			   }
			   break;
		   case 5:
			   if(scale<=1)
			   {
				   System.out.println("Pay the cost of: "+price*scale);  
				   System.out.println("              ");
				   arr_option[2]=price*scale;
			   }
			   else
			   {
				   System.out.println("Sorry the limit is 1kg only.Choose the given Limit");
				   System.out.println("              ");
				   cal(arr_option);
			   }
			   break;
		   case 6:
			   if(scale<=1)
			   {
				   System.out.println("Pay the cost of: "+price*scale);  
				   System.out.println("              ");
				   arr_option[2]=price*scale;
			   }
			   else
			   {
				   System.out.println("Sorry the limit is 1lite only.Choose the given Limit");
				   System.out.println("              ");
				   cal(arr_option);
			   }
			   break;
		    default:  
		    	System.out.println("You select wrong option.Please select correct option");
		    	System.out.println("              ");
		    	cal(arr_option);
		    	break;
			   
		   }
	   }
		   else
		   {
			   System.out.println("You should enter the scale more than 0");
			   System.out.println("              ");
			   cal(arr_option);
		   }
		   return arr_option;
	  
   }
   catch(Exception e)
	{
	   System.out.println(e);
	}
	return null;
}	  

	    
   public double[] cal2(double[] arr_option) throws SQLException 
   { 
	   try
	   {
	   System.out.print("Enter the scale of the product "+(2)+": ");
	   int scale=sc.nextInt();
	   if(scale>0)
	   {
	   Connection con=DButill.getConnection();
	   Statement st=con.createStatement();
	   ResultSet rs=st.executeQuery("select cost from products_available where user_option="+arr_option[1]);
	   double price=0.0;
	 while(rs.next()) {
		 price=rs.getDouble(1);
	 }
	  arr_option[3]=price;
	   System.out.println("Actual price:"+price);
	   int int_option=(int)arr_option[1];
	   switch(int_option)
	   {
	   case 1:
		   if(scale<=4)
		   {
		   System.out.println("The cost is free");
		   System.out.println("              ");
		   
		   }
		   else
		   {
			   System.out.println("Sorry the limit is 4kg only.Choose the given Limit");  
			   System.out.println("              ");
			   cal2(arr_option);
		   }
		   break;
	   case 2:
		   if( scale<=2)
		   {
		   System.out.println("Pay the cost of: "+price*scale);
		   System.out.println("              ");
		   arr_option[3]=price*scale;
		   }
		   else 
		   {
			System.out.println("Sorry the limit is 2kg only.Choose the given Limit");   
			System.out.println("              ");
			cal2(arr_option);
		   }
		   break;
	   case 3:
		   if(scale<=10.0)
		   {
			   System.out.println("Pay the cost of: "+price*scale);  
			   System.out.println("              ");
			   arr_option[3]=price*scale;
		   }
		   else
		   {
			   System.out.println("Sorry the limit is 10kg only.Choose the given Limit");
			   System.out.println("              ");
			   cal2(arr_option);
		   }
		   break;
	   case 4:
		   if(scale<=15.0)
		   {
			   System.out.println("Pay the cost of: "+price*scale);
			   System.out.println("              ");
			   arr_option[3]=price*scale;
		   }
		   else
		   {
			   System.out.println("Sorry the limit is 15litres only.Choose the given Limit");
			   System.out.println("              ");
			   cal2(arr_option);
		   }
		   break;
	   case 5:
		   if(scale<=1)
		   {
			   System.out.println("Pay the cost of: "+price*scale);  
			   System.out.println("              ");
			   arr_option[3]=price*scale;
		   }
		   else
		   {
			   System.out.println("Sorry the limit is 1kg only.Choose the given Limit");
			   System.out.println("              ");
			   cal2(arr_option);
		   }
		   break;
	   case 6:
		   if(scale<=1)
		   {
			   System.out.println("Pay the cost of: "+price*scale);  
			   System.out.println("              ");
			   arr_option[3]=price*scale;
		   }
		   else
		   {
			   System.out.println("Sorry the limit is 1lite only.Choose the given Limit");
			   System.out.println("              ");
			   cal2(arr_option);
		   }
		   break;
	    default:  
	    	System.out.println("You select wrong option.Please select correct option");
	    	System.out.println("              ");
	    	cal2(arr_option);
	    	break;
		   
	   }
   }
	   else
	   {
		   System.out.println("You should enter the scale more than 0");
		   System.out.println("              ");
		   cal2(arr_option);
	   }

	  
	  
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
	  
  return arr_option;
   }
   public void pay(double[] arr_option)
   {
	   double Total_amount=arr_option[2]+arr_option[3];
	   System.out.println("   ");
		  System.out.println("Total Amount of purchasing is: "+Total_amount);
		  System.out.print("Enter the amount: ");
		  double pay_amount=sc.nextDouble();
		  if(Total_amount==pay_amount)
		  {
			  System.out.println("Successfully paid the amount: "+Total_amount);
			  System.out.println("   ");
			   System.out.println("Thanks for purchasing.Have a great day:)");
		  }
		  else if(pay_amount<Total_amount)
		  {
			  System.out.println("You paid less amount.please pay again:"+(Total_amount));
			  pay(arr_option);
			  
		  }
		  else 
		  {
			System.out.println("You paid more than the price.Please get the balance:"+(pay_amount-Total_amount)); 
			System.out.println("   ");
			   System.out.println("Thanks for purchasing.Have a great day:)");
		  }
		  
   }
}
