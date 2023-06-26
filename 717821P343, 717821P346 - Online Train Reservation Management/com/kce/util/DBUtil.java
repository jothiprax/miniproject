package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/rijo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rijo";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

private static Train getTrainById(int trainId) throws SQLException {
    List<Train> trains = TrainDAO.getAllTrains();

    for (Train train : trains) {
        if (train.getTrainId() == trainId) {
            return train;
        }
    }

    return null;
}
}
