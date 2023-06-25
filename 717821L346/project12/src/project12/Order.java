package project12;
import java.util.ArrayList;
import java.util.List;
public class Order {
	    private int id;
	    private String customerName;
	    private List<MenuItem> items;

	    public Order(int id, String customerName) {
	        this.id = id;
	        this.customerName = customerName;
	        this.items = new ArrayList<>();
	    }

	    // Getters and setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public List<MenuItem> getItems() {
	        return items;
	    }

	    public void setItems(List<MenuItem> items) {
	        this.items = items;
	    }

	    // Methods to add and remove items from the order

	    public void addItem(MenuItem item) {
	        items.add(item);
	    }

	    public void removeItem(MenuItem item) {
	        items.remove(item);
	    }

	    // toString method

	    @Override
	    public String toString() {
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("Order ID: ").append(id).append(", Customer Name: ").append(customerName).append("\n");
	        stringBuilder.append("Order Items:\n");
	        for (MenuItem item : items) {
	            stringBuilder.append(item.toString()).append("\n");
	        }
	        return stringBuilder.toString();
	    }
	}
