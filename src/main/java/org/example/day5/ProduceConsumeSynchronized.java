//package org.example.day5;
//
//import java.util.*;
//
//public class ProduceConsumeSynchronized {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Started");
//        Buffer buffer = new Buffer(3);
//
//        List<Producer> producers = new ArrayList<>();
//        List<Consumer> consumers = new ArrayList<>();
//
//        Consumer c1 = new Consumer(buffer, 1);
//        Consumer c2 = new Consumer(buffer, 2);
//        Producer p1 = new Producer(buffer, 1);
//        Producer p2 = new Producer(buffer, 2);
//
//        c1.start();
//        c2.start();
//        p1.start();
//        p2.start();
//
//        c1.join();
//        c2.join();
//        p1.join();
//        p2.join();
//    }
//}
//
//
//
//
//class Buffer {
//    private ArrayList<Long> list = new ArrayList<>();
//    private final int bufferSize;
//
//    public Buffer(int bufferSize) {
//        this.bufferSize = bufferSize;
//    }
//
//    public synchronized void insert(long item, int prodId) throws InterruptedException {
//        while (list.size() == this.bufferSize){
//            System.out.println("BUFFER FULL :: Insert waiting for consumption");
//            wait();
//        }
//
//        System.out.println("Producer " + prodId + " Inserted Item " + item);
//        list.add(item);
//        System.out.println("ITEM COUNT :: " + list.size());
//
//        notifyAll();
//    }
//
//    public synchronized void extract(int consId) throws InterruptedException {
//        while(list.isEmpty()){
//            System.out.println("BUFFER EMPTY :: Extract waiting for production");
//            wait();
//        }
//
//        System.out.println("Consumer " + consId + " Consumed " + list.get(0));
//        list.remove(0);
//        System.out.println("ITEM COUNT :: " + list.size());
//
//        notifyAll();
//    }
//}
//
//class Producer extends Thread {
//    private final Buffer buffer;
//    private final int id;
//
//    public Producer(Buffer buffer, int id) {
//        this.buffer = buffer;
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            try {
//                this.buffer.insert(System.currentTimeMillis(), this.id);
//                sleep((long) (Math.random() * 1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//class Consumer extends Thread {
//    private final Buffer buffer;
//    private final int id;
//
//    public Consumer(Buffer buffer, int id) {
//        this.buffer = buffer;
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            try {
//                this.buffer.extract(this.id);
//                sleep((long) (Math.random() * 1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}