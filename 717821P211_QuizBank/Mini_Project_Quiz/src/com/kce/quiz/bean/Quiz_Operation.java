package com.kce.quiz.bean;
import com.kce.quiz.Dao.*;
import com.kce.quiz.util.*;
import java.util.*;
public class Quiz_Operation {
	Scanner s = new Scanner(System.in);
	public int choice = 0;
	public Quiz_Operation() {
		super();
	}
	DataBaseOperation dbo = new DataBaseOperation();
     public void Display() {
    	  dbo.DisplayQuizTable();
    	 
     }
     public int Quiz_Topic_Selection() {
    	 System.out.println();
    	 System.out.println("Hey, Please enter your choice : ");
    	 
    	 //HANDLING IF INPUT MISMATCH OCCURS
    	 try{
    		 choice = s.nextInt();
    	 }catch(InputMismatchException e) {
    		System.err.println(e);
 			System.out.println("Enter again : ");
 			choice = s.nextInt();
    	 }
    	 
    	 //HANDLING IF INVALID CHOICE OCCURS
    	 if(choice < 1 || choice > 5) {
    		try {
    			throw new InvalidQuizIDException();
    		}
    		catch(InvalidQuizIDException e) {
    			System.err.println(e);
    			System.out.println("Enter again : ");
    			choice = s.nextInt();
    		}
    	 }
    	 System.out.println("                    Great choice!! ");
    	 return choice;
         //System.out.println();
     }
     public void quiz_Question() {
    	 dbo.quiz_Question(choice);
     }
}
