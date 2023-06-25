package com.kce.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Teams;

public class UserInputUtil {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getNumberOfClubs() {
        System.out.print("Enter the number of clubs: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Teams getClubDetails() {
        try {
            System.out.print("Enter Club ID: ");
            int clubId = Integer.parseInt(reader.readLine());

            System.out.print("Enter Club Name: ");
            String clubName = reader.readLine();

            List<String> players = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                System.out.print("Enter Player " + (i + 1) + ": ");
                String player = reader.readLine();
                players.add(player);
            }

            System.out.print("Enter Origin: ");
            String origin = reader.readLine();

            System.out.print("Enter Manager Name: ");
            String managerName = reader.readLine();

            return new Teams(clubId, clubName, players, origin, managerName);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getClubIdToUpdate() {
        System.out.print("Enter the Club ID to update: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getClubIdToDelete() {
        System.out.print("Enter the Club ID to delete: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

