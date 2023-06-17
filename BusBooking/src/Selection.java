import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Selection {
	private static Connection con;
	private static Statement stat;
	private static ResultSet rset;
	public void Dispaly() throws SQLException, ClassNotFoundException {
		try {
		BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
		con=DataBase.getConnection();
		stat=con.createStatement();
		System.out.println("if you need to see the specific bus Customer Details type 1 ");
		System.out.println("if you need to see the full Customer Details type 2 ");
		int n=Integer.parseInt(sc.readLine());
		if(n==1) {
		rset=stat.executeQuery("select busName from bus");
		while(rset.next()) {
			System.out.println(rset.getString(1).toUpperCase());
		}
		System.out.println("Enter the BusName to show the Customer Details of the bus ");
		String busName=sc.readLine();
		rset=stat.executeQuery("select * from "+busName);
		System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","Name","Boarding","Destination","Age","ContactDetails" );
		while(rset.next()) {
			System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getLong(5));
		}
		}
		else if(n==2) {
			rset=stat.executeQuery("select * from customer");
			 System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n","Name","Boarding","Destination","Age","ContactDetails","BusName");
			while(rset.next()) {
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n",rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getLong(5),rset.getString(6));
			}
		}
		else {
			System.out.println("Invalid Input ");
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
