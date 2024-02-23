package sample;
import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class RoomsCategory 
{
Scanner sc=new Scanner(System.in);
List<Integer> l=new ArrayList<Integer>();
	void Standardroom(int mem) 
	{
		try {
	int count=0;
	int i=0;
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kal","root","12345");
		int maxmembers=2;
		System.out.println("--------------DETAILS---------------------");
		System.out.println("Standard Rooms ---> [101-108] ");
		System.out.println("Maximum People : 2 ");
		System.out.println("Price For Non-Ac : Rs:1500/- (With Food)");
		System.out.println("For Ac Rs: 2000/-");
		System.out.println("--------------------------------------");
		System.out.println("Enter your room number : ");
		int range=sc.nextInt();
		if(l.isEmpty()) {
			if(mem<=maxmembers) {
				PreparedStatement st=con.prepareStatement("insert into customer values(?)");
			st.setInt(1,range);
				 i=st.executeUpdate();
	         l.add(i);
			System.out.println("Your Room Has Booked Successfully.");
		}
			else {
				throw new OverBookingException();
			}
		}
		else {
			PreparedStatement st=con.prepareStatement("select * from customer");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)== range) {
					throw new UnavailableException();
				}
				count++;
				
			}
			}
			 if(l.contains(count)){
				if(mem<maxmembers) {
					PreparedStatement st=con.prepareStatement("insert into customer values(?)");
					st.setInt(1,range);
					i+=st.executeUpdate();
					l.add(i);
				System.out.println("Your Room Has Booked Successfully.");
			}
				else {
					throw new OverBookingException();
				}
		}
	}
	catch(UnavailableException e) {
		System.out.println(e.toString());
	}
     catch(OverBookingException m) {
    	 System.out.println(m.toString());
     }
		catch(SQLException e) {
			System.out.println(e);
		}
	
	}
		
	void Doublecot(int mem)  
	{
		try {
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kal","root","12345");
		
		int count = 0,i=0;
		int maxmembers=3;
		System.out.println("-----------DETAILS---------------");
		System.out.println("Doublecot Rooms ---> [201-210] ");
		System.out.println("Maximum People : 3 ");
		System.out.println("Price For Non-Ac : Rs:2500/- (With Food)");
		System.out.println(" For Ac Rs:3000/-");
		System.out.println("--------------------------------");
		System.out.println("Enter your room number : ");
		int range=sc.nextInt();
		if(l.isEmpty()) {
			if(mem<=maxmembers) {
				PreparedStatement	st=con.prepareStatement("insert into customer values(?)");
				st.setInt(1,range);
					 i=st.executeUpdate();
	 l.add(i);	
			System.out.println("Your Room Has Booked Successfully.");
		}
			else {
				throw new OverBookingException();
			}
		}
		else {
			PreparedStatement	st=con.prepareStatement("select * from customer");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)== range) {
					throw new UnavailableException();
				}
				count++;
				
			}
			}
			 if(l.contains(count)){
				if(mem<maxmembers) {
					PreparedStatement st=con.prepareStatement("insert into customer values(?)");
					st.setInt(1,range);
					i+=st.executeUpdate();
					l.add(i);
				System.out.println("Your Room Has Booked Successfully.");
			}
				else {
					throw new OverBookingException();
				}		
	}
	}
		catch(UnavailableException e) {
			System.out.println(e.toString());
		}
	     catch(OverBookingException m) {
	    	 System.out.println(m.toString());
	     }
		catch(SQLException m) {
	    	 System.out.println(m);
	     }
		
		
	}
	void deluxeroom(int mem)  {
		try {
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kal","root","12345");
		int count = 0,i=0;
		int maxmembers=6;
		System.out.println("---------DETAILS---------");
		System.out.println("Deluxe Rooms ---> [310-350] ");
		System.out.println("Maximum People : 6 ");
		System.out.println("Price For Non-Ac : Rs:4500/- (With Food)");
		System.out.println("For Ac Rs:5000/-");
		System.out.println("----------------------------");
		System.out.println("Enter your room number : ");
		int range=sc.nextInt();
		if(l.isEmpty()) {
			if(mem<=maxmembers) {
				PreparedStatement  st=con.prepareStatement("insert into customer values(?)");
				st.setInt(1,range);
			   i=st.executeUpdate();
	            l.add(i);	
			System.out.println("Your Room Has Booked Successfully.");
		}
			else {
				throw new OverBookingException();
			}
		}
		else {
			PreparedStatement  st=con.prepareStatement("select * from customer");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)== range) {
					throw new UnavailableException();
				}
				count++;
				
			}
			}
			 if(l.contains(count)){
				if(mem<maxmembers) {
					PreparedStatement st=con.prepareStatement("insert into customer values(?)");
					st.setInt(1,range);
					i+=st.executeUpdate();
					l.add(i);
				System.out.println("Your Room Has Booked Successfully.");
			}
				else {
					throw new OverBookingException();
				}	
	}
		}
		catch(UnavailableException e) {
			System.out.println(e.toString());
		}
	     catch(OverBookingException m) {
	    	 System.out.println(m.toString());
	     }
		catch(SQLException d) {
	    	 System.out.println(d);
	     }
		
		
	}
		
}
