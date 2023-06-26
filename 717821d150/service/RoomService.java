package com.kce.service;
import java.util.*;
import com.kce.bean.Room;
import com.kce.dao.RoomDao;

import java.util.List;

public class RoomService {
    private RoomDao roomDao;

    public RoomService() {
        roomDao = new RoomDao();
    }

    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    public Room getRoomById(int roomId) {
        return roomDao.getRoomById(roomId);
    }

    public List<Room> getAvailableRooms(Date checkInDate, Date checkOutDate) {
        return roomDao.getAllRooms();
    }

    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    public void deleteRoom(int roomId) {
        roomDao.deleteRoom(roomId);
    }
}