package com.kce.quiz.Dao;
import com.kce.quiz.util.*;
import java.util.*;
import java.sql.*;
public class DataBaseOperation {
	Scanner s = new Scanner(System.in);
	DataBaseConnection db = new DataBaseConnection();
	public static  int score = 0;
	
	//DISPLAYING THE TABLE DETAILS
    public void DisplayQuizTable() {
    	
    	Connection cnx = db.createConnection();
    	try {
			PreparedStatement ps = cnx.prepareStatement("select * from Quiz_table");
			ResultSet rs = ps.executeQuery();
			System.out.printf("          %-10s%-20s%-10s\n","Quiz_Id","Name","Questions");
			while(rs.next()) {
				System.out.printf("          %-10s%-20s%-10s\n",rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			System.out.print(e);
		}	
    }
    
    //ASKING QUESTION
    public void quiz_Question(int choice) {
    	Connection cnx = db.createConnection();
    	
    	//QUESTION FROM HTML 
    	if(choice == 1) {
    	try {
			PreparedStatement ps = cnx.prepareStatement("select * from Html_Question");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(8) +" . "+ rs.getString(1));
				System.out.println();
				System.out.println("Options :");
				System.out.println("a. "+rs.getString(2));
				System.out.println("b. "+rs.getString(3));
				System.out.println("c. "+rs.getString(4));
				System.out.println("d. "+rs.getString(5));
				System.out.println();
				System.out.print("Enter your answer : ");
				String option = s.nextLine();
				System.out.println();
				
				if(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")) {
					try{
						throw new InvalidChoiceException();
					}
					catch (InvalidChoiceException e) {
						System.err.println(e);
						continue;
					}
				}
				else if(!option.equals(rs.getString(6))) {
					 System.err.println("Worng answer!!   (＞﹏＜)   ");
					 System.out.println("Correct opiton is "+ rs.getString(6));
				}
				else {
					System.err.println("Cheers you are Correct!!    (✿◕‿◕✿)");
					System.out.println();
				    score++;
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
		}  
    	}
    	
    	//QUESTION FROM CSS
    	else if(choice == 2) {
        	try {
    			PreparedStatement ps = cnx.prepareStatement("select * from Css_Question");
    			ResultSet rs = ps.executeQuery();
    			while(rs.next()) {
    				System.out.println(rs.getInt(8) +" . "+ rs.getString(1));
    				System.out.println();
    				System.out.println("Options :");
    				System.out.println("a. "+rs.getString(2));
    				System.out.println("b. "+rs.getString(3));
    				System.out.println("c. "+rs.getString(4));
    				System.out.println("d. "+rs.getString(5));
    				System.out.println();
    				System.out.print("Enter your answer : ");
    				String option = s.nextLine();
    				if(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")) {
    					try{
    						throw new InvalidChoiceException();
    					}catch (InvalidChoiceException e) {
    		    			System.err.println(e);  
    		    			continue;
    		    		}
    				}
    				else if(!option.equals(rs.getString(6))) {
    					 System.err.println("Worng answer!! (＞︿＜) ");
    				     System.out.println("Correct opiton is "+ rs.getString(6));
    				}
    				else {
    					System.err.println("Cheers you are Correct!!   (★‿★)");
    				    score++;
    				}
    			}
    		} catch (SQLException e) {
    			System.err.println(e);
    		} 
    	}
    	
    	//QUESTION FROM CORE JAVA QUESTION
    	else if(choice == 3) {
        		try {
        			PreparedStatement ps = cnx.prepareStatement("select * from Core_JAVA_Question");
        			ResultSet rs = ps.executeQuery();
        			while(rs.next()) {
        				System.out.println(rs.getInt(2) +" . "+ rs.getString(3));
        				System.out.println();
        				System.out.println("Options :");
        				System.out.println("a. "+rs.getString(4));
        				System.out.println("b. "+rs.getString(5));
        				System.out.println("c. "+rs.getString(6));
        				System.out.println("d. "+rs.getString(7));
        				System.out.println();
        				System.out.print("Enter your answer : ");
        				String option = s.nextLine();
        				if(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")) {
        					try{
        						throw new InvalidChoiceException();
        					}
        				catch (InvalidChoiceException e) {
        					System.err.println(e);   
        					continue;
        				}
        				}
        				else if(!option.equals(rs.getString(8))) {
        						 System.err.println("Worng answer!! (＞︿＜)");
        						 System.out.println("Correct opiton is "+ rs.getString(8));
        				}
        				else {
        					System.err.println("Cheers you are Correct!! (◔◡◔)");
        					System.out.println();
        				    score++;
        				}
        			}
        		} catch (SQLException e) {
        			System.err.println(e);
        		}
        		
        	}
    	
    	//QUESTION FROM C BASICS
    	else if(choice == 4) {
        			try {
            			PreparedStatement ps = cnx.prepareStatement("select * from C_Basics_Question");
            			ResultSet rs = ps.executeQuery();
            			while(rs.next()) {
            				System.out.println(rs.getInt(2) +" . "+ rs.getString(3));
            				System.out.println();
            				System.out.println("Options :");
            				System.out.println("a. "+rs.getString(4));
            				System.out.println("b. "+rs.getString(5));
            				System.out.println("c. "+rs.getString(6));
            				System.out.println("d. "+rs.getString(7));
            				System.out.println();
            				System.out.print("Enter your answer : ");
            				String option = s.nextLine();
            				if(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")) {
            					try{
            						throw new InvalidChoiceException();
            					}
            					catch (InvalidChoiceException e) {
                        			System.err.println(e);
                        			continue;
                        		}
            				}
            				else if(!option.equals(rs.getString(8))) {
            					 System.err.println("Worng answer!! (^_^)");
            					 System.out.println("Correct opiton is "+ rs.getString(8));
            				}
            				else {
            					System.err.println("Cheers you are Correct!! (★‿★)");
            					System.out.println();
            				    score++;
            				}
            			}
            		} catch (SQLException e) {
            			System.out.println(e);
            		} 
         		}
    	
    	//QUESTION FROM DATA STRUCTURE
    	else if(choice == 5) {
        			try {
            			PreparedStatement ps = cnx.prepareStatement("select * from DataStructure_Question");
            			ResultSet rs = ps.executeQuery();
            			while(rs.next()) {
            				System.out.println(rs.getInt(2) +" . "+ rs.getString(3));
            				System.out.println();
            				System.out.println("Options :");
            				System.out.println("a. "+rs.getString(4));
            				System.out.println("b. "+rs.getString(5));
            				System.out.println("c. "+rs.getString(6));
            				System.out.println("d. "+rs.getString(7));
            				System.out.println();
            				System.out.print("Enter your answer : ");
            				String option = s.nextLine();
            				if(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")) {
            					try{
            						throw new InvalidChoiceException();
            					}
            					 catch (InvalidChoiceException e) {
            	            			System.err.println(e);
            	            			continue;           	            			
            	            		}
            				}
            				else if(!option.equals(rs.getString(8))) {
            					 System.err.println("Worng answer!! (＞﹏＜)");
            					 System.out.println("Correct opiton is "+ rs.getString(8));
            				}
            				else {
            					System.err.println("Cheers you are Correct!! (✿◕‿◕✿)");
            					System.out.println();
            				    score++;
            				}
            			}
            		} catch (SQLException e) {
            			System.out.println(e);
            		} 	
            	}
         	} 
	
    //SCORE
    public int getScore() {
		
		return score;
	}

}
