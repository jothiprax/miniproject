package com.kce.bean;
import com.kce.service.*;
import com.kce.util.*;
import java.sql.*;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class Audience {
 private String aname;
 private String email;
 private String number;
 public Audience() {
	 
 }
 public Audience(String aname,String email,String number) {
	 this.aname=aname;
	 this.email=email;
	 this.number=number;
 }
 public String getname() {
	 return aname;
 }
 public String getemail() {
	 return email;
 }
 public String getnumber() {
	 return number;
 }
 public void booktickets(Connection con) {
	 Scanner sc=new Scanner(System.in);
	 try {
	 System.out.println("\n\t\t\t\t\tLatest Screening Movies in our Cinemas\n\t\t\t\t\t--------------------------------------");
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("select * from movie");
	 System.out.printf("%-10s %-15s %-15s\n","Screen_No","Movie_Name","Show_Time");
	 System.out.println("-------------------------------------");
	 int mov=0;
	 while(rs.next()) {
		 String movie=rs.getString(2);
		 int screenno=rs.getInt(1);
		 Time time=rs.getTime(4);
		 System.out.printf("%-10s %-15s %-15s\n",screenno,movie,time);
		 System.out.println("-------------------------------------");
		 mov++;
	 }
	 if(mov==0) {
		 System.out.printf("%-10s %-15s %-15s\n","!Null!","!Null!","!Null");
		 System.out.println("\n\t\tNo Screening Movies Right Now!!");
		 return;
	 }
		 System.out.println("Enter the Movie name from the above list to book tickets:");
		 String mname=sc.nextLine();
		 String moviename=mname.substring(0,1).toUpperCase()+mname.substring(1);
		 System.out.println("\nEntered the show time(HH:MM:SS):");
		   String time=sc.next();
		   
		   LocalTime ti=LocalTime.parse(time);
		   Time t=Time.valueOf(ti);
	     PreparedStatement pst=con.prepareStatement("select * from movie where Movie_Name=? and Show_Time=?");
	    pst.setString(1,moviename);
	    pst.setTime(2, t);
	     ResultSet rst=pst.executeQuery();
	     while(rst.next()) {
	    	System.out.println("Enter the number of tickets to book:");
	    	int seat=sc.nextInt();
	    	int availableseats=rst.getInt(3);
	    	if(seat>availableseats||availableseats<=0) {
	    		System.out.println("\nTickets are not available for your needed seats\nCurrently Available seats :"+availableseats);
	    		return;
	    	}
	    	else {
	    		String name=rst.getString(2);
	    		int sno=rst.getInt(1);
	    		Time time1=rst.getTime(4);
	    		float total=seat*190;
	    		System.out.println("\nConfirm Your Ticket:\n\nMovie Name\t\t:"+name+"\nAt Screen_No\t\t:"+sno+"\nShow Time\t\t:"+time1+"\nTotal_Price - "+seat+" Seats \t:"+total);
	    		System.out.println("\nTo confirm type YES or type NO to cancel");
	    		String str=sc.next();
	    		if(str.equalsIgnoreCase("yes")) {
	    		availableseats=availableseats-seat;
	    		PreparedStatement newseat=con.prepareStatement("update movie set Seats_Available=? where Movie_Name=?");
	    		newseat.setInt(1, availableseats);
	    		newseat.setString(2, moviename);
	    		newseat.executeUpdate();
	    		PreparedStatement pt=con.prepareStatement("insert into audience(Name,Phone_No,Email_Id,Movie_Name,Show_Time,Seats_Booked,Total_Price)values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
	    		pt.setString(1,aname);
	    		pt.setString(2, number);
	    		pt.setString(3, email);
	    		pt.setString(4, name);
	    		pt.setTime(5, t);
	    		pt.setInt(6,seat);
	    		
	    		pt.setFloat(7, total);
	    		if(pt.executeUpdate()>0) {
	    			System.out.println("\nTickets are Booked Successfully");
	    		}
	    		return;
	    	}
	    	
	     }
	     }
	     System.out.println("\nEntered Movie is not screening in our cinemas");
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
 
}
 public void canceltickets(Connection con) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("\n\t\t\t\t\tIn our cinemas full refund of ticket will be issued after Cancellation!!");
	 System.out.println("\nEnter the Mobile number which is registered with the booked Ticket:");
	 String mno=sc.nextLine();
	 String numberp="^[6-9][0-9]{9}$";
     Pattern npattern=Pattern.compile(numberp);
     Matcher nmatch=npattern.matcher(mno);
     if(!nmatch.matches()) {
	    System.out.println("\nInvalid Phone number!!");
	    return;
	  }
     try {
    	 Statement st=con.createStatement();
    	 ResultSet rs=st.executeQuery("select * from audience where Phone_No='"+mno+"'");
    	 while(rs.next()) {
        System.out.println("\nConfirm Your Cancellation:\n----------------------------------------");
    	System.out.println("| Name\t\t:"+rs.getString(1)+"\t\t|\n| Phone_No\t:"+rs.getString(2)+"\t\t|\n| Email_Id\t:"+rs.getString(3)+"\t|\n| Movie_Name\t:"+rs.getString(4)+"\t\t|\n| Show_Time\t:"+rs.getTime(5)+"\t\t|\n| Seats_Booked\t:"+rs.getInt(6)+"\t\t\t|\n| Total_Price\t:"+rs.getFloat(7)+"\t\t\t|");
    	System.out.println("----------------------------------------");
    	System.out.println("\nTo confirm cancellation type YES or type NO to cancel the Process");
	    String s=sc.next();
	    if(s.equalsIgnoreCase("yes")) {
    	 PreparedStatement pst=con.prepareStatement("Delete from audience where Phone_No=?");
    	 pst.setString(1, mno);
    	 pst.executeUpdate();
    	 System.out.println("\nYour Ticket Cancellation completed succesfully!!");
    	 return;
    	 }
	    else if(s.equalsIgnoreCase("no")) {
	    	 System.out.println("\nYour Ticket Cancellation process been cancelled!!");
	    	 return;
	    }
	    else {
	    	 System.out.println("\nInvalid command");
	    	 return;
	    }
     }
    	 System.out.println("\nEntered Mobile Number is not registered in our cinemas");
     }
	 catch(Exception e) {
		 System.out.println(e);
	 }
 }
 public void viewtickets(Connection con) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("\n\t\t\t\t\tTicket Viewing Session");
	 System.out.println("\nEnter the Mobile number which is registered with the booked Ticket:");
	 String mno=sc.nextLine();
	 
	 String numberp="^[6-9][0-9]{9}$";
     Pattern npattern=Pattern.compile(numberp);
     Matcher nmatch=npattern.matcher(mno);
     if(!nmatch.matches()) {
	    System.out.println("\nInvalid Phone number!!");
	    return;
	  }
     try {
    	 Statement st=con.createStatement();
    	 ResultSet rs=st.executeQuery("select * from audience where Phone_No='"+mno+"'");
    	 while(rs.next()) {
        System.out.println(" ---------------------------------------");
    	System.out.println("| Name\t\t:"+rs.getString(1)+"\t\t|\n| Phone_No\t:"+rs.getString(2)+"\t\t|\n| Email_Id\t:"+rs.getString(3)+"\t|\n| Movie_Name\t:"+rs.getString(4)+"\t\t|\n| Show_Time\t:"+rs.getTime(5)+"\t\t|\n| Seats_Booked\t:"+rs.getInt(6)+"\t\t\t|\n| Total_Price\t:"+rs.getFloat(7)+"\t\t\t|");
    	System.out.println(" ---------------------------------------");
 }
     }
     catch(Exception e) {
    	 System.out.println(e);
     }
}
 public void orderfoods(Connection con) throws Exception{
		
		 Scanner sc=new Scanner(System.in).useDelimiter("");
	 System.out.println("\n\t\t\t:::::::In our Cinemas we are providing foods only to the customer who have booked The Ticket:::::::");
	 System.out.println("\nEnter the Mobile number which is registered with the booked Ticket:");
	 String mno=sc.nextLine();
	 String np="^[6-9][0-9]{9}$";
     Pattern npa=Pattern.compile(np);
     Matcher nm=npa.matcher(mno);
     if(!nm.matches()) {
	    System.out.println("\nInvalid Phone number!!");
	    return;
	  }
     Statement fst=con.createStatement();
	 ResultSet frs=fst.executeQuery("select * from audience where Phone_No='"+mno+"'");
	 while(!frs.next()) {
		 System.out.println("\nEntered Mobile Number is not Registered with any Tickets!!");
		 return;
	 }
	 Statement fc=con.createStatement();
	 ResultSet fct=fc.executeQuery("select * from snacks");
	 System.out.println("\nCurrently Available Foods:");
	 System.out.printf("\n     %-15s %-15s %10s\n","Food_Name","Type","Price");
	 System.out.println("-----------------------------------------------");

	 int o=1;
	 int c=0;
	 while(fct.next()) {
		 System.out.printf("| "+o+". %-15s %-15s %10s|\n",fct.getString(1),fct.getString(2),fct.getFloat(3));
		 System.out.println("-----------------------------------------------");
		 o++;
		 c++;
	 }
	 if(c==0) {
		 System.out.println("\nCurrently Foods not available!!\nTry Again Later!!");
	 }
	 System.out.println("\nChoose Foods from the menu above:\n");
		System.out.println("\nEnter the food name:");
		String foooname=sc.nextLine();
		String fname=foooname.substring(0, 1).toUpperCase()+foooname.substring(1);
		System.out.println("\nEnter the food type name:");
		String foooname1=sc.nextLine();
		String typename=foooname1.substring(0, 1).toUpperCase()+foooname1.substring(1);
		Statement fc1=con.createStatement();
		ResultSet fo=fc1.executeQuery("select * from snacks where Food_Name='"+fname+"' and Type='"+typename+"'");
		while(!fo.next()) {
			System.out.println("\nEntered Food Name or Type name is not available in our food court!!");
			return;
		}
		System.out.println("\nEnter the Qty:");
	    int qty=sc.nextInt();
	    PreparedStatement fc2=con.prepareStatement("select * from snacks where Food_Name=? and Type=?");
	    fc2.setString(1, fname);
	    fc2.setString(2, typename);
	    float price=fo.getFloat(3);
        float total=qty*price;
        PreparedStatement af=con.prepareStatement("insert into foodorders(phno,Fname,Qty,Total_price) values (?,?,?,?)");
        System.out.println("\nFood Details:\nFood_Name\t:"+fname+"\nQty\t\t:"+qty+"\nTotal_Price\t:"+total);
        System.out.println("\nDo you want to confirm your food order (Enter 1(YES) or other than 1(NO):");
        Scanner t=new Scanner(System.in);
        int cho=t.nextInt();
        if(cho!=1) {
        	System.out.println("\nYour Order been Neglected!!");
        	return;
        }
        af.setString(1, mno);
        af.setString(2,fname);
        af.setInt(3, qty);
        af.setFloat(4, total);
        if(af.executeUpdate()>0) {
        System.out.println("\nYour Order been Placed");
         }
        return;
	 }

     public void viewfoodorder(Connection con) {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("\n\t\t\t\t\tFood Orders Viewing Session");
    	 System.out.println("\nEnter the Mobile number which is registered with the Ordered Food:");
    	 String mno=sc.nextLine();
    	 String nump="^[6-9][0-9]{9}$";
         Pattern npat=Pattern.compile(nump);
         Matcher nmat=npat.matcher(mno);
         if(!nmat.matches()) {
    	    System.out.println("\nInvalid Phone number!!");
    	    return;
    	  }
         try {
        	 Statement forder=con.createStatement();
        	 ResultSet f=forder.executeQuery("select * from foodorders where phno='"+mno+"'");
        	 while(!f.next()) {
        		 System.out.println("\nEntered Mobile Number is not Registered with any Food Orders!!");
        		 return;
        	 }
        	 System.out.println("\nYour Ordered Foods:");
        	 System.out.printf("\n     %-15s %-15s %10s\n","Food_Name","Qty","Total_Price");
        	 System.out.println("-----------------------------------------------");

        	 int o=1;
        	 int c=0;
        	 float Total=0;
        	 Statement statement=con.createStatement();
        	 ResultSet food=statement.executeQuery("select * from foodorders where phno='"+mno+"'");
        	 while(food.next()) {
        		 System.out.printf("| "+o+". %-15s %-15s %10s|\n",food.getString(2),food.getString(3),food.getFloat(4));
        		 System.out.println("-----------------------------------------------");
        		 o++;
        		 c++;
        		 Total+=f.getFloat(4);
        	 }
        	 if(Total>0) {
        		 System.out.printf("\tTotal cost of your Food Orders: %.2f.Rs",Total);
        	 }
        	 else if(c==0) {
        		 System.out.println("You have ordered nothing in our Food Court");
        	 }
         }
         catch(Exception e) {
        	 System.out.println(e);
         }
     }
}

