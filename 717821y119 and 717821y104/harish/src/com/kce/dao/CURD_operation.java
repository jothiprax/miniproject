package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import com.kce.bean.*;
import com.kce.util.DBConnection;
import com.kce.util.RoomsUnavailableException;

public class CURD_operation  {
	
	static Connection con =DBConnection.getConnection();
	public static void InsertHotel(String name, int hotelId, String city, String phoneNumber,int noOfRooms) throws RoomsUnavailableException {
		if(noOfRooms>5)throw new RoomsUnavailableException();
	try  {
        String sql = "INSERT INTO hotel (name, hotelid, city, phonenumber,noOfRooms) VALUES (?, ?, ?, ?,?)";
        PreparedStatement statement = con.prepareStatement(sql);

        Hotel obj=new Hotel(name,hotelId,city,phoneNumber,noOfRooms);
        statement.setString(1,obj.getName());
        statement.setInt(2,obj.getHotelId());
        statement.setString(3,obj.getCity());
        statement.setString(4, obj.getPhoneNumber());
        statement.setInt(5, noOfRooms);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new row has been inserted.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	}
	public static void InsertCustomer(String customerName, int hotelId, int bookingId, int roomNo,int noOfDays, String bookDate,String roomtype) {
		try  {
	        String sql = "INSERT INTO hotel (Customername, hotelid, bookingId, roomNo,noOfDays,bookDate) VALUES (?, ?, ?, ?,?,?)";
	        PreparedStatement statement = con.prepareStatement(sql);

	        Customer obj=new Customer(customerName,hotelId,bookingId,roomNo,noOfDays,bookDate,roomtype);
	        statement.setString(1,obj.getCustomerName());
	        statement.setInt(2,obj.getHotelId());
	        statement.setInt(3,obj.getBookingId());
	        statement.setInt(4, obj.getRoomNo());
	        statement.setInt(5, obj.getNoOfDays());
	        statement.setString(6, obj.getBookDate());
	        statement.setString(6, obj.getRoomtype());

	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A new row has been inserted.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		}
	public static void RetriveHotel(){

        try {
            Statement statement = con.createStatement();
            String query = "SELECT name, hotelid, city, phonenumber, noofrooms FROM hotel";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int hotelId = resultSet.getInt("hotelid");
                String city = resultSet.getString("city");
                String phoneNumber = resultSet.getString("phonenumber");
                int numOfRooms = resultSet.getInt("noofrooms");

                System.out.println("Name: " + name);
                System.out.println("Hotel ID: " + hotelId);
                System.out.println("City: " + city);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Number of Rooms: " + numOfRooms);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public static void RetriveCustomer() {
		try {
		 Statement statement = con.createStatement();
		 String query = "SELECT * FROM customer";
         ResultSet resultSet = statement.executeQuery(query);
         while (resultSet.next()) {
             String customerName = resultSet.getString(1);
             int hotelId = resultSet.getInt(2);
             int bookingId = resultSet.getInt(3);
             int roomNo = resultSet.getInt(4);
             int noOfDays = resultSet.getInt(5);
             Date bookDate = resultSet.getDate(6);
             String roomtype=resultSet.getString(7);
             System.out.println("Customer Name: " + customerName);
             System.out.println("Hotel ID: " + hotelId);
             System.out.println("Booking ID: " + bookingId);
             System.out.println("Room No: " + roomNo);
             System.out.println("Number of Days: " + noOfDays);
             System.out.println("Booking Date: " + bookDate);
             if(roomtype.equalsIgnoreCase("Normal"))
            	 System.out.println("Bill Amount ="+noOfDays*1000);
             else if(roomtype.equalsIgnoreCase("Delux"))
                 System.out.println("Bill Amount ="+noOfDays*2000);
             else if(roomtype.equalsIgnoreCase("Suite"))
                 System.out.println("Bill Amount ="+noOfDays*3000);
             System.out.println("---------------------------");
         }

     } catch (SQLException e) {
         e.printStackTrace();
     }
	}
    public static void DeleteHotel(int hotelId) {
        String sql = "DELETE FROM hotel WHERE hotelid = ?";
        	try {
             PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, hotelId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the specified hotel ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteCustomer(int bookingId) {
        String sql = "DELETE FROM Customer WHERE bookingid = ?";
        	try {
             PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookingId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the specified Booking ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
