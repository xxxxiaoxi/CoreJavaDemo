package org.example.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 4, 5));  // 2 3 4 5 3 5 6 -> even 2 4 6
//        List<Integer> res = list.stream().map(e -> e + 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
//        System.out.println(res);
//        Character[] array = new Character[] {'a', 'a', 'b', 'c'};
//        Map<Character, Integer> map = Arrays.stream(array).collect(Collectors.toMap(c -> c, c-> 1, (a, b)-> a+b));
//        System.out.println(map);
//        Map<Character, Integer> map1 = Arrays.stream(array).collect(Collectors.groupingBy(c -> c, Collectors.summingInt(e -> 1)));
//        System.out.println(map1);
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is created by extending Thread class!");
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is created by implementing Runnable interface!");
    }
}

class CallableThread implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " thread is created by implementing Callable interface");
        return 123;
    }
}
public class Day4Note {
    public static void main(String[] args) {
        ExecutorService tp1 = Executors.newFixedThreadPool(2);
        ExecutorService tp2 = Executors.newSingleThreadExecutor();
        ExecutorService tp3 = Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);









//        ExecutorService threadPool = new ThreadPoolExecutor(
//                2,
//                5,
//                2L,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(4),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardOldestPolicy()
//        );
//
//        for (int i = 1; i <= 10; i++) {
//            int cur = i;
//            threadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " is working on " + cur + " task");
//            });
//        }
//        threadPool.shutdown();





//        Thread t1 = new MyThread();
//        t1.start();
//
//        Thread t2 = new Thread(new RunnableThread());
//        t2.start();
//
//        FutureTask task = new FutureTask(new CallableThread());
//        Thread t3 = new Thread(task);
//        t3.start();
//        System.out.println(task.get());

//        List<Student> list = new ArrayList<>();
//        list.add(new Student("Achen", 18, 65));
//        list.add(new Student("Asss", 18, 95));
//        list.add(new Student("achen", 20, 55));
//        list.add(new Student("Dchen", 21, 45));
////        use stream api to find all the students’ name starting with ‘A’
//        List<String> names = list.stream().map(Student::getName).filter(e -> e.startsWith("A")).collect(Collectors.toList());
//        List<String> test = list.stream().filter(s -> s.getName().startsWith("A")).map(Student::getName).collect(Collectors.toList());
//        System.out.println("starting with ‘A’ : " + names);
////        use stream api to get the sum of all the students score
//        int sum = list.stream().map((Student::getScore)).mapToInt(e -> e).sum();
//        System.out.println("all the students score : " + sum);
////        use stream api to find all the students whose sore >= 60
//        List<String> names1 = list.stream().filter(s -> s.getScore() >= 60).map(Student::getName).collect(Collectors.toList());
//        System.out.println("students whose sore >= 60 : " + names1);
////        use stream api to retrieve all students name
//        List<String> names2 = list.stream().map(Student::getName).collect(Collectors.toList());
//        System.out.println("all students name : " + names2);
////        use stream api to count the frequency of each age
//        Map<Integer, Integer> map = list.stream().map(Student::getAge).collect(Collectors.toMap(c -> c, c -> 1, (a, b) -> a + b));
//        System.out.println("the frequency of each age : " + map);
    }
    static class Student {
        public String name;
        public int age;
        public int score;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getScore() {
            return score;
        }

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }
}

