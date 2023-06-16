package com.kce.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Product;
import com.kce.dao.ProductsDao;

public class CartService {
    private List<Integer> pid = new ArrayList<Integer>();
    private List<String> pname = new ArrayList<String>();
    private List<String> ptype = new ArrayList<String>();
    private List<Integer> qpur = new ArrayList<Integer>();
    private List<Float> qprice = new ArrayList<Float>();

    public List<Integer> getpid() throws IOException {
        return pid;
    }

    public List<String> getpname() throws IOException {
        return pname;
    }

    public List<Integer> getpqty() throws IOException {
        return qpur;
    }

    public List<Float> getprice() throws IOException {
        return qprice;
    }

    public void addToCart(int p_id, String p_name, String p_type, int q_pur, float q_price) throws IOException {
        pid.add(p_id);
        pname.add(p_name);
        ptype.add(p_type);
        qpur.add(q_pur);
        qprice.add(q_price);
    }

    public void viewCart() throws IOException {
        int x = pid.size();
        if (x != 0) {
            System.out.println("YOUR CART IS : \n");
            int i;
            System.out.println(
                    "***********************************************************************************************************************\n");
            System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID", "Product_Name",
                    "Product_Type", "Quantity_Purchased", "Total_Price");
            System.out.println(
                    "***********************************************************************************************************************\n");
            for (i = 0; i < x; i++) {
                System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n", pid.get(i), pname.get(i), ptype.get(i),
                        qpur.get(i), qprice.get(i));
            }
            System.out.println(
                    "***********************************************************************************************************************\n");
        } else
            System.out.println("CART IS EMPTY !");

    }

    public void removeFromCart(int p_id) throws IOException {
        int res;
        int x = -1;
        int newq = 0;
        res = pid.indexOf(p_id);
        if (res == -1)
            System.out.println("You have not purchased this product!");
        else {
            pid.remove(res);
            pname.remove(res);
            ptype.remove(res);
            qprice.remove(res);
            try {
                ProductsDao productDao = new ProductsDao();
                Product product = productDao.findProductById(pid.get(x));
                newq = product.getQuantity() + qpur.get(res);
                qpur.remove(res);
                productDao.updateQuantity(newq, p_id);
                System.out.println("cart updated successfully!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void cancelCart() throws IOException {
        try {
            ProductsDao productDao = new ProductsDao();
            for (int x = 0; x < pid.size(); x++) {
                Product product = productDao.findProductById(pid.get(x));
                Integer newquantity = product.getQuantity() + qpur.get(x);
                productDao.updateQuantity(newquantity, pid.get(x));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
