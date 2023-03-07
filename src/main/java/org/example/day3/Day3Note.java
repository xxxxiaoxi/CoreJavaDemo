package org.example.day3;

import org.example.exception.UserNotFoundException;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.*;

class Node <K, V> {
    K key;
    V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
@FunctionalInterface
interface Square {
    int calculate(int x);
    public default void sayOne() {
        System.out.println("1");
    }
    default void sayTwo() {
        System.out.println("2");
    }

}
public class Day3Note {
    public static <E> E getFirstElement(E[] array) {
        return array[0];
    }

    public static void main(String[] args)  {


//        if (array[0] == null) {
//            throw new IllegalArgumentException("the value is null");
//        } else {
//            System.out.println(array[0]);
//        }
        Integer[] array = new Integer[2];
        Integer[] array1 = new Integer[]{1, 2};
        Integer a = null;
        Optional opt = Optional.ofNullable(array1[0]);
       opt.empty();
//        System.out.println(opt.orElse("the value is null"));
//        opt.orElseThrow(() -> new IllegalArgumentException("the value is null"));

//        Optional opt1 = Optional.ofNullable(array1[0]);
//        System.out.println(opt1.orElse("the value is null"));
//        opt.orElseThrow(() -> new IllegalArgumentException("the value is null"));



//        BiFunction<Integer, Integer, Integer> myAdd = (a, b) -> a + b;
//        System.out.println(myAdd.apply(1, 2));
//
//        Predicate<Integer> myPre = (a) -> a == 1;
//        System.out.println(myPre.test(2));
//
//        Function<Integer, Integer> addOne = a -> a + 1;
//        System.out.println(addOne.apply(4));
//
//        Supplier<Boolean> addSup = () -> true;
//        System.out.println(addSup.get());
//
//        Consumer<String> addCon = (a) -> {
//            System.out.println(a);
//        };
//        addCon.accept("Hello, Chenxi!");
//    int a = 5;
//    Square s = (int x) -> x * x;
//    System.out.println(s.calculate(a));
//    s.sayOne();
//    s.sayTwo();

//    Set<Integer> treeSet1 = new TreeSet<>((a, b) -> Integer.compare(b, a)); // descending
//    Set<Integer> treeSet2 = new TreeSet<>((a, b) -> b - a);// descending  maybe overflow

//        Integer[] intArray = new Integer[]{1, 2, 4};
//        Character[] charArray = new Character[]{'a', 'b', 'c'};
//        System.out.println(getFirstElement(intArray));
//        System.out.println(getFirstElement(charArray));
//
//
//        Node<Integer, String> node1 = new Node<>(1, "chenxi");
//        Node<Double, Character> node2 = new Node<>(2.0, 'c');


//        try {
//            int[] array = new int[1000 * 10000 * 10000];
//        } catch (OutOfMemoryError oome) {
//            oome.printStackTrace();
//            System.err.println("Array size too large");
//            System.err.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
//        }



//        try (
//                BufferedReader br = new BufferedReader(new FileReader("src/main/resources/test.txt"))
//        )
//        {
//            System.out.println(br.readLine());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        try {
//            FileInputStream input = new FileInputStream("/");
//        } catch(UserNotFoundException | NullPointerException | ArithmeticException | FileNotFoundException ex) {
//            System.out.println(ex);
//        }
//        try {
//            int a = 1 / 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//
//        }
//        throw new UserNotFoundException("id 1");
    }
//    public static void main(String[] args)  {
//        try {
//            fileReader("/");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void fileReader(String path) throws FileNotFoundException{
//    }
}


