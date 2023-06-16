package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.CustomerInfo;
import com.kce.bean.LoginInfo;
import com.kce.exception.OnlineShoppingException;
import com.kce.util.DbConnectionUtils;

public class CustomerDao {
    
    private Connection connection;

    public CustomerDao() throws ClassNotFoundException, SQLException {
        this.connection = DbConnectionUtils.getConnection();
    }
    
    public void saveCustInfo(final CustomerInfo customerInfo) throws OnlineShoppingException {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into custInfo(CustID,Name,Age,Email,Address,ContactNumber) values(?,?,?,?,?,?)");
            ps.setString(1, customerInfo.getCustomerId());
            ps.setString(2, customerInfo.getName());
            ps.setString(3, Integer.toString(customerInfo.getAge()));
            ps.setString(4, customerInfo.getEmail());
            ps.setString(5, customerInfo.getAddress());
            ps.setString(6, customerInfo.getContactNumber());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
    }
    
    public void saveLoginInfo(final CustomerInfo registerBean, final String userType) throws OnlineShoppingException {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into loginInfo(userID,password,userType) values(?,?,?)");
            ps.setString(1, registerBean.getCustomerId());
            ps.setString(2, registerBean.getPassword());
            ps.setString(3, userType);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
    }
    
    public LoginInfo findUser(final LoginInfo loginBean) throws OnlineShoppingException {
        LoginInfo loginInfo = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from logininfo where userID= ? and password= ?");
            ps.setInt(1, loginBean.getUserId());
            ps.setString(2, loginBean.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loginInfo = new LoginInfo();
                loginInfo.setUserId(Integer.parseInt(rs.getString("userID")));
                loginInfo.setPassword(rs.getString("password"));
                loginInfo.setUserType((rs.getString("userType")));
            }
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
        return loginInfo;
    }
    
    public Integer updateCustomerInfo(final String type, final String value, final Integer custID) throws OnlineShoppingException, SQLException {
        PreparedStatement ps = null;
        if (type.equalsIgnoreCase("Name")) {
            ps = connection.prepareStatement("update custinfo set Name = ? where custID=?");
            ps.setString(1, value);
        } else if (type.equalsIgnoreCase("Age")) {
            ps = connection.prepareStatement("update custinfo set Age = ? where custID=?");
            ps.setInt(1, Integer.parseInt(value));
        } else if (type.equalsIgnoreCase("Email")) {
            ps = connection.prepareStatement("update custinfo set Email = ? where custID=?");
            ps.setString(1, value);
        } else if (type.equalsIgnoreCase("Address")) {
            ps = connection.prepareStatement("update custinfo set Address = ? where custID=?");
            ps.setString(1, value);
        } else if (type.equalsIgnoreCase("ContactNumber")) {
            ps = connection.prepareStatement("update custinfo set ContactNumber = ? where custID=?");
            ps.setString(1, value);
        } else if (type.equalsIgnoreCase("Password")) {
            ps = connection.prepareStatement("update logininfo set password=? where userID=?");
            ps.setString(1, value);
        }
        ps.setString(2, Integer.toString(custID));
        Integer x = ps.executeUpdate();
        return x;
    }
    
    public Integer findCustInfoId() throws OnlineShoppingException, SQLException {
        PreparedStatement ps = connection.prepareStatement("select CustID from custinfo");
        ResultSet rs = ps.executeQuery();
        int x = 0;
        while (rs.next()) {
            x = Integer.parseInt(rs.getString("CustID"));
        }
        x = x + 1;
        return x;
    }
    
    public CustomerInfo findCustInfoById(final Integer customerId) throws OnlineShoppingException, SQLException {
        CustomerInfo customerInfo = null;
        PreparedStatement ps = connection.prepareStatement("select * from custinfo where custID=?");
        ps.setString(1, Integer.toString(customerId));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            customerInfo = new CustomerInfo();
            customerInfo.setCustomerId(rs.getString(1));
            customerInfo.setName(rs.getString(2));
            customerInfo.setAge(Integer.parseInt(rs.getString(3)));
            customerInfo.setEmail(rs.getString(4));
            customerInfo.setAddress(rs.getString(5));
            customerInfo.setContactNumber(rs.getString(6));
        }
        return customerInfo;
    }
    

}
