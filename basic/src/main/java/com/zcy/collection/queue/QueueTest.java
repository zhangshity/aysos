package com.zcy.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用JDK 常用实现类: {@link LinkedList}LinkedList
 */
public class QueueTest {


    public static void main(String[] args) {
        // FIFO
        //|---------------------------------------------------------
        //|                  | throw Exception  | 返回false或null
        //|---------------------------------------------------------
        //| 添加元素到队尾	     | add(E e)         | boolean offer(E e)
        //| 取队首元素并删除	 | E remove()       | E poll()
        //| 取队首元素但不删除	 | E element()	    | E peek()
        //|---------------------------------------------------------


        Queue<String> queue1 = new LinkedList<>();
        // ----- 无异常 -----
        System.out.println("offer入队 (队尾/tail/last)");
        queue1.offer("123");
        queue1.offer("456");
        System.out.println(">>> " + queue1);

        System.out.println("peek获取对首 (对首/head/first)");
        String peek1 = queue1.peek();
        System.out.println("peek对首 " + peek1);
        String peek2 = queue1.peek();
        System.out.println("peek对首 " + peek2);
        System.out.println(">>> " + queue1);

        System.out.println("poll出队 (对首/head/first)");
        String poll1 = queue1.poll();
        System.out.println("poll出队 " + poll1);
        String poll2 = queue1.poll();
        System.out.println("poll出队 " + poll2);
        System.out.println(">>> " + queue1);


        System.out.println("\n\n\n\n");


        // ----- 异常 -----
        Queue<String> queue2 = new LinkedList<>();
        System.out.println("add入队 (队尾/tail/last)");
        queue2.add("abc");
        queue2.add("def");
        System.out.println(">>> " + queue2);

        System.out.println("element获取对首 (对首/head/first)");
        String element1 = queue2.element();
        System.out.println("对首element " + element1);
        String element2 = queue2.element();
        System.out.println("对首element " + element2);
        System.out.println(">>> " + queue2);

        System.out.println("remove出队 (对首/head/first)");
        String remove1 = queue2.remove();
        System.out.println("出队remove " + remove1);
        String remove2 = queue2.remove();
        System.out.println("出队remove " + remove2);
        System.out.println(">>> " + queue2);

    }
}
