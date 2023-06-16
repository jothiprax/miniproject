package com.kce.serivce;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class breakfast
{
	//int id=1;
	public String food;
	public float price;
	public breakfast(String food,float price)
	{ this.food=food;
	this.price=price;
	System.out.println("Constructor of breakfast");
	}
}
class dinner extends breakfast
{
	public dinner(String food, float price) {
		super(food, price);
		System.out.println("Constructor of dinner");
		// TODO Auto-generated constructor stub
	}
	
}
public class manage {
	private static String foodname;
	public static void main(String[]args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_project","root","Kishore@2004");
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("Select * from food");
			Scanner scanner =new Scanner(System.in);
			dinner la= new dinner("lemon rice",30);
			
			System.out.println("foodname of launch"+la.food);
			System.out.println("Food price of "+la.price);
			
			
			while(true)
			{
				System.out.println("Welcome to hotel managemant system");
				System.out.println("1.Breakfast");
				System.out.println("2.Launch");
				System.out.println("3.Dinner");
				System.out.println("4.Add food item");
				System.out.println("5.Search food item");
				System.out.println("6.Delete food item");
				System.out.println("7.Exit");
				System.out.println("Enter your choice:");
				int choice=scanner.nextInt();
				scanner.nextLine();
				switch(choice)
				{
				case 1:
					System.out.println("Breakfast fooditems");
					String s="select * from food";
					ResultSet rs=stmt.executeQuery(s);
					while(rs.next())
					{System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					
					}break;
				case 2:
					System.out.println("Lunch fooditems");
					String s1="select * from lunch";
					ResultSet lan=stmt.executeQuery(s1);
					while(lan.next())
					{System.out.println(lan.getString(1)+"\t"+lan.getString(2)+"\t"+lan.getString(3));
					
					}break;
				case 3:
					System.out.println("Fooditems for dinner");
					String s2="select * from dinner";
					ResultSet din=stmt.executeQuery(s2);
					while(din.next())
					{System.out.println(din.getString(1)+"\t"+din.getString(2)+"\t"+din.getString(3));
					
					}break;
				case 4:
					System.out.println("Enter item no");
					int sno=scanner.nextInt();
					System.out.println("Enter food name");
					String name=scanner.nextLine();
					scanner.nextLine();
					System.out.println("Enter food price");
					double price=scanner.nextDouble();
					String sql="insert into food values ("+sno+","+name+","+price+")";
					//int  rowsAffected=stmt.executeUpdate(sql);
					//if(rowsAffected>0)
						//{
						//	System.out.println("Food item added successfully");
						//}
						//else
						//{System.out.println("Failed");}
					//ResultSet ins=stmt.executeQuery(sql);
					//while(ins.next())
					//{System.out.println(ins.getString(1)+"\t"+ins.getString(2)+"\t"+ins.getString(3));
					
					//}
					//stmt.execute(sql);
					System.out.println("Insert complete");
					break;
					
				case 5:
					System.out.println("Enter food name to search");
					String searchname=scanner.nextLine();
					searchFooditem(stmt,searchname);
					break;
				case 6:
					System.out.println("Enter food name to delete");
					String deletename=scanner.nextLine();
					deletefooditem(stmt,deletename);
					break;
				case 7:
				//ResultSet rs1=stmt.executeQuery("select * from food");
				System.out.println("Exiting program");
				String ans="select *from food";
				ResultSet ans1=stmt.executeQuery(ans);
				while(ans1.next())
				{System.out.println(ans1.getString(1)+"\t"+ans1.getString(2)+"\t"+ans1.getString(3));
				
				}break;
				}}
					
				//con.close();	
			
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}	//finally {
			//try {
			//	if(stmt!=null)
			//		stmt.close();
			//}catch(SQLException se)
			//{
			//	se.printStackTrace();
			//}}
			}
		
	
private static void searchFooditem(Statement stmt, String searchname ) throws SQLException{
	String sql="select * from food where foodname LIKE '%p'";
	ResultSet result=stmt.executeQuery(sql);
	while(result.next()) {
		
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		
		}
		//int sno=result.getInt("sno");
		//String name=result.getString("foodname");
		//int price=result.getInt("price");
		//System.out.println("sno:"+sno+", name:"+foodname+",price:"+price);
	}
	private static void deletefooditem(Statement stmt, String deletename) throws SQLException
	{
		String sq="delete from lunch where foodname="+deletename+"";
	int rowsAffected=stmt.executeUpdate(sq);
		if(rowsAffected>0)
{System.out.println("Food item deleted successfully");
}
else
{System.out.println("Food item not found");
}}
	
}

