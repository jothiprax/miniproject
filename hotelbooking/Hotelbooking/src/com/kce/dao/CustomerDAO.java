package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Customer;
import com.kce.util.ConnectionUtil;

public class CustomerDAO {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (name, phone, email, address) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM customer";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE id = ?";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE customer SET name = ?, phone = ?, email = ?, address = ? WHERE id = ?";
    private static final String SELECT_CUSTOMER_BY_ID_SQL = "SELECT * FROM customer WHERE id = ?";

    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.executeUpdate();
        }
    }
    public List<Customer> selectAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customers.add(new Customer(id, name, phone, email, address));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public void deleteCustomer(int id) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setInt(5, customer.getId());
            preparedStatement.executeUpdate();
        }
    }
    public Customer selectCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, name, phone, email, address);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
	public List<Customer> getAllCustomers() {
		return null;
	}
}
