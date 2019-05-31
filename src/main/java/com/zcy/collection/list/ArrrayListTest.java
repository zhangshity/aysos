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

        //普通
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
