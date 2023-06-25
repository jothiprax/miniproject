package com.kce.train.service;

public class ValidationService {

    public boolean validateTrainNumber(String trainNumber) {
        // Train number is of 5 digits
        return trainNumber.matches("\\d{5}");
    }

    public boolean validateAge(int age) {
        // Passenger age must be between 1 and 120
        return age >= 1 && age <= 120;
    }

    public boolean validateConcession(double concession) {
        // Concession is always non-negative
        return concession >= 0;
    }
}
