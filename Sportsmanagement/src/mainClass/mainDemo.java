package mainClass;

import java.util.Scanner;
import com.kce.dao.GamesDao;
import com.kce.dao.Sports;
import com.kce.dao.StaffDao;
import com.kce.dao.StudentDao;

import sports.Games;
import sports.Student;

public class mainDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		Sports sp=new Sports();
		Student stu=new Student();
		Games ga=new Games();

	sp.insert(a);
	    sp.update();
		sp.delete();
		sp.displayTable();
		stu.insert(a);
		stu.update();
		stu.delete();
		stu.displayTable();
		ga.insert(a);
	    ga.update();
		ga.delete();
		ga.displayTable();
		sc.close();


	}

}
