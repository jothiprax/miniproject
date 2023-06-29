package OnlineShop.src.com.kce.services;

import java.io.*;

public class Payment {
	Bill customerBill;
	public int billPaid_f=0;
	private Cart customerCart;
	public Payment(Cart cart1,String c_name,String b_add,String c_phn)throws IOException
	{
		customerCart=cart1;
		customerBill=new Bill(c_name,b_add,c_phn,customerCart.getpid(),customerCart.getpname(),customerCart.getpqty(),customerCart.getprice());
		billPaid_f=0;
	}
	public void paymentPage()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("WELCOME TO PAYMENTS PAGE\n");
		int ch;
		do
		{
			System.out.println("*****************************************");
			System.out.println("OPTIONS:");
			System.out.println("1 - PAY BILL");
			System.out.println("2 - DISPLAY BILL");
			System.out.println("3 - EXIT");
			System.out.println("*****************************************\n");
			System.out.print("Enter choice : ");
			ch=Integer.parseInt(br.readLine());
			if(ch==1)
			{
				customerBill.displayBill();
				System.out.println("\nENTER AMOUNT TO PAY = ");
				float flag;
				flag=Float.parseFloat(br.readLine());
				while(flag<customerBill.total_amount || flag>customerBill.total_amount)
				{
					System.out.println("Invalid amount entered !");
					System.out.println("Enter again : ");
					flag=Float.parseFloat(br.readLine());
				}
				customerBill.addToDatabase();
				System.out.println("BILL PAID SUCCESSFULLY !");
				billPaid_f=1;
				ch=3;
			}
				
			else if(ch==2)
				customerBill.displayBill();
			else if(ch==3)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice");
				
		}while(ch!=3);
		
	}
}
