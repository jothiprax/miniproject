package com.kce.dao;

import com.kce.bean.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.util.DBUtil;

public class TrainDAO {
    private Connection connection;

    public TrainDAO() {
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(Train train) {
        String query = "INSERT INTO trains (train_number, train_name, source, destination, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, train.getTrainNumber());
            statement.setString(2, train.getTrainName());
            statement.setString(3, train.getSource());
            statement.setString(4, train.getDestination());
            statement.setString(5, train.getDepartureTime());
            statement.setString(6, train.getArrivalTime());

            statement.executeUpdate();
            System.out.println("Train added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTrain(Train train) {
        String query = "UPDATE trains SET train_name = ?, source = ?, destination = ?, departure_time = ?, arrival_time = ? WHERE train_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, train.getTrainName());
            statement.setString(2, train.getSource());
            statement.setString(3, train.getDestination());
            statement.setString(4, train.getDepartureTime());
            statement.setString(5, train.getArrivalTime());
            statement.setInt(6, train.getTrainNumber());

            statement.executeUpdate();
            System.out.println("Train updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrain(int trainNumber) {
        String query = "DELETE FROM trains WHERE train_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, trainNumber);

            statement.executeUpdate();
            System.out.println("Train deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Train getTrainByNumber(int trainNumber) {
        String query = "SELECT * FROM trains WHERE train_number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, trainNumber);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Train train = new Train(resultSet.getInt("train_number"),
                        resultSet.getString("train_name"),
                        resultSet.getString("source"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_time"));
                return train;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Train> getAllTrains() {
        List<Train> trainList = new ArrayList<>();
        String query = "SELECT * FROM trains";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Train train = new Train(resultSet.getInt("train_number"),
                        resultSet.getString("train_name"),
                        resultSet.getString("source"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_time"));
                trainList.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainList;
    }
}
