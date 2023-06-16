package com.kce.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	import com.kce.bean.MedicineDetails;
	import com.kce.util.DBUtil;

	public class MedicineDetailsDao {
		static Scanner sc = new Scanner(System.in);

		public static void insertValues(int temp) {
			try {
				int noOfMedicines =temp;
				MedicineDetails[] arr=new MedicineDetails[noOfMedicines];
				for(int i=0;i<noOfMedicines;i++) {
					System.out.println("Enter Id:");
					int Id=sc.nextInt();
					System.out.println("Enter Name:");
					String Name=sc.next();
					System.out.println("Enter Price:");
					double Price=sc.nextDouble();
					System.out.println("Enter Quantity:");
					int Quantity=sc.nextInt();
					arr[i]=new MedicineDetails(Id,Name,Price,Quantity);
				}

				Connection con = DBUtil.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO medicine VALUES (?, ?, ?, ?, ?)");
				for (int i = 0; i < temp; i++) {
					pst.setInt(1,arr[i].getId());
					pst.setString(2, arr[i].getName());
					pst.setDouble(3, arr[i].getPrice());
					pst.setInt(4, arr[i].getQuantity());
					pst.executeUpdate();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		public static void deleteTable() {
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				st.executeUpdate("DROP TABLE medicine");
				System.out.println("Table is Dropped");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		public static void deleteRows() {
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				st.executeUpdate("TRUNCATE TABLE medicine");
				System.out.println("Table Record is Deleted");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		public static void updateRecord() {
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				String str, data;
				int choice, id;
				System.out.println("Enter the ID to Update");
				id = sc.nextInt();
				ResultSet rs = st.executeQuery("SELECT * FROM medicine");
				ResultSetMetaData rsMetaData = rs.getMetaData();
				int columnCount = rsMetaData.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					System.out.println(i + ". " + rsMetaData.getColumnName(i));
				}
				System.out.println("Enter the Choice:");
				choice = sc.nextInt();
				sc.nextLine(); 
				str = rsMetaData.getColumnName(choice);
				System.out.println("Enter the new data:");
				data = sc.nextLine();
				String updateQuery = "UPDATE medicine SET " + str + " = ? WHERE id = ?";
				PreparedStatement updateStmt = con.prepareStatement(updateQuery);
				updateStmt.setString(1, data);
				updateStmt.setInt(2, id);
				int rowsAffected = updateStmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Record updated successfully.");
				} else {
					System.out.println("No record found with the specified ID.");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		public static void buyMedicine() {
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM medicine");
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String barcode = rs.getString(3);
					double price = rs.getDouble(4);
					int quantity = rs.getInt(5);
					System.out.println("ID: " + id);
					System.out.println("Name: " + name);
					System.out.println("Barcode: " + barcode);
					System.out.println("Price: " + price);
					System.out.println("Quantity: " + quantity);
				}
				System.out.println("Enter No of Medicines You want to Buy");
				int noOfMedicines =sc.nextInt();
				System.out.println("Enter the ID And Quantity of the medicine you want to buy:\n\n");
				int medicineId=0;
				int quantityToBuy=0;
				List<Integer> l=new ArrayList<>();
				List<Integer> q=new ArrayList<>();
				for(int i=0;i<noOfMedicines;i++) {
					System.out.println("Enter ID:");
					medicineId = sc.nextInt();
					l.add(medicineId);
					System.out.println("Enter the quantity:");
					quantityToBuy = sc.nextInt();
					q.add(quantityToBuy);
				}

				List<Double> price=new ArrayList<>();
				for(int i=0;i<l.size();i++) {
					PreparedStatement updateStmt = con.prepareStatement("Select Price from medicine Where id=?");
					updateStmt.setInt(1,l.get(i));
					ResultSet rst = updateStmt.executeQuery();
					while(rst.next()) {
						price.add(rst.getDouble(1));

					}
				}
				double Total =0;
				System.out.println("Bill is Generating");


				for(int i=0;i<l.size();i++) {
					System.out.println("Price of Medicine ID: "+l.get(i)+" Of Quantity "+q.get(i)+" = "+price.get(i)*q.get(i));
					Total=Total+price.get(i)*q.get(i);
				}
				System.out.println("Total Price Of Medicines ="+Total);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}