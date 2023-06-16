package MovieDetails;
import java.sql.*;
import java.util.*;
public class MovieDetails {

private static final String Theatre = null;
static String DB_URL = "jdbc:mysql://localhost:3306/amitdb";
static String USER = "root";
static String PASSWORD = "Amma7708@";
private static String ph_number;
private static String newTheatre;
private static String newtime;
public static void main(String[] args) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
Statement stmt = con.createStatement();
// Create table
String createTableQuery = "CREATE TABLE IF NOT EXISTS MovieTicketDetail("
+ "ticket_id VARCHAR(20) NOT NULL,"
+ "peoplename VARCHAR(50) NOT NULL,"
+ "Moviename VARCHAR(50) NOT NULL,"
+ "Theatre VARCHAR(50) NOT NULL,"
+ "class VARCHAR(20) NOT NULL,"
+ "time VARCHAR(30) NOT NULL,"
+ "gender VARCHAR(1) NOT NULL,"
+ "ph_number VARCHAR(10) NOT NULL,"
+ "fare VARCHAR(50) NOT NULL)";
stmt.executeUpdate(createTableQuery);
System.out.println("Table created successfully!");
try (Scanner sc = new Scanner(System.in)) {
	int choice = -1;
	while (choice != 0) {
	System.out.println("\n----- MOVIE TICKET BOOKING SYSTEM -----");
	System.out.println("1. Book a Ticket");
	System.out.println("2. Update Ticket Fare");
	System.out.println("3. Update Ticket Class");
	System.out.println("4. Update time ");
	System.out.println("5. Update Theatre");
	System.out.println("6. Update pepole ph_number");
	System.out.println("7. Delete a Ticket");
	System.out.println("8. Show All Tickets");
	System.out.println("9. Exit");
	System.out.print("Enter your choice: ");
	choice = sc.nextInt();
	sc.nextLine();
	switch (choice) {
	case 1:
	// Book a ticket
	System.out.print("Enter the number of Ticekt:");
	int n=sc.nextInt();
	sc.nextLine();
	for(int i=0;i<n;i++)
	{System.out.print("Enter Ticket id: ");
	String ticket_id = sc.nextLine();
	System.out.print("Enter people name: ");
	String name = sc.nextLine();
	System.out.print("Enter Moviename: ");
	String Moviename = sc.nextLine();
	System.out.print("Enter Theatre: ");
	String Theatre = sc.nextLine();
	System.out.print("Enter class (First/Second): ");
	String ticketClass = sc.nextLine();
	System.out.print("Entertime: ");
	String time = sc.nextLine();
	System.out.print("Enter  gender: ");
	String gender = sc.nextLine();
	System.out.print("Enter people ph_number: ");
    String ph=sc.nextLine();
	System.out.print("Enter ticket fare: ");
	String fare = sc.nextLine();
	String insertQuery = "INSERT INTO MovieTicketDetail VALUES(?,?,?,?,?,?,?,?,?)";
	PreparedStatement insertStmt = con.prepareStatement(insertQuery);
	insertStmt.setString(1,ticket_id);
	insertStmt.setString(2, name);
	insertStmt.setString(3, Moviename);
	insertStmt.setString(4, Theatre);
	insertStmt.setString(5, ticketClass);
	insertStmt.setString(6,time);
	insertStmt.setString(7, gender);
	insertStmt.setString(8,ph);
	insertStmt.setString(9, fare);
	insertStmt.executeUpdate();
	}System.out.println("Ticket booked successfully!");
	break;
	case 2:
	// Update ticket fare
	System.out.print("Enter ticket ID to update fare: ");
	String ticketId = sc.nextLine();
	System.out.print("Enter new fare: ");
	String newFare = sc.nextLine();
	String updateQuery = "UPDATE MovieTicketDetail SET fare= ? WHEREticket_id = ?";
	PreparedStatement updateStmt = con.prepareStatement(updateQuery);
	updateStmt.setString(1, newFare);
	updateStmt.setString(2, ticketId);
	int rowsUpdated = updateStmt.executeUpdate();
	if (rowsUpdated > 0) {
	System.out.println("Fare updated successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 3:
	// Update ticket class
	System.out.print("Enter ticket ID to update Class: ");
	String ticketId1 = sc.nextLine();
	System.out.print("Enter new class: ");
	String newClass = sc.nextLine();
	String updateQuery1 = "UPDATE MovieTicketDetail SET class = ? WHEREticket_id = ?";
	PreparedStatement updateStmt1 = con.prepareStatement(updateQuery1);
	updateStmt1.setString(1, newClass);
	updateStmt1.setString(2, ticketId1);
	int rowsUpdated1 = updateStmt1.executeUpdate();
	if (rowsUpdated1 > 0) {
	System.out.println("Class updated successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 4:
	// Update Ticket Theatre
	System.out.print("Enter ticket ID to update Theatre: ");
	String ticketId2 = sc.nextLine();
	System.out.print("Enter new Theatre: ");
	newTheatre = sc.nextLine();
	String updateQuery2 = "UPDATE MovieTicketDetail SET Theatre= ?WHERE ticket_id = ?";
	PreparedStatement updateStmt2 = con.prepareStatement(updateQuery2);
	updateStmt2.setString(1, Theatre);
	updateStmt2.setString(2, ticketId2);
	int rowsUpdated2 = updateStmt2.executeUpdate();
	if (rowsUpdated2 > 0) {
	System.out.println("Class updated successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 5:
	// Update Date_time
	System.out.print("Enter ticket ID to update time: ");
	String ticketId3 = sc.nextLine();
	System.out.print("Enter new time: ");
		newtime = sc.nextLine();
	String updateQuery3= "UPDATE MovieTicketDetail SET time= ?WHERE ticket_id = ?";
	PreparedStatement updateStmt3 = con.prepareStatement(updateQuery3);
		String time1 = null;
		updateStmt3.setString(1, time1);
	updateStmt3.setString(2, ticketId3);
	int rowsUpdated3 = updateStmt3.executeUpdate();
	if (rowsUpdated3 > 0) {
	System.out.println("Class updated successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 6:
	// Update passenger ph_number
	System.out.print("Enter ticket ID to update ph_number: ");
	String ticketId4 = sc.nextLine();
	System.out.print("Enter new ph_number ");
	String newph_number = sc.nextLine();
	String updateQuery4 = "UPDATE MovieTicketDetail SET ph_number= ?WHERE ticket_id = ?";
	PreparedStatement updateStmt4 = con.prepareStatement(updateQuery4);
	updateStmt4.setString(1, newph_number);
	updateStmt4.setString(2, ticketId4);
	int rowsUpdated4 = updateStmt4.executeUpdate();
	if (rowsUpdated4 > 0) {
	System.out.println("Class updated successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 7:
	// Delete a ticket
	System.out.print("Enter ticket ID to delete: ");
	String deleteTicketId = sc.nextLine();
	String deleteQuery = "DELETE FROM MovieTicketDetail WHERE ticket_id= ?";
	PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
	deleteStmt.setString(1, deleteTicketId);
	int rowsDeleted = deleteStmt.executeUpdate();
	if (rowsDeleted > 0) {
	System.out.println("Ticket deleted successfully!");
	} else {
	System.out.println("Ticket not found!");
	}break;
	case 8:
	// Show all tickets
	String selectQuery = "SELECT * FROM MovieTicketDetail";
	ResultSet resultSet = stmt.executeQuery(selectQuery);
	if (!resultSet.next()) {
	System.out.println("No tickets found!");
	}else
	{
		System.out.print(" ----- TICKET DETAILS ----- ");
	System.out.println();
	System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	String output = String.format(" %-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","Ticket_ID","people Name","Moviename","Theatre","Class","time","gender","ph_number","Fare");
	System.out.print(output);
	System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println();
	while (resultSet.next())
	{String output1 = String.format(" %-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s",resultSet.getString(1) ,resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9));
	System.out.print(output1);
	System.out.println();
	}System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}break;
	case 9:
	//exit program
	System.out.println("Exiting the program.");
	break;
	
	default:
	//invalid choice
	System.out.println("Invalid choice! Please try again.");
	}}
}
con.close();
} catch (ClassNotFoundException e)
{e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}}
}
