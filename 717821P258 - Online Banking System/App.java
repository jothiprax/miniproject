import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        OnlineBanking ob = new OnlineBanking(1);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(
                    "=====================================\nWelcome to Online Banking :)\n=====================================");
            while (true) {
                System.out.println("=================");
                System.out.println("1.Register");
                System.out.println("2.Login");
                System.out.println("3.Withdraw");
                System.out.println("4.Deposit");
                System.out.println("5.Check Balance");
                System.out.println("6.Account details");
                System.out.println("7.Transfer amount");
                System.out.println("8.Logout");
                System.out.println("9.Exit");
                System.out.println("=================");
                System.out.print("Enter your choice:");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        ob = new OnlineBanking();
                        System.out.print("Enter the user name:");
                        String userName = sc.nextLine();
                        System.out.print("Enter the password:");
                        String password = sc.nextLine();
                        ob.registerUser(userName, password);
                        break;
                    case 2:
                        System.out.print("Enter the user name:");
                        userName = sc.nextLine();
                        System.out.print("Enter the password:");
                        password = sc.nextLine();
                        ob.logIn(userName, password);
                        break;
                    case 3:
                        System.out.print("Enter the user name:");
                        userName = sc.nextLine();
                        System.out.print("Enter the amount:");
                        double amount = sc.nextDouble();
                        ob.withdraw(userName, amount);
                        break;
                    case 4:
                        System.out.print("Enter the user name:");
                        userName = sc.nextLine();
                        System.out.print("Enter the amount:");
                        amount = sc.nextDouble();
                        ob.deposit(userName, amount);
                        break;
                    case 5:
                        System.out.print("Enter the user name:");
                        userName = sc.nextLine();
                        ob.checkBalance(userName);
                        break;
                    case 6:
                        System.out.print("Enter the user name:");
                        userName = sc.nextLine();
                        ob.accountDetails(userName);
                        break;
                    case 7:
                        System.out.println("Enter the username for sender account:");
                        String senderUserName = sc.nextLine();
                        System.out.println("Enter user namename for the receiver account:");
                        String receiverUserName = sc.nextLine();
                        System.out.println("Enter the amount to deposit in the " + receiverUserName + " account:");
                        amount = sc.nextDouble();
                        ob.transfer(senderUserName, receiverUserName, amount);
                        break;
                    case 8:
                        ob.logOut();
                        break;
                    case 9:
                        System.out.println("\nThank you. Visit again :)\n");
                        System.exit(0);
                        break;
                }
            }
        }
    }
}