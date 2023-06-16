package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;

public class CalculateDueDate {
              public void DueDate() throws ClassNotFoundException,SQLException, NumberFormatException, IOException {
            	  
            	/*	  BufferedReader reader = new BufferedReader(
            	                 new InputStreamReader(System.in));
            	    SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy"); 
            	   // df.setLenient(false);

            	    try {
            	        System.out.print("ENTER DATE STRING (mm/dd/yyyy ): ");
            	        String dateString = reader.readLine();
            	        // Parse the date
            	        Date date = (Date) df.parse(dateString);
            	        System.out.println("Original string: " + dateString);
            	        System.out.println("Parsed date    : " + date.toString());  
            	    }
            	    catch(Exception e) {
            	    }*/
            	    try {
            	    	int Fine=0;
            			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
            			//System.out.println("Enter Year you Purchased");
            			//int StartYear=Integer.parseInt(sc.readLine());
            			System.out.println("Enter Month you Purchased");
            			int StartMonth=Integer.parseInt(sc.readLine());
            			System.out.println("Enter Date you Purchased");
            			int StartDate=Integer.parseInt(sc.readLine());
            			LocalDate d1=LocalDate.of(0, StartMonth, StartDate);
            		    //System.out.println("Enter Year you Return");
            		    //int EndYear=Integer.parseInt(sc.readLine());
            			System.out.println("Enter Month you Return");
            			int EndMonth=Integer.parseInt(sc.readLine());
            			System.out.println("Enter Date you Return");
            			int EndDate=Integer.parseInt(sc.readLine());
            			LocalDate d2=LocalDate.of(0,EndMonth, EndDate);
            			Period p=Period.between(d1, d2);
            			System.out.println("Days: "+p.getDays());
            			
            			if(p.getDays()>15) {
            				Fine=Fine+p.getDays()-15;
            			}
            			else {
            				System.out.println("You have no Fine");
            			}
            			System.out.println("Your Fine amount:"+Fine);
            			}catch(DateTimeException e) {
            				System.out.println(e);
            			}
            	  
              }
}
