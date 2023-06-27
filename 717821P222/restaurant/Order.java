package restaurant;

import java.sql.*;
import java.util.Scanner;

public class Order {
    
    public void Bill_Amount() throws SQLException
    {
    	String url="jdbc:mysql://127.0.0.1:3306/restaurant";
        String username="root";
        String password="teddy@22";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
        String query="select sum(total_price) from orders";
        ResultSet resultset=statement.executeQuery(query);
        double Bill_Amount=0.0;
        while(resultset.next())
        {
        	Bill_Amount=resultset.getDouble(1);
        }
        System.out.println("TOTAL BILL_AMOUNT = "+Bill_Amount);
        	
    }
    public void Food_Served() throws SQLException
    {
    	String url="jdbc:mysql://127.0.0.1:3306/restaurant";
        String username="root";
        String password="teddy@22";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
        String query="delete from orders ";
        int c=statement.executeUpdate(query);
        System.out.println(c);
        System.out.println("Thank u visiting our restaurant ...");
        	
    }
    
    public void Show_Order() throws SQLException
    {
    	String url="jdbc:mysql://127.0.0.1:3306/restaurant";
        String username="root";
        String password="teddy@22";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
        String query="select * from orders";
        ResultSet resultset=statement.executeQuery(query);
        System.out.printf("%-20s%-20s%-20s%-20s\n","Food_id","Food_name","Food_Quantity","Total_Price");
        while(resultset.next())
        {
        	System.out.printf("%-20s%-20s%-20s%-20s\n",resultset.getInt(1),resultset.getString(2),resultset.getInt(3),resultset.getFloat(4));
        }
        

    }
    public void orderFood ()throws SQLException
    {
    	Scanner scanner= new Scanner(System.in);
    	String url="jdbc:mysql://127.0.0.1:3306/restaurant";
        String username="root";
        String password="teddy@22";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();

        int choice=1;
        while(choice!=0) {
        System.out.println("Enter The food Id:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter The food name :");
        String foodname=scanner.nextLine();
        System.out.println("Enter The Quanttity:");
        int quantity=scanner.nextInt();
        String query="select price from  menu_items where id="+id;
        double foodPrice=0.0;
        
 
       ResultSet rs=statement.executeQuery(query);
       while( rs.next())
       foodPrice=rs.getDouble(1);
    	  
        float total_price=(float)(quantity*foodPrice);
        System.out.println(total_price);
        String query1="insert into orders values(?,?,?,?)";

        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
        preparedStatement1.setInt(1,id);
        preparedStatement1.setString(2, foodname);
        preparedStatement1.setInt(3, quantity);
        preparedStatement1.setFloat(4,total_price);
        preparedStatement1.executeUpdate();               
        
        System.out.println("If you want to order another item : Enter 1 else Enter 0");
        int choice2=scanner.nextInt();
        choice=choice2;
        
        }
        connection.close();
        
    }
    
}
