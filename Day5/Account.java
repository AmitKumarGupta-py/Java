package Day5;


import java.lang.Exception;


public class Account {

    protected int balance = 10000;
    protected int noOfTransactions = 3;
    protected int amt;
    protected int count = 0;

    public void deposite(int amt)
    {
        
        try {
            if(amt%100 !=0 | amt%500 != 0 | amt%2000 != 0)
            {
                throw new IncorrectDenominationException("\nIncorrect Denomination of amount you are trying to deposite");
            }
            else
                {
                    System.out.println("\nSucessfully Deposited");
        }
        }
        catch(IncorrectDenominationException e)
            {
                System.out.println(e.getMessage());
            }
    }

    public void withdraw(int amt)
    {
        
        try{
            if(amt > balance)
            {
                throw new InsufficientFundException("\nAccount Balance is lower than the amount you want to withdraw ");
            }
            else if(count > noOfTransactions)
            {
                throw new TransactionLimitExceededException("\nYou reached the Transaction Limit");
            }
        else
            count++;
            System.out.println("\nAmount is Withdrawn!");
            
        
        }
        catch(InsufficientFundException e)
            {
                System.out.println(e.getMessage());
            }

        catch(TransactionLimitExceededException e)
            {
                System.out.println(e.getMessage());
            }
    }

    public static void main(String[] args) {
        
        Account a = new Account();
        a.deposite(3455);
        a.withdraw(300);
        a.withdraw(400);
        a.withdraw(500);
        a.withdraw(600);

    }
    
}
