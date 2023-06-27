package com.RKFoodOrder.main;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.RKFoodOrder.bean.*;
import com.RKFoodOrder.dao.*;
import com.RKFoodOrder.service.*;
import com.RKFoodOrder.util.*;
public class FoodOrder_main {
public static void main(String args[]) {
	try {
	Scanner sc = new Scanner(System.in);
	System.out.println("If you're already a customer press 'y' else 'n'");
    String s= sc.nextLine();
    Customer c1 = new Customer();
    if(s.equalsIgnoreCase("y")) {
    	System.out.println("Enter your phone number ");
   	    String Customer_phno=sc.nextLine();
   	    CustomerDAO cd = new CustomerDAO();
   	    cd.find_customer(Customer_phno); 	   
    }
    else
    {
    	System.out.println("Enter your Name: "); 
	     String Customer_name = sc.nextLine();
	     System.out.println("Enter your Phone number: ");
	     String Customer_phno = sc.nextLine();
	     System.out.println("Enter your Address: ");
	     String Customer_addr = sc.nextLine();
	     System.out.println("Enter your mail id: ");
	     String Customer_mail = sc.nextLine();
	     c1.setCustomer_name(Customer_name);
	     c1.setCustomer_phonenum(Customer_phno);
	     c1.setCustomer_address(Customer_addr);
	     c1.setCustomer_mail(Customer_mail);
	     AddCustomer ac = new AddCustomer();
	     int k = ac.add(c1);
	     if(k==1)
	    	 System.out.println("Welcome our new Customer Mr/Mrs "+c1.getCustomer_name());
	     else 
	     {
	    	 System.out.print("Enter again");
	    	 System.exit(0);
	     }
    }
         Thread.sleep(2000); //to slow the name for long and confirm
         System.out.println("\n------Welcome to RK Restaurant------\nHere's the menu");
         Menu_listDAO md = new Menu_listDAO();
         md.Menu();
         System.out.println("Choose the food_ID U like to order!....& 0 to end ur order");
         Statement st = null;
         Connection con =null;
         con=DBUtil.getConnection();
         st=con.createStatement();
         String q2="DELETE FROM Menu";
		 st.execute(q2);
         int serial=0;
         List<Ordered_list> l1 = new ArrayList<>();
         AddOrder ao = new AddOrder();
		 Ordered_listDAO ol = new Ordered_listDAO();
		 while(sc.hasNext()) {
			 int choice   = Integer.parseInt(sc.nextLine());
			 if(choice==0) break;
			 System.out.println("Enter the number of items");
			 int nos = Integer.parseInt(sc.nextLine());
			 String query2 ="SELECT * FROM Food_items WHERE Id='"+choice+"'";
			 ResultSet rs2 = st.executeQuery(query2);
			 int id=0;String food_name="";int quantity=0;double amt=0d;
			 while(rs2.next()) {
				 id        =rs2.getInt(1);
				 food_name =rs2.getString(2);
				 quantity  =rs2.getInt(3);
				 amt       =rs2.getDouble(4);
			 } 
			 rs2.close();
			 serial++;
			 quantity = quantity *nos;
			 amt = ol.final_price(quantity, amt);
		     //Total of ordered items
			 Ordered_list o = new Ordered_list(id,food_name,quantity,amt);
			 o.setSeraial_no(serial);
			 o.setId(id);
			 o.setDish_name(food_name);
			 o.setQuantity(quantity);
			 o.setPrice(amt);
			 l1.add(o);
			 ao.add(o);
			 System.out.println("Enter the next item u need");
		 }
		 System.out.println("Your order details");
		 String query4="SELECT * FROM Menu";
		 ResultSet rs3=st.executeQuery(query4);
		 System.out.format("%-5s %-17s %-9s %-5s\n","Id","Food_Name","Quantity","Price");
		 while(rs3.next()) {
	    	 System.out.format("%-5s %-17s %-9s %-5s\n",rs3.getInt(1),rs3.getInt(2),rs3.getString(3),rs3.getInt(4),rs3.getDouble(5));
	     }
		 rs3.close();
		 double total = ol.total(l1);
		 System.out.println("Your total amount is "+total);
		 double discount = ol.discount_amt(l1);
		 if(total>500 && total<1000) {
			 System.out.println("For above purchase of 500$ 5%discount");
			 total = total - discount;
			 System.out.println("Your discounted amount = "+discount);
		 }
		 else if(total>1000) {
			 System.out.println("For above purchase of 1000$ 10%discount");
			 discount = total *0.1;
			 total = total - discount;
			 System.out.println("Your discounted amount = "+discount);
		 }
		 System.out.println("Your payable amount = "+total);
		 System.out.println("If your sure to pay press 'y' else for cancel'n'");
		 String chk = sc.nextLine();
		 PaymentDAO pd = new PaymentDAO();
		 Payment py = new Payment();
		 AddPayment ap = new AddPayment();
		 if(chk.equalsIgnoreCase("y")) {
			 String Customer_name = c1.getCustomer_name();
			 Double total1 = total;
			 String transaction_id = pd.transact_id();
			 Date Curent_date = pd.pay_day();
			 Time Cuurent_time = pd.pay_time();
			 py.setCustomer_name(Customer_name);
			 py.setPaid_amount(total1);
			 py.setTransaction_id(transaction_id);
			 py.setPaid_date(Curent_date);
			 py.setPaid_time(Cuurent_time);
			 ap.add(py);
			 System.out.println("Payment successfull your order will be delivered soon at "+c1.getCustomer_address()+" ,Thank you");
		 }
		 else {
			 System.out.println("Payment Cancelled....");
			 System.exit(0);
		 }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
