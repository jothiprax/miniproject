package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.Doctor;
import com.kce.bean.Patient;
import com.kce.bean.UserDefinedException;
import com.kce.util.DBUtil;
public class DAO1 {
    public static void addPatient() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter patient Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();
            System.out.print("Enter patient age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter patient gender: ");
            String gender = sc.nextLine();
            Patient p = new Patient();
            p.setId(id);
            p.setName(name);
            p.setAge(age);
            p.setGender(gender);
            Connection con=DBUtil.createConnection();
            PreparedStatement s = con.prepareStatement("INSERT INTO Patient VALUES (?, ?, ?,?)");
            s.setInt(1, p.getId());
            s.setString(2, p.getName());
            s.setInt(3, p.getAge());
            s.setString(4, p.getGender());
            int rowsAffected = s.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient added successfully!");
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void updatePatient() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter patient ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            Connection con=DBUtil.createConnection();
            PreparedStatement s1 = con.prepareStatement("SELECT * FROM Patient WHERE id = ?");
            s1.setInt(1, id);
            ResultSet resultSet = s1.executeQuery();
            if (resultSet.next()) {
                Patient p1 = new Patient();
                p1.setId(resultSet.getInt("id"));
                p1.setName(resultSet.getString("name"));
                p1.setAge(resultSet.getInt("age"));
                p1.setGender(resultSet.getString("gender"));
                System.out.print("Enter new patient name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new patient age: ");
                int newAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new patient gender: ");
                String newGender = sc.nextLine();
                Patient p2 = new Patient();
                p2.setId(p1.getId());
                p2.setName(newName);
                p2.setAge(newAge);
                p2.setGender(newGender);
                PreparedStatement s2 = con.prepareStatement("UPDATE Patient SET name = ?, age = ?, gender = ? WHERE id = ?");
                s2.setString(1, p2.getName());
                s2.setInt(2, p2.getAge());
                s2.setString(3, p2.getGender());
                s2.setInt(4, p2.getId());
                int rowsAffected = s2.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Patient updated successfully!");
                } else {
                    System.out.println("Failed to update patient.");
                }
            } else {
                System.out.println("Patient not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void deletePatient() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter patient ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            Connection con=DBUtil.createConnection();
            PreparedStatement s3 = con.prepareStatement("SELECT * FROM Patient WHERE id = ?");
            s3.setInt(1, id);
            ResultSet resultSet = s3.executeQuery();
            if (resultSet.next()) {

                PreparedStatement s4 = con.prepareStatement("DELETE FROM Patient WHERE id = ?");
                s4.setInt(1, id);
                int rowsAffected = s4.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Patient deleted successfully!");
                } else {
                    System.out.println("Failed to delete patient.");
                }
            } else {
                System.out.println("Patient not found.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void addDoctor() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter doctor id: ");
            int id = sc.nextInt();
            System.out.print("Enter doctor name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Enter doctor specialization: ");
            String specialization = sc.nextLine();
            Connection con=DBUtil.createConnection();
            Doctor d = new Doctor();
            d.setId(id);
            d.setName(name);
            d.setSpecialization(specialization);
            PreparedStatement s5 = con.prepareStatement("INSERT INTO Doctor VALUES (?, ?, ?)");
            s5.setInt(1, d.getId());
            s5.setString(2, d.getName());
            s5.setString(3, d.getSpecialization());
            int rowsAffected = s5.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Doctor added successfully!");
            } else {
                System.out.println("Failed to add doctor.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void updateDoctor() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter doctor ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            Connection con=DBUtil.createConnection();
            PreparedStatement s6 = con.prepareStatement("SELECT * FROM Doctor WHERE id = ?");
            s6.setInt(1, id);
            ResultSet resultSet = s6.executeQuery();
            if (resultSet.next()) {
                Doctor d1 = new Doctor();
                d1.setId(resultSet.getInt("id"));
                d1.setName(resultSet.getString("name"));
                d1.setSpecialization(resultSet.getString("specialization"));
                System.out.print("Enter new doctor name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new doctor specialization: ");
                String newSpecialization = sc.nextLine();
                Doctor d2 = new Doctor();
                d2.setId(d1.getId());
                d2.setName(newName);
                d2.setSpecialization(newSpecialization);
                PreparedStatement s7 = con.prepareStatement("UPDATE Doctor SET name = ?, specialization = ? WHERE id = ?");
                s7.setString(1, d2.getName());
                s7.setString(2, d2.getSpecialization());
                s7.setInt(3, d2.getId());
                int rowsAffected = s7.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Doctor updated successfully!");
                } else {
                    System.out.println("Failed to update doctor.");
                }
            } else {
                System.out.println("Doctor not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void deleteDoctor() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter doctor ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            Connection con=DBUtil.createConnection();
            PreparedStatement s8 = con.prepareStatement("SELECT * FROM Doctor WHERE id = ?");
            s8.setInt(1, id);
            ResultSet resultSet = s8.executeQuery();
            if (resultSet.next()) {

                PreparedStatement s9 = con.prepareStatement("DELETE FROM Doctor WHERE id = ?");
                s9.setInt(1, id);
                int rowsAffected = s9.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Doctor deleted successfully!");
                } else {
                    System.out.println("Failed to delete doctor.");
                }
            } else {
                System.out.println("Doctor not found.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void DisplayPatientdetails() {
        Connection con=DBUtil.createConnection();
        try {
            PreparedStatement ps3 = con.prepareStatement("select *from Patient");
                    ResultSet r=ps3.executeQuery();
            while(r.next())
            {
                System.out.println("ID: "+r.getInt(1)+"\nName: "+r.getString(2)+"\nAge: "+r.getInt(3)+"\nGender: "+r.getString(4));
            }
        } catch(SQLException e)
        {
            e.printStackTrace();


        }
    }
    public static void DisplayDoctordetails() {
        Connection con=DBUtil.createConnection();
        try {
            PreparedStatement ps4 = con.prepareStatement("select *from Doctor");
            ResultSet r=ps4.executeQuery();
            while(r.next())
            {
                System.out.println("ID: "+r.getInt(1)+"\nName:  "+r.getString(2)+"\nSpecialization: "+r.getString(3));
            }
        } catch(SQLException e)
        {
            e.printStackTrace();


        }
    }
}