package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kce.Application;
import com.kce.bean.CustomerInfo;
import com.kce.bean.Product;
import com.kce.dao.CustomerDao;
import com.kce.dao.ProductsDao;
import com.kce.exception.OnlineShoppingException;

public class CustomerService extends Application {
    private int customerID;
    private String customerPass;
    private int cartFlag = 0;
    private int billPaidFlag = 0;
    private int checkFlag = -1;

    private List<Integer> pid = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private List<String> type = new ArrayList<>();
    private List<Integer> qty = new ArrayList<>();
    private List<Float> price = new ArrayList<>();


    private static CustomerDao customerDao;
    private static ProductsDao productsDao;
    private static CartService customerCart;

    public CustomerService(int custID, String passw) throws ClassNotFoundException, SQLException {
        customerID = custID;
        customerPass = passw;
        billPaidFlag = 0;
        cartFlag = 0;
        customerDao = new CustomerDao();
        productsDao = new ProductsDao();
        customerCart = new CartService();
    }

    public void CustomerPage() throws IOException, OnlineShoppingException, SQLException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("WELCOME TO CUSTOMER SECTION\n");
        int ch;
        do {
            System.out.println("*****************************************************\n");
            System.out.println("1 - VIEW PRODUCTS LIST");
            System.out.println("2 - SEARCH A PRODUCT NAMEWISE");
            System.out.println("3 - SEARCH PRODUCTS TYPEWISE");
            System.out.println("4 - ADD PRODUCT TO CART");
            System.out.println("5 - REMOVE PRODUCT FROM CART");
            System.out.println("6 - VIEW CART");
            System.out.println("7 - PROCEED TO PAYMENT");
            System.out.println("8 - EDIT PROFILE");
            System.out.println("9 - LOGOUT FROM SYSTEM");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 1)
                this.viewProducts();
            else if (ch == 2)
                this.searchByName();
            else if (ch == 3)
                this.searchByType();
            else if (ch == 4) {
                this.addProducts();
            } else if (ch == 5) {
                int rem;
                System.out.print("ENTER PRODUCT ID TO REMOVE FROM CART = ");
                rem = Integer.parseInt(br.readLine());
                customerCart.removeFromCart(rem);
                this.updateArrayList();
            } else if (ch == 6)
                customerCart.viewCart();
            else if (ch == 7) {
                this.proceedPayment(customerCart);
            } else if (ch == 8)
                editProfile(customerID);
            else if (ch == 9) {
                ch = this.checkExit();
                if (ch == 0)
                    ch = 9;
            } else
                System.out.println("Wrong choice");
        } while (ch != 9);
    }

    // View Products
    private void viewProducts() throws IOException, OnlineShoppingException, SQLException {
        List<Product> products = productsDao.findAllProducts();
        if (products.isEmpty()) {
            System.out.println("Products not available!");
        } else {
            System.out.println(
                    "***********************************************************************************************************************\n");
            System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID", "Product_Name",
                    "Product_Type", "Product_Quantity", "Product_Price");
            System.out.println(
                    "***********************************************************************************************************************\n");
            for (Product product : products) {
                System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n", product.getProductId(),
                        product.getProductName(), product.getProductType(), product.getQuantity(), product.getPrice());
            }
            System.out.println(
                    "***********************************************************************************************************************\n");
        }
    }

    // Search by product name
    private void searchByName() throws IOException, OnlineShoppingException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chc;
        do {
            List<Product> products = productsDao.findAllProducts();
            if (products.isEmpty()) {
                System.out.println("Products not available!");
            }
            System.out.print("Enter product name to search : ");
            String sr = br.readLine();
            products = products.stream().filter(product -> product.getProductName().equalsIgnoreCase(sr))
                    .collect(Collectors.toList());
            if (products.isEmpty()) {
                System.out.println("Product not found!");
            } else {
                System.out.println("Products available are : \n");
                System.out.println(
                        "***********************************************************************************************************************\n");
                System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID", "Product_Name",
                        "Product_Type", "Product_Quantity", "Product_Price");
                System.out.println(
                        "***********************************************************************************************************************\n");
                for (Product product : products) {
                    if (product.getProductName().equalsIgnoreCase(sr)) {
                        System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n", product.getProductId(),
                                product.getProductName(), product.getProductType(), product.getQuantity(),
                                product.getPrice());
                    }
                }
                System.out.println(
                        "***********************************************************************************************************************\n");
            }
            System.out.print("PRESS Y to continue , N for exit : ");
            chc = br.readLine();
        } while (chc.equalsIgnoreCase("Y"));
    }

    // Search by product type
    private void searchByType() throws IOException, OnlineShoppingException, SQLException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String chc;
            do {
                List<Product> products = productsDao.findAllProducts();
                if (products.isEmpty()) {
                    System.out.println("Products not available!");
                }
                System.out.print("Enter product type to search : ");
                String sr = br.readLine();
                products = products.stream().filter(product -> product.getProductType().equalsIgnoreCase(sr))
                        .collect(Collectors.toList());
                if (products.isEmpty()) {
                    System.out.println("Product not found!");
                } else {
                    System.out.println("Products available are : \n");
                    System.out.println(
                            "***********************************************************************************************************************\n");
                    System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID", "Product_Name",
                            "Product_Type", "Product_Quantity", "Product_Price");
                    System.out.println(
                            "***********************************************************************************************************************\n");
                    for (Product product : products) {
                        System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n", product.getProductId(),
                                product.getProductName(), product.getProductType(), product.getQuantity(),
                                product.getPrice());
                    }
                    System.out.println(
                            "***********************************************************************************************************************\n");
                }
                System.out.print("PRESS Y to continue , N for exit : ");
                chc = br.readLine();
            } while (chc.equalsIgnoreCase("Y"));
    }

    // Add to cart
    private void addProducts() throws IOException, OnlineShoppingException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chc;
        do {
            System.out.print("Enter product id to add cart = ");
            Integer productId = Integer.parseInt(br.readLine());
            Product product = productsDao.findProductById(productId);
            if (product == null) {
                System.out.println("Product not found !");
            } else {
                System.out.println("Quanity available = " + product.getQuantity());
                System.out.println("Enter quantity to purchase = ");
                Integer quantityPurchase = Integer.parseInt(br.readLine());
                if (quantityPurchase > product.getQuantity())
                    System.out.println("Product stock not available");
                else {
                    updateQty(quantityPurchase, product);
                    customerCart.addToCart(product.getProductId(), product.getProductName(), product.getProductType(),
                            quantityPurchase, quantityPurchase * product.getPrice());
                    cartFlag = 1;
                }
            }
            System.out.print("DO YOU WANT TO CONTINUE PRESS ( Y for yes, N for no)");
            chc = br.readLine();
        } while (chc.equalsIgnoreCase("Y"));
    }

    // Updated quantity when add to cart
    private void updateQty(final Integer quantityPurchase, final Product product) throws IOException {
        try {
            Integer updateQuantity = 0;
            if (product.getQuantity() - quantityPurchase > 0) {
                updateQuantity = product.getQuantity() - quantityPurchase;
            }
            Integer result = productsDao.updateQuantity(updateQuantity, product.getProductId());
            if (result == 0)
                System.out.println("products update failed!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int checkExit() throws IOException, ClassNotFoundException, SQLException, OnlineShoppingException {
        if (cartFlag == 1) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String chc;
            System.out.println("You have a pending cart !");
            System.out.print("DO YOU WANT TO MAKE PAYMENT ( PRESS Y ) ELSE CANCEL THE CART ( PRESS N) : ");
            chc = br.readLine();
            if (chc.equalsIgnoreCase("Y")) {
                proceedPayment(customerCart);
                if (billPaidFlag != 1 && checkFlag == -1)
                    return -1;
                else
                    return 0;
            } else {
                customerCart.cancelCart();
                customerCart = new CartService();
                cartFlag = 0;
                billPaidFlag = 0;
            }
        }
        System.out.println("Thank you !");
        return 9;

    }

    private void proceedPayment(CartService cart1) throws IOException, ClassNotFoundException, SQLException, OnlineShoppingException {
        if (cartFlag == 1) {
            CustomerInfo customerInfo = null;
            try {
                customerInfo = customerDao.findCustInfoById(customerID);
            } catch (Exception e) {
                System.out.println(e);
            }
            PaymentService paymentService = new PaymentService(cart1, customerInfo.getName(), customerInfo.getAddress(), customerInfo.getContactNumber());
            paymentService.paymentPage();
            if (paymentService.billPaid_f == 1)
                billPaidFlag = 1;
            if (billPaidFlag == 1) {
                customerCart = new CartService();
                cartFlag = 0;
                billPaidFlag = 0;
                checkFlag = -2;
            }
        } else
            System.out.println("CART IS EMPTY! ");
    }

    // the below functions are of private use only , not to be used by customer
    // class
    private void updateArrayList() throws IOException {
        pid.clear();
        name.clear();
        type.clear();
        qty.clear();
        price.clear();
    }

    //Edit profile
    private static void editProfile(int custID) throws IOException {
        try {
            int x = 0;
            String chc;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            String name = "", email = "", addr = "", contact = "", passw = "";
            String age = "";
            int ch = 0;
            do {
                System.out.println("************************************************************");
                System.out.println("1 - EDIT NAME");
                System.out.println("2 - EDIT AGE");
                System.out.println("3 - EDIT EMAIL ID");
                System.out.println("4 - EDIT ADDRESS");
                System.out.println("5 - EDIT CONTACT NUMBER");
                System.out.println("6 - CHANGE PASSWORD");
                System.out.println("7 - EXIT");
                System.out.println("************************************************************");
                System.out.print("Enter choice : ");
                ch = Integer.parseInt(br.readLine());
                if (ch == 1) {
                    System.out.print("ENTER NEW NAME : ");
                    name = br.readLine();
                    s = "Name";
                    x = customerDao.updateCustomerInfo(s, name, custID);
                } else if (ch == 2) {
                    System.out.print("ENTER AGE : ");
                    age = br.readLine();
                    s = "Age";
                    x = customerDao.updateCustomerInfo(s, age, custID);
                } else if (ch == 3) {
                    System.out.print("ENTER NEW EMAIL ID : ");
                    email = br.readLine();
                    s = "Email";
                    x = customerDao.updateCustomerInfo(s, email, custID);
                } else if (ch == 4) {
                    System.out.print("ENTER ADDRESS : ");
                    addr = br.readLine();
                    s = "Address";
                    x = customerDao.updateCustomerInfo(s, addr, custID);
                } else if (ch == 5) {
                    System.out.print("ENTER NEW CONTACT NUMBER : ");
                    contact = br.readLine();
                    s = "ContactNumber";
                    x = customerDao.updateCustomerInfo(s, contact, custID);
                } else if (ch == 6) {
                    System.out.print("ENTER NEW PASSWORD : ");
                    passw = br.readLine();
                    s = "password";
                    x = customerDao.updateCustomerInfo(s, passw, custID);
                } else if (ch == 7) {
                    System.out.println("Thank you");
                    break;
                } else {
                    System.out.println("Wrong choice");
                }

                if (x == 1) {
                    System.out.println("Customer info updated successfully!");
                }

                System.out.print("Do you want to continue ( Y for yes, N for No ) : ");
                chc = br.readLine();

            } while (chc.equalsIgnoreCase("Y"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
