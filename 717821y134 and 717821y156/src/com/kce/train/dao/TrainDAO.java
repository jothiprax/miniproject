package com.kce.train.dao;

import java.util.ArrayList;
import java.util.List;

import com.kce.train.bean.Train;

public class TrainDAO {
    private List<Train> trains;

    public TrainDAO() {
        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void viewAllTrains() {
        for (Train train : trains) {
            System.out.println("Train Number: " + train.getTrainNumber());
            System.out.println("Train Name: " + train.getTrainName());
            System.out.println("Train Type: " + train.getTrainType());
            System.out.println("Source: " + train.getSource());
            System.out.println("Destination: " + train.getDestination());
            System.out.println("-----------------------------");
        }
    }
}
