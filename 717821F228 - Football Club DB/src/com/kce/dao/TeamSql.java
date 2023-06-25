package com.kce.dao;

import java.sql.Connection;
import com.kce.bean.Teams;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeamSql {
    private Connection connection;

    public TeamSql(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
    	Statement st=connection.createStatement();
    	st.execute("drop table teams");
        String query = "CREATE TABLE  teams ( clubId INT,clubName VARCHAR(100),players VARCHAR(200),origin VARCHAR(100), managerName VARCHAR(100))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        }
    }

    public void addTeam(Teams team) throws SQLException {
        String query = "INSERT INTO teams (clubId, clubName, players, origin, managerName) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, team.getClubId());
            statement.setString(2, team.getClubName());
            statement.setString(3, String.join(",", team.getPlayers()));
            statement.setString(4, team.getOrigin());
            statement.setString(5, team.getManagerName());
            statement.executeUpdate();
        }
    }

    public void displayTeams() throws SQLException {
        String query = "SELECT * FROM teams";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int clubId = resultSet.getInt("clubId");
                String clubName = resultSet.getString("clubName");
                String players = resultSet.getString("players");
                String origin = resultSet.getString("origin");
                String managerName = resultSet.getString("managerName");

                System.out.println("Club ID: " + clubId);
                System.out.println("Club Name: " + clubName);
                System.out.println("Players: " + players);
                System.out.println("Origin: " + origin);
                System.out.println("Manager Name: " + managerName);
                System.out.println();
            }
        }
    }

    public void deleteTeam(int clubId) throws SQLException {
        String query = "DELETE FROM teams WHERE clubId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clubId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Team deleted successfully!");
            } else {
                System.out.println("Team with Club ID " + clubId + " not found.");
            }
        }
    }

}
