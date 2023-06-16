package com.kce.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.BillInfo;
import com.kce.dao.PaymentDao;
import com.kce.exception.OnlineShoppingException;

public class BillService {
    private int bill_id;
    private String cust_name;
    private String bill_addr;
    private String cust_phone;
    public float total_amount;
    private List<Integer> pid = new ArrayList<>();
    private List<String> pname = new ArrayList<>();
    private List<Integer> qty = new ArrayList<>();
    private List<Float> price = new ArrayList<>();
    
    private PaymentDao paymentDao;

    public BillService(String cname, String badd, String cphn, List<Integer> p_id, List<String> p_name,
            List<Integer> quant, List<Float> prc) throws IOException, ClassNotFoundException, SQLException {
        cust_name = cname;
        bill_addr = badd;
        cust_phone = cphn;
        total_amount = 0.0f;
        pid = p_id;
        pname = p_name;
        qty = quant;
        price = prc;
        paymentDao = new PaymentDao();
    }

    private void generateBill() throws IOException, OnlineShoppingException {
        bill_id = setBillId();
        float sum = 0.0f;
        int i;
        for (i = 0; i < pid.size(); i++) {
            sum = sum + price.get(i);
        }
        total_amount = sum;
    }

    private  int setBillId() throws IOException, OnlineShoppingException {
        int billId = paymentDao.findBillIds();
        return billId + 1;
    }

    public void displayBill() throws IOException, OnlineShoppingException {
        generateBill();
        int x;
        System.out.println("YOUR BILL IS :\n");
        System.out.println(
                "************************************************************************************************\n");
        System.out.printf("BILL ID                  =  %-5d\n", bill_id);
        System.out.printf("CUSTOMER NAME            =  %-20s\n", cust_name);
        System.out.printf("CUSTOMER CONTACT NUMBER  =  %-20s\n", cust_phone);
        System.out.printf("CUSTOMER ADDRESS         =  %-30s\n", bill_addr);
        System.out.println(
                "************************************************************************************************\n");
        System.out.printf("%-20s \t %-20s \t %-20s \t %-20s\n", "PRODUCT_ID", "PRODUCT_NAME", "QUANTITY PURCHASED",
                "TOTAL_PRICE");
        for (x = 0; x < pid.size(); x++) {
            System.out.printf("%-20d \t %-20s  \t %-20d \t %-20f\n", pid.get(x), pname.get(x), qty.get(x),
                    price.get(x));
        }
        System.out.println(
                "************************************************************************************************\n");
        System.out.printf("TOTAL AMOUNT PAYABLE = Rs. " + total_amount + "\n");
        System.out.println(
                "************************************************************************************************\n");
    }

    public void addToDatabase() throws IOException {
        try {
            BillInfo billInfo = new BillInfo();
            billInfo.setBillId(bill_id);
            billInfo.setCustomerName(cust_name);
            billInfo.setBillAddress(bill_addr);
            billInfo.setAmount(total_amount);
            paymentDao.saveBillInfo(billInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
