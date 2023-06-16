package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Product;
import com.kce.exception.OnlineShoppingException;
import com.kce.util.DbConnectionUtils;

public class ProductsDao {

    private Connection connection;

    public ProductsDao() throws ClassNotFoundException, SQLException {
        this.connection = DbConnectionUtils.getConnection();
    }

    public List<Product> findAllProducts() throws OnlineShoppingException, SQLException {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false) {
                return products;
            }
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(Integer.parseInt(rs.getString(1)));
                product.setProductName(rs.getString(2));
                product.setProductType(rs.getString(3));
                product.setQuantity(Integer.parseInt(rs.getString(4)));
                product.setPrice(Float.parseFloat(rs.getString(5)));
                products.add(product);
            }
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
        return products;
    }
    
    public Product findProductById(final Integer productId) throws OnlineShoppingException, SQLException {
        Product product = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from products where productID= ?");
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setProductId(Integer.parseInt(rs.getString(1)));
                product.setProductName(rs.getString(2));
                product.setProductType(rs.getString(3));
                product.setQuantity(Integer.parseInt(rs.getString(4)));
                product.setPrice(Float.parseFloat(rs.getString(5)));
            }
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
        return product;

    }
    
    public Integer updateQuantity(final Integer quantity, final Integer productId) throws OnlineShoppingException, SQLException {
        Integer result = null;
        try {
            PreparedStatement ps = connection.prepareStatement("update products set Quantity=? where productID=?");
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            result = ps.executeUpdate();
        } catch (Exception e) {
            throw new OnlineShoppingException(e.getMessage());
        }
        return result;

    }

}
