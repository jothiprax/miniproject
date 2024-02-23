package Demo;
import java.sql.*;
import java.util.*;
public class Hospital_Management {
static String DB_URL = "jdbc:Mysql://localhost:3306/hospital_management";
 static String USER = "root";
 static String PASSWORD = "#Nesamani5";
 public static void main(String[] args) {
 try {

 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
 Statement stmt = con.createStatement();
 
 System.out.println("Table created successfully!");
 Scanner sc = new Scanner(System.in);
 int ch = -1;

 while (ch != 0) {
 System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
 System.out.println("1. Add patient");
 System.out.println("2. Update patient weight");
 System.out.println("3. Update patient age");
 System.out.println("4. Delete patient record");
 System.out.println("5. Show all patient details");
 System.out.println("6. Exit");
 System.out.print("Enter your choice for displaying the details of the patient: ");
 ch = sc.nextInt();
 sc.nextLine();
 switch (ch) {
 case 1:
 System.out.print("Enter number of patients:");
 int n=sc.nextInt();
 sc.nextLine();
 for(int i=0;i<n;i++)
 {
 System.out.print("Enter patient id: ");
 String id = sc.nextLine();
 System.out.print("Enter patient name: ");
 String name = sc.nextLine();
 System.out.print("Enter patient weight: ");
 String weight = sc.nextLine();
 System.out.print("Enter patient age: ");
 String age = sc.nextLine();
 System.out.print("Enter consultant doctor: ");
 String consultantdoctor = sc.nextLine();
 System.out.print("Enter medical comments: ");
 String medicalcomments = sc.nextLine();
 String insertQuery = "INSERT INTO hospital_management(id,name,weight,age,consultantdoctor,medicalcomments) VALUES (?,?, ?, ?, ?, ?)";
 PreparedStatement insertStmt = con.prepareStatement(insertQuery);
 insertStmt.setString(1,id);
 insertStmt.setString(2, name);
 insertStmt.setString(3, weight);
 insertStmt.setString(4, age);
 insertStmt.setString(5, consultantdoctor);
 insertStmt.setString(6, medicalcomments);
 insertStmt.executeUpdate();
 }
 System.out.println("Patient name added successfully!");
 break;
 case 2:
 System.out.print("Enter patient ID for updating weight: ");
 String id1 = sc.nextLine();
 System.out.print("Enter new weight: ");
 String newweight = sc.nextLine();

 PreparedStatement updateStmt = con.prepareStatement("UPDATE hospital_management SET weight="+newweight+" where id="+id1+";");

 int rowsUpdated = updateStmt.executeUpdate();
 if (rowsUpdated > 0) {
 System.out.println("Weight updated successfully!");
 } else {
 System.out.println("Patient Id not found");
 }
 break;
 case 3:
 System.out.print("Enter patient ID to update age: ");
 String id4 = sc.nextLine();
 System.out.print("Enter new age: ");
 String newage = sc.nextLine();
 String updateQuery1 = "UPDATE hospital_management SET age = ? WHERE id = ?";
 PreparedStatement updateStmt1 = con.prepareStatement(updateQuery1);
 updateStmt1.setString(1, newage);
 updateStmt1.setString(2, id4);
 int rowsUpdated1 = updateStmt1.executeUpdate();
 if (rowsUpdated1 > 0) {
 System.out.println("Patient age updated successfully");
 } else {
 System.out.println("Patient Id not found");
 }
 break;
 case 4:
 // Delete a patient record
 System.out.print("Enter patient ID for deletion: ");
 String delpatid = sc.nextLine();
 String delQuery = "DELETE FROM hospital_management WHERE id = ?";
 PreparedStatement deleteStmt = con.prepareStatement(delQuery);
 deleteStmt.setString(1, delpatid);
 int rowsDeleted = deleteStmt.executeUpdate();
 if (rowsDeleted > 0) {
 System.out.println("Patient record deleted successfully!");
 } else {
 System.out.println("Patient Id found");
 }
 break;
 case 5:

 String selectQuery = "SELECT * FROM hospital_management";
 ResultSet resultSet = stmt.executeQuery(selectQuery);
 if (!resultSet.isBeforeFirst()) {
 System.out.println("No Patient records found");
 }
 else
 {
 System.out.print("PATIENT DETAILS:");
 System.out.println();
 System.out.print("\n   \n");
 String output = String.format("%-20s%-20s%-20s%-20s%-20s%s", "ID",
"Name","Weight","Age","Consultantdoctor","Medicalcomments");
 System.out.print(output);
 System.out.print("\n   \n");
 System.out.println();
 while (resultSet.next())
 {
 String output1 = String.format("%-20s%-20s%-20s%-20s%-20s%s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
 System.out.print(output1);
 System.out.println();
 }
 System.out.print("\n   \n");
 }
 break;
 case 6:

 System.out.println("Exiting the program.");
 break;
 default:

 System.out.println("Invalid choice!Enter valid choice");
 }
 }
 con.close();
 } catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 }
 catch (SQLException e) {
 e.printStackTrace();
 }
 }
}