package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kce.bean.OldRegimeTaxCalculator;

import com.kce.util.DButil;

public class OldRegimeDao {
	public static void calculateOldRegimeTax(OldRegimeTaxCalculator tc) {
		try {
			Double taxableIncome=0.0;
			Connection con = DButil.getConnection();
			PreparedStatement stmt = con.prepareStatement("Select total_income from investments where username=?");
			stmt.setString(1, tc.getUsername());
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				taxableIncome=Double.parseDouble(rs.getString(1));
			}
			//Double slabRateRange1 = 0.0;
			Double slabRateRange2 = 5.0 / 100;
			Double slabRateRange3 = 20.0 / 100;
			Double slabRateRange4 = 30.0 / 100;
			Double oldRegTax = 0.0;
			if (taxableIncome <= 250000) {
				// No tax for income less than or equal to 250000
			} else if (taxableIncome <= 500000) {
				oldRegTax = (taxableIncome - 250000) * slabRateRange2;
			} else if (taxableIncome <= 1000000) {
				Double slab1 = 250000.0 * slabRateRange2;
				Double slab2 = (taxableIncome - 500000) * slabRateRange3;
				oldRegTax = slab1 + slab2;
			} else {
				Double slab1 = 250000.0 * slabRateRange2;
				Double slab2 = 500000.0 * slabRateRange3;
				Double slab3 = (taxableIncome - 1000000) * slabRateRange4;
				oldRegTax = slab1 + slab2 + slab3;
			}
			tc.setOld_tax_regime(oldRegTax);
		}catch(Exception e) {
			System.out.println(e);
		}
		OldRegimeInsertDao.insertOldRegime(tc);
	}
}
