package Day9;

class Thread111 extends Thread {
    private char[] greeting;

    public Thread111(char[] greeting) {
        this.greeting = greeting;
    }
/*public void printable(char[] a)
{
for (int i:a)
    System.out.println(a[i]);
}*/
    @Override
    public void run() {
        synchronized (greeting) {
         
            System.out.println("Thread1:  ");  
            for (char c : greeting) {
                System.out.print( c); 
                try {
                    Thread.sleep(350); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(); 
        }
    }
}

class Thread222 extends Thread {
    private char[] greeting;

    public Thread222(char[] greeting) {
        this.greeting = greeting;
    }

    @Override
    public void run() {
        synchronized (greeting) {
         
            System.out.println("Thread2:  "); 
            for (char c : greeting) {
                System.out.print(c); 
                try {
                    Thread.sleep(350); 
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
            System.out.println(); 
        }
    }
}

public class ArrayCopy {
    public static void main(String[] args) {
        char[] greeting = {'G', 'o', 'o', 'd', ' ', 'M', 'o', 'r', 'n', 'i', 'n', 'g'};
        System.out.println(greeting);

        Thread t1 = new Thread111(greeting);
        Thread t2 = new Thread222(greeting);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution.");
    }
}
