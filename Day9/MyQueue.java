package Day9;

public class MyQueue {
    int value;
    boolean hasvalue = false;
    public synchronized void setValue(int value) {
        if(hasvalue)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        hasvalue = true;
        notify();
        System.out.println("Set value: " + value);
    
}

    public synchronized void getValue() {
        if(!hasvalue)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get value: " + value);
        hasvalue = false;
        notify();
    }
    
}
