package OnlineShop.src.com.kce.dao;


import java.sql.*;

// import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseConnection {
	public static String root;
	public static Connection makeDatabase()
	{
		int i=3;
		//creating a table return 0 for execute update
		Scanner sc = new Scanner(System.in);
		
		Connection check=null;
		try
		{
			
			int flag = 0;
			
			System.out.println("CONNECTING TO DATABASE.......");
			
			while(flag<3){
				System.out.print("ENTER ROOT PASSWORD = ");
				String password =sc.next();;
				root=password;
			    try
			    {
			     check=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineShop","root", password);
			    	
			    }
			    catch(Exception e)
			    {
			    	
			    	//System.out.println(e);
					
			    }
				if(check!=null){
					break;
				}
				else{
					if(i>1){
					System.out.println("WRONG PASSWORD RE-ENTER:");
					
					System.out.println("No Of Attempts left:"+(--i));
					flag++;
					}
					else{
						break;
					}
				}
			//	return check;
			
			
			
			}
	
		}catch(Exception e){
			System.out.println(e);
			
		}
		return check;
	}

	
}
	

