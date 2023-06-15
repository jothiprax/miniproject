package com.kce.service;
import java.util.*;
import com.kce.dao.DAO;

public class Main {

	public static void main(String[] args) throws Exception {
		
		 Scanner sc = new Scanner(System.in);
         boolean exit = false;
             System.out.println("1. Add book");
             System.out.println("2. Update book");
             System.out.println("3. Delete book");
             System.out.println("4. Add Borrowers details");
             System.out.println("5. Update Borrowers details");
             System.out.println("6. Delete Borrowers details");
             System.out.println("7. Display book details");
             System.out.println("8. Display borrowers details");
             System.out.println("9. Exit");
            while (!exit) 
            {
             System.out.print("Enter your choice: ");
             int choice = sc.nextInt();
             sc.nextLine();
             DAO d=new DAO();
             switch (choice) {
                   case 1:
                     d.addBook();
                     break;
                 case 2:
                     d.updateBook();
                     break;
                 case 3:
                     d.deleteBook();
                     break;
                 case 4:
                    d.addBorrower1();
                    break;
                 case 5:
                	 d.updateBorrower1();
                	 break;
                 case 6:
                	 d.deleteBorrower1();
                	 break;
                 case 7:
                	 d.Displaybookdetails();
                	 break;
                 case 8:
                	 d.Displayborrowerdetails();
                	 break;
                	case 9:
                	 exit = true;
                	 System.out.println("         ********THANK YOU********");
                     break;
                 default:
                     System.out.println("Invalid choice");
             }// end of switch
         }//end of while loop
     }// end of main method 
	}// end of class Main


