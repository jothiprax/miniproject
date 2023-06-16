package com.kce.bean;

public class MedicineDetails {
		private int Id;
		private String Name;
		private double Price;
		private int Quantity;
		public MedicineDetails(int id, String name, double price, int quantity) {
			super();
			Id = id;
			Name = name;
			Price = price;
			Quantity = quantity;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public String toString() {
			return "Medicines [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Quantity="
					+ Quantity + "]";
		}

	}
