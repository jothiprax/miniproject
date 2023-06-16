package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.kce.bean.CustomerInfo;
import com.kce.dao.CustomerDao;
import com.kce.exception.OnlineShoppingException;

public class CustomerRegistrationService {

    private static CustomerDao customerDao;

    public CustomerRegistrationService() throws ClassNotFoundException, SQLException {
        customerDao = new CustomerDao();
    }

    public void registerCustomer() throws IOException {
        try {
            CustomerInfo registerBean = getInput();
            customerDao.saveCustInfo(registerBean);
            customerDao.saveLoginInfo(registerBean, "C");
            System.out.println("signedup successfully!\n");
        } catch (Exception e) {
            System.out.println("signup failed !\n");
            e.printStackTrace();
        }
    }

    private static CustomerInfo getInput() throws IOException, OnlineShoppingException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pass, name, num, addr, email;
        int age = 0;
        System.out.println("\n Welcome to customer registration page \n");
        System.out.println("*****************************************************\n");
        Integer UID = customerDao.findCustInfoId();
        System.out.println("admin id = " + UID);
        System.out.print("Enter password = ");
        pass = br.readLine();
        System.out.print("Enter Name = ");
        name = br.readLine();
        System.out.print("Enter age = ");
        String tempAge = br.readLine();
        if (tempAge != null) {
            age = Integer.parseInt(tempAge);
        }
        System.out.print("Enter contact number = ");
        num = br.readLine();
        System.out.print("Enter address = ");
        addr = br.readLine();
        System.out.print("Enter email = ");
        email = br.readLine();

        CustomerInfo registerBean = new CustomerInfo();
        registerBean.setCustomerId(UID.toString());
        registerBean.setPassword(pass);
        registerBean.setName(name);
        registerBean.setAge(age);
        registerBean.setAddress(addr);
        registerBean.setContactNumber(num);
        registerBean.setEmail(email);

        return registerBean;
    }

}
