package Naveenraj717821P335;

import java.sql.*;
import java.util.Scanner;
public class MainEnroll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Student_Name;
        System.out.println("Enter the Student_Name : ");
        Student_Name = in.nextLine();
        String Student_Email;
        System.out.println("Enter the Student_Email : ");
        Student_Email = in.nextLine();
        String Student_address;
        System.out.println("Enter the Student_address : ");
        Student_address = in.nextLine();
        String Student_Mobile_No;
        System.out.println("Enter the Student_Mobile_No : ");
        Student_Mobile_No = in.nextLine();
        String Student_Gender;
        System.out.println("Enter the Student_Gender : ");
        Student_Gender = in.nextLine();
        EnrollCourse ec = new EnrollCourse(Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
        boolean flag = true;
        String url="jdbc:mysql://localhost:3306/JAVATRAINING";
        String  name ="root";
        String pass="Naveen@1801";
        try {
            Connection con=DriverManager.getConnection(url,name,pass);
            PreparedStatement pst=con.prepareStatement("update course set count=? where name=?;");
            while (flag) {
                flag = false;
                String Department;
                System.out.println("Enter the Department_Name : ");
                Department = in.nextLine();
                switch (Department) {
                    case "CSE":
                        CSEEnrollment cseEnrollment = new CSEEnrollment(Department, Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
                        cseEnrollment.GetDetails();
                        cseEnrollment.courseSeats();
                        if (cseEnrollment.seatsAvailable("CSE")) {
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select count from course where name='CSE'");
                            int k=0;
                            while(rs.next()) {
                                k=rs.getInt(1);
                            }
                            pst.setString(2, Department);
                            pst.setInt(1, k-1);
                            pst.executeUpdate();
                            cseEnrollment.feesDetails();
                            cseEnrollment.DBstore(Department);
                            cseEnrollment.DisplayDeatils();
                        } else {
                            if (cseEnrollment.Suggestion()) {
                                break;
                            }
                            else {
                                flag = true;
                            }
                        }
                        break;
                    case "ECE":
                        ECEEnrollment eceEnrollment = new ECEEnrollment(Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
                        eceEnrollment.GetDetails();
                        eceEnrollment.courseSeats();
                        if (eceEnrollment.seatsAvailable("ECE")) {
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select count from course where name='CSE'");
                            int k=0;
                            while(rs.next()) {
                                k=rs.getInt(1);
                            }
                            pst.setString(2, Department);
                            pst.setInt(1, k-1);
                            pst.executeUpdate();
                            eceEnrollment.feesDetails();
                            eceEnrollment.DBstore(Department);
                            eceEnrollment.DisplayDeatils();
                        } else {
                            if (eceEnrollment.Suggestion()) {
                                break;
                            }
                            else {
                                flag = true;
                            }
                        }
                        break;

                    case "EEE":
                        EEEEnrollment eeeEnrollment = new EEEEnrollment(Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
                        eeeEnrollment.GetDetails();
                        eeeEnrollment.courseSeats();
                        if (eeeEnrollment.seatsAvailable("EEE")) {
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select count from course where name='CSE'");
                            int k=0;
                            while(rs.next()) {
                                k=rs.getInt(1);
                            }
                            pst.setString(2, Department);
                            pst.setInt(1, k-1);
                            pst.executeUpdate();
                            eeeEnrollment.feesDetails();
                            eeeEnrollment.DBstore(Department);
                            eeeEnrollment.DisplayDeatils();
                        } else {
                            if (eeeEnrollment.Suggestion()) {
                                break;
                            }
                            else {
                                flag = true;
                            }
                        }
                        break;

                    case "MECH":
                        MECHEnrollment mechEnrollment = new MECHEnrollment(Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
                        mechEnrollment.GetDetails();
                        mechEnrollment.courseSeats();
                        if (mechEnrollment.seatsAvailable("MECH")) {
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select count from course where name='CSE'");
                            int k=0;
                            while(rs.next()) {
                                k=rs.getInt(1);
                            }
                            pst.setString(2, Department);
                            pst.setInt(1, k-1);
                            pst.executeUpdate();
                            mechEnrollment.feesDetails();
                            mechEnrollment.DBstore(Department);
                            mechEnrollment.DisplayDeatils();
                        } else {
                            if (mechEnrollment.Suggestion()) {
                                break;
                            }
                            else {
                                flag = true;
                            }
                        }
                        break;

                    case "IT":
                        ITEnrollment itEnrollment = new ITEnrollment(Student_Name, Student_Email, Student_address, Student_Mobile_No, Student_Gender);
                        itEnrollment.GetDetails();
                        itEnrollment.courseSeats();
                        if (itEnrollment.seatsAvailable("IT")) {
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select count from course where name='CSE'");
                            int k=0;
                            while(rs.next()) {
                                k=rs.getInt(1);
                            }
                            pst.setString(2, Department);
                            pst.setInt(1, k-1);
                            pst.executeUpdate();
                            itEnrollment.feesDetails();
                            itEnrollment.DBstore(Department);
                            itEnrollment.DisplayDeatils();
                        } else {
                            if (itEnrollment.Suggestion()) {
                                break;
                            }
                            else {
                                flag = true;
                            }
                        }
                        break;
                    default:
                        System.out.println("SORRY...! DEPARTMENT IS NOT AVAILABLE IN OUR COLLEGE");
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
