// import java.sql.*;
// import java.util.Scanner;
// public class flight {	
//  public static void main(String[] args) throws ClassNotFoundException{
//  try{
//   Class.forName("com.mysql.jdbc.Driver");
//  String url="jdbc:mysql://localhost:3306/mysql";
//  String us="root";
//  String ps="root";
//  Connection c=DriverManager.getConnection(url,us,ps);
//  System.out.println("connected");

//          Scanner sc = new Scanner(System.in);

//          System. out. println("Enter the flight details:") ;

//          String flightNumber = sc.nextLine();
//          String origin = sc.nextLine();
//          String destination = sc.nextLine();
//          String departureDate = sc.nextLine();
//          String arrivalDate =sc.nextLine();
//          String departureTime = sc.nextLine();
//          String arrivalTime = sc.nextLine();


//          String sql = "INSERT INTO flights (flightNumber, origin, destination, departureDate, arrivalDate, departureTime, arrivalTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
//          PreparedStatement st = c.prepareStatement(sql);
//          st.setString(1, flightNumber);
//          st.setString(2, origin);
//          st.setString(3, destination);
//          st.setString(4, departureDate);
//          st.setString(5, arrivalDate);
//          st.setString(6, departureTime);
//          st.setString(7, arrivalTime);
//          st.executeUpdate();

//        PreparedStatement st1 = c.prepareStatement("select * from flights");
//  ResultSet rs=st.executeQuery("select flightNumber, origin, destination, departureDate, arrivalDate, departureTime, arrivalTime from flights") ;
//  while(rs.next()) {
//  System. out. println(rs.getString(1) +" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)) ;
//  }
//  }catch(Exception e) {
//  System. out. println(e) ;
//  }
//  }
// }