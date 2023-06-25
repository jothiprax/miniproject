package com.RKFoodOrder.dao;
import java.util.List;

import com.RKFoodOrder.bean.Ordered_list;
public class Ordered_listDAO {
public double final_price(int quantity,double price) {
	return quantity * price;
}
public double total(List<Ordered_list> ol) {
	double sum=0;
   for(Ordered_list o:ol) {
	   sum+=o.getPrice();
   }
return sum;
}
public double discount_amt(List<Ordered_list> ol) {
	double sum=0;
	   for(Ordered_list o:ol) {
		   sum+=o.getPrice();
	   }
	if(sum >=500 ) return sum*0.05;
	else if (sum>=500 && sum<=1000) return sum*0.1;
	else return 0;
}
}
