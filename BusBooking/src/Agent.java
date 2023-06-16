import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Agent {
	private static Connection con;
	private static Statement stat;
	private static PreparedStatement pset;
public void display() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
	BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
	con=DataBase.getConnection();
	System.out.println("Enter the Number of bus to be Added: ");
	   int n=Integer.parseInt(sc.readLine());
	   for(int i=1;i<=n;i++) {
	   System.out.println("Enter the "+i+" bus details:");
	   System.out.println("Enter the Bus Name: ");
	   String busName=sc.readLine().toLowerCase();
	   System.out.println("Enter the Boarding: ");
	   String boarding=sc.readLine().toLowerCase();
	   System.out.println("Enter the Destintion: ");
	   String  destination=sc.readLine().toLowerCase();
	   System.out.println("enter the Seat Capacity: ");
	   int seats=Integer.parseInt(sc.readLine()); 
	   System.out.println("Enter the Bus Fare : ");
	   double busfare=Double.parseDouble(sc.readLine());
	   stat=con.createStatement();
	   stat.execute("create table "+busName+
	   "(customerName varchar(20),boarding varchar(20),destination varchar(20),age int,ContactNumber long)");
	   pset=con.prepareStatement("insert into bus values(?,?,?,?,?)");
	   pset.setString(1,busName);
	   pset.setString(2,boarding);
	   pset.setString(3, destination);
	   pset.setInt(4, seats);
	   pset.setDouble(5,busfare);
	   pset.executeUpdate();
	   }
	   System.out.println("***** Thank you  for registering with us ! *****");

}
}
