package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kce.bean.NewRegimeTaxCalculator;
import com.kce.util.DButil;

public class NewRegimeDao {
	public static void calculateNewRegimeTax(NewRegimeTaxCalculator tc) {
		try {
			Double taxableIncome=null; 
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("Select total_income from investments where username=?");
			stmt.setString(1, tc.getUsername());
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				taxableIncome=Double.parseDouble(rs.getString(1));
			}
			Double newRegTax = 0.0;
			if (taxableIncome <= 250000) {
				// No tax for income less than or equal to 250000
			} else if (taxableIncome <= 500000) {
				newRegTax = (taxableIncome - 250000) * (5.0 / 100);
			} else if (taxableIncome <= 750000) {
				newRegTax = 250000 * (5.0 / 100) + (taxableIncome - 500000) * (10.0 / 100);
			} else if (taxableIncome <= 1000000) {
				newRegTax = 250000 * (5.0 / 100) + 250000 * (10.0 / 100) + (taxableIncome - 750000) * (15.0 / 100);
			} else if (taxableIncome <= 1250000) {
				newRegTax = 250000 * (5.0 / 100) + 250000 * (10.0 / 100) + 250000 * (15.0 / 100) + (taxableIncome - 1000000) * (20.0 / 100);
			} else if (taxableIncome <= 1500000) {
				newRegTax = 250000 * (5.0 / 100) + 250000 * (10.0 / 100) + 250000 * (15.0 / 100) + 250000 * (20.0 / 100) + (taxableIncome - 1250000) * (25.0 / 100);
			} else {
				newRegTax = 250000 * (5.0 / 100) + 250000 * (10.0 / 100) + 250000 * (15.0 / 100) + 250000 * (20.0 / 100) + 250000 * (25.0 / 100) + (taxableIncome - 1500000) * (30.0 / 100);
			}
			tc.setNew_tax_regime(newRegTax);
			NewRegimeInsertDao.insertNewRegime(tc);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
