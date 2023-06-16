package com.kce.service;
import java.util.*;
import com.kce.dao.*;
import com.kce.util.*;
import com.kce.bean.*;
public class RestaurantMain extends OrderingBean{
	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		DBUtil db=new DBUtil();
        db.ConnectiongetDBConnection();
        RestaurantDAO rd=new RestaurantDAO();
        OrderingBean od=new OrderingBean();
        RestaurantUpdateDAO rud=new RestaurantUpdateDAO();
        BillBean bb=new BillBean();
        int x=1;
        Start:for(int i=0;;i++) {
        	xx=0;
	    System.out.println("Press Any Option:");
	    System.out.println("    1)Manager");
	    System.out.println("    2)Customer");
	    System.out.println("    3)Exit");
	    int r;
	    r=sc1.nextInt();sc1.nextLine();
	    if(r==1){
	    	System.out.println("Press One Option:");
	    	System.out.println("    1)Breakfast");
		    System.out.println("    2)Lunch");
		    System.out.println("    3)Dinner");
	    	int time=sc1.nextInt();sc1.nextLine();
	    switch(time) {
	    case 1:
	    	rd.createRestaurant();
	    	System.out.println("Menu Card Updated");
	    	x=1;
	    	break;
	    case 2:
	    	rud.updateOrder1();
	    	System.out.println("Menu Card Updated");
	    	x=2;
	    	break;
	    case 3:
	    	rud.updateOrder2();
	    	System.out.println("Menu Card Updated");
	    	x=3;
	    	break;
	        }
	    }
	    else if(r==2){
	    System.out.println("                         Welcome To AR Restaurant:                            ");	
	    System.out.printf("Menu Card ");
	    if(x==1) {
	    	System.out.printf("(BREAKFAST):\n");
	    }
	    else if(x==2) {
	    	System.out.printf("(LUNCH):\n");
	    }
	    else{
	    	System.out.printf("(DINNER):\n");
	    }
	    System.out.println("----------------------\nDish.ID\t\t\t      Dishes\t\t\t    Price\n------------------------------------------------------------------------");
	    rd.displayMenu();//Display The Menu Card
	    System.out.println("------------------------------------------------------------------------");
	    System.out.println("Select Your Orders:(PRESS BUY NOW ONCE ORDER COMPLETED)\n--------------------------------------------------------");
	    od.foodOrders();//Order The Food
	    System.out.println("---------------------------------------------------------");
	    if(xx==1) {
	    	continue Start;
	    }
	    System.out.println("Your Orders:\n------------");
	    System.out.println("Dish.ID\t\t\t      Dishes\t\t\t    Qunatity\n--------------------------------------------------------------------");
	    od.displayOrder();//Display The Order
	    System.out.println("---------------------------------------------------------------------");
	    System.out.println("Press 1 For Payment:");
	    int a=sc1.nextInt();sc1.nextLine();
	    System.out.println("--------------------");
	    if(a==1){
	    System.out.println("Your Bill:\n----------");
	    bb.Bill();//Bill Process
	    }
	    else {
	    	continue Start;
	    }
	    System.out.println("Dish.ID\t\t\t      Dishes\t\t\t    Qunatity\t\t\t  Price\n---------------------------------------------------------------------------------------------------");
	    bb.displayBill();//Display Bill
	    System.out.println("---------------------------------------------------------------------------------------------------");
	    System.out.println("Thank You Visit Again");
	    try {
	    Thread.sleep(10000);
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	    }
	    else if(r==3) {
	    	db.CloseConnection();//Close The Restaurant
	    	System.exit(0);
	    }
        }
	}
}
