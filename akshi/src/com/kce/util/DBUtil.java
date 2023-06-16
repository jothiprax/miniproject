package com.kce.util;



import com.kce.bean.*;

import java.sql.*;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



public class DBUtil {



  private static final String URL = "jdbc:mysql://localhost:3306/akshitha";

  private static final String USERNAME = "root";

  private static final String PASSWORD = "root";

  private static Connection connection;

  

  public static Connection getConnection() {

   if (connection == null) {

    try {

     connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);

     System.out.println("Connected to the database successfully!");

     } 

    catch (SQLException e) {

     System.out.println("Failed to connect to the database.");

     e.printStackTrace();

     }

    }

  return connection;

  }

  public static void closeConnection() {

  if (connection != null) {

   try {

    connection.close();

    System.out.println("Database connection closed.");

    }

   catch (SQLException e) {

    System.out.println("Failed to close the database connection.");

    e.printStackTrace();

         }

    }

   }

  }