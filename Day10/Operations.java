package Day10;

class Account {
    private double balance;
    public Account(double balance)
    {
        this.balance = balance;
    }
    public synchronized void  deposite(double amount)
    {
        if(amount>0)
        {
            balance += amount;
            System.out.println("Deposited: " + amount + "New balance " + balance);
            notifyAll();
        }
        else
        {
            System.out.println("Invalid deposit amount");
        }
    }

    public synchronized void withdraw(double amount)  throws InterruptedException
    {
            
            while (amount > balance) {
            System.out.println("\nWaiting to withdraw: " + amount + ", Current Balance: " + balance);
            wait(); 
        }
        if (amount > 0) {
            Thread.sleep(1000);
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    
    }

    
    public double getBalance()
    {
        return balance;
    }
}

class User extends Thread{
    private Account account;
    private boolean isdepositing = false;
    private double amount = 0;
    public User(Account account, boolean isdepositing,  double amount)
    {
        this.account = account;
        
        this.isdepositing = isdepositing;
        
        this.amount = amount;
    }


    @Override
public void run() {
    try{
    if (isdepositing) {
        account.deposite(amount);
    } else {
        account.withdraw(amount);
    }
}
    catch(InterruptedException e){
        e.printStackTrace();
    }
}

}





public class Operations {
public static void main(String[] args) {
    Account account = new Account(1000);

    User user1 = new User(account, true, 500);  
   User user2 = new User(account, false, 2000); 
   User user4 = new User(account, true, 500);
   User user3 = new User(account, false, 800); 
   
   User user5 = new User(account, true, 5000); 


    user1.start();
    user2.start();
    user4.start();  
    user3.start();
   try { 
    Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    user5.start();
    
    try {
        user1.join();
        user2.join();
        user4.join();
        user3.join();
        user5.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("Final Balance: " + account.getBalance());
}
}


