package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.bean.BillInfo;
import com.kce.exception.OnlineShoppingException;
import com.kce.util.DbConnectionUtils;

public class PaymentDao {

    private Connection connection;

    public PaymentDao() throws ClassNotFoundException, SQLException {
        this.connection = DbConnectionUtils.getConnection();
    }

    public void saveBillInfo(final BillInfo billInfo) throws OnlineShoppingException {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into bills(bill_id,cust_name,bill_addr,total_amt) values(?,?,?,?)");
            ps.setString(1, Integer.toString(billInfo.getBillId()));
            ps.setString(2, billInfo.getCustomerName());
            ps.setString(3, billInfo.getBillAddress());
            ps.setString(4, Float.toString(billInfo.getAmount()));
            ps.executeUpdate();
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
    }
    
    public Integer findBillIds() throws OnlineShoppingException {
        Integer billId = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("select bill_id from bills");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                billId = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
        return billId;
    }

}
