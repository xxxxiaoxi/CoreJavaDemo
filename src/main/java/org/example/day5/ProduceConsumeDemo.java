package org.example.day5;

import java.util.*;

/*
      producers  ->  [queue size = 3]   <- consumers
 */

public class ProduceConsumeDemo {
    public static void main(String[] args) {
        ProducerConsumerModel sharedObject = new ProducerConsumerModel();
        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();
        for (int i=1; i<=5; i++) producers.add(new Producer("producer-" + i, sharedObject));
        for (int i=1; i<=5; i++) consumers.add(new Consumer("consumer-" + i, sharedObject));

        for (Producer p: producers) p.start();
        for (Consumer c: consumers) c.start();

/*
        producer-1 put 15
        producer-3 put 31
        producer-4 put 71                 // queue size =  3, full
        producer-2 wait, queue is full
        producer-5 wait, queue is full
        consumer-1 take 15
        consumer-2 take 31
        consumer-3 take 71               // queue size = 0, empty
        consumer-4 wait, queue is empty
        consumer-5 wait, queue is empty
        producer-2 put 9
        producer-5 put 88                 // put 9, 88 into queue
        consumer-4 take 9
        consumer-5 take 88
 */

    }
}

class ProducerConsumerModel {
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 3;
    private Random myRandom = new Random();

    public void put() {
        synchronized (this) {
            try {
                while (queue.size() == capacity) {
                    System.out.println(Thread.currentThread().getName() + " wait, queue is full");
                    wait();
                }
                int tempValue = myRandom.nextInt(100);
                queue.offer(tempValue);
                System.out.println(Thread.currentThread().getName() + " put " + tempValue);
                notifyAll();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void take() {
        synchronized (this) {
            try {
                while (queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " wait, queue is empty");
                    wait();
                }
                int tempValue = queue.poll();
                System.out.println(Thread.currentThread().getName() + " take " + tempValue);
                notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producer extends Thread{
    private String name;
    ProducerConsumerModel pc;
    public Producer(String name, ProducerConsumerModel sharedObject) {
        super(name);
        pc = sharedObject;
    }

    @Override
    public void run() {
        pc.put();;
    }
}

class Consumer extends Thread {
    private String name;
    ProducerConsumerModel pc;
    public Consumer(String name, ProducerConsumerModel sharedObject) {
        super(name);
        pc = sharedObject;
    }
    @Override
    public void run() {
        pc.take();;
    }
}