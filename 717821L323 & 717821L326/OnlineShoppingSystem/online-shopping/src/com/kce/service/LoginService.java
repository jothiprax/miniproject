package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.kce.bean.LoginInfo;
import com.kce.dao.CustomerDao;

public class LoginService {

    private static CustomerDao customerDao;

    public LoginService() throws ClassNotFoundException, SQLException {
        customerDao = new CustomerDao();
    }

    public void loginSystem() throws IOException {
        try {
            LoginInfo loginBean = getInput();
            LoginInfo loginInfo = customerDao.findUser(loginBean);
            if (loginInfo != null) {
                CustomerService ob = new CustomerService(loginInfo.getUserId(), loginInfo.getPassword());
                ob.CustomerPage();
            } else {
                System.out.println("invalid  credientials , enter again !");
                System.out.print("Do you want to continue ( Y for yes, N for No)");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String chc = br.readLine();
                if (chc.equalsIgnoreCase("Y")) {
                    loginSystem();
                } else {

                }

            }
        } catch (Exception e) {
            System.out.println("Login failed !\n");
            e.printStackTrace();
        }

    }

    private static LoginInfo getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nWELCOME TO LOGIN PAGE\n");
        System.out.println("*****************************************************\n");

        System.out.print("Enter USER ID : ");
        int uid = Integer.parseInt(br.readLine());
        System.out.print("Enter PASSWORD : ");
        String password = br.readLine();

        LoginInfo loginBean = new LoginInfo();
        loginBean.setUserId(uid);
        loginBean.setPassword(password);

        return loginBean;
    }
}
