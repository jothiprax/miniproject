package com.kce.dao;

import com.kce.bean.Customer;
import com.kce.util.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public void addCustomer(Customer customer) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO customers (name, email, id, room_no, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getId());
            statement.setInt(4, customer.getRoomNo());
            statement.setString(5, customer.getCheckInDate());
            statement.setString(6, customer.getCheckOutDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE customers SET name = ?, email = ?, id = ?, room_no = ?, check_in_date = ?, check_out_date = ? WHERE id = ?")) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getId());
            statement.setInt(4, customer.getRoomNo());
            statement.setString(5, customer.getCheckInDate());
            statement.setString(6, customer.getCheckOutDate());
            statement.setString(7, customer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String customerId) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE id = ?")) {
            statement.setString(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> viewCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String id = resultSet.getString("id");
                int roomNo = resultSet.getInt("room_no");
                String checkInDate = resultSet.getString("check_in_date");
                String checkOutDate = resultSet.getString("check_out_date");

                Customer customer = new Customer(name, email, id, roomNo, checkInDate, checkOutDate);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
