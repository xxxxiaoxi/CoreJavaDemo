package org.example.day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Day5Note {
    private static Integer num = 1;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main thread starts, the num initial as 1");
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("start adding 10 to number");
            num += 10;
            return num;
        }).thenApply(val -> val * 4)
          .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return 404;
                })
          .handle((val, ex) -> {
            System.out.println("get into the handle method");
            if (ex == null) {
                System.out.println("task is done");
                return val;
            } else {
                System.out.println("exception thrown" + ex.getMessage());
                return 400;
            }
        }).thenAcceptAsync(val -> {
                    System.out.println("this is the last step from mian thread");
                    System.out.println("result: " + val);
                });
        System.out.println("task result: " + future.get());
        System.out.println("main thread ends");


//exception
//        System.out.println("main thread starts");
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int result = 1 / 0;
//            System.out.println("add 10 to num");
//            num += 10;
//            return num;
//        }).exceptionally(ex -> {
//            System.out.println(ex.getMessage());
//            return 404;
//        });
//        System.out.println("task result: " + future.get());
//        System.out.println("main thread ends");






//with return
//        System.out.println("main thread starts");
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("child thread starts working");
//                Thread.sleep(3000);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return "child thread is done";
//        });
//        System.out.println("task result: " + future.get());
//        System.out.println("main thread ends");








//without return
//        System.out.println("main thread starts");
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                System.out.println("child thread starts working");
//                Thread.sleep(500);
//                System.out.println("child thread done");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//        future.get();// the main thread will block here, until new thread return the result to the get method
//        System.out.println("main thread ends");
    }
}
