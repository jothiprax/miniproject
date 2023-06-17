package com.kce.service;

import com.kce.bean.Hotel;
import com.kce.dao.HotelDAO;

import java.util.List;

public class HotelService {
    public static void addHotel(Hotel hotel) {
        HotelDAO.addHotel(hotel);
    }

    public static List<Hotel> getAllHotels() {
        return HotelDAO.getAllHotels();
    }

    public static Hotel getHotelById(int id) {
        return HotelDAO.getHotelById(id);
    }
}
