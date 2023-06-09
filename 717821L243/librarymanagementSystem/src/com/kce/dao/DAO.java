package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.Book;
import com.kce.bean.UserDefinedException;
import com.kce.bean.Borrower;

import com.kce.util.DBUtil;

public class DAO {
  public void addBook()throws UserDefinedException {
       Scanner sc=new Scanner(System.in);
        	 System.out.print("Enter book Id: ");
             int id = sc.nextInt();
             sc.nextLine();
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter book author: ");
            String author = sc.nextLine();
            System.out.print("Enter publication year: ");
            int year = sc.nextInt();
            sc.nextLine(); 
 Book b = new Book();
            b.setId(id);
            b.setTitle(title);
            b.setAuthor(author);
           b.setYear(year);
Connection con=DBUtil.createConnection();
try {
            PreparedStatement ps = con.prepareStatement("insert into books values (?, ?, ?,?)");
            ps.setInt(1, b.getId());
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getAuthor());
            ps.setInt(4, b.getYear());

            int a = ps.executeUpdate();

            if (a > 0) {
                System.out.println("Book added successfully!");
            } else {
                System.out.println("Failed to add book.");
            }
}catch(SQLException e)
{
	e.printStackTrace();
	
	
} } 
    public void addBorrower1()throws UserDefinedException {
        
    	Scanner sc=new Scanner(System.in);
    	 System.out.print("Enter Borrower Id: ");
         int id = sc.nextInt();
         sc.nextLine();
        System.out.print("Enter Borrower Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Borrower PhoneNumber: ");
        String phone = sc.nextLine();
        System.out.print("Enter Borrower email: ");
        String email = sc.nextLine();
        System.out.print("Enter the name of the book borrower bought: ");
        String bookname = sc.nextLine();
        Borrower bb=new Borrower();
        bb.setBorrowerId(id);
        bb.setName(name);
        bb.setPhoneNumber(phone);
        bb.setEmail(email);
        bb.setborrowerbookname(bookname);
         Connection con=DBUtil.createConnection();
try {
        PreparedStatement ps = con.prepareStatement("insert into borrower values (?, ?, ?,?,?)");
        ps.setInt(1, bb.getBorrowerId());
        ps.setString(2, bb.getName());
        ps.setString(3, bb.getPhoneNumber());
        ps.setString(4, bb.getEmail());
        ps.setString(5, bb.getborrowerbookname());
        int a = ps.executeUpdate();
       if (a > 0) {
            System.out.println("Borrower details added successfully!");
        } else {
            System.out.println("Failed to add Borrowers details.");
        }
}catch(SQLException e)
{
e.printStackTrace();


} } 
         public void updateBook() 
    {
    	Scanner sc=new Scanner(System.in);
          System.out.print("Enter book Id: ");
          int id1 = sc.nextInt();
          sc.nextLine();
         System.out.print("Enter new book title: ");
         String title1 = sc.nextLine();
         Book b1=new Book();
         b1.setId(id1);
         b1.setTitle(title1);
         
          
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps1 = con.prepareStatement("update books set title = ? where Id = ?");
                ps1.setString(1, b1.getTitle());
                 ps1.setInt(2, b1.getId());

                int a = ps1.executeUpdate();

                if (a > 0) {
                    System.out.println("Book updated successfully!");
                } else {
                    System.out.println("Failed to update book.");
                }} catch(SQLException e)
                {
                	e.printStackTrace();
                	
                	
                } 
            } 
         public void updateBorrower1() 
         {
         	Scanner sc=new Scanner(System.in);
               System.out.print("Enter borrower Id: ");
               int id1 = sc.nextInt();
               sc.nextLine();
               System.out.print("Enter new book name bought by the borrower : ");
               String name1 = sc.nextLine();
                System.out.print("Enter new borrower email: ");
              String email1 = sc.nextLine();
              Borrower bb1=new Borrower();
              bb1.setBorrowerId(id1);
              bb1.setborrowerbookname(name1);
              bb1.setEmail(email1);
              
               
     Connection con=DBUtil.createConnection();
     try {
                     PreparedStatement ps1 = con.prepareStatement("update borrower set Email = ?, Borrowerbookname =? where Id = ?");
                     ps1.setString(1, bb1.getEmail());
                     ps1.setString(2,bb1.getborrowerbookname());
                      ps1.setInt(3, bb1.getBorrowerId());

                     int a = ps1.executeUpdate();

                     if (a > 0) {
                         System.out.println("Borrower details updated successfully!");
                     } else {
                         System.out.println("Failed to update Borrower details.");
                     }} catch(SQLException e)
                     {
                     	e.printStackTrace();
                     	
                     	
                     } 
                 } 
         
    

    public void deleteBook() {
    	Scanner sc=new Scanner(System.in);
       
            System.out.print("Enter book ID : ");
            int id2 = sc.nextInt();
            sc.nextLine();
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps2 = con.prepareStatement("delete from  books where Id = ?");
                ps2.setInt(1, id2);

                int a = ps2.executeUpdate();

                if (a > 0) {
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("Failed to delete book.");
          
}}catch(SQLException e)
{
	e.printStackTrace();
	
	
} 
                
    }
    public void deleteBorrower1() {
    	Scanner sc=new Scanner(System.in);
       
            System.out.print("Enter borrower book ID : ");
            int id3 = sc.nextInt();
            sc.nextLine();
Connection con=DBUtil.createConnection();
try {
                PreparedStatement ps2 = con.prepareStatement("delete from  borrower where Id = ?");
                ps2.setInt(1, id3);

                int a = ps2.executeUpdate();

                if (a > 0) {
                    System.out.println("Borrower details deleted successfully!");
                } else {
                    System.out.println("Failed to delete Borrower detail.");
          
}}catch(SQLException e)
{
	e.printStackTrace();
	
	
} 
                
    }
    public void Displaybookdetails() {
    	Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter book author name : ");
        String aname = sc.nextLine();
    	 Connection con=DBUtil.createConnection();
    	 try {
    	 PreparedStatement ps3 = con.prepareStatement("select *from books where author=?");
    	  ps3.setString(1,aname );
    	  ResultSet r=ps3.executeQuery();
           if(r.next())
    	 {
    		  System.out.println("Book Details of the selected author");
    		  do {
    	
    		 System.out.println( "Id : " +r.getInt(1)+"\nTitle : "+r.getString(2)+"\nAuthor : "+r.getString(3)+"\nYear : "+r.getInt(4));
    		 System.out.println("----------------------");
      		
    		  }while(r.next());
    		  }
    	
    	  else {
	 System.out.println("Book details of selected author is not found");
		
 }
    	 }catch(SQLException e)
    	 {
    	 	e.printStackTrace();
    	 	
    	 	
    	 } 
    }
    public void Displayborrowerdetails() {
    	
    	 Connection con=DBUtil.createConnection();
    	 try {
    	 PreparedStatement ps4 = con.prepareStatement("select *from borrower ");
    	  ResultSet r=ps4.executeQuery();
    	 System.out.println("Displaying all the borrowers details in the library");
    	 while(r.next())
    	 {
    		 System.out.println( "Id : " +r.getInt(1)+"\nName : "+r.getString(2)+"\nPhoneNumber : "+r.getString(3)+"\nEmail : "+r.getString(4));
    		 System.out.println("Book name : "+r.getString(5));
    		 System.out.println("----------------------");
     		
    	 }
    	 } catch(SQLException e)
    	 {
    	 	e.printStackTrace();
    	 	
    	 	
    	 } 
    }
}


