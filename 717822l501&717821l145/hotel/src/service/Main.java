package service;
import dao.HotelDAO;
import dao.HotelDAOInterface;
public class Main {
public static void main(String[]args)
{
	HotelDAO dao=new HotelDAO();
	do
	{
		System.out.println("****WELCOME****");
		System.out.println("Checking For Rooms...");
		dao.isRoomAvailable();
		System.out.println("****Thank You****");
	}while(true);
}
}
