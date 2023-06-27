package com.kce.bus.service;

import com.kce.bus.bean.Bus_Reserve;
import com.kce.bus.dao.Bus_Booking;

public class Bus_Main {
public static void main(String[] args)
{
	Bus_Reserve br=new Bus_Reserve();
	br.getReserve();
	Bus_Booking bb=new Bus_Booking();
	bb.getBooking();
}
	

}
