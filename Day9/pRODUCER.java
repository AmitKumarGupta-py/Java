package Day9;
import java.util.LinkedList;

class CustomQueue {
    private final LinkedList<String> queue = new LinkedList<>();
    private final int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method to add an item to the queue
    public synchronized void put(String item) {
        while (queue.size() == capacity) {
            try {
                wait(); // Wait if the queue is full
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                return; // Exit if interrupted
            }
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify consumers that an item has been added
    }

    // Synchronized method to remove an item from the queue
    public synchronized String take() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait if the queue is empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                return null; // Exit if interrupted
            }
        }
        String item = queue.removeFirst();
        System.out.println("Consumed: " + item);
        notifyAll(); // Notify producers that an item has been removed
        return item;
    }
}

class Producer1 implements Runnable {
    private final CustomQueue queue;

    public Producer1(CustomQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { // Producing 10 items
            String item = "Item " + i;
            queue.put(item); // Add item to the queue
            try {
                Thread.sleep(500); // Simulate time taken to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        System.out.println("Producer has finished producing.");
    }
}

class Consumer1 implements Runnable {
    private final CustomQueue queue;

    public Consumer1(CustomQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { // Consuming 10 items
            String item = queue.take(); // Retrieve and remove the item from the queue
            if (item != null) {
                try {
                    Thread.sleep(1000); // Simulate time taken to consume
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            }
        }
        System.out.println("Consumer has finished consuming.");
    }
}

public class ProducedConsumer implements Runnable {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(2); // Size of the queue

        Thread producerThread = new Thread(new Producer1(queue));
        Thread consumerThread = new Thread(new Consumer1(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join(); // Wait for the producer to finish
            consumerThread.interrupt(); // Interrupt the consumer to exit
            consumerThread.join(); // Wait for the consumer to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        System.out.println("Producer and Consumer have finished execution.");
    }
}
