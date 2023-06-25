package com.kce.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.Doctor;
import com.kce.bean.Patient;
import com.kce.util.DBUtil;
public class DPdao {
	public void addPatient() {
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
            sc.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public  void updatePatient() {
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
   sc.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public  void deletePatient() {
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
            }sc.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public  void addDoctor() {
        try {
        	Scanner sc=new Scanner(System.in);
        	 System.out.print("Enter doctor id: ");
             int id = sc.nextInt();
            System.out.print("Enter doctor name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Enter doctor Domain: ");
            String domain = sc.nextLine();
            Connection con=DBUtil.createConnection();
            Doctor d = new Doctor();
            d.setId(id);
            d.setName(name);
            d.setDomain(domain);
            PreparedStatement s5 = con.prepareStatement("INSERT INTO Doctor  VALUES (?, ?, ?)");
            s5.setInt(1, d.getId());
            s5.setString(2, d.getName());
            s5.setString(3, d.getDomain());

            int rowsAffected = s5.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Doctor added successfully!");
            } else {
                System.out.println("Failed to add doctor.");
            }
            sc.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public  void updateDoctor() {
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
                d1.setDomain(resultSet.getString("Domain"));

                System.out.print("Enter new doctor name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new doctor Domain: ");
                String newDomain = sc.nextLine();

                Doctor d2 = new Doctor();
                d2.setId(d1.getId());
                d2.setName(newName);
                d2.setDomain(newDomain);

                PreparedStatement s7 = con.prepareStatement("UPDATE Doctor SET name = ?, domain = ? WHERE id = ?");
                s7.setString(1, d2.getName());
                s7.setString(2, d2.getDomain());
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
            sc.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public  void deleteDoctor() {
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
                sc.close();
            } else {
                System.out.println("Doctor not found.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
        public void DisplayPatientdetails() {
       	 Connection con=DBUtil.createConnection();
       	 try {
       	 PreparedStatement ps3 = con.prepareStatement("select *from Patient");
       	 ResultSet r=ps3.executeQuery();
       	 while(r.next())
       	 {
       		 System.out.println("ID: "+r.getInt(1)+"\nName:  "+r.getString(2)+"\nAge:  "+r.getInt(3)+"\nGender:  "+r.getString(4));
       	 }
       	 } catch(SQLException e)
       	 {
       	 	e.printStackTrace();
       	 	
       	 	
       	 } 
    }

public  void DisplayDoctordetails() {
  	 Connection con=DBUtil.createConnection();
  	 try {
  	 PreparedStatement ps4 = con.prepareStatement("select *from Doctor");
  	 ResultSet r=ps4.executeQuery();
  	 while(r.next())
  	 {
  		 System.out.println("ID: "+r.getInt(1)+"\nName:  "+r.getString(2)+"\nDomain: "+r.getString(3));
  	 }
  	 } catch(SQLException e)
  	 {
  	 	e.printStackTrace();
  	 	
  	 	
  	 } 
}
}