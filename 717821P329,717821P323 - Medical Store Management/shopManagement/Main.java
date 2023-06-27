package shopManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main 
{
public static void main (String[]args) throws Exception 
  {
    Scanner sc = new Scanner (System.in);
	Random ra = new Random ();  
    Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject","root", "Manick@14");
    Statement st = con.createStatement ();
    while (true)
      {
    		System.out.println ("Enter 1 to Add Stock");
    		System.out.println ("Enter 2 to Buy Medicine");
    		System.out.println ("Enter 3 to Display The List of Products");
    		System.out.println ("Enter 4 to Display The List of Customers");
    		System.out.println("Enter 5 to get bill details");
    		System.out.println ("Enter 0 to exit");
    		int val = sc.nextInt ();
    		switch (val)
    			{
    				case 1:
    					System.out.println("Enter 1 for Adding Medicine");
    					System.out.println("Enter 2 for Adding Quantity for Medicine");
    					int c=sc.nextInt();
    					sc.nextLine();
    					if(c==1) {
    					System.out.println("Enter Product Id:");
    					int pid = sc.nextInt ();
    					sc.nextLine ();
    					System.out.println("Enter Product Name:");
    					String pname = sc.nextLine ();
    					System.out.println("Enter Product Price:");
    					double price = sc.nextDouble ();
    					System.out.println("Enter Product Quantity:");
    					int quantity = sc.nextInt ();
    					Add_Stock a = new Add_Stock (pid, pname, price, quantity);
    					a.addMedicine();
    					}
    					else {
    						System.out.println("Enter Product Name:");
    						String name=sc.nextLine();
    						System.out.println("Enter Product Quantity:");
    						int qty=sc.nextInt();
    						Add_Stock a = new Add_Stock ();
        					a.addQuantity(qty,name);
    					}
    					break;
    				case 2:
    					int bill_no = ra.nextInt (1000000000);
    					int j=0;
    					Update_stock us=new Update_stock();
    					while(true) {
    					us.update(bill_no,j);
    					j=1;
    					System.out.println("Enter 0 to stop buying or Enter 1 to buy again");
    					int ret=sc.nextInt();
    					sc.nextLine();
    					if(ret==0)
    						break;
    					}
    					break;
    				case 3:
    					System.out.println("The Products in the store are:");
    					ResultSet rs = st.executeQuery ("select * from Available_stocks");
    					System.out.printf("%-20s%-20s%-20s%-20s\n","Product Id","Product Name","Product Price","Product Quantity");
    					while(rs.next()) {
    						System.out.printf("%-20s%-20s%-20s%-20s\n",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
    					}
    					break;
    				case 4:
    					try {
    					System.out.println("The Customers of the Store are:");
    					ResultSet r = st.executeQuery ("select * from Customer_details");
    					
    					System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","Bill No","Customer Name","Customer Phone Number","Medicine Name","Total Purchacse Amount");
    					while(r.next()) {
    						System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(3));
    					}
    					}
    					catch(Exception e) {
    						e.printStackTrace();
    					}
    					break;
    				case 5:
    					Retrive_billdetails rb=new Retrive_billdetails();
    					System.out.println("Enter bill no to retrive");
    					int billnum=sc.nextInt();
    					rb.retrive(billnum, con);
    					break;
    				case 0:
    					System.out.println ("-----------------Thank you------------------");	    
    					return;
    			}
      }
  }
}
