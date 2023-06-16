package com.kce.bean;

public class Train {
private int trainId;
private String trainName;

public Train(int trainId, String trainName) {
    this.trainId = trainId;
    this.trainName = trainName;
}

public int getTrainId() {
    return trainId;
}

public String getTrainName() {
    return trainName;
}

public void displayDetails() {
    System.out.println("Train ID: " + trainId);
    System.out.println("Train Name: " + trainName);
}
}


