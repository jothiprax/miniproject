package com.kce.dao;

import com.kce.bean.Customer;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO customers (name, phone_number, email) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";

    public static void addCustomer(Customer customer) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPhoneNumber());
            statement.setString(3, customer.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                Customer customer = new Customer(name, phoneNumber, email);
                customer.setId(id);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                customer = new Customer(name, phoneNumber, email);
                customer.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
