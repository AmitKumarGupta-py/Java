package Day9;

public class MyArray {
    
    public static void main(String[] args) {
    char[] greeting = {'G','o','o','d',' ','M','o','r','n','i','n','g'};
    System.out.println(greeting);

        Thread t1 = new Thread11(greeting);
        Thread t2 = new Thread22(greeting);
        t1.start();
        t2.start();


    }
}
