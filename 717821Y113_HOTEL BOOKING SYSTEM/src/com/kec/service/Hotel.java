package com.kec.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.kce.dao.*;
public class Hotel {
	public static void RoomTypeCheck() {
		int DBR=0,SBR=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Dhesigan123@kkm");
			Statement stmt=con.createStatement();
			ResultSet r=stmt.executeQuery("select * from rooms");
			while(r.next()) {
				if(r.getString(5).toLowerCase().equals("double")) {
					DBR++;
				}
				if(r.getString(5).toLowerCase().equals("single")) {
					SBR++;
				}
			}
			System.out.println("DOUBLE BEDROOMS: "+(25-DBR));
			System.out.println("SINGLE BEDROOMS: "+(75-SBR));
	}catch(Exception e) {
		System.out.println(e);
	}
}
	public static int RoomCheck() {
		int ans=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Dhesigan123@kkm");
			Statement stmt=con.createStatement();
			int Roomno=0;
			ResultSet r=stmt.executeQuery("select * from rooms");
			while(r.next()) {
				Roomno++;
			}
			ans= 100-Roomno;
	}catch(Exception e) {
		System.out.println(e);
	}
		return ans;
}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		com.kce.dao.HotelDatabase h=new com.kce.dao.HotelDatabase();
		System.out.println("WELCOME TO SOONAPANA HOTEL!!");
		System.out.println("OUR HOTEL HAVE 100 ROOMS 25 DOUBLE BEDROOM ROOMS AND 75 SINGLE BEDROOM ROOMS");
		System.out.println("       =>DOUBLE BEDROOM IS RS.2500 PER DAY");
		System.out.println("       =>SINGLE BEDROOM IS RS.1500 PER DAY");
		System.out.println("DO YOU WANT ANY ROOMS? YES OR NO");
		String want=in.nextLine();
		if(want.toUpperCase().equals("YES")) {
			System.out.println("WAIT WE WILL CHECK IS THERE IS ANY ROOMS ARE AVAILABLE NOW");
			int check=RoomCheck();
			if(check<100) {
				System.out.println("YES SIR THERE ARE MANY ROOMS ARE AVAILABLE IN OUR HOTEL");
				System.out.println("AVAILABLE ROOMS: "+check);
				RoomTypeCheck();
				System.out.println("WE'LL ALLOCATE THE ROOM FOR YOU");
				System.out.println("PLEASE FILL THE DETAILS");
				h.InsertData();
				
			}else {
				System.out.println("SORRY SIR THERE IS NO ROOMS AVAILABLE NOW");
			}
		}
		if(want.toUpperCase().equals("NO")) {
			System.out.println("OK SIR.THEN IF YOU CAME TO OUR HOTEL FOR SEE OUR CUSTOMER DETAILS");
			System.out.println("PLEASE ENTER YES");
			String option=in.nextLine();
			if(option.toUpperCase().equals("YES")){
				h.ViewDatabase();
			}
		}
	}

}

