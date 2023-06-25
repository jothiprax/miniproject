package com.kce.hbs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.kce.hbs.bean.Room;
import com.kce.hbs.dao.HotelBookingDAO;
import com.kce.hbs.util.DBUtil;
import com.kce.hbs.util.OverBookingException;
import com.kce.hbs.util.RoomUnAvailableException;

public class HotelBooking {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ch; // used to get the choice from the user
        while (true) {
            // Menu to book, update or check out room
            System.out.println("------------------------------Hotel Booking System------------------------------");
            System.out.println("1. Book an Room");
            System.out.println("2. Update Check out date");
            System.out.println("3. Check out");
            System.out.println("4. Display all the Bookings");
            System.out.println("5. Exit");
            // getting choice from the user
            System.out.println("Enter your Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    CreatingBooking();
                    break;
                case 2:
                    if (HotelBookingDAO.update_Check_out_date())
                        System.out.println("Check out date updated Successfully");
                    else
                        System.out.println("Sothing Wrong");
                    break;
                case 3:
                    if (HotelBookingDAO.checkOut())
                        System.out.println("You have checked Out successfully.");
                    else
                        System.out.println("Somthing Wrong");
                    break;
                case 4:
                    List<Room> list = HotelBookingDAO.getAllBookings();

                    list.stream().forEach(System.out::println);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Data");
            }
        }
    }

    private static void CreatingBooking() throws Exception {
        Room room = HotelBookingDAO.getBookingDetails();

        try {
            if (getRoomsCount(room.getHotelId()) >= 100) {
                throw new OverBookingException();
            }

            if (getRooms(room.getHotelId()).contains(room.getRoomNo())) {
                throw new RoomUnAvailableException();
            }

            Connection con = DBUtil.getConnection();
            PreparedStatement stmt1 = con.prepareStatement("INSERT INTO Room VALUES(?,?,?,?,?,?)");
            stmt1.setInt(1, room.getHotelId());
            stmt1.setInt(2, room.getRoomNo());
            stmt1.setString(3, room.getGuestName());
            stmt1.setInt(4, room.getGuestCount());
            stmt1.setString(5, room.getCheck_in_date());
            stmt1.setString(6, room.getCheck_out_date());
            stmt1.executeUpdate();

            System.out.println("\nBooking Successful....\n");

        } catch (OverBookingException e) {
            System.err.println(e);
        } catch (RoomUnAvailableException e) {
            System.out.println(e);
        }

    }

    private static int getRoomsCount(int hotelId) throws Exception {

        int count = 0;
        // Creating connection to the Database
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        String sqlQuery = "SELECT COUNT(*) FROM ROOM where hotelId = " + hotelId;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    private static List<Integer> getRooms(int hotelId) throws Exception {

        // List to add all the rooms which are Booked in that hotel
        List<Integer> listOfRooms = new ArrayList<>();

        // Creating connection to the database
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        String sqlQuery = "SELECT roomNo FROM ROOM where hotelId = " + hotelId;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            listOfRooms.add(rs.getInt(1));
        }
        return listOfRooms;
    }
}
