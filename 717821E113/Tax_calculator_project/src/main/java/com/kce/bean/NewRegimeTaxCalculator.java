package com.kce.bean;

public class NewRegimeTaxCalculator extends TaxCalculator {
	private Double new_tax_regime;
	public NewRegimeTaxCalculator(String username, String assessment_year, String taxpayer, String mfs,
			String residential_status, String total_income) {
		super(username,assessment_year,taxpayer,mfs,residential_status,total_income);
	}
	public Double getNew_tax_regime() {
		return new_tax_regime;
	}
	public void setNew_tax_regime(Double new_tax_regime) {
		this.new_tax_regime = new_tax_regime;
	}

}
