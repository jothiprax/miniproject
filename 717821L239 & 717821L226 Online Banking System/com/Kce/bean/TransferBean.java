package com.Kce.bean;
import java.util.Date;
public class TransferBean {
    private int Transcation_id;
    private String FromAccountNumber;
    private String ToAccountNumber;
    private Date dateofTranscation;
    private float amount;
    TransferBean(){}
    public TransferBean(int Transcation_id,String FromAccountNumber,String ToAccountNumber,Date dateofTranscation,float amount){
        this.Transcation_id=Transcation_id;
        this.FromAccountNumber=FromAccountNumber;
        this.ToAccountNumber=ToAccountNumber;
        this.dateofTranscation=dateofTranscation;
        this.amount=amount;
    }
    public int getTranscation_id(){
        return Transcation_id;
    }
    public String getFromAccountNumber(){
        return FromAccountNumber;
    }
    public String getToAccountNumber(){
        return ToAccountNumber;
    }
    public java.sql.Date getDateofTranscation() {
        java.sql.Date sqldate= new java.sql.Date(dateofTranscation.getTime());
        return sqldate;
    }

    public float getAmount() {
        return amount;
    }
    public void setTranscation_id(int Transcation_id){
        this.Transcation_id=Transcation_id;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        FromAccountNumber = fromAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        ToAccountNumber = toAccountNumber;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDateofTranscation(Date dateofTranscation) {
        this.dateofTranscation = dateofTranscation;
    }

    @Override
    public String toString() {
        return "TransferBean{" +
                "Transcation_id=" + Transcation_id +
                ", FromAccountNumber=" + FromAccountNumber +
                ", ToAccountNumber='" + ToAccountNumber +
                ", dateofTranscation=" + dateofTranscation +
                ", amount=" + amount +
                '}';
    }
}
