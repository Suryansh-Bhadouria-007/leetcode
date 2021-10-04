package multithreading.reentrant.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++)
            count++;
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Waiting....");
            condition.await();
            System.out.println("Resumed");
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);

        lock.lock();
        System.out.println("Press the enter key");
        new Scanner(System.in).nextLine();
        System.out.println("Got the return key");
        condition.signal();
        try {
            increment();
        } finally {
            //comment this for the lock to never be released and used by the other thread
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}
