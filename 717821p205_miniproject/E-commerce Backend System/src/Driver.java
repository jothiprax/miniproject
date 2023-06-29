import java.util.*;
public class Driver {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Datastore d = new Datastore();
        String opt = "yes";
        while(opt == "yes"){
            System.out.println("WELCOME to speedycart");
            System.out.println("Press 1 to login.");
            System.out.println("Press 2 to order.");
            System.out.println("Press 3 to display Orderdetails.");
            System.out.println("Press 4 to display userdetails.");
            System.out.println("Press 5 to display productdetails.");
            System.out.println("Press 6 to Add products in the website.");
            System.out.println("press 0 to exit the application.");
            int s=sc.nextInt();
            if(s == 1){
    d.Userlogin();
}
else if(s == 2){
            d.Order();
        }
        else if(s == 3){
            d.showorderdetails();
        }
        else if(s == 4){
            d.showuserdetails();
        }else if(s == 5){
            d.showproductdetails();
        }
        else if(s== 6){
            d.Insertproducts();
        }
       else if(s == 0){
        System.out.println("Thank you for Using speedycart , Visit Again!!!");
        break;
       }
    }
}
}
