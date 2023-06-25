package com.kce.quiz.Service;
import com.kce.quiz.bean.*;
import com.kce.quiz.Dao.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			int quiz_id;
		System.err.println("                     (✿◕‿◕✿) *****   WELCOME TO QUIZ BANK   ***** (✿◕‿◕✿)");
		System.err.println("The Below shown are the Quiz Topics You Select from it!!");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
		Quiz_Operation quiz = new Quiz_Operation();
		
		//DISPLAYING QUIZ TABLE
		quiz.Display();
		
		//REQUESTING TO SELECT THE QUIZ TOPIC
		quiz_id = quiz.Quiz_Topic_Selection();
		
		ParticipentUpdation p = new ParticipentUpdation();
		
	    //ASKING PARTICIPENT DETAILS
		System.out.println("Enter your roll no: ");
		String roll_no = s.nextLine();
		
		System.out.println();
		System.out.println("Enter your name: ");
		String name = s.nextLine();
		
		System.out.println("Have a good day! (★‿★)");
		System.out.println();
		p.getDetails(roll_no,name,quiz_id,0);
		
		//STARTING QUIZ
		System.out.println("Let's begin !\n");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		
		//DISPLAYING QUESTION
		quiz.quiz_Question();
		
		//UPDATING IN SCORE IN PARTICIPENT TABLE
		p.update(roll_no,quiz_id);
		
		//DISPLAY PARTICIPENT DETAILS WITH THEIR SCORE
		p.Display();
		
		//ASKING WHETHER TO PLAY AGAIN
		System.out.println("\nDO YOU WANT TO PLAY AGAIN ? (YES/yes) or (NO/no)? ");
		
		String playagain = s.nextLine();
		if(playagain.equals("no") || playagain.equals("No"))
			break;
		
		}
	}

}
