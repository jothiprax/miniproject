package com.kce.service;


	import java.util.Scanner;

	import com.kce.bean.Admin;
	import com.kce.bean.Bus;
	import com.kce.bean.Localbus;
	import com.kce.bean.Routebus;
	import com.kce.dao.Dao;
	public class Main {

		public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);
			Admin admin=new Admin();
			Localbus local = new Localbus();
			Localbus constlocal;
			Routebus route=new Routebus();
			Routebus constroute;
			Bus bus = new Bus();
			Bus constbus;
			Dao dd=new Dao();
			int i=0;
			System.out.println("Enter your choice\n1.Admin\n2.User");
			String choiceType=sc.nextLine();
			System.out.println("Enter 1 for register(new user)\nEnter 2 for login");
			int choice=sc.nextInt();
			if(choice==1)
			{
				     admin.register();	
		    }
			if(choice==2)
			{
					admin.login();
			}
			for( i=0;i<10;i++)
			{
			System.out.println("which bus do you want to access?");
			System.out.println("1=localBus------2=routeBus------3=All Bus");
			int busChoice=sc.nextInt();
			if(busChoice==1)
			{
			if(choiceType.equals("admin"))
			{
				System.out.println("1=update------2=delete------3=insert");
				int newChoice=sc.nextInt();
				if(newChoice==1)
				{
					System.out.println("you have choosen to UPDATE the MAIN-BUS-STAND of local bus");
					System.out.print("Enter the bus number= ");
					sc.nextLine();
					String bn=sc.nextLine();
					System.out.print("Enter new main bus stand= ");
					String newbstand=sc.nextLine();
					local.setBusNumber(bn);
					local.setMainBusStand(newbstand);
					dd.updateLocal();
				}
				if(newChoice==2)
				{
					System.out.println("you have choosen to DELETE any ROW in local bus");
					System.out.print("Enter the bus number= ");
					String bn1=sc.nextLine();
					local.setBusNumber(bn1);
					dd.deleteLocal();
				}
				if(newChoice==3)
				{
					System.out.println("you have choosen to INSERT RECORD in local bus");
					String bname=sc.nextLine();
					String bnum=sc.nextLine();
					double depTime=sc.nextDouble();
					double arrTime=sc.nextDouble();
					sc.nextLine();
					String broute=sc.nextLine();
					String splace=sc.nextLine();
					String eplace=sc.nextLine();
					String mainStand=sc.nextLine();
					constlocal=new Localbus(bname,bnum,depTime,arrTime,broute,splace,eplace,mainStand);
					dd.insertLocal();
				}
			}	
			
			else
			{
				System.out.println("Enter your required bus number= ");
				String num=sc.nextLine();
				local.setBusNumber(num);
				dd.displayLocal();
				System.out.println("HAVE A SAFE AND HAPPY JOURNEY");
			}
		  }     // ************** end of local bus if statement **********************
			if(busChoice==2)
			{
			if(choiceType.equals("admin"))
			{
				System.out.println("1=update------2=delete------3=insert");
				int newChoice=sc.nextInt();
				if(newChoice==1)
				{
					System.out.println("you have choosen to UPDATE the RETURN TIME of route bus");
					System.out.print("Enter the bus number= ");
					sc.nextLine();
					String bn=sc.nextLine();
					System.out.print("Enter new return time= ");
					Double newreturn =sc.nextDouble();
					route.setBusNumber(bn);
					route.setReturnTime(newreturn);
					dd.updateRoute();
				}
				if(newChoice==2)
				{
					System.out.println("you have choosen to DELETE any ROW in route bus");
					System.out.print("Enter the bus number= ");
					String bn1=sc.nextLine();
					route.setBusNumber(bn1);
					dd.deleteRoute();
				}
				if(newChoice==3)
				{
					System.out.println("you have choosen to INSERT RECORD in route bus");
					String bname=sc.nextLine();
					String bnum=sc.nextLine();
					double depTime=sc.nextDouble();
					double arrTime=sc.nextDouble();
					sc.nextLine();
					String broute=sc.nextLine();
					String splace=sc.nextLine();
					String epdlace=sc.nextLine();
					double returnnew=sc.nextDouble();
					constroute=new Routebus(bname,bnum,depTime,arrTime,broute,splace,epdlace,returnnew);
					dd.insertRoute();
				}
			}	
			
			else
			{
				System.out.println("Enter your required bus number= ");
				String num=sc.nextLine();
				route.setBusNumber(num);
				dd.displayRoute();
				System.out.println("HAVE A SAFE AND HAPPY JOURNEY");
			}
		  }     //  ******************end of route bus if statement*************************
			if(busChoice==3)
			{
			if(choiceType.equals("admin"))
			{
				System.out.println("1=update------2=delete------3=insert");
				int newChoice=sc.nextInt();
				if(newChoice==1)
				{
					System.out.println("you have choosen to UPDATE the ROUTE of bus");
					System.out.print("Enter the bus number= ");
					sc.nextLine();
					String bn=sc.nextLine();
					System.out.print("Enter new bus route= ");
					String newroute=sc.nextLine();
					bus.setBusNumber(bn);
					bus.setRoute(newroute);
					dd.updateBus();
				}
				if(newChoice==2)
				{
					System.out.println("you have choosen to DELETE any ROW in bus");
					System.out.print("Enter the bus number= ");
					String bn1=sc.nextLine();
					bus.setBusNumber(bn1);
					dd.deleteBus();
				}
				if(newChoice==3)
				{
					System.out.println("you have choosen to INSERT RECORD in bus");
					String bname=sc.nextLine();
					String bnum=sc.nextLine();
					double depTime=sc.nextDouble();
					double arrTime=sc.nextDouble();
					sc.nextLine();
					String broute=sc.nextLine();
					String splace=sc.nextLine();
					String eplace=sc.nextLine();
					constbus=new Bus(bname,bnum,depTime,arrTime,broute,splace,eplace);
					dd.insertBus();
				}
			}	
			
			else
			{
				System.out.println("Enter your required bus number= ");
				String num=sc.nextLine();
				bus.setBusNumber(num);
				dd.displayBus();
				System.out.println("HAVE A SAFE AND HAPPY JOURNEY");
			}
		  }     //  *************end of  bus if statement***********************
		
		
			}     // end of for loop
			if(i>10)
				System.out.println("you have exceeded the limit!!!! log in again and try.....");
		}        //end of main method
		  }     //end of class



