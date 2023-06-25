package com.kce.hotel.service;
import com.kce.hotel.bean.Guest;
import com.kce.hotel.bean.Hotel;
import com.kce.hotel.dao.GuestDAO;
import com.kce.hotel.dao.HotelDAO;
import com.kce.hotel.util.GuestException;
import com.kce.hotel.util.HotelException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    HotelDAO hotelDAO=new HotelDAO();
    GuestDAO guestDAO = new GuestDAO();


    public static void main(String[] args) throws SQLException {
        Main main= new Main();
        System.out.println("Hotel management system");
        System.out.println();
        int repeat;
        do {
            System.out.println("If you want to manage guests, press 1");
            System.out.println("If you want to manage hotels, press 2");
            System.out.print("Enter your choice: ");
            int mainChoice = in.nextInt();
            if (mainChoice == 1) {
                System.out.println("If you want to create a new guest, press 1");
                System.out.println("If you want to view a particular guest, press 2");
                System.out.println("If you want to view all guests, press 3");
                System.out.println("If you want to update an existing guest, press 4");
                System.out.println("If you want to delete a guest, press 5");
                int guestChoice = in.nextInt();
                if (guestChoice == 1)
                    main.createGuest();
                else if (guestChoice == 2)
                    main.particularGuest();
                else if (guestChoice == 3)
                    main.allGuests();
                else if (guestChoice == 4)
                    main.updateGuest();
                else
                    main.deleteGuest();
            } else {
                System.out.println("If you want to create a new hotels, press 1");
                System.out.println("If you want to update an existing hotel, press 2");
                System.out.println("If you want to delete an existing hotel, press 3");
                System.out.println("If you want to view a hotel, press 4");
                int hotelChoice = in.nextInt();
                if (hotelChoice == 1)
                    main.createHotel();
                else if (hotelChoice == 2)
                    main.updateHotel();
                else if (hotelChoice == 3)
                    main.deleteHotel();
                else
                    main.getHotel();
            }
            System.out.println("Do you want to continue your work? Press 1 for Yes, 0 for No");
            repeat = in.nextInt();
        } while (repeat == 1);
    }
    public  void createHotel() throws SQLException {
        System.out.println("Enter the hotel id");
        int id = in.nextInt();
        in.nextLine(); // to obtain the buffer when the enter key  pressed.
        System.out.println("Enter the hotel name");
        String name = in.nextLine();
        System.out.println("Enter the hotel location");
        String location = in.nextLine();
        Hotel hotel = new Hotel(id, name, location);
        try {
        hotelDAO.createHotel(hotel);
        System.out.println("Hotel created successfully!");

        }catch (HotelException e){
            System.out.println(e);
        }
    }
    public  void updateHotel() throws SQLException {
        System.out.println("Enter the hotel id");
        int id = in.nextInt();
        in.nextLine(); // to obtain the buffer when the enter key  pressed.
        Hotel hotel = hotelDAO.getHotelById(id);
        if (hotel != null) {
            System.out.println("Enter the new hotel name");
            String name = in.nextLine();
            System.out.println("Enter the new hotel location");
            String location = in.nextLine();
            hotel.setName(name);
            hotel.setLocation(location);
            hotelDAO.updateHotel(hotel);
            System.out.println("Hotel updated successfully!");
        } else {
            System.out.println("Hotel not found!");
        }
    }
    public  void deleteHotel() throws SQLException {
        System.out.println("Enter the hotel id");
        int id = in.nextInt();
        Hotel hotel = hotelDAO.getHotelById(id);
        if (hotel != null) {
            hotelDAO.deleteHotel(id);
            System.out.println("Hotel deleted successfully!");
        } else {
            System.out.println("Hotel not found!");
        }
    }
    public  void getHotel() throws SQLException {
        System.out.println("Enter the hotel id");
        int id = in.nextInt();
        Hotel hotel = hotelDAO.getHotelById(id);
        if (hotel != null) {
            System.out.println("Hotel ID: " + hotel.getId());
            System.out.println("Hotel Name: " + hotel.getName());
            System.out.println("Hotel Location: " + hotel.getLocation());
        } else {
            System.out.println("Hotel not found!");
        }
    }
    public  void createGuest() throws SQLException{
        System.out.println("Enter the guest id");
        int id = in.nextInt();
        in.nextLine(); // to obtain the buffer when the enter key  pressed.
        System.out.println("Enter the guest name");
        String name = in.nextLine();
        System.out.println("Enter the guest email");
        String email = in.nextLine();
        Guest guest = new Guest(id, name, email);
        try {
            guestDAO.createGuest(guest);
            System.out.println("Guest created successfully!");
        }catch (GuestException e){
            System.out.println(e);
        }
    }
    public  void particularGuest() throws SQLException {
        System.out.println("Enter the guest id");
        int id = in.nextInt();
        Guest guest = guestDAO.getGuestById(id);
        if (guest != null) {
            System.out.println("Guest ID: " + guest.getId());
            System.out.println("Guest Name: " + guest.getName());
            System.out.println("Guest Email: " + guest.getEmail());
        } else {
            System.out.println("Guest not found!");
        }
    }
    public  void allGuests() throws SQLException {
        System.out.println("List of all guests:");
        for (Guest guest : guestDAO.getAllGuests()) {
            System.out.println("Guest ID: " + guest.getId());
            System.out.println("Guest Name: " + guest.getName());
            System.out.println("Guest Email: " + guest.getEmail());
        }
    }
    public  void updateGuest() throws SQLException {
        System.out.println("Enter the guest id");
        int id = in.nextInt();
        in.nextLine(); // to obtain the buffer when the enter key  pressed.
        Guest guest = guestDAO.getGuestById(id);
        if (guest != null) {
            System.out.println("Enter the new guest name");
            String name = in.nextLine();
            System.out.println("Enter the new guest email");
            String email = in.nextLine();
            guest.setName(name);
            guest.setEmail(email);
            guestDAO.updateGuest(guest);
            System.out.println("Guest updated successfully!");
        } else {
            System.out.println("Guest not found!");
        }
    }
    public  void deleteGuest() throws SQLException {
        System.out.println("Enter the guest id");
        int id = in.nextInt();
        Guest guest = guestDAO.getGuestById(id);
        if (guest != null) {
            guestDAO.deleteGuest(id);
            System.out.println("Guest deleted successfully!");
        } else {
            System.out.println("Guest not found!");
        }
    }

}
