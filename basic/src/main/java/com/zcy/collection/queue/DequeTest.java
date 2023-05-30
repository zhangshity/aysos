package com.zcy.collection.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DequeTest {
    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();
        deque.offer("2");
        deque.offerFirst("1");
        deque.offerLast("3");
        System.out.println(deque); //[1, 2, 3]


        System.out.println(deque.peekFirst()); //1
        System.out.println(deque.peekLast()); //3
        System.out.println(deque); //[1, 2, 3]

        System.out.println(deque.pollFirst()); // 1
        System.out.println(deque.pollLast()); // 3
        System.out.println(deque); //[2]

    }
}
