package service;
import java.util.*;

import com.kce.dao.DAO;
public class Main {

		public static void main(String[] args) throws Exception {
			 Scanner sc = new Scanner(System.in);
	         boolean exit = false;
	             System.out.println("1. Add sports");
	             System.out.println("2. Update sports");
	             System.out.println("3. Delete sports");
	             System.out.println("4. Add schedule details");
	             System.out.println("5. Update schedule details");
	             System.out.println("6. Delete schedule details");
	             System.out.println("7. Display sports details");
	             System.out.println("8. Display schedule details");
	             System.out.println("9. Exit");
	            while (!exit) 
	            {
	             System.out.print("Enter your choice: ");
	             int choice = sc.nextInt();
	             sc.nextLine();
	             DAO d=new DAO();
	             switch (choice) {
	                   case 1:
	                     d.addMembers();
	                     break;
	                 case 2:
	                     d.updateMembers();
	                     break;
	                 case 3:
	                     d.deletePlayer();
	                     break;
	                 case 4:
	                    d.addMembers1();
	                    break;
	                 case 5:
	                	 d.updateSchedule();
	                	 break;
	                 case 6:
	                	 d.deletePlayer();
	                	 break;
	                 case 7:
	                	 d.DisplayMemberdetails();
	                	 break;
	                 case 8:
	                	 d.DisplayScheduledetails();
	                	 break;
	                 case 9:
	                	 d.DisplayScoredetails();
	                	 break; 
	                case 10:
	                	 exit = true;
	                	 System.out.println("         ********THANK YOU********");
	                     break;
	                 default:
	                     System.out.println("Invalid choice");
	             }// end of switch
	         }//end of while loop
	     }// end of main method 
		}// end of class Main



