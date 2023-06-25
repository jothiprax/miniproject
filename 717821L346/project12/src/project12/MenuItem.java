package project12;
import java.util.*;
public class MenuItem {
	    private int id;
	    private String name;
	    private double price;

	    public MenuItem(int id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

	    // Getters and setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    // toString method

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Price: " + price;
	    }
	}


