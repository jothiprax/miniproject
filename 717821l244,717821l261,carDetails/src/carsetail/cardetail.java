package carsetail;
import java.sql.*;
import java.util.*;
public class cardetail {
static String DB_URL =
"jdbc:mysql://localhost:3306/CarChekingDetails";
static String USER = "root";
static String PASSWORD = "root";
public static void main(String[] args)
{ try
{ Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
Statement stmt = con.createStatement();
// Create table
String createTableQuery = "CREATE TABLE IF NOT EXISTS CarDetail("
+ "car_id VARCHAR(20) NOT NULL,"
+ "car_name VARCHAR(50) NOT NULL,"
+ "owner_name VARCHAR(50) NOT NULL,"
+ "model VARCHAR(50) NOT NULL,"
+ "ph_number VARCHAR(10) NOT NULL,"
+ "fare VARCHAR(50) NOT NULL)";
stmt.executeUpdate(createTableQuery);
System.out.println("Table created successfully!");
Scanner sc = new Scanner(System.in);
int choice = -1;
while (choice != 0) {
System.out.println("\n----- Car BOOKING TICKET SYSTEM----------- ");
System.out.println("1. car detail to store");
System.out.println("2. Update car Fare");
System.out.println("3. Update car model");
System.out.println("4. Delete a car detail");
System.out.println("5. Show All detail");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1:
// Book a ticket
System.out.print("enter the number of car:");
int n=sc.nextInt();
sc.nextLine();
for(int i=0;i<n;i++)
{
System.out.print("Enter car id: ");
String car_id = sc.nextLine();
System.out.print("Enter car name: ");
String car_name = sc.nextLine();
System.out.print("Enter owner_name: ");
String owner_name = sc.nextLine();
System.out.print("Enter car model: ");
String model = sc.nextLine();
System.out.print("Enter owner ph_number: ");
String ph_number = sc.nextLine();
System.out.print("Enter service fare: ");
String fare = sc.nextLine();
String insertQuery = "INSERT INTO CarDetail
(car_id,car_name,owner_name,model,ph_number, fare) VALUES
(?,?,?,?,?,?)";
PreparedStatement insertStmt = con.prepareStatement(insertQuery);
insertStmt.setString(1,car_id);
insertStmt.setString(2, car_name);
insertStmt.setString(3, owner_name);
insertStmt.setString(4, model);
insertStmt.setString(5, ph_number);
insertStmt.setString(6, fare);
insertStmt.executeUpdate();
}
System.out.println("car booked successfully!");
break;
case 2:
// Update car fare
System.out.print("Enter car ID to update fare: ");
String carId = sc.nextLine();
System.out.print("Enter new fare: ");
String newFare = sc.nextLine();
String updateQuery = "UPDATE CarDetail SET fare = ? WHERE ticket_id
= ?";
PreparedStatement updateStmt = con.prepareStatement(updateQuery);
updateStmt.setString(1, newFare);
updateStmt.setString(2, carId);
int rowsUpdated = updateStmt.executeUpdate();
if (rowsUpdated > 0) {
System.out.println("Fare updated successfully!");
} else {
System.out.println("Car not found!");
}
break;
case 3:
// Update car model
System.out.print("Enter ticket ID to update Class: ");
String carId1 = sc.nextLine();
System.out.print("Enter new class: ");
String newmodel = sc.nextLine();
String updateQuery1 = "UPDATE CarDetail SET model = ? WHERE ticket_id
= ?";
PreparedStatement updateStmt1 = con.prepareStatement(updateQuery1);
updateStmt1.setString(1, newmodel);
updateStmt1.setString(2, carId1);
int rowsUpdated1 = updateStmt1.executeUpdate();
if (rowsUpdated1 > 0) {
System.out.println("Model updated successfully!");
} else {
System.out.println("Car not found!");
}
break;
case 4:
// Delete a car
System.out.print("Enter car ID to delete: ");
String deletecarId = sc.nextLine();
String deleteQuery = "DELETE FROM CarDetail WHERE Car_id = ?";
PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
deleteStmt.setString(1, deletecarId);
int rowsDeleted = deleteStmt.executeUpdate();
if (rowsDeleted > 0) {
System.out.println("Car deleted successfully!");
} else {
System.out.println("Car not found!");
}
break;
case 5:
// Show all car
String selectQuery = "SELECT * FROM CarDetail";
ResultSet resultSet = stmt.executeQuery(selectQuery);
if (!resultSet.next()) {
System.out.println("No Car found!");
}
else
{
System.out.print(" ----- CAR DETAILS-------------");
System.out.println();
System.out.print("\n-------------------------------------------------
---------------------------------------------------------------------
----------------------\n");
String output = String.format(" %-25s%-25s%-25s%-25s%-25s%s",
"Car_ID", "Car_Name","Owner_Name","Model","Ph_Number","Fare");
System.out.print(output);
System.out.print("\n-------------------------------------------------
---------------------------------------------------------------------
----------------------\n");
System.out.println();
while (resultSet.next())
{
String output1 = String.format(" %-20s%-25s%-25s%-25s%-
25s%s",resultSet.getString(1) ,resultSet.getString(2),resultSet.getSt
ring(3),resultSet.getString(4),resultSet.getString(5),resultSet.getSt
ring(6));
System.out.print(output1);
System.out.println();
}
System.out.print("\n-------------------------------------------------
---------------------------------------------------------------------
----------------------\n");
}
break;
case 7:
//exit program
System.out.println("Exiting the program.");
break;
default:
//invalid choice
System.out.println("Invalid choice! Please try again.");
}
}
con.close();
} catch (ClassNotFoundException e)
{
e.printStackTrace();
} catch (SQLException e)
{ e.printStackTrace();
}
}
}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	

}
