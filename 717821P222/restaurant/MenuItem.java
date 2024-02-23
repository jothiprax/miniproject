package restaurant;

import java.sql.*;


public class MenuItem {
    private int id;
    private String name;
    private double price;
    private String category;
    
    public MenuItem()
    {
    }	
    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

	public void display() throws SQLException
	{
		String url="jdbc:mysql://127.0.0.1:3306/restaurant";
        String username="root";
        String password="teddy@22";
        Connection connection = DriverManager.getConnection(url,username,password);
        String query="select * from menu_items";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        System.out.printf("%-20s%-20s%-20s%-20s\n","food id","food name","vilai","v/nv");
        while (resultSet.next()) {
        	System.out.printf("%-20s%-20s%-20s%-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4));
        }
        }
	}

	


