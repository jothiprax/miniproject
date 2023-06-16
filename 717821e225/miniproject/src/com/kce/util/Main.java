package com.kce.util;
import com.kce.bean.*;
import com.kce.*;
import com.kce.dao.*;
import java.util.*;
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Scanner sc1 = new Scanner(System.in);
    private static List<Resort> resorts = new ArrayList<>();
    private static List<Guest> guests = new ArrayList<>();
    public static void main(String args[]) {
        System.out.println("Resort management system");
        System.out.println();
        int repeat;
        do {
            System.out.println("If you want to manage guests, press 1");
            System.out.println("If you want to manage resorts, press 2");
            int mainChoice = sc.nextInt();

            if (mainChoice == 1) {
                System.out.println("If you want to create a new guest, press 1");
                System.out.println("If you want to view a particular guest, press 2");
                System.out.println("If you want to view all guests, press 3");
                System.out.println("If you want to update an existing guest, press 4");
                System.out.println("If you want to delete a guest, press 5");
                int guestChoice = sc.nextInt();

                if (guestChoice == 1)
                    createGuest();
                else if (guestChoice == 2)
                    particularGuest();
                else if (guestChoice == 3)
                    allGuests();
                else if (guestChoice == 4)
                    updateGuest();
                else
                    deleteGuest();
            } else {
                System.out.println("If you want to create a new resort, press 1");
                System.out.println("If you want to update an existing resort, press 2");
                System.out.println("If you want to delete an existing resort, press 3");
                System.out.println("If you want to view a resort, press 4");
                int resortChoice = sc.nextInt();

                if (resortChoice == 1)
                    createResort();
                else if (resortChoice == 2)
                    updateResort();
                else if (resortChoice == 3)
                    deleteResort();
                else
                    getResort();
            }

            System.out.println("Do you want to continue your work? Press 1 for Yes, 0 for No");
            repeat = sc.nextInt();
        } while (repeat == 1);
    }

    public static void createResort() {
        System.out.println("Enter the resort id");
        int id = sc.nextInt();
        System.out.println("Enter the resort name");
        String name = sc1.nextLine();
        System.out.println("Enter the resort location");
        String location = sc1.nextLine();
        Resort resort = new Resort(id, name, location);
        resorts.add(resort);
        System.out.println("Resort created successfully!");
    }

    public static void updateResort() {
        System.out.println("Enter the resort id");
        int id = sc.nextInt();
        Resort resort = findResortById(id);
        if (resort != null) {
            System.out.println("Enter the new resort name");
            String name = sc1.nextLine();
            System.out.println("Enter the new resort location");
            String location = sc1.nextLine();
            resort.setName(name);
            resort.setLocation(location);
            System.out.println("Resort updated successfully!");
        } else {
            System.out.println("Resort not found!");
        }
    }

    public static void deleteResort() {
        System.out.println("Enter the resort id");
        int id = sc.nextInt();
        Resort resort = findResortById(id);
        if (resort != null) {
            resorts.remove(resort);
            System.out.println("Resort deleted successfully!");
        } else {
            System.out.println("Resort not found!");
        }
    }

    public static void getResort() {
        System.out.println("Enter the resort id");
        int id = sc.nextInt();
        Resort resort = findResortById(id);
        if (resort != null) {
            System.out.println("Resort ID: " + resort.getId());
            System.out.println("Resort Name: " + resort.getName());
            System.out.println("Resort Location: " + resort.getLocation());
        } else {
            System.out.println("Resort not found!");
        }
    }

    public static void createGuest() {
        System.out.println("Enter the guest id");
        int id = sc.nextInt();
        System.out.println("Enter the guest name");
        String name = sc1.nextLine();
        System.out.println("Enter the guest email");
        String email = sc1.nextLine();
        Guest guest = new Guest(id, name, email);
        guests.add(guest);
        System.out.println("Guest created successfully!");
    }

    public static void particularGuest() {
        System.out.println("Enter the guest id");
        int id = sc.nextInt();
        Guest guest = findGuestById(id);
        if (guest != null) {
            System.out.println("Guest ID: " + guest.getId());
            System.out.println("Guest Name: " + guest.getName());
            System.out.println("Guest Email: " + guest.getEmail());
        } else {
            System.out.println("Guest not found!");
        }
    }

    public static void allGuests() {
        System.out.println("List of all guests:");
        for (Guest guest : guests) {
            System.out.println("Guest ID: " + guest.getId());
            System.out.println("Guest Name: " + guest.getName());
            System.out.println("Guest Email: " + guest.getEmail());
        }
    }

    public static void updateGuest() {
        System.out.println("Enter the guest id");
        int id = sc.nextInt();
        Guest guest = findGuestById(id);
        if (guest != null) {
            System.out.println("Enter the new guest name");
            String name = sc1.nextLine();
            System.out.println("Enter the new guest email");
            String email = sc1.nextLine();
            guest.setName(name);
            guest.setEmail(email);
            System.out.println("Guest updated successfully!");
        } else {
            System.out.println("Guest not found!");
        }
    }

    public static void deleteGuest() {
        System.out.println("Enter the guest id");
        int id = sc.nextInt();
        Guest guest = findGuestById(id);
        if (guest != null) {
            guests.remove(guest);
            System.out.println("Guest deleted successfully!");
        } else {
            System.out.println("Guest not found!");
        }
    }

    private static Resort findResortById(int id) {
        for (Resort resort : resorts) {
            if (resort.getId() == id) {
                return resort;
            }
        }
        return null;
    }

    private static Guest findGuestById(int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null;
    }
}