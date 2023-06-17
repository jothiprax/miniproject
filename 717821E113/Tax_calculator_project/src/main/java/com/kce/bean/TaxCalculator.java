package com.kce.bean;

public class TaxCalculator {
	private String username;
	private String assessmentyear;
	private String taxpayer;
	private String mfs;
	private String residential_status;
	private String total_income;
	public TaxCalculator(String username,String assessmentyear, String taxpayer, String mfs, String residential_status,
			String total_income) {
		super();
		this.username = username;
		this.assessmentyear = assessmentyear;
		this.taxpayer = taxpayer;
		this.mfs = mfs;
		this.residential_status = residential_status;
		this.total_income = total_income;
	}
	public String getAssessmentyear() {
		return assessmentyear;
	}
	public void setAssessmentyear(String assessmentyear) {
		this.assessmentyear = assessmentyear;
	}
	public String getTaxpayer() {
		return taxpayer;
	}
	public void setTaxpayer(String taxpayer) {
		this.taxpayer = taxpayer;
	}
	public String getMfs() {
		return mfs;
	}
	public void setMfs(String mfs) {
		this.mfs = mfs;
	}
	public String getResidential_status() {
		return residential_status;
	}
	public void setResidential_status(String residential_status) {
		this.residential_status = residential_status;
	}
	public String getTotal_income() {
		return this.total_income;
	}
	public void setTotal_income(String total_income) {
		this.total_income = total_income;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "taxcalculator [assessmentyear=" + assessmentyear + ", taxpayer=" + taxpayer + ", mfs=" + mfs
				+ ", residential_status=" + residential_status + ", total_income=" + total_income + "]";
	}
}
