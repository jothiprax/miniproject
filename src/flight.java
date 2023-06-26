import java.sql.*;
import java.util.Scanner;
public class flight {	
 public static void main(String[] args) throws ClassNotFoundException{
 try{
 // Class.forName("com.mysql.jdbc.Driver");
 String url="jdbc:mysql://localhost:3306/";
 String us="root";
 String ps="Kavin@123";
 Connection c=DriverManager.getConnection(url,us,ps);
 Statement stmt=c.createStatement();
 stmt.execute("use kavin");
 System.out.println("connected");

         try (Scanner sc = new Scanner(System.in)) {
            System. out. println("Enter the flight details:") ;
             System.out.println("Enter the FlightNumber");
             String flightNumber = sc.nextLine();
             System.out.println("Enter the Orgin:");
             String origin = sc.nextLine();
             System.out.println("Enter the Destination:");
             String destination = sc.nextLine();
             System.out.println("Enter the DepatureDate:");
             String departureDate = sc.nextLine();
             System.out.println("Enter ArrivalDate:");
             String arrivalDate =sc.nextLine();
             System.out.println("DepatureTime:");
             String departureTime = sc.nextLine();
             System.out.println("Enter the ArrivalTime:");
             String arrivalTime = sc.nextLine();
              System.out.println("Inserted");

             String sql = "INSERT INTO flights VALUES (?,?,?,?,?,?,?)";
             PreparedStatement st = c.prepareStatement(sql);
             st.setString(1, flightNumber);
             st.setString(2, origin);
             st.setString(3, destination);
             st.setString(4, departureDate);
             st.setString(5, arrivalDate);
             st.setString(6, departureTime);
             st.setString(7, arrivalTime);
             st.execute();
             System.out.println("Inserted");

      ResultSet rs=st.executeQuery("select flightNumber, origin, destination, departureDate, arrivalDate, departureTime, arrivalTime from flights") ;
      System.out.println("Your Ticket is:");
 while(rs.next()) {
 System. out. println(rs.getString(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)) ;
 }
        }
 }catch(Exception e) {
 System. out. println(e) ;
 }
 }
}