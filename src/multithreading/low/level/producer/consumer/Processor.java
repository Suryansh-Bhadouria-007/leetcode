package multithreading.low.level.producer.consumer;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
    LinkedList<Integer> list = new LinkedList<>();
    private int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            Random random = new Random();
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List.size = " + list.size());
                Integer taken = list.removeFirst();
                System.out.println("Element removed = " + taken);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}
