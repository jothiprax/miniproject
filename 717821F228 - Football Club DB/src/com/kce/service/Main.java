package com.kce.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.kce.bean.Teams;
import com.kce.dao.TeamSql;
import com.kce.dao.UserInputUtil;
import com.kce.util.DBConnection;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a database connection
            Connection connection = DBConnection.getConnection();

            // Create an instance of TeamSql using the database connection
            TeamSql teamSql = new TeamSql(connection);

            // Create the teams table if it doesn't exist
            teamSql.createTable();

            // Get the number of clubs to add
            int numberOfClubs = UserInputUtil.getNumberOfClubs();

            // Add clubs
            for (int i = 0; i < numberOfClubs; i++) {
                Teams team = UserInputUtil.getClubDetails();
                teamSql.addTeam(team);
            }

            // Display teams
            teamSql.displayTeams();

            System.out.print("Do you want to delete a club? (yes/no): ");
            String deleteOption = UserInputUtil.getUserInput();
            if (deleteOption.equalsIgnoreCase("yes")) {
                int clubIdToDelete = UserInputUtil.getClubIdToDelete();
                teamSql.deleteTeam(clubIdToDelete);
                teamSql.displayTeams();
            } else {
                System.out.println("Program ended.");
            }

            // Close the database connection
            DBConnection.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
