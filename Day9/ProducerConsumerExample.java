package Day9;
import java.util.LinkedList;
import java.util.Scanner;

class SimpleQueue {
    private final LinkedList<String> queue = new LinkedList<>();
    private final int capacity;

    public SimpleQueue(int capacity) {
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

class Producer implements Runnable {
    private final SimpleQueue queue;

    public Producer(SimpleQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a value (type 'exit' to quit): ");
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    break; // Exit the loop if the user types 'exit'
                }

                queue.put(input); // Add input to the queue
            }
        } finally {
            System.out.println("Producer has finished execution.");
        }
    }
}

class Consumer implements Runnable {
    private final SimpleQueue queue;

    public Consumer(SimpleQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = queue.take(); // Retrieve and remove the item from the queue
                if (item == null) {
                    break; // Exit if interrupted
                }
                // Simulate processing
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            System.out.println("Consumer has finished execution.");
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(1); // Size of 1

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join(); // Wait for the producer to finish
            consumerThread.interrupt(); // Interrupt the consumer to exit after producer finishes
            consumerThread.join(); // Wait for the consumer to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        System.out.println("Producer and Consumer have finished execution.");
    }
}
