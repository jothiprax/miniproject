package com.kce.bean;

	public class ExpenseTracker{
		    private double amount;
		    private String date;
		    
		    // Constructors
		    public ExpenseTracker(double amount, String date){
		        this.amount = amount;
		        this.date = date;
		    }
		    
		    // Getters and Setters
		    public void setAmount(double amount) {
				this.amount = amount;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public double getAmount() {
		        return amount;
		    }
		    public String getDate() {
		        return date;
		    }
		    
		    @Override
			public String toString() {
				return "Transaction [amount=" + amount + ", date=" + date + "]";
			}
		}

