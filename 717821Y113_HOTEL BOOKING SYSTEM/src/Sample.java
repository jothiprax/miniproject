import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Sample {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Dhesigan123@kkm");
			Statement stmt=con.createStatement();
			int Roomno=0;
			ResultSet r=stmt.executeQuery("select * from rooms");
			while(r.next()) {
				Roomno++;
			}
			System.out.println("Enter Your Choise:");
			System.out.println("1.View Details");
			System.out.println("2.Insert data");
			System.out.println("3.Delete Data");
			int choise=in.nextInt();
			in.nextLine();
			switch(choise) {
			case 1:
				ResultSet rs=stmt.executeQuery("select * from rooms");
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
					Roomno++;
				}
				break;
			case 2:
				System.out.println(Roomno);
				System.out.println("Enter the details want to insert:");
				System.out.print("Enter the Name:");
				String name=in.nextLine();
				System.out.print("Enter the Phone Number:");
				String number=in.nextLine();
				System.out.print("Enter the Address:");
				String Address=in.nextLine();
				System.out.print("Enter the Room Type:");
				String Room_type=in.nextLine();
				System.out.print("Enter the No of Days:");
				int Days=in.nextInt();
				int cost=0;
				if(Room_type.toLowerCase().equals("single")){
					cost=Days*1500;}
				if(Room_type.toLowerCase().equals("double")) {
					cost=Days*2500;
				}
				String sql="insert into rooms(Room_no,User_name,Phone,Address,Room_Type,Days,Cost) values(?,?,?,?,?,?,?)";
				PreparedStatement preparedstatement=con.prepareStatement(sql);
				Roomno++;
				preparedstatement.setInt(1, Roomno);
				preparedstatement.setString(2, name);
				preparedstatement.setString(3, number);
				preparedstatement.setString(4, Address);
				preparedstatement.setString(5, Room_type);
				preparedstatement.setInt(6, Days);
				preparedstatement.setInt(7, cost);
				int rows=preparedstatement.executeUpdate();
				if(rows>0) {
					System.out.println("Successfuly inserted");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
