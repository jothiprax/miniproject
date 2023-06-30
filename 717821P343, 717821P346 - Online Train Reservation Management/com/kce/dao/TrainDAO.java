package com.kce.dao;

import com.kce.bean.Train;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDAO {
    public static List<Train> getAllTrains() throws SQLException {
        List<Train> trains = new ArrayList<>();
        Connection connection = DBUtil.getConnection();

        String selectQuery = "SELECT * FROM trains";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int trainId = resultSet.getInt("train_id");
            String trainName = resultSet.getString("train_name");
            Train train = new Train(trainId, trainName);
            trains.add(train);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return trains;
    }
}
