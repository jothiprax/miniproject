package com.kce.util;
import java.sql.SQLException;
import java.util.*;

import com.kce.service.Admission;
public class Main {
  public static void main(String[]args) throws ClassNotFoundException, SQLException {
	  try(Scanner sc = new Scanner(System.in)){
		  System.out.println("For new Admission Enter 1");
		  System.out.println("For present Student details Enter 2");
		  int a = sc.nextInt();
		 if(a==1) {
			 Admission b = new Admission();
			 b.select();
			 }
		 else if(a==2) {
			System.out.println("Enter 1 for view: ");
			System.out.println("Enter 2 for insert: ");
			System.out.println("Enter 3 for update: ");
			System.out.println("Enter 4 for delete: ");
			int c = sc.nextInt();
			if(c==1) {
				Admission b = new Admission();
				b.view();
			}
			else if(c==2) {
				Admission b = new Admission();
				b.insert();
			}
			else if(c==3) {
				Admission b = new Admission();
				b.update();
			}
			else if(c==2) {
				Admission b = new Admission();
				b.delete();
 }
			else {
			     throw new NumberInvalidException();
			}
 }
	  }
	  
		 catch(Exception e) {
			 System.out.println(e);
		 }
}
}
