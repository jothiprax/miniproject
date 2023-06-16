package com.kce.service;

import com.kce.bean.Luggage;
import com.kce.dao.LuggageDAO;

import java.util.List;

public class LuggageService {
    public static void addLuggage(Luggage luggage) {
        LuggageDAO.addLuggage(luggage);
    }

    public static List<Luggage> getAllLuggage() {
        return LuggageDAO.getAllLuggage();
    }

    public static Luggage getLuggageById(int id) {
        return LuggageDAO.getLuggageById(id);
    }
}
