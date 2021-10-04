package multithreading.deadlock;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    Account acc1 = new Account();
    Account acc2 = new Account();

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock firstLock, Lock secondLock) {
        while (true) {
            //Try to acquire locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                //if got both locks return
                if (gotFirstLock && gotSecondLock)
                    return;
                //else relinquish locks acquired
                if (gotFirstLock)
                    firstLock.unlock();
                if (gotSecondLock)
                    secondLock.unlock();
            }
            //Wait for locks to be available
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            acquireLocks(lock2, lock1);
            //if the lock here is acquired first on lock2 and then on lock1 there is a chance for deadlock;
            // ways to avoid deadlock-
            // 1. always acquire locks in teh same order
            // 2. use a method called tryLock of reentrantLock to get lock and handle deadlock scenario gracefully
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}
