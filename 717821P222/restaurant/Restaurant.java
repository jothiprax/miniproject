package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
class OutOfChoicesException extends Exception
{
	public String toString()
	{
		return "You entered Invalid Choices";
	}
}

public class Restaurant{
	private static Connection connection;
    private  static Statement statement;
	public static void main(String[] args) throws SQLException, OutOfChoicesException {
		MenuItem menuitem= new MenuItem();
		Order order=new Order();
		
		System.out.println("Welcome to our Restaurant !!!");
		Scanner scanner=new Scanner(System.in);
        try {
	            String url="jdbc:mysql://127.0.0.1:3306/restaurant";
	            String username="root";
	            String password="teddy@22";
	            connection = DriverManager.getConnection(url,username,password);
	            //System.out.println(connection);
	            statement = connection.createStatement();
	        } catch (SQLException e) {
	            e.printStackTrace();
	      }
		 int verify=1;
		 while(verify!=0)
		 {
		   System.out.println("--------------------------------------------------------------");
		   System.out.println("1.View Menu card");
		   System.out.println("2.Add Food Order");
		   System.out.println("3.Show Order");
		   System.out.println("4.Display_Bill");
		   System.out.println("5. Exit !!! Enter 5");
		   System.out.println("---------------------------------------------------------------");
		   System.out.println("Enter your choice : ");
		  
		   int  option=scanner.nextInt();
		   switch(option)
		   {
		   case 1: menuitem.display();
		           break;
		   case 2: order.orderFood();
		           break;
		   case 3:order.Show_Order();
		          break;
		   case 4:order.Bill_Amount();
	              break;
		   case 5:order.Food_Served();
		          return;
	      default: 
	    	  try{
	    		  throw new OutOfChoicesException();
	    	  }
	    	  catch(OutOfChoicesException e) {
	    	    System.err.println(e);
	    	  }
	               
	          
		   
		   }
		   
		 }
	    }
	
	}

