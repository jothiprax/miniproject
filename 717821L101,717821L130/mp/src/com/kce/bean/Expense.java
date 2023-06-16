package com.kce.bean;

	public class Expense extends ExpenseTracker{
		    private int categoryId;
		    private String description;
		    
            // Constructor
		    public Expense(double amount, String date, int category, String description) {
		        super(amount, date);
		        this.categoryId = category;
		        this.description = description;
		    }
		    
            // Getters and Setters 
		    public void setCategoryId(int categoryId) {
				this.categoryId = categoryId;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public int getCategoryId() {
		        return categoryId;
		    }

		    public String getDescription() {
		        return description;
		    }

			@Override
			public String toString() {
				return "Expense [categoryId=" + categoryId + ", description=" + description + "]";
			}
		}
