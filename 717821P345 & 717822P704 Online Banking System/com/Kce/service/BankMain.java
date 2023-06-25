package com.Kce.service;
import com.Kce.bean.*;
import com.Kce.util.*;
import com.Kce.DAO.*;
import java.sql.SQLException;
import java.util.*;
import com.Kce.util.MTPINMismatchException;
public class BankMain {
    public static void main(String [] args)throws ClassNotFoundException, SQLException {
        Scanner sc=new Scanner(System.in);
        List<AccountBean> AB=new ArrayList<>();
        List<TransferBean> TB=new ArrayList<>();
        BankDAO bd=new BankDAO();
        boolean flg=true;
        while(flg) {
            int ch;
            //Enter choices for Online Banking
            System.out.println("Welcome to Online Banking System\n1 To Create Account\n2 To Login\n3 To Exit\nEnter your Choice");
            ch=sc.nextInt();
            sc.nextLine();
            if(ch==1){
                //To perform amount deposit
                System.out.println("Enter AccountNumber:");
                String an=sc.nextLine();
                System.out.println("Enter HolderName:");
                String name=sc.nextLine();
                System.out.println("Enter Amount to Deposit:");
                float bl=(float)sc.nextInt();
                sc.nextLine();
                System.out.println("Enter 4 digit pin to Set MPIN:");
                String mp=sc.nextLine();
                System.out.println("Enter 4 digit pin to Set MTPIN:");
                String mt=sc.nextLine();
                AccountBean a=new AccountBean(an,name,bl,mp,mt);
                AB.add(a);
                bd.addAccount(a);
            }
            else if (ch==2) {
                //choice 2 is to perform transfer money or account deletion or change or reset MPIN
                System.out.println("Enter your Account Number:");
                String ac=sc.nextLine();
                System.out.println("Enter your MPIN:");
                String MP=sc.nextLine();
                if(MP.equals(bd.getMPIN(ac))) {
                    boolean inflg = true;
                    System.out.println("Account Number: " + ac);
                    while (inflg) {
                        System.out.println("1 To Transfer Money\n2 To Reset MPIN\n3 To Reset MTPIN\n4 To Delete Your Online Account\n5 To View your Account Details\n6 To View Transcation Details\n7 To View your Account Transcations\n8 To Logout\nEnter your choice");
                        int c = sc.nextInt();
                        sc.nextLine();
                        if (c == 1) {
                            //To perform money transfer
                            boolean va = true;
                            int tid = bd.generateTranscationid();
                            System.out.println("TranscationId: " + tid);
                            String db = "";
                            String cr = "";
                            while (va) {
                                System.out.println("Enter your AccountNumber:");
                                db = sc.nextLine();
                                if (bd.ValidateAccount(db)) {
                                    va = false;
                                } else {
                                    System.out.println("Enter valid AccountNumber");
                                }
                            }
                            va = true;
                            while (va) {
                                System.out.println("Enter Beneficiary AccountNumber:");
                                cr = sc.nextLine();
                                if (bd.ValidateAccount(cr)) {
                                    va = false;
                                } else {
                                    System.out.println("Enter valid AccountNumber");
                                }
                            }
                            boolean f = true;
                            System.out.println("Enter the TransferAmount:");
                            float ta = (float) sc.nextInt();
                            sc.nextLine();
                            try {
                                if (ta > bd.findBalance(db)) {
                                    throw new InSufficientFundsException();
                                }
                            } catch (InSufficientFundsException e) {
                                f = false;
                                System.out.println(e);
                            }
                            if(f) {
                                boolean fl = true;
                                System.out.println("Enter Your MTPIN:");
                                String MT = sc.nextLine();
                                try {
                                    if (!(MT.equals(bd.getMTPIN(db)))) {
                                        throw new MTPINMismatchException();
                                    }
                                } catch (MTPINMismatchException e) {
                                    fl = false;
                                    System.out.println(e);
                                }
                                Date d = new Date();
                                if (fl) {
                                    TransferBean tb = new TransferBean(tid, db, cr, d, ta);
                                    TB.add(tb);
                                    boolean trans;
                                    trans = bd.transferMoney(tb);
                                    if (trans) {
                                        float dbbal = bd.findBalance(db);
                                        float crbal = bd.findBalance(cr);
                                        bd.UpdateAccount_tbl(db, dbbal - ta);
                                        bd.UpdateAccount_tbl(cr, crbal + ta);
                                        System.out.println("Transcation completed Successfully");
                                    }
                                }
                            }
                        } else if (c == 2) {
                            System.out.println("Enter new MPIN:");
                            String mpin = sc.nextLine();
                            bd.ResetMPIN(ac, mpin);
                            System.out.println("Your MPIN is Reset Successfully");
                        } else if (c == 3) {
                            System.out.println("Enter new MTPIN:");
                            String mtpin = sc.nextLine();
                            bd.ResetMTPIN(ac, mtpin);
                            System.out.println("Your MTPIN is Reset Successfully");
                        } else if (c == 4) {
                            bd.deleteAccount(ac);
                        } else if (c == 5) {
                            bd.DetailofAccount(ac);
                        } else if (c == 6) {
                            System.out.println("Enter TranscationID:");
                            int id = sc.nextInt();
                            bd.DetailofTranscation(id);
                        } else if (c == 7) {
                            bd.viewTranscation(ac);
                        }
                        else if(c==8){
                            inflg=false;
                            System.out.println("You Logout");
                        }
                        else{
                            System.out.println("Invalid Choice");
                        }
                    }
                }
                else{
                    System.out.println("Please Check your Account number or MPIN");
                }
            }
            else if(ch==3){
                flg=false;
                System.out.println("Thanks for using Banking System");
            }
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
