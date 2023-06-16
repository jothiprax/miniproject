package management;
import java.sql.*;
import java.util.*;
public class Details {
static String URL = "jdbc:mysql://localhost:3306/RailwayDetail";
static String USER = "root";
static String PASSWORD = "Y1012Jqkhkp";
public static void main(String[] args) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
Statement s = con.createStatement();
// Create table
String createTable = "CREATE TABLE IF NOT EXISTS RailwayTicketDetails("
+ "ticket_id VARCHAR(20) NOT NULL,"
+ "name VARCHAR(50) NOT NULL,"
+ "source VARCHAR(50) NOT NULL,"
+ "destination VARCHAR(50) NOT NULL,"
+ "class VARCHAR(20) NOT NULL,"
+ "age VARCHAR(5) NOT NULL,"
+ "gender VARCHAR(1) NOT NULL,"
+ "ph_number VARCHAR(10) NOT NULL,"
+ "fare VARCHAR(50) NOT NULL)";
s.executeUpdate(createTable);
System.out.println("Table Created Successfully!");
Scanner sc = new Scanner(System.in);
boolean flag = true;
while (flag) {
System.out.println("\n----- COIMBATORE RAILWAY TICKET BOOKING SYSTEM -----");
System.out.println("1. Book a Ticket");
System.out.println("2. Update Ticket Class");
System.out.println("3. Update Ticket Destination");
System.out.println("4. Update passenger Age");
System.out.println("5. Update passenger ph_number");
System.out.println("6. Delete a Ticket");
System.out.println("7. Show All Tickets");
System.out.println("8. Update Ticket Fare");
System.out.println("9. Exit");
System.out.print("Enter your choice: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1:
System.out.print("Number of Passenger's:");
int n=sc.nextInt();
sc.nextLine();
for(int i=0;i<n;i++)
{
System.out.print("Ticket id: ");
String ticket_Id = sc.nextLine();
System.out.print("Passenger's name: ");
String Pname = sc.nextLine();
System.out.print("Source: ");
String source = sc.nextLine();
System.out.print("Destination: ");
String destination = sc.nextLine();
System.out.print("Class (First/Second): ");
String ticket_Class = sc.nextLine();
System.out.print("Passenger Age: ");
String age = sc.nextLine();
System.out.print("Passenger Gender: ");
String gender = sc.nextLine();
System.out.print("Passenger Phone number: ");
String phone_number = sc.nextLine();
System.out.print("Enter ticket fare: ");
String fare = sc.nextLine();
String s1 = "INSERT INTO RailwayTicketDetails(ticket_id,name,source,destination,class,age,gender,ph_number,fare) VALUES (?,?,?,?,?,?,?,?,?)";
PreparedStatement P = con.prepareStatement(s1);
P.setString(1,ticket_Id);
P.setString(2, Pname);
P.setString(3, source);
P.setString(4, destination);
P.setString(5, ticket_Class);
P.setString(6, age);
P.setString(7, gender);
P.setString(8, phone_number);
P.setString(9, fare);
P.executeUpdate();
}
System.out.println("Ticket Booked Successfully!");
break;
case 2:
System.out.print("Enter ticket ID to update Class: ");
String t1 = sc.nextLine();
System.out.print("Enter new class: ");
String updated_Class = sc.nextLine();
String q1 = "UPDATE RailwayTicketDetails SET class = ? WHERE ticket_id = ?";
PreparedStatement s1 = con.prepareStatement(q1);
s1.setString(1,updated_Class);
s1.setString(2,t1);
int r1 = s1.executeUpdate();
if (r1 > 0) {
System.out.println("Ticket Class Updated Successfully!");
} else {
System.out.println("SORRY :( Ticket Not Found!");
}
break;
case 3:
System.out.print("Ticket ID to Update Destination: ");
String t2 = sc.nextLine();
System.out.print("New Destination: ");
String new_destination = sc.nextLine();
String q2 = "UPDATE RailwayTicketDetails SET destination=? WHERE ticket_id = ?";
PreparedStatement s2 = con.prepareStatement(q2);
s2.setString(1, new_destination);
s2.setString(2, t2);
int r2 = s2.executeUpdate();
if (r2 > 0) {
System.out.println("Destination Updated Successfully!");
} else {
System.out.println("SORRY :( Ticket Not Found!");
}
break;
case 4:
System.out.print("Ticket ID to update Age: ");
String t3 = sc.nextLine();
System.out.print("Enter new Age: ");
String new_age = sc.nextLine();
String q3= "UPDATE RailwayTicketDetails SET age= ? WHERE ticket_id = ?";
PreparedStatement s3 = con.prepareStatement(q3);
s3.setString(1, new_age);
s3.setString(2, t3);
int r3 = s3.executeUpdate();
if (r3 > 0) {
System.out.println("Passenger Age Updated Successfully!");
} else {
System.out.println("SORRY :( Ticket Not Found!");
}
break;
case 5:
System.out.print("Ticket ID to Update Phone Number: ");
String t4 = sc.nextLine();
System.out.print("New phone Number: ");
String new_phonenumber = sc.nextLine();
String q4 = "UPDATE RailwayTicketDetails SET ph_number= ? WHERE ticket_id = ?";
PreparedStatement s4 = con.prepareStatement(q4);
s4.setString(1, new_phonenumber);
s4.setString(2, t4);
int r4 = s4.executeUpdate();
if (r4 > 0) {
System.out.println("Phone Number Updated Successfully!");
} else {
System.out.println("SORRY :( Ticket Not Found!");
}
break;
case 6:
System.out.print("Ticket ID to Cancel: ");
String canceled_id = sc.nextLine();
String q5 = "DELETE FROM RailwayTicketDetails WHERE ticket_id= ?";
PreparedStatement s5 = con.prepareStatement(q5);
s5.setString(1,canceled_id);
int r5 = s5.executeUpdate();
if (r5 > 0) {
System.out.println("Ticket Cancelled Successfully!");
} else {
System.out.println("SORRY :( Ticket Not Found!");
}
break;
case 7:
String Query = "SELECT * FROM RailwayTicketDetails";
ResultSet result = s.executeQuery(Query);
if (!result.next()) {
System.out.println("SORRY :( Ticket Not Found!");
}
else
{
System.out.print(" ----- TICKET DETAILS ----- ");
System.out.println();
System.out.print("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
System.out.printf(" %-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s", "Ticket_ID","Name","Source","Destination","Class","age","gender","ph_number","Fare");
System.out.print("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
System.out.println();
while (result.next())
{
System.out.printf(" %-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s",result.getString(1) ,result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9));
System.out.println();
}
System.out.print("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
}
break;
case 8:
System.out.print("Ticket ID to Update Fare: ");
String t7 = sc.nextLine();
System.out.print("Enter new fare: ");
String new_fare = sc.nextLine();
String q7 = "UPDATE RailwayTicketDetails SET fare= ? WHERE ticket_id = ?";
PreparedStatement s7 = con.prepareStatement(q7);
s7.setString(1, new_fare);
s7.setString(2, t7);
int r7 = s7.executeUpdate();
if (r7 > 0) {
System.out.println("Fare Updated Successfully!");
}else {
System.out.println("SORRY :( Ticket not found!");
}
break;
case 9:
System.out.println("Exiting From Program!! BYE :(");
flag=false;
break;
default:
System.out.println("Invalid Choice!!");
flag=false;
}
}
con.close();
} catch (Exception e)
{
System.out.println(e);
} 
}
}
