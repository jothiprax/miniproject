package simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Main class
public class OnlineBankingSystem
{
public static void main(String[] args) throws SQLException 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Insert the Details:");
	System.out.println("2.Retrive the details:");
     int option=sc.nextInt();
     if(option==1) 
     {
    	 System.out.println("Enter The acccount number:");
    	 String acno=sc.next();
    	 System.out.println("Enter the Name:");
    	 String ah=sc.next();
    	 System.out.println("Enter the balance:");
    	 double bal=sc.nextDouble();
    	 BankAccount ba=new BankAccount(acno,ah,bal);
    	 ba.saveAccount();
     }
     else //option==2
     {
    	 Result r=new Result();
    	 System.out.println("The Details:");
    	 r.printResult();
     }
     

 }
}