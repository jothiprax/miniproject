package com.kce.bean;

public class Doctor {
      private String name;
      private int id;
      private String domain;
      public Doctor() {
    	  
      }
	public Doctor(String name, int id, String specialization) {
		super();
		this.name = name;
		this.id = id;
		this.domain = specialization;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id2) {
		this.id = id2;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", id=" + id + ", specialization=" + domain + ", getName()=" + getName()
				+ ", getId()=" + getId() + ", getDomain()=" + getDomain() + "]";
	}
      
}