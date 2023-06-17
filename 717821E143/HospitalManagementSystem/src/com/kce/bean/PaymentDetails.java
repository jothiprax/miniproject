package com.kce.bean;

public class PaymentDetails extends DischargeDetails {
	public String disease;
	public String testsRequired;
	public int totalCost;
	//CONSTRUCTOR
	public PaymentDetails() {
		super();
	}
	
	public PaymentDetails(int admission_no, String name, String blood_group, String disease, String dateOfJoin,
			String dateOfDischarge,String testsRequired,int totalCost) {
		super(admission_no, name, blood_group, disease, dateOfJoin, dateOfDischarge);
		this.testsRequired=testsRequired;
		this.totalCost=totalCost;
	}
	//GETTER AND SETTER
	public String getDisease() {
		return disease;
	}
	
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getTestsRequired() {
		return testsRequired;
	}
	public void setTestsRequired(String tests_required) {
		this.testsRequired = tests_required;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int total_cost) {
		this.totalCost = total_cost;
	}
	//TOSTRING METHOD
	@Override
	public String toString() {
		return "PaymentDetails [disease=" + disease + ", testsRequired=" + testsRequired + ", totalCost="
				+ totalCost + "]";
	}
	
}
