package com.kce.dao;
import com.kce.*;
	import java.util.*;
	import java.sql.*;
	import java.time.LocalTime;
	public class Dao{
		Scanner sc=new Scanner(System.in);
	   public void addmovie(Connection con) {
		   try {
		   PreparedStatement st=con.prepareStatement("insert into movie(Screen_No,Movie_Name,Show_Time) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
		   
		   System.out.println("\nEnter the name of movie:");
		   String mname=sc.nextLine();
		   String name=mname.substring(0,1).toUpperCase()+mname.substring(1);
		   System.out.println("\nEnter the Screen_No to screen the movie-"+name+" :");
		   int sno=sc.nextInt();
		   if(sno<=5) {
		   Statement state=con.createStatement();
		   ResultSet rs=state.executeQuery("select * from movie where Screen_No='"+sno+"'");
		   while(rs.next()) {
			   System.out.println("\nEntered Screen_No not available!!");
			   return;
		   }
		   System.out.println("\nEntered the show time(HH:MM:SS):");
		   String time=sc.next();
		   
		   LocalTime ti=LocalTime.parse(time);
		   Time t=Time.valueOf(ti);
		   st.setInt(1, sno);
		   st.setString(2, name);
		   st.setTime(3, t);
		   if(st.executeUpdate()>0) {
		   System.out.println("\nNew Movie Successfully Updated\nMovie Name\t\t: "+name+"\nAt Screen_No\t\t: "+sno+"\nShow Time\t\t:"+t);
		   return;
		   }
	   }
		   else {
			   System.out.println("\nScreen no is invalid: Only 5 screens are inbuilted");
		   }
		   }
		   catch(Exception e) {
			   System.out.println(e);
		   }
	   }
	   public void removemovie(Connection con) {
		   try {
			   System.out.println("\nWhich Movie you want to remove?");
			   Statement pst=con.createStatement();
			   ResultSet rs=pst.executeQuery("select * from movie");
			   System.out.printf("\n     %-15s %-10s\n","Movie_Name","Screen_No");
			   System.out.printf(" %-15s\n","------------------------------");
			  int i=1;
			   while(rs.next()) {
				   int screen=rs.getInt(1);
					 String movie=rs.getString(2);
					 System.out.printf("| "+i+". %-15s %-10s|\n",movie,screen);
					 System.out.printf(" %-15s\n","------------------------------");
					 i++;
			   }
		   PreparedStatement st=con.prepareStatement("delete from movie where Movie_Name=?");
		   System.out.println("\nEnter the name of movie to remove:");
		   String mname=sc.next();
		   String name=mname.substring(0,1).toUpperCase()+mname.substring(1);
		   st.setString(1,name);
		   if(st.executeUpdate()>0) {
		   System.out.println("\nRequested Movie Successfully Removed from your Cinemas\nMovie Name\t\t: "+name);
		   return;
		   }
		   else {
			   System.out.println("\nRequested Movie is not available in your Cinemas\n");
		   }
	   }
	   catch(Exception e) {
		   System.out.println(e);
	   }
	}
	   public void bookingsincome(Connection con) {
		   try {
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("select * from audience");
		   System.out.println("\nBooking Details:");
		   System.out.printf("  %-20s %-15s %-25s %-15s %-10s %-15s %-10s\n","Name","Phone_No","Email_Id","Movie_Name","Show_Time","Seats_Booked","Total_Price");
		   int booking=0;
		   float TotalIncome=0;
		   System.out.println("---------------------------------------------------------------------------------------------------------------------");
		   while(rs.next()) {
			   System.out.printf("|  %-20s %-15s %-25s %-15s %-10s %-15s %10s|\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)); 
			   System.out.println("---------------------------------------------------------------------------------------------------------------------");
		       booking++;
		       TotalIncome+=rs.getFloat(7);
		   }
		   
		   if(booking==0) {
		   System.out.println("\nNo Booking till now!!");
	   }
		   else {
			   System.out.printf("\t\t\t\t\t\t\t\t\t\t\t   Total Income ="+TotalIncome+".Rs");
		   }
		   }
		   catch(Exception e) {
			   System.out.println(e);
		   }
	}
	   public void foodcounter(Connection con) {
		   Scanner s=new Scanner(System.in);
		   int foodc=1;
			try (  Scanner sc=new Scanner(System.in).useDelimiter("")){	
					System.out.println("\nFOOD COURT");
					   System.out.println("\nAVAILABLE OPTIONS:\n1-Add Foods\n2-Remove Foods\n3-Set New Price to foods\n4-Exit\nEnter the Choice:");
						int choice=s.nextInt();
			switch(choice) {
			case 1:
				
			    System.out.println("\nEnter the food name:");
			    String name=sc.nextLine();
			    String fname= name.substring(0,1).toUpperCase()+name.substring(1);
			    System.out.println("\nEnter Type:");
			    String t=sc.nextLine();
			    String type=t.substring(0,1).toUpperCase()+t.substring(1);
			    System.out.println("\nEnter the price of food:");
			    float price=s.nextFloat();
	            Statement ava=con.createStatement();
				ResultSet result=ava.executeQuery("select * from snacks where Food_Name='"+fname+"' and Type='"+type+"'");
				
				while(result.next()) {
					System.out.println("\nEntered Food name is already added in Food Court");
					return;
				}
				PreparedStatement ti=con.prepareStatement("insert into snacks(Food_Name,Type,Price) values (?,?,?)");
				ti.setString(1,fname);
				ti.setString(2, type);
				ti.setFloat(3, price);
				ti.executeUpdate();
					System.out.println("\nFood_Name\t:"+fname+"\nType\t\t:"+type+"\nPrice\t\t:"+price);
					System.out.println("\nNew Food Successfully Added");	
			
				
			    break;
			 case 2:
				Statement pst=con.createStatement();
				ResultSet rst=pst.executeQuery("select * from snacks");
				System.out.println("\nCurrently Available Foods:");
				System.out.printf("\n     %-15s %-15s %10s\n","Food_Name","Type","Price");
				System.out.println("-----------------------------------------------");
				int to=0;
				int o=1;
				while(rst.next()) {
					System.out.printf("| "+o+". %-15s %-15s %10s|\n",rst.getString(1),rst.getString(2),rst.getFloat(3));
					System.out.println("-----------------------------------------------");
					to++;
					o++;
				}
				if(to==0) {
					System.out.println("\nNo Foods available in Food Court!!");
					return;
				}
				System.out.println("\nEnter the food name:");
			    String fooname=sc.next();
			    String foodname= fooname.substring(0,1).toUpperCase()+fooname.substring(1);
			    System.out.println("Enter Type:");
			    String ty=sc.next();
			    String type1=ty.substring(0,1).toUpperCase()+ty.substring(1);
			    Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from snacks where Food_Name='"+foodname+"' and Type='"+type1+"'");
			    while(rs.next()) {
			    	PreparedStatement pst1=con.prepareStatement("delete from snacks where Food_Name='"+foodname+"' and Type='"+type1+"'");
			    	System.out.println("Food_Name\t:"+foodname+"\nType\t\t:"+type1+"\nFood been Removed from Food Court");
			    	pst1.executeUpdate();
			    	return;
			    }
			    System.out.println("\nFood Name or Food Type is invalid");
				break;
			case 3:
				Statement ps=con.createStatement();
				ResultSet rst2=ps.executeQuery("select * from snacks");
				int i=1;
			    int f=0;
			    System.out.println("\nCurrently Available Foods:");
				System.out.printf("\n     %-15s %-15s %10s\n","Food_Name","Type","Price");
				System.out.println("-----------------------------------------------");
				while(rst2.next()) {
				     
					System.out.printf("| "+i+". %-15s %-15s %10s|\n",rst2.getString(1),rst2.getString(2),rst2.getFloat(3));
					System.out.println("-----------------------------------------------");
					i++;
					f++;
				}
				 if(f==0) {
						System.out.println("\nNo Foods available in Food Court!!");
						return;
						}
				System.out.println("\nEnter the food name:");
			    String foo=sc.next();
			    String food= foo.substring(0,1).toUpperCase()+foo.substring(1);
			    System.out.println("\nEnter Type:");
			    String typ=sc.next();
			    String type2=typ.substring(0,1).toUpperCase()+typ.substring(1);
			    System.out.println("\nEnter the New Price:");
			    float cost=s.nextFloat();
			    
			    Statement sta=con.createStatement();
			    ResultSet res=sta.executeQuery("select * from snacks where Food_Name='"+food+"' and Type='"+type2+"'");
			   
			    while(res.next()) {
			    	PreparedStatement pst2=con.prepareStatement("Update snacks set Price=? where Food_Name='"+food+"' and Type='"+type2+"'");
			    	pst2.setFloat(1, cost);
			    	System.out.println("Food_Name\t:"+food+"\nType\t\t:"+type2+"\nNew_Price\t:"+cost+"\nNew Price been updated");
			    	pst2.executeUpdate();
			    	return;
			    }
			    System.out.println("\nFood Name or Food Type is invalid!!");
			   
				break;
			case 4:
				break;
			
			    default:
				System.out.println("\nInvalid Option!!");
				break;
			}
			
		   }
	   
			
	   
		   
		   catch(Exception e) {
			   System.out.println(e);
			   
		   }
	   }
	}


