package com.zcy.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:48 2019-05-24
 * @ Modified: By:
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.demo();
    }

    public void demo() {

        List<String> list = new LinkedList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");


        //Iterator遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object result = iterator.next();
            System.out.println(result);
        }

        //foreach遍历
        for (String i : list) {
            System.out.println(i);
        }

        //普通遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //转为数组-遍历
        list.toArray();

        System.out.println("=============LinkedList get()====================");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
