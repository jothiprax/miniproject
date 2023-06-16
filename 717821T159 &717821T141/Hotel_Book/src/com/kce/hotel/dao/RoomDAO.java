package com.kce.hotel.dao;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.hotel.util.RoomUnavailableException;
import com.kce.hotel.util.OverbookingException;
import com.kce.hotel.bean.Booking;
import com.kce.hotel.bean.Room;

public class RoomDAO {
 // @SuppressWarnings("unused")
	Connection connection;

  public RoomDAO(Connection connection) {
      this.connection = connection;
  }
  public List<Room> getAvailableRooms() throws SQLException {
      List<Room> availableRooms = new ArrayList<>();
      return availableRooms;
  }
  public void bookRoom(Booking booking) throws SQLException, RoomUnavailableException, OverbookingException {
      
  	Room room = getRoomByNumber(booking.getRoomNumber());
      if (room != null /* || room.getIsAvailable()*/) {
          throw new RoomUnavailableException("Room is unavailable.");
      }
      if (isRoomOverbooked(booking.getCheckInDate(), booking.getCheckOutDate())) {
          throw new OverbookingException("Room is overbooked.");
      }
  }

  private Room getRoomByNumber(int roomNumber) throws SQLException {
      return null;
  }

  private boolean isRoomOverbooked(String checkInDate, String checkOutDate) throws SQLException {
      return false;
  }
}