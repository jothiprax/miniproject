package com.kce.dao;

import com.kce.bean.flight;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;



public class flightDAO {

  private Connection connection;

  

  public flightDAO(Connection connection) {

   this.connection=connection;

  }

  public void addFlight(flight flg) throws SQLException{

   String query ="INSERT INTO flight(flightid,airline,origin,destination,departuretime,arrivaltime,duration,capacity,availableseats,fare)VALUES(?,?,?,?,?,?,?,?,?,?)";

   

   try(PreparedStatement st =connection.prepareStatement(query)){

    st.setInt(1,flg.getFlightid());

    st.setString(2,flg.getAirline());

    st.setString(3,flg.getOrigin());

    st.setString(4,flg.getDestination());

    st.setInt(5,flg.getDeparturetime());

    st.setInt(6,flg.getArrivaltime());

    st.setInt(7,flg.getDuration());

    st.setInt(8,flg.getCapacity());

    st.setInt(9,flg.getAvailableseats());

    st.setDouble(10,flg.getFare());

    

    st.executeUpdate();

   }

  }

  

  public void UpdateFlight(flight flg)throws SQLException{

   

   String query = "UPDATE flight SET airline = ? ,origin = ?,destination=? ,departuretime=? ,arrivaltime=? ,duration=? ,capacity=? ,availableseats=? ,fare=? WHERE flightid = ? ";

   

   try(PreparedStatement st = connection.prepareStatement(query)){

    

    st.setString(1,flg.getAirline());

    st.setString(2,flg.getOrigin());

    st.setString(3,flg.getDestination());

    st.setInt(4,flg.getDeparturetime());

    st.setInt(5,flg.getArrivaltime());

    st.setInt(6,flg.getDuration());

    st.setInt(7,flg.getCapacity());

    st.setInt(8,flg.getAvailableseats());

    st.setDouble(9,flg.getFare());

    st.setInt(10,flg.getFlightid());

    

    st.executeUpdate();

   }

  }

  public void deleteFlight(int flgId)throws SQLException{

   String query= "DELETE FROM flight WHERE flightid = ?";

   

   try (PreparedStatement st = connection.prepareStatement(query)){

    st.setInt(1,flgId);

    st.executeUpdate();

   }

  }

  public flight getFlightById(int flgId) throws SQLException{

    String query="SELECT * FROM flight WHWERE flightid=?";

    try (PreparedStatement st = connection.prepareStatement(query)){

     st.setInt(1,flgId);

     

     try(ResultSet rs = st.executeQuery()){

      if(rs.next()) {

       flight flg=new flight();

       flg.setFlightid(rs.getInt("flightid"));

       flg.setAirline(rs.getString("airline"));

       flg.setOrigin(rs.getString("origin"));

       flg.setDestination(rs.getString("destination"));

       flg.setDeparturetime(rs.getInt("departuretime"));

       flg.setArrivaltime(rs.getInt("arrivaltime"));

       flg.setDuration(rs.getInt("duration"));

       flg.setCapacity(rs.getInt("capacity"));

       flg.setAvailableseats(rs.getInt("availableseats"));

       flg.setFare(rs.getDouble("fare"));

       return flg;

      }

     }

    }

   return null;

  }

  public List<flight> getAllflights() throws SQLException{

   List<flight> flgt =new ArrayList<>();

   String query="SELECT * FROM flight";

   

   try (PreparedStatement st = connection.prepareStatement(query);

    ResultSet rs= st.executeQuery()){

    

    while(rs.next()) {

     flight flg=new flight();

     flg.setFlightid(rs.getInt("flightid"));

     flg.setAirline(rs.getString("airline"));

     flg.setOrigin(rs.getString("origin"));

     flg.setDestination(rs.getString("destination"));

     flg.setDeparturetime(rs.getInt("departuretime"));

     flg.setArrivaltime(rs.getInt("arrivaltime"));

     flg.setDuration(rs.getInt("duration"));

     flg.setCapacity(rs.getInt("capacity"));

     flg.setAvailableseats(rs.getInt("availableseats"));

     flg.setFare(rs.getDouble("fare"));

     

     flgt.add(flg);

    }

   }

   return flgt;

  }
}