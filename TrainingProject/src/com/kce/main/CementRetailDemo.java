package com.kce.main;
import java.util.Scanner;

import com.kce.dao.CustomerSql;
import com.kce.dao.ProductSql;
import com.kce.entity.Customer;
import com.kce.entity.Product;
public class CementRetailDemo {

	public static void main(String[] args) {
	System.out.println("                                                      WELCOME TO XYZAGENCIES                 ");
    System.out.println("Enter 1 to get into CustomersLedger");
    System.out.println("Enter 2 to get into Productledger");
	Scanner input=new Scanner(System.in);
	int ledgerType=input.nextInt();
	switch(ledgerType) {
	case 1://customer table
	System.out.println("Enter any one number:");
	System.out.println("1:Deleting a Customer");
	System.out.println("2:Place order");
	System.out.println("3:New Customer Entry");
	System.out.println("4:Today's Orders");
	System.out.println("5:Updating Payment Details");
	System.out.println("6:Display Customer Ledger");
	int operationType=input.nextInt();
	switch(operationType) {
	case 1:
		System.out.println("Enter the Customer name to delete:");
		String name=input.nextLine();
		CustomerSql cs=new CustomerSql();
		Customer c=cs.collectData(name);
		cs.setCustomer(c);
		cs.deleteCustomer(c.getCId());
		break;
	case 2:
		System.out.println("Enter the Customer name placing Order:");
		String name1=input.nextLine();
		CustomerSql cs1=new CustomerSql();
		Customer c1=cs1.collectData(name1);
		cs1.setCustomer(c1);
		System.out.println("Enter the Quantity and int Product Id");
		int quantity=input.nextInt();
		int PId=input.nextInt();
	    Product p=cs1.collectProductData(PId);
	    cs1.setP(p);
	    cs1.OrderUpdate(quantity, PId);
        break;
	case 3:
		System.out.println("Enter Customer details in order:id,name,cpno,pamount,PId1");
		int CId=input.nextInt();
		String cname=input.nextLine();
		String cpno=input.nextLine();
		double pamount=0.0;
		int PId1=input.nextInt();
		Customer c3=new Customer(CId,cname,cpno,pamount,PId1);
		CustomerSql cs2=new CustomerSql();
		cs2.addNewCustomer(c3);
		break;
	case 4:
		CustomerSql cs4=new CustomerSql();
		cs4.DisplayLedger();
		break;
	case 5:
		CustomerSql cs5=new CustomerSql();
		cs5.TodayOrders();
		break;
	case 6:
		CustomerSql cs6=new CustomerSql();
		System.out.println("Enter the customer name who made payment and the amount:");
		String name2=input.nextLine();
		double amt=input.nextDouble();
		Customer c4=cs6.collectData(name2);
		cs6.madePayment(amt);
		break;
	default:
		System.out.println("Enter valid choice");
	break;
	}
	break;
	case 2:
	System.out.println("Enter any one the numbers:");
	System.out.println("Enter 1:To add Product");
	System.out.println("Enter 2:To display Product Ledger:");
	System.out.println("Enter 3:To update price of a product:");
	System.out.println("Enter 4:To add Stock:");
	int OperationType2=input.nextInt();
	switch(OperationType2) {
	case 1:
		System.out.println("Enter new Product details in order:ProductId,ProductName,Stock,price");
		int PId=input.nextInt();
		String PName=input.next();
		int Stock=input.nextInt();
		double price=input.nextDouble();
		Product p=new Product(PId,PName,Stock,price);
		ProductSql ps=new ProductSql(p);
		ps.AddProduct(p);
		break;
	case 2:
		ProductSql ps1=new ProductSql();
		ps1.DisplayProduct();
		break;
	case 3:
		System.out.println("Enter the updated price and Product ID:price and PId");
		Double price1=input.nextDouble();
		int PId2=input.nextInt();
		ProductSql ps2=new ProductSql();
		Product p2=ps2.collectProductData(PId2);
		ps2.setP(p2);
		ps2.UpdatePrice(price1, PId2);
		break;
	case 4:
		System.out.println("Enter the No of bags and the product id:bags,productId");
		int bags=input.nextInt();
		int PId3=input.nextInt();
		ProductSql ps3=new ProductSql();
		Product p5=ps3.collectProductData(PId3);
		ps3.setP(p5);
		ps3.addStock(bags, PId3);
		break;
	}
	break;
	}
	}

}
