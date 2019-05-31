package com.zcy.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:36 2019-05-24
 * @ Modified: By:
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSetTest hashSetTest = new HashSetTest();
        hashSetTest.demo();
    }

    public void demo() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("test01");
        hashSet.add("test02");
        hashSet.add("test03");

        //foreach遍历
        for (String s : hashSet) {
            System.out.println(s);
        }

        //Iterator
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //转为数组-遍历
        Object[] o = hashSet.toArray();
        for (int i = 0; i < hashSet.size(); i++) {
            System.out.println(o[i]);
        }
    }
}
