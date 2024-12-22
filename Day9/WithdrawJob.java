package Day9;
import static java.lang.Thread.currentThread;

public  class WithdrawJob implements Runnable {
    Account acc = new Account(10000);

    public synchronized void withdraw(int amount)
    {
        if(acc.getBalance() >= amount)
        {
            System.out.println(currentThread().getName() + " is ready to withdraw");
            System.out.println(currentThread().getName() + " is sleeping");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println(currentThread().getName() + " wake up");
            acc.withdraw(amount);
            System.out.println(currentThread().getName() + " withdrew successfully");
            System.out.println("Remaining balance: " + acc.getBalance());
        }
        else    
            System.out.println(currentThread().getName() + "  doesn't have enough balance to withdraw");

    }

    @Override
    public void run() {
       for(int i = 0; i <3; i++) {
        withdraw(2000);
   
    }
    
}
}   
