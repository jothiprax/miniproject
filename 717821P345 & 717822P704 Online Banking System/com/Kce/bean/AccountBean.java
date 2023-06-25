package com.Kce.bean;
public class AccountBean {
    private String Account_number;
    private String Customer_name;
    private float Balance;
    private String MPIN;
    private String MTPIN;
    AccountBean(){}
    public AccountBean(String Account_number,String Customer_name,float Balance,String MPIN,String MTPIN){
        this.Account_number=Account_number;
        this.Customer_name=Customer_name;
        this.Balance=Balance;
        this.MPIN=MPIN;
        this.MTPIN=MTPIN;
    }
    public String getAccount_number(){
        return Account_number;
    }
    public String getCustomer_name(){
        return Customer_name;
    }

    public float getBalance() {
        return Balance;
    }
    public String getMPIN(){
        return MPIN;
    }

    public String getMTPIN() {
        return MTPIN;
    }

    public void setAccount_number(String Account_number){
        this.Account_number=Account_number;
    }

    public void setMPIN(String MPIN) {
        this.MPIN = MPIN;
    }
    public void setMTPIN(String MTPIN){
        this.MTPIN=MTPIN;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "AccountBean{" +
                "Account_number='" + Account_number +
                ", Customer_name='" + Customer_name +
                ", Balance=" + Balance +
                ", MPIN='" + MPIN +
                ", MTPIN='" + MTPIN +
                '}';
    }
}
