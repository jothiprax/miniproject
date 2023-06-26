package KCE;

 
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Scanner;

 
public class Ecommerce
{
  
public static void main (String[]args) throws SQLException,
    ProductNotFoundException
  {
    
Connection conn = null;
    
PreparedStatement stmt = null;
    
try
    {
      
conn =
	DriverManager.getConnection ("jdbc:mysql://localhost:3306/Ecommerce",
				     "root", "Admin@14");
    
} catch (SQLException e1)
    {
      
	// TODO Auto-generated catch block
	e1.printStackTrace ();
    
} 
Scanner sc = new Scanner (System.in);
    
while (true)
      {
	
System.out.
	  println
	  ("Enter 1 to add product \nEnter 2 to Update product\nEnter 3 to delete Product\nEnter 0 to delete Product\n");
	
int check = sc.nextInt ();
	
sc.nextLine ();
	
switch (check)
	  {
	  
case 1:
	    
System.out.println ("Enter product id to add");
	    
String id = sc.nextLine ();
	    
System.out.println ("Enter product name to add");
	    
String name = sc.nextLine ();
	    
System.out.println ("Enter product price to add");
	    
double d = sc.nextDouble ();
	    
Add_products.addProduct (conn, id, name, d);
	    
System.out.println ("Enter product id to get");
	    
sc.nextLine ();
	    
String gp = sc.nextLine ();
	    
Product product = Retrive.getProduct (conn, gp);
	    
System.out.println ("Retrieved product: " + product);
	    
break;
	  
case 2:
	    
 
System.out.
	      println ("Enter product id which you need to update");
	    
String newid = sc.nextLine ();
	    
System.out.println ("Enter product name and price to update");
	    
String newname = sc.nextLine ();
	    
double newprice = sc.nextDouble ();
	    
Update.updateProduct (conn, newid, newname, newprice);
	    
product = Retrive.getProduct (conn, newid);
	    
System.out.println ("Updated product: " + product);
	    
break;
	  
case 3:
	    
System.out.println ("Enter product to delete");
	    
String delid = sc.nextLine ();
	    
Delete.deleteProduct (conn, delid);
	    
System.out.println ("The product id=" + delid +
				 " is deleted successfully");
	  
case 4:
	    
System.out.println ("Thank you");
	    
return;
	  
}
      
}
  
}

}


 
 
