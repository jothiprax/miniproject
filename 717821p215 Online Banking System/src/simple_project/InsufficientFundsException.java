package simple_project;

class InsufficientFundsException extends Exception 
{
    public InsufficientFundsException(String message) 
    {
        super(message);
    }
}