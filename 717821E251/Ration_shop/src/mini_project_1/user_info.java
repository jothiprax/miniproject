package mini_project_1;

public class user_info 
{
	private int aadharNo;
	private int rationNo;
	private String name;

 user_info(int aadharNo,int rationNo,String name)
 {
	 this.aadharNo=aadharNo;
	 this.rationNo=rationNo;
	 this.name=name;
 }
 public int getAadharNo()
 {
	 return aadharNo;
 }
 public int getRationNo()
 {
	 return rationNo;
 }
 public String getName()
 {
	 return name;
 }
}