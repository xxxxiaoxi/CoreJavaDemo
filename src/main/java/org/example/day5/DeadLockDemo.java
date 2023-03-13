package org.example.day5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
    public static void main(String[] args) {

        Lock lockA = new ReentrantLock();
        Lock lockB = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                lockA.lock();
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // thread 1 is waiting for thread 2 release lock
                lockB.lock();
                System.out.println("Thread 1: locked resource 2");
                lockA.unlock();
                lockB.unlock();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                lockB.lock();
                System.out.println("Thread 2: locked resource 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // thread 2 is waiting for thread 1 release lock
                lockA.lock();
                System.out.println("Thread 2: locked resource 1");
                lockA.unlock();
                lockB.unlock();
            }
        };

        t1.start();
        t2.start();
    }
}