package com.kce.dao;

import com.kce.bean.Passenger;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAO {
    public Passenger getPassengerById(int passengerId) {
        Passenger passenger = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM passengers WHERE id = ?")) {

            stmt.setInt(1, passengerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                passenger = new Passenger();
                passenger.setId(rs.getInt("id"));
                passenger.setName(rs.getString("name"));
                passenger.setEmail(rs.getString("email"));
                passenger.setPhone(rs.getString("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passenger;
    }
}

