package com.kce.textile.bean;

public class CalculateBean 
{
	String detail;
	double yarn;
	double warp;
	double balanceYarn;
	double balanceWarp;
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getYarn() {
		return yarn;
	}
	public void setYarn(double yarn) {
		this.yarn = yarn;
	}
	public double getWarp() {
		return warp;
	}
	public void setWarp(double warp) {
		this.warp = warp;
	}
	public CalculateBean(String detail, double yarn, double warp) {
		super();
		this.detail = detail;
		this.yarn = yarn;
		this.warp = warp;
	}
	
}
