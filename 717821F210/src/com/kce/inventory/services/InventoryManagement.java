package com.kce.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kce.inventory.bean.Customer;
import com.kce.inventory.bean.Product;
import com.kce.inventory.bean.SalesInfo;
import com.kce.inventory.bean.Stock;
import com.kce.inventory.dao.CustomerDAO;
import com.kce.inventory.dao.ProductDAO;
import com.kce.inventory.dao.SalesinfoDAO;
import com.kce.inventory.dao.StockDAO;

public class InventoryManagement {

	public static void main(String[] args) {
		
		Scanner bm=new Scanner(System.in);
		System.out.println("\t\t\tWelcome to Inventory Management System\t\t\t\n");
		while(true) {
			System.out.println("press 1 for Customer Details");
			System.out.println("press 2 for Product Details");
			System.out.println("press 3 for SalesInfo Details");
			System.out.println("press 4 for Stock Details");
			System.out.println("Press 5 for Quit");
			int n=bm.nextInt();
			switch(n) {
				case 1:
					while(true) {
						System.out.println("\npress 1 for Add Customer");
						System.out.println("Press 2 for Delete Customer");
						System.out.println("Press 3 for Update Customer");
						System.out.println("Press 4 for View all customer details");
						System.out.println("Press 5 for view one Customer");
						System.out.println("Press 6 for Quit\n");
						int x=bm.nextInt();
						switch(x) {
							case 1:
								System.out.println("Please enter customer Details:");
								System.out.println("Enter customer Id");
								int id=bm.nextInt();
								bm.nextLine();
								System.out.println("Enter customer name");
								String name=bm.nextLine();
								System.out.println("Enter Customer location");
								String location=bm.nextLine();
								System.out.println("Enter customer number");
								long number=bm.nextLong();
								bm.nextLine();
								Customer cus=new Customer(id,name,location,number);
								if(CustomerDAO.addCustomer(cus))
									System.out.println("\nCustomer details were added sucessfully\n\n");
								else System.out.println("\nCustomer already exist\n\n");
								break;
							case 2:
								System.out.println("Enter Customer id to delete");
								int id1=bm.nextInt();
								bm.nextLine();
								Customer c=new Customer();
								c.setCustomerId(id1);
								if(CustomerDAO.deleteCustomer(c))
									System.out.println("\nCustomer deleted sucessfully\n\n");
								else System.out.println("\nThere is no customer with this Id\n\n");
								break;
							case 3:
								System.out.println("press 1 to update customer location");
								System.out.println("Press 2 to update customer number\n\n");
								int i=bm.nextInt();
								if(i==1) {
									System.out.println("Enter customer id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter customer location");
									String loc=bm.nextLine();
									Customer c1=new Customer();
									c1.setCustomerId(id2);
									c1.setLocation(loc);
									if(CustomerDAO.updateCustomerLocation(c1))
										System.out.println("\nCustomer location updated sucessfully\n\n");
									else System.out.println("\nThere is no customer with this Id\n\n");
								}
								else if(i==2) {
									System.out.println("Enter customer id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter customer number");
									long num=bm.nextLong();
									Customer c1=new Customer();
									c1.setCustomerId(id2);
									c1.setNumber(num);
									if(CustomerDAO.updateCustomerLocation(c1))
										System.out.println("\nCustomer number updated sucessfully\n\n");
									else System.out.println("\nThere is no customer with this Id\n\n");
								}
								break;
							case 4:
								List<Customer> list=new ArrayList<>();
								list=CustomerDAO.viewAllCustomer();
								for(Customer cust:list) {
									System.out.println(cust);
								}
								break;
							case 5:
								System.out.println("Enter Customer Id");
								int id3=bm.nextInt();
								Customer c1=new Customer();
								c1.setCustomerId(id3);
								Customer c2=new Customer();
								c2=CustomerDAO.viewOneCustomer(c1);
								System.out.println(c2);
								break;
						}
						if(x==6) break;
					}
					break;
				case 2:
					while(true) {
						System.out.println("\npress 1 for Add Product");
						System.out.println("Press 2 for Delete Product");
						System.out.println("Press 3 for Update Product");
						System.out.println("Press 4 for View all Product details");
						System.out.println("Press 5 for view one Product");
						System.out.println("Press 6 for Quit\n\n");
						int x=bm.nextInt();
						switch(x) {
							case 1:
								System.out.println("Please enter Product Details:");
								System.out.println("Enter Product Id");
								int id=bm.nextInt();
								bm.nextLine();
								System.out.println("Enter Product code");
								String code=bm.nextLine();
								System.out.println("Enter Product name");
								String name=bm.nextLine();
								System.out.println("Enter Product costPrice");
								int cost=bm.nextInt();
								bm.nextLine();
								System.out.println("Enter Product Sell Price");
								int sell=bm.nextInt();
								bm.nextLine();
								Product p=new Product(id,code,name,cost,sell);
								if(ProductDAO.addProduct(p))
									System.out.println("\nProduct details were added sucessfully\n\n");
								else System.out.println("\nProduct are already exist\n\n");
								break;
							case 2:
								System.out.println("Enter Product id to delete");
								int id1=bm.nextInt();
								bm.nextLine();
								Product p1=new Product();
								p1.setProductId(id1);
								if(ProductDAO.deleteProduct(p1))
									System.out.println("\nProduct deleted sucessfully\n\n");
								else System.out.println("\nThere is no Product with this Id\n\n");
								break;
							case 3:
								System.out.println("press 1 to update Product cost price");
								System.out.println("Press 2 to update Product selling price\n\n");
								int i=bm.nextInt();
								if(i==1) {
									System.out.println("Enter Product id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter Product cost price");
									int cost1=bm.nextInt();
									Product p2=new Product();
									p2.setProductId(id2);
									p2.setCostPrice(cost1);
									if(ProductDAO.updateProductCostPrice(p2))
										System.out.println("\nProduct cost price updated sucessfully\n\n");
									else System.out.println("\nThere is no Product with this Id\n\n");
								}
								else if(i==2) {
									System.out.println("Enter Product id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter Product selling price");
									int sell1=bm.nextInt();
									Product p2=new Product();
									p2.setProductId(id2);
									p2.setSellPrice(sell1);
									if(ProductDAO.updateProductSellPrice(p2))
										System.out.println("\nProduct selling price updated sucessfully\n\n");
									else System.out.println("\nThere is no Product with this Id\n\n");
								}
								break;
							case 4:
								List<Product> list=new ArrayList<>();
								list=ProductDAO.viewAllProduct();
								for(Product cust:list) {
									System.out.println(cust);
								}
								break;
							case 5:
								System.out.println("Enter Product Id");
								int id3=bm.nextInt();
								Product p2=new Product();
								p2.setProductId(id3);
								Product p3=new Product();
								p3=ProductDAO.viewOneProduct(p2);
								System.out.println(p3);
								break;
						}
						if(x==6) break;
					}
					break;
				case 3:
					while(true) {
						System.out.println("\npress 1 for Add SalesInfo");
						System.out.println("Press 2 for Delete SalesInfo");
						System.out.println("Press 3 for Update SalesInfo");
						System.out.println("Press 4 for View all SalesInfo details");
						System.out.println("Press 5 for view one SalesInfo");
						System.out.println("Press 6 for Quit\n\n");
						int x=bm.nextInt();
						switch(x) {
							case 1:
								System.out.println("Please enter SalesInfo Details:");
								System.out.println("Enter Product Id");
								int id=bm.nextInt();
								bm.nextLine();
								System.out.println("Enter Product name");
								String name=bm.nextLine();
								System.out.println("Enter Product quantity");
								int quan=bm.nextInt();
								bm.nextLine();
								System.out.println("Enter Product Total cost");
								int sell=bm.nextInt();
								bm.nextLine();
								SalesInfo s=new SalesInfo(id,name,quan,sell);
								if(SalesinfoDAO.addSalesInfo(s))
									System.out.println("\nSalesInfo details were added sucessfully\n\n");
								else System.out.println("\nSalesInfo are already exist\n\n");
								break;
							case 2:
								System.out.println("Enter Product id to delete");
								int id1=bm.nextInt();
								bm.nextLine();
								SalesInfo s1=new SalesInfo();
								s1.setProductId(id1);
								if(SalesinfoDAO.deleteSalesInfo(s1))
									System.out.println("\nSalesInfo deleted sucessfully\n\n");
								else System.out.println("\nThere is no SalesInfo with this Id\n\n");
								break;
							case 3:
								System.out.println("press 1 to update SalesInfo Quantity");
								System.out.println("Press 2 to update SalesInfo Cost\n\n");
								int i=bm.nextInt();
								if(i==1) {
									System.out.println("Enter Product id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter Product Quantity");
									int quan1=bm.nextInt();
									SalesInfo s2=new SalesInfo();
									s2.setProductId(id2);
									s2.setQuantity(quan1);
									if(SalesinfoDAO.updateSalesQuantity(s2))
										System.out.println("\nSalesInfo Quantity updated sucessfully\n\n");
									else System.out.println("\nThere is no SalesInfo with this Id\n\n");
								}
								else if(i==2) {
									System.out.println("Enter Product id");
									int id2=bm.nextInt();
									bm.nextLine();
									System.out.println("Enter Product Total Cost");
									int cost1=bm.nextInt();
									SalesInfo s2=new SalesInfo();
									s2.setProductId(id2);
									s2.setTotalCost(cost1);
									if(SalesinfoDAO.updateSalesCost(s2))
										System.out.println("\nSalesInfo Total cost updated sucessfully\n\n");
									else System.out.println("\nThere is no SalesInfo with this Id\n\n");
								}
								break;
							case 4:
								List<SalesInfo> list=new ArrayList<>();
								list=SalesinfoDAO.viewAllSalesInfo();
								for(SalesInfo cust:list) {
									System.out.println(cust);
								}
								break;
							case 5:
								System.out.println("Enter Product Id");
								int id3=bm.nextInt();
								SalesInfo s2=new SalesInfo();
								s2.setProductId(id3);
								SalesInfo s3=new SalesInfo();
								s3=SalesinfoDAO.viewOneSalesInfo(s2);
								System.out.println(s3);
								break;
						}
						if(x==6) break;
					}
					break;
				case 4:
					while(true) {
						System.out.println("\nPress 1 for Add Stock");
						System.out.println("Press 2 for Delete Stock");
						System.out.println("Press 3 for Update Stock");
						System.out.println("Press 4 for View all Stock details");
						System.out.println("Press 5 for view one Stock");
						System.out.println("Press 6 for Quit\n\n");
						int x=bm.nextInt();
						switch(x) {
							case 1:
								System.out.println("Please enter Stock Details:");
								System.out.println("Enter Product name");
								String name=bm.nextLine();
								System.out.println("Enter Product quantity");
								int quan=bm.nextInt();
								bm.nextLine();
								Stock s=new Stock(name,quan);
								if(StockDAO.addStock(s))
									System.out.println("\nStock details were added sucessfully\n\n");
								else System.out.println("\nStock are already exist\n\n");
								break;
							case 2:
								System.out.println("Enter Product name to delete");
								String name1=bm.nextLine();
								Stock s1=new Stock();
								s1.setProductName(name1);
								if(StockDAO.deleteStock(s1))
									System.out.println("\nStock deleted sucessfully\n\n");
								else System.out.println("\nThere is no Stock with this Id\n\n");
								break;
							case 3:
								System.out.println("Enter Product name");
								String name2=bm.nextLine();
								System.out.println("Enter Product Quantity");
								int quan1=bm.nextInt();
								Stock s2=new Stock();
								s2.setProductName(name2);
								s2.setQuantity(quan1);
								if(StockDAO.updateQuantity(s2))
									System.out.println("\nStock Quantity updated sucessfully\n\n");
								else System.out.println("\nThere is no Stock with this Id\n\n");
								break;
							case 4:
								List<Stock> list=new ArrayList<>();
								list=StockDAO.viewAllStock();
								for(Stock cust:list) {
									System.out.println(cust);
								}
								break;
							case 5:
								System.out.println("Enter Product Name");
								String name3=bm.nextLine();
								Stock s3=new Stock();
								s3.setProductName(name3);
								Stock s4=new Stock();
								s4=StockDAO.viewOneStock(s3);
								System.out.println(s4);
								break;
						}
						if(x==6) break;
					}
					break;
			}
			if(n==5) break;
		}
		System.out.println("\t\t\tThank you for using our service\t\t\t");
		bm.close();
	}
}
