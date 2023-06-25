package Naveenraj717821P335;

import java.util.*;
import java.sql.*;

public class EnrollCourse {


    public String Student_Name;
    public String Student_Email;
    public String Student_address;
    public String Student_Mobile_No;
    public String Student_Gender;




    public EnrollCourse(String Student_Name,String Student_Email,String Student_address,String Student_Mobile_No,String Gender){

        this.Student_address = Student_address;
        this.Student_Email = Student_Email;
        this.Student_Mobile_No = Student_Mobile_No;
        this.Student_Name = Student_Name;
        this.Student_Gender = Gender;
    }

    public void SeatsChecker(){
        String url="jdbc:mysql://localhost:3306/JAVATRAINING";
        String user="root";
        String pw="Naveen@1801";
        try {
            Connection con=DriverManager.getConnection(url,user,pw);
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery("select * from Course");
            while(rs.next()) {
                System.out.println(rs.getString(1)+" : "+rs.getInt(2));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void courseSeats(){
        String url="jdbc:mysql://localhost:3306/JAVATRAINING";
        String user="root";
        String pw="Naveen@1801";
        try {
            Connection con=DriverManager.getConnection(url,user,pw);
            PreparedStatement pst=con.prepareStatement("insert into Course values(?,?);");
            pst.setString(1,"CSE");
            pst.setInt(2, 0);
            pst.executeUpdate();
            pst.setString(1,"ECE");
            pst.setInt(2, 180);
            pst.executeUpdate();
            pst.setString(1,"EEE");
            pst.setInt(2, 60);
            pst.executeUpdate();
            pst.setString(1,"MECH");
            pst.setInt(2, 60);
            pst.executeUpdate();
            pst.setString(1,"IT");
            pst.setInt(2, 120);
            pst.executeUpdate();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public boolean seatsAvailable(String dept) {
        String url="jdbc:mysql://localhost:3306/JAVATRAINING";
        String user="root";
        String pw="Naveen@1801";
        try {
            Connection con=DriverManager.getConnection(url,user,pw);
            PreparedStatement pst=con.prepareStatement("select count from course where name=?");
            pst.setString(1, dept);
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                if(rs.getInt(1)==0) {
                    return false;
                }
            }
            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

