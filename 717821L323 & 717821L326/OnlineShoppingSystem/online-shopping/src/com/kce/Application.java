package com.kce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kce.service.CustomerRegistrationService;
import com.kce.service.LoginService;

public class Application {

    public static void main(String args[]) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to online shopping system \n");
            int ch;
            do {
                System.out.println("*****************************************************\n");
                System.out.println("1 - Signup");
                System.out.println("2 - Login");
                System.out.println("3 - Exit");
                System.out.println("*****************************************************\n");
                System.out.print("Enter choice : ");
                ch = Integer.parseInt(br.readLine());
                if (ch == 1) {
                    new CustomerRegistrationService().registerCustomer();
                } else if (ch == 2) {
                    new LoginService().loginSystem();
                } else if (ch == 3) {
                    System.out.println("Thank you");
                } else {
                    System.err.println("Wrong choice");
                }
            } while (ch != 4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
