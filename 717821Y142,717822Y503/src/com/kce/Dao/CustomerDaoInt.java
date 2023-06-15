package com.kce.Dao;
import com.kce.bean.Customer;

public interface CustomerDaoInt {

    //create Customer
    public void createCustomer(Customer emp);
    //show all Customer
    public void showAllCustomer();
    //show Customer based on id
    public void showCustomerBasedOnID(int id);
    //update Customer
    public void updateCustomer(int id,String name);
    //delete Customer
    public void deleteCustomer(int id);
}