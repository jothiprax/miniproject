package com.kce.dao;
import com.kce.bean.Bus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BusDAO {
	    private static final Statement DBUtil = null;
		@SuppressWarnings("unused")
		private static List<Bus> buses;

		public static List<Bus> getAllBuses() throws SQLException {
	        List<Bus> buses = new ArrayList<>();
	        Connection connection = DBUtil.getConnection();

	        String selectQuery = "SELECT * FROM buses";
	        PreparedStatement statement = connection.prepareStatement(selectQuery);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int busId = resultSet.getInt("bus_id");
	            String busName = resultSet.getString("bus_name");
	            Bus bus = new Bus(busId, busName);
	            buses.add(bus);
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();

	        return buses;
	    }
	}


