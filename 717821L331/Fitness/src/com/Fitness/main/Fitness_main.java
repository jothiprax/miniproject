package com.Fitness.main;
import  com.Fitness.Dao.trainer;
import com.Fitness.Dao.update;
import com.Fitness.bean.*;
import com.Fitness.service.*;
import com.Fitness.util.DBUtil;
import java.util.*;
import java.sql.*;
public class Fitness_main {
public static void main(String args[]) throws SQLException {
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	con = DBUtil.getConnection();
	st = con.createStatement();
	System.out.println("Enter your phone_no");
	String phone_no = sc.nextLine();
	System.out.println("If you are already a member press y else n");
	String opt=sc.nextLine();
	switch(opt) {
	case "n":
		System.out.println("Hi......");
			Member m = new Member();
	AddMember am = new AddMember();
    System.out.println("Enter your name");
    String name = sc.nextLine();
    System.out.println("Enter your age");
    int age = Integer.parseInt(sc.nextLine());
	System.out.println("Enter your gender");
	String gender = sc.nextLine();
	m.setName(name);
	m.setAge(age);
	m.setGender(gender);
	m.setPhone_no(phone_no);
	int k=am.add(m);
	BMI b=new BMI();
	
     b.setName(name);
    b.setPhone_no(phone_no);
   
    System.out.println("Enter the weight:");
    double weight =sc.nextDouble();
    b.setWeight(weight);
    System.out.println("Enter the height:");
    double height =sc.nextDouble();
    b.setHeight(height);
      
       
   AddBMI bmi=new AddBMI();
   bmi.add(b);
   break;
	case "y":
		
  System.out.println("Welcome again......");
  System.out.println("are you intrested to update weight  and height...");
  System.out.println("Enter y or n");
  String opt1=sc.nextLine();
  switch (opt1) {
  case"y":
	  update u=new update();
	  u.updation(phone_no);
	  
	  break;
  case "n":
	  System.out.println("Thankyou.........");
  }
    break;
	}
   String query="SELECT BMI  FROM bmi WHERE phone_no='"+phone_no+"'";
   Statement st1=con.createStatement();
     rs=st1.executeQuery(query);
     while(rs.next()) {
    	 double bmi=rs.getDouble(1);
    	
    	 trainer t=new trainer();
    	t.trainerselection(bmi,phone_no);
     }
   
}
}
