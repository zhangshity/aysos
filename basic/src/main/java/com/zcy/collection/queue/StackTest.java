package com.zcy.collection.queue;

import java.util.*;

public class StackTest {
    public static void main(String[] args) {

        // -------------- 双端队列模拟栈 --------------
        // LIFO
        Deque<String> stack = new LinkedList<>();
        stack.push("1"); //=addFirst(e)
        stack.push("2");
        stack.push("3");
        System.out.println(stack); //[3, 2, 1]

        System.out.println(stack.pop()); //=removeFirst()  3
        System.out.println(stack.pop()); //2
        System.out.println(stack.peek()); //1
        System.out.println(stack); //[1]



        // -------------- 双端队列模拟栈 --------------
        //JDK Stack 推荐使用 Deque<Integer> stack = new ArrayDeque<Integer>();
        Stack<String> stackVector = new Stack<>();
        stackVector.push("4");
        stackVector.push("5");
        stackVector.push("6");
        stackVector.push("7");
        stackVector.push("8");
        System.out.println(stackVector); //[4, 5, 6, 7, 8]

        System.out.println(stackVector.search("2")); //-1 不存在
        System.out.println(stackVector.pop()); //8
        System.out.println(stackVector.pop()); //7
        System.out.println(stackVector.peek()); //6
        System.out.println(stackVector); //[4, 5, 6]
    }
}
