package com.zcy.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:52 2019-05-24
 * @ Modified: By:
 */
public class ArrrayListTest {

    public static void main(String[] args) {

        ArrrayListTest arrrayListTest = new ArrrayListTest();
        arrrayListTest.demo();

    }


    public void demo() {
        List<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");

        //Iterator遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //foreach遍历
        for (String i : list) {
            System.out.println(i);
        }

        //普通遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        //============cotains()方法=============
        System.out.println("============cotains()方法============="); //本质就是对List中的存储容器elementData做了一个遍历
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add(null);
        list2.add("d");

        System.out.println(list2);
        System.out.println(list2.contains("a"));
        System.out.println(list2.contains(null));
        System.out.println(list2.contains("d"));
        System.out.println(list2.contains("v"));

    }
}
