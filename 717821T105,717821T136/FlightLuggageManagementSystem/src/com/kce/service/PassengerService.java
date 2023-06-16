package com.kce.service;

import com.kce.bean.Passenger;
import com.kce.dao.PassengerDAO;

import java.util.List;

public class PassengerService {
    public static void addPassenger(Passenger passenger) {
        PassengerDAO.addPassenger(passenger);
    }

    public static List<Passenger> getAllPassengers() {
        return PassengerDAO.getAllPassengers();
    }

    public static Passenger getPassengerById(int id) {
        return PassengerDAO.getPassengerById(id);
    }
}
