package com.kce.hbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.kce.hbs.bean.Room;
import com.kce.hbs.util.DBUtil;

public class HotelBookingDAO {
    public static Room getBookingDetails() {
        int hotelId; // hotelId of the Hotel (generated using random() method )
        int roomNo; // room no that guest wants
        int guestCount; // total no of guest
        String guestName; // guest name (one who books the room)
        String check_in_date; // date of check-in to the hotel
        String check_out_date; // date of check out

        // Creating room referance to store details
        Room room = null;

        // Scanner for getting inputs
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--------------Hotel Details--------------\n");
        System.out.println("1) ABC Hotel, Chennai");
        System.out.println("2) XYZ Hotel, Coimbatore");
        System.out.println("3) Hotel Hari, Coimbatore");
        System.out.println("4) Hotel SRK, Chennai");
        System.out.println("5) PQR Hotel, Chennai\n");
        System.out.println("Enter Hotel Id: ");
        hotelId = sc.nextInt();
        System.out.println("Enter Room no: ");
        roomNo = sc.nextInt();
        System.out.println("Enter Guest Count: ");
        guestCount = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Guest Name: ");
        guestName = sc.nextLine();
        System.out.println("Check In Date: ");
        check_in_date = sc.nextLine();
        System.out.println("Check Out Date: ");
        check_out_date = sc.nextLine();

        // Initialize the Room class fields with the Constructor
        room = new Room(hotelId, roomNo, guestCount, guestName, check_in_date, check_out_date);

        return room;
    }

    public static boolean update_Check_out_date() throws Exception {
        Scanner sc = new Scanner(System.in);
        // Getting hotel Id
        System.out.println("Enter your Hotel Id: ");
        int hotelId = sc.nextInt();
        // Getting Room No
        System.out.println("Enter your Room No: ");
        int roomNo = sc.nextInt();
        sc.nextLine();
        // Getting updated date
        System.out.println("Enetr the new Check out Date: ");
        String updatedDate = sc.nextLine();
        System.out.println(updatedDate);
        // Creating Connection to the Database
        Connection con = DBUtil.getConnection();
        String query = "UPDATE Room SET  check_out_date = ? where hotelId = ? and1 roomNo = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, updatedDate);
        stmt.setInt(2, hotelId);
        stmt.setInt(3, roomNo);
        int n = stmt.executeUpdate();
        if (n == 1)
            return true;
        else
            return false;
    }

    public static boolean checkOut() throws Exception {
        Scanner sc = new Scanner(System.in);
        // Getting hotel Id
        System.out.println("Enter your Hotel Id: ");
        int hotelId = sc.nextInt();
        // Getting Room No
        System.out.println("Enter your Room No: ");
        int roomNo = sc.nextInt();

        // Creating Connection to the Database
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        String query = "DELETE FROM Room where hotelId = " + hotelId + " and roomNo = " + roomNo;
        int n = stmt.executeUpdate(query);
        if (n == 1)
            return true;
        else
            return false;
    }

    public static List<Room> getAllBookings() throws Exception {
        List<Room> list = new ArrayList<>();
        Room room = null;

        // Creating Connection to the Database
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        String query = "SELECT h.hotelId,h.name,h.location,r.roomNo,r.guestCount,r.guestName,r.check_in_date,r.check_out_date from Room r join Hotel h where h.hotelId = r.hotelId";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int hotelId = rs.getInt(1);
            String name = rs.getString(2);
            String location = rs.getString(3);
            int roomNo = rs.getInt(4);
            int guestCount = rs.getInt(5);
            String guestName = rs.getString(6);
            String check_in_date = rs.getString(7);
            String check_out_date = rs.getString(8);

            room = new Room(hotelId, name, location, roomNo, guestCount, guestName, check_in_date, check_out_date);
            list.add(room);
        }

        return list;
    }
}
