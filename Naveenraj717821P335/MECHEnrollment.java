package Naveenraj717821P335;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MECHEnrollment extends EnrollCourse{
    public String Student_Fathers_Name;
    public String Student_Mothers_Name;
    public String Student_Education_Type;
    public String Student_Major_Group;
    public String stay_type;
    public String confirm;
    public MECHEnrollment(String Std_Name,String Email,String Address,String Mobile_No,String Student_Gender){
        super(Std_Name,Email,Address,Mobile_No,Student_Gender);
    }

    public void GetDetails(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Father's Name: ");
        Student_Fathers_Name = in.nextLine();
        System.out.println("Enter the Mother's Name: ");
        Student_Mothers_Name = in.nextLine();
        System.out.println("Enter the Student_Education_Type: ");
        Student_Education_Type = in.nextLine();
        System.out.println("Enter DayScholar or Hosteler: ");
        stay_type = in.nextLine();
        System.out.println("Enter the Student_Major");
        Student_Major_Group = in.nextLine();
    }

    public boolean Suggestion(){
        Scanner in = new Scanner(System.in);

        System.out.println("Here the available seats in other departments...");
        SeatsChecker();
        System.out.println("Would you like change your course..? Please Type \" CHANGE \" to change the course");
        System.out.println("Otherwise type \"CONTINUE \" to continue with you selected course");
        String confirm = in.nextLine();
        if(confirm.equals("CHANGE")){
            System.out.println("COURSE CHANGING PROCESS BEGINS");
            return false;
        }
        else if(confirm.equals("CONTINUE")){
            System.out.println("THANK YOU FOR VISITING KCE");
            return true;
        }
        else{
            return false;
        }
    }
    public int feesDetails() {
        System.out.println("Fees Deatils ");
        int totalfees = 0;
        if (stay_type.equals("Day_Scholar")) {
            if (Student_Education_Type.equals("Management")) {
                System.out.println("College Fees : 750000 Thousand per year");
                totalfees += 75000;
            } else {
                System.out.println("College Fees : 90000 Thousand per year");
                totalfees += 50000;
            }
            System.out.println("Bus Fess : 25000 Thousand per year");
            System.out.println("Application Fees : 5000");
            totalfees += 30000;
            System.out.println("Total Fess : " + totalfees);
        }
        else {
            if (Student_Education_Type.equals("Management")) {
                System.out.println("College Fees : 75000 Thousand per year");
                totalfees += 75000;
            } else {
                System.out.println("College Fees : 90000 Thousand per year");
                totalfees += 50000;
            }
            System.out.println("Hostel Fees : 85000 Thousand per year");
            System.out.println("Application Fees : 5000");
            totalfees += 90000;
            System.out.println("Total Fess " + totalfees);
        }
        return totalfees;
    }
    public void DBstore(String dept){
        String url = "jdbc:mysql://localhost:3306/JAVATRAINING";
        String name = "root";
        String pass = "Naveen@1801";
        try {
            Connection con = DriverManager.getConnection(url, name, pass);
            PreparedStatement pst = con.prepareStatement("Insert into StudentDetails values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,Student_Name);
            pst.setString(2,Student_Email);
            pst.setString(3,Student_address);
            pst.setString(4,Student_Mobile_No);
            pst.setString(5,Student_Gender);
            pst.setString(6,Student_Fathers_Name);
            pst.setString(7,Student_Mothers_Name);
            pst.setString(8,dept);
            pst.setString(9,Student_Education_Type);
            pst.setString(10,Student_Major_Group);
            pst.setString(11,stay_type);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void DisplayDeatils(){
        System.out.println("COURSE SUCCESSFULLY ENROLLED");
        System.out.println("WELCOME TO KCE");
    }
}


