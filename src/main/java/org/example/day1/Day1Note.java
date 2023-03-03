package org.example.day1;

import java.util.*;

public class Day1Note {
    public static void main(String[] args) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b,a));
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println(maxHeap.stream().findFirst().get());

        Set<Node> set = new TreeSet<>(new MyComparator());
//        Set<Node> set = new TreeSet<>((a, b) -> Integer.compare(a.x, b.x));
        set.add(new Node(1, 1));
        set.add(new Node(2, 2));
        set.add(new Node(3, 3));
        set.add(new Node(4, 4));
        System.out.println(set.stream().findFirst().get().x); //

    }
    static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o2.x, o1.x);
        }
    }
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
//        @Override
//        public int compareTo(Node o) {
//            return Integer.compare(o.x, this.x);
//        }
    }
}
