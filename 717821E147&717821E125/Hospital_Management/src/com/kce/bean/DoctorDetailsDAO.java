package com.kce.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.Util.DButil;

public class DoctorDetailsDAO {

    private static Connection con;
    private static PreparedStatement pstmt;
    private static Scanner ip = new Scanner(System.in);

    public static void create() throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS Doctor (id INT(5), name VARCHAR(15), spec VARCHAR(15),gender VARCHAR(10))");
        pstmt.executeUpdate();
        System.out.println("Table is created...");
    }

    public static void insertValues(int n) throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("INSERT INTO Doctor VALUES (?, ?, ?, ?)");

        for (int i = 0; i < n; i++) {
            System.out.println("doctor_id:");
            int id = ip.nextInt();
            pstmt.setInt(1, id);

            System.out.println("doctor_name:");
            String name = ip.next();
            pstmt.setString(2, name);

            System.out.println("doctor_specialization:");
            String spec = ip.next();
            pstmt.setString(3, spec);

            System.out.println("doctor_gender:");
            String gender = ip.next();
            pstmt.setString(4, gender);

            pstmt.executeUpdate();
            System.out.println("Record inserted successfully...");
        }
    }

        public static void update(int id) throws ClassNotFoundException, SQLException {
            con = DButil.getConnection();
            pstmt = con.prepareStatement("UPDATE Doctor SET name = ?,spec = ?, gender = ? WHERE id = ?");
            
            System.out.println("doctor_name:");
            String name = ip.next();
            pstmt.setString(1, name);

            System.out.println("doctor_specialization:");
            String spec = ip.next();
            pstmt.setString(2, spec);

            System.out.println("doctor_gender:");
            String gender = ip.next();
            pstmt.setString(3, gender);

            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully...");
            } else {
                System.out.println("No record found with the given doctor_id...");
            }
        }

        public static void showDetails() throws ClassNotFoundException, SQLException {
            con = DButil.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM Doctor");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String spec = rs.getString("spec");
                String gender = rs.getString("gender");

                System.out.println("doctor_id: " + id);
                System.out.println("doctor_name: " + name);
                System.out.println("doctor_specialization: " + spec);
                System.out.println("doctor_gender: " + gender);
                System.out.println("---------------------------");
            }
        }
    }


