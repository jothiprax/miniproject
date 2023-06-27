package shopManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update_stock {
	Scanner sc=new Scanner(System.in);
	String name=null,phonenumber = null;
	public void update(int bill_no,int val) throws Exception {
		
		int availableqty = 0;
		double med_price = 0;
		System.out.println ("Required Tablet:");
		String med_name = sc.nextLine();
		System.out.println ("Quantity Required:");
		int quantity_wanted = sc.nextInt ();
		sc.nextLine();
		Quantity_Check qc =new Quantity_Check (med_name, quantity_wanted);
		Connection con;
		con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject", "root","Manick@14");
		Statement st = con.createStatement ();
		if (qc.check ())
			{
				String query ="select product_price,Quantity from Available_stocks where product_name='"+med_name + "'";
				ResultSet rs = st.executeQuery (query);
				rs.next();
				availableqty = rs.getInt (2) - quantity_wanted;
				med_price = quantity_wanted * rs.getDouble (1);
				System.out.println (med_price);
				st.executeUpdate ("update Available_stocks set Quantity=" +availableqty + " where product_name='" +med_name + "'");
				if(val==0) {
				System.out.println ("Enter The Customer Details:\n");
				System.out.println ("Customer Name : \n");
				name = sc.nextLine();
				System.out.println ("Customer Phone Number : \n");
				 phonenumber = sc.nextLine();
				}
				Customer_Details cd =new Customer_Details (bill_no,	name, phonenumber, med_name,med_price);
				cd.update_details ();
				Update_bill ub=new Update_bill(bill_no,name,med_price);
				ub.add_bill(con);
			}
		else	      
			{
			throw new OutOfStockException ("Sorry out of stock");      
			}
	}
}
