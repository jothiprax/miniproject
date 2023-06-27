package simple_project;

//Child class CheckingAccount
class CheckingAccount extends BankAccount 
{
 private double overdraftLimit;

 public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) 
 {
     super(accountNumber, accountHolder, balance);
     this.overdraftLimit = overdraftLimit;
 }

 @Override
 public void withdraw(double amount) throws InsufficientFundsException 
 {
     if (amount <= balance + overdraftLimit) {
         balance -= amount;
         System.out.println("Withdrawal successful. New balance: " + balance);
     } else {
         throw new InsufficientFundsException("Exceeded overdraft limit.");
     }
 }
}
