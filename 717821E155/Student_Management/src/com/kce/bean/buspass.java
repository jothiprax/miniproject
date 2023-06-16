package com.kce.bean;

public class buspass {

 private int id;
 private int busno;
 private double fees;
 private String source;

 public buspass(int id,int busno,double fees,String source) {
	 super();
	 this.id=id;
	 this.busno=busno;
	 this.fees=fees;
	 this.source=source;
    }
  public int getid() {
		 return id;
	 }
	 public void setid(int id) {
		 this.id=id;
	 }
	 public int getbusno() {
		 return busno;
	 }
	 public void setbusno(int busno) {
		 this.busno=busno;
	 }
	 public double getfees() {
		 return fees;
	 }
	 public void setfees(double fees) {
		 this.fees=fees;
	 }
 public String getsource() {
	 return source;
 }
 public void setsource(String source) {
	 this.source=source;
 }
 
 @Override
 public String toString() 
 {
 return "StudentInfo [id= "+id+",fees= "+fees+",busNo= "+busno+",source= "+source+"]";

}
}
