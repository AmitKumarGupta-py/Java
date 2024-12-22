package Day9;
import java.util.LinkedList;

class CustomQueue {
    private  LinkedList<String> queue = new LinkedList<>();
    private  int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
    }

    
    public synchronized void put(String item) {
        while (queue.size() == capacity) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace(); 
                 
            }
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); 
    }

    
    public synchronized String take() {
        while (queue.isEmpty()) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String item = queue.removeFirst();
        System.out.println("Consumed: " + item);
        notifyAll(); 
        return item;
    }
}

class Producer1 implements Runnable {
    private CustomQueue queue;

    public Producer1(CustomQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { 
            String item = "Item " + i;
            queue.put(item); 
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
        System.out.println("Producer has finished producing.");
    }
}

class Consumer1 implements Runnable {
    private CustomQueue queue;

    public Consumer1(CustomQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { 
            String item = queue.take(); 
            if (item != null) {
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }
            }
        }
        System.out.println("Consumer has finished consuming.");
    }
}

public class ProdConExam{
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(2); 

        Thread producerThread = new Thread(new Producer1(queue));
        Thread consumerThread = new Thread(new Consumer1(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join(); 
            consumerThread.interrupt(); 
            consumerThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }

        System.out.println("Producer and Consumer have finished execution.");
    }
}
