
package com.kce.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.kce.Util.DButil;

public class PatientDetailsDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private Statement st;
    private Scanner ip = new Scanner(System.in);
    private ResultSet rs;
    
    public void insertValues(int n) throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("INSERT INTO Patient VALUES (?, ?, ?, ?, ?)");

        for (int i = 0; i < n; i++) {
            System.out.println("patient_id:");
            pstmt.setInt(1, ip.nextInt());

            System.out.println("patient_name:");
            pstmt.setString(2, ip.next());

            System.out.println("patient_gender:");
            pstmt.setString(3, ip.next());

            System.out.println("Enter the entry_Date (YYYY-MM-DD):");
            pstmt.setDate(4, Date.valueOf(ip.next()));

            System.out.println("Enter the exit_Date (YYYY-MM-DD):");
            pstmt.setDate(5, Date.valueOf(ip.next()));

            pstmt.executeUpdate();
            System.out.println("Record inserted successfully...");
        }
    }
    
    public void update(int patientId) throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("UPDATE Patient SET name = ?, gender = ?, entrydate = ?, exitdate = ? WHERE id = ?");
        
        System.out.println("patient_name:");
        pstmt.setString(1, ip.next());

        System.out.println("patient_gender:");
        pstmt.setString(2, ip.next());

        System.out.println("Enter the entry_Date (YYYY-MM-DD):");
        pstmt.setDate(3, Date.valueOf(ip.next()));

        System.out.println("Enter the exit_Date (YYYY-MM-DD):");
        pstmt.setDate(4, Date.valueOf(ip.next()));

        pstmt.setInt(5, patientId);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Record updated successfully...");
        } else {
            System.out.println("No record found with the given patient_id...");
        }
    }
    
    public void delete(int patientId) throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("DELETE FROM Patient WHERE id = ?");

        pstmt.setInt(1, patientId);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully...");
        } else {
            System.out.println("No record found with the given patient_id...");
        }
    }
    
    public void showDetails() throws ClassNotFoundException, SQLException {
        con = DButil.getConnection();
        pstmt = con.prepareStatement("SELECT * FROM Patient");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            Date entryDate = rs.getDate("entrydate");
            Date exitDate = rs.getDate("exitdate");

            System.out.println("patient_id: " + id);
            System.out.println("patient_name: " + name);
            System.out.println("patient_gender: " + gender);
            System.out.println("entry_Date: " + entryDate);
            System.out.println("exit_Date: " + exitDate);
            System.out.println("---------------------------");
        }
    }
}