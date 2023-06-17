package com.kce.bean;

public class OldRegimeTaxCalculator extends TaxCalculator {
	private Double old_tax_regime;
	public OldRegimeTaxCalculator(String username, String assessment_year, String taxpayer, String mfs,
			String residential_status, String total_income) {
		super(username,assessment_year,taxpayer,mfs,residential_status,total_income);
	}
	public Double getOld_tax_regime() {
		return old_tax_regime;
	}
	public void setOld_tax_regime(Double old_tax_regime) {
		this.old_tax_regime = old_tax_regime;
	}
}
