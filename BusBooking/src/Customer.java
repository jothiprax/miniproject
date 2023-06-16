import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Customer {
	private static Connection con;
	private static Statement stat;
	private static PreparedStatement pset;
	private static ResultSet rset;
	public void display() throws ClassNotFoundException, SQLException, IOException {
	BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
	con=DataBase.getConnection();
	//System.out.println("if all the person travel to same destination type 1:");
	   System.out.println("Enter the Boarding: ");
	   String boarding=sc.readLine().toLowerCase();
	   System.out.println("Enter the Destintion: ");
	   String  destination=sc.readLine().toLowerCase();
	   stat=con.createStatement();
	   rset=stat.executeQuery("select * from bus");
	   int count=0;
	   while(rset.next()) {
			if(rset.getString(2).equals(boarding) && rset.getString(3).equals(destination)) {
			System.out.printf("%-20s %s %20s %20s \n","BusName","Boarding","Destination","Busfare" );
			System.out.printf("%-20s %s %20s %20s \n",rset.getString(1),rset.getString(2),rset.getString(3),rset.getDouble(5));
			count++;
			}
		}
			if(count==0) {
				System.out.println("No busses Available : ");
				System.out.println("we will add bus through this path Ass Soon As Possible:");
				System.out.println("**** Thanking You ! ****");
			}
			else {
			System.out.println("These are the busses available : ");
			System.out.println("enter the bus name you want to Travel : ");
			String busName=sc.readLine();
			stat=con.createStatement();
		    rset=stat.executeQuery("select count(*) from "+busName);
		    int seatsAvai = 0;
		    while(rset.next()) {
		    seatsAvai=rset.getInt(1);
		    }
		    stat=con.createStatement();
		    rset=stat.executeQuery("select seats from bus where busName="+"'"+busName+"'");
		    int seatsAvailablec = 0;
		    while(rset.next()) {
			    seatsAvailablec=rset.getInt(1);
			    }
			int seatsAvailable = (seatsAvailablec-seatsAvai);
		    System.out.println("Available seats = "+seatsAvailable);
		    if(seatsAvailable==0) {
		    	System.out.println("No seats Available");
		    }else {
			System.out.println("Enter the Number of persons to be Added: ");
			int n=Integer.parseInt(sc.readLine());
			Double busfare=0.0;
			int age = 0;
			for(int i=1;i<=n;i++) {
			System.out.println("Enter the  Name: ");
		    String Name=sc.readLine();
		    System.out.println("enter the age: ");
		    age=Integer.parseInt(sc.readLine());
		    System.out.println("enter the contactNumber: ");
		    long contactNumber =Long.parseLong(sc.readLine()); 
		    pset=con.prepareStatement("insert into "+ busName+" values(?,?,?,?,?)");
	  	    pset.setString(1 ,Name);
		    pset.setString(2,boarding);
		    pset.setString(3, destination);
         pset.setInt(4, age);
         pset.setLong(5, contactNumber);
		    pset.executeUpdate();
		    pset=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
	  	    pset.setString(1 ,Name);
		    pset.setString(2,boarding);
		    pset.setString(3, destination);
         pset.setInt(4, age);
         pset.setLong(5, contactNumber);
         pset.setString(6,busName);
		    pset.executeUpdate();
		    stat=con.createStatement();
		    rset=stat.executeQuery("select busfare from bus where busName="+"'"+busName+"'");
		    while(rset.next()) {
		    	busfare=rset.getDouble(1);
			    }
		    System.out.println("Name        : "+Name.toUpperCase());
		    System.out.println("Bus Name    : "+busName.toUpperCase());
			System.out.println("from        : "+boarding.toUpperCase());
			System.out.println("To          : "+destination.toUpperCase());
			System.out.println("Total Seats : 1");
			System.out.println("Ticket price for Each person : "+busfare);
			if(age<5) {
				System.out.println("Ticket price for children : "+busfare/2);
			}
			 }
			if(age<=5) {
				System.out.println("Total Ticket Amount: "+((n*busfare)-(n*(busfare/2))));
			}
			else {
				System.out.println("Total Ticket Amount: "+(n*busfare));
			}
			 }
			System.out.println("***** Thank you  for Booking ! *****");
			System.out.println("******   Happy Journey !      ******");
			}
}
}
