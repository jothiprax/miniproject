
import java.util.Scanner;
public class Hotel {
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            HotelServies hotelServies=new HotelServies("ABCD","some","9922342342");
            hotelServies.display();
            VegMenu vegMenu=new VegMenu();
            NonVegMenu nonVegMenu=new NonVegMenu();
      // vegMenu.Insert_veg();
            System.out.println("Please choose your menuType "+"\n"+"vegetarian menu --> veg"+"\n"+"Non-Vegetarian menu --> nonveg.");
            System.out.print("Enter the Menu Type:");
            String menuType=sc.nextLine();
            if(menuType.equals("veg")) {
                System.out.println("Food available in the our shop for vegetarian Menu :");
                vegMenu.display();
                boolean b=true;
                int sum=0;
                while(b)
                {
                    System.out.println("choose 1 for continuing the ordering (or) choose 2 for stop the ordering:");
                    int n=sc.nextInt();
                    switch (n)
                    {
                        case 1:
                            System.out.println("Please! Enter the Food Order:");
                            sc.nextLine();
                            String product=sc.nextLine();
                            System.out.println("please! Enter number of quantity you want:");
                            int qua=sc.nextInt();
                            sum=sum+vegMenu.calculate(product,qua)*qua;
                            break;
                        case 2:
                            b=false;
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                System.out.println("Total Bill amount for your order:"+sum);
                RateingAndFeedback r=new RateingAndFeedback();
                r.feed();
            }
            else if (menuType.equals("nonveg"))
            {

                System.out.println("Food available in the our shop for non-vegetarian menu");
                nonVegMenu.display();
                boolean b=true;
                int sum=0;
                while(b)
                {
                    System.out.println("choose 1 for continuing the ordering (or) choose 2 for stop the ordering");
                    int n=sc.nextInt();
                    switch (n)
                    {
                        case 1:
                            System.out.println("Please! Enter the Food Name:");
                            sc.nextLine();
                            String product=sc.nextLine();
                            System.out.println("please! Enter number of quantity you want:");
                            int qua=sc.nextInt();
                            sum=sum+ nonVegMenu.calculate(product,qua)*qua;
                            break;
                        case 2:
                            RateingAndFeedback r=new RateingAndFeedback();
                            r.feed();
                            b=false;
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                System.out.print("Total Bill amount for your order:"+sum);
            }
        }
    }
}