package simple_project;

class SavingsAccount extends BankAccount 
{
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) 
    {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() 
    {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest applied. New balance: " + balance);
    }
}