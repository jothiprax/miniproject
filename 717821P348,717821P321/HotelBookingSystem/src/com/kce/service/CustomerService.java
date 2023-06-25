package com.kce.service;

import com.kce.bean.Customer;
import com.kce.dao.CustomerDAO;

import java.util.List;

public class CustomerService {
    public static void addCustomer(Customer customer) {
        CustomerDAO.addCustomer(customer);
    }

    public static List<Customer> getAllCustomers() {
        return CustomerDAO.getAllCustomers();
    }

    public static Customer getCustomerById(int id) {
        return CustomerDAO.getCustomerById(id);
    }
}
