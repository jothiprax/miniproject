package com.kce.bean;

public class Category {
		 private int id;
		    private String name;
		    
		    // Constructor 
		    public Category(int id, String name) {
		        this.id = id;
		        this.name = name;
		    }
		    
            // Getters and Setters  
		    public int getId() {
		        return id;
		    }

		    public String getName() {
		        return name;
		    }

			public void setId(int id) {
				this.id = id;
			}

			public void setName(String name) {
				this.name = name;
			}
			
			@Override
			public String toString() {
				return "Category [id=" + id + ", name=" + name + "]";
			}
	}
