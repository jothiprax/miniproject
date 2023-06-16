package com.kce.hotel.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import com.kce.hotel.dao.RoomDAO;
import com.kce.hotel.util.RoomUnavailableException;
import com.kce.hotel.util.OverbookingException;
import com.kce.hotel.bean.Booking;
import com.kce.hotel.bean.Room;

public class HotelBookingApp {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
            RoomDAO roomDAO = new RoomDAO(connection);
            List<Room> availableRooms = roomDAO.getAvailableRooms();
            System.out.println("------Welcom to HOTEL-------");
            System.out.println("\nAvailable rooms: only 5\n");
            for (Room room : availableRooms) {
                System.out.println(room.getRoomNumber() + " - " + room.getType());
            }
            Scanner sc=new Scanner(System.in);
             int rooms=210;
            Booking booking = new Booking();
            booking.setRoomNumber(rooms);
            System.out.println("1)Enter the Name: ");
            booking.setGuestName(sc.nextLine());
            System.out.println("1)Enter the In Date: ");
            booking.setCheckInDate(sc.next());
            System.out.println("1)Enter the Out Date: ");
            booking.setCheckOutDate(sc.next());
            
            Booking booking1 = new Booking();
            booking1.setRoomNumber(++rooms);
            System.out.println("2)Enter the Name: ");
            booking1.setGuestName(sc.next());
            System.out.println("2)Enter the In Date: ");
            booking1.setCheckInDate(sc.next());
            System.out.println("2)Enter the Out Date: ");
            booking1.setCheckOutDate(sc.next());
            try {
                roomDAO.bookRoom(booking);
                System.out.println("Room booked successfully.");
                System.out.println("*****************************************************************************************");
                System.out.println("Details:");
                System.out.println("Room Number: "+booking.getRoomNumber()+"\tName: "+booking.getGuestName()+"\tIn Date: "+booking.getCheckInDate()+"\tOut Date: "+booking.getCheckOutDate()+"\n");
                System.out.println("Room Number: "+booking1.getRoomNumber()+"\tName: "+booking1.getGuestName()+"\tIn Date: "+booking1.getCheckInDate()+"\tOut Date: "+booking1.getCheckOutDate()+"\n");
                System.out.println("*****************************************************************************************");
                System.out.println("Thank you!\n");
            } catch (RoomUnavailableException e) {
                System.out.println("Failed to book room: " + e.getMessage());
            } catch (OverbookingException e) {
                System.out.println("Failed to book room: " + e.getMessage());
            }
            connection.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
