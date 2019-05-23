package com.zcy.collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 16:41 2019-05-22
 * @ Modified: By:
 */
public class TreeSetTest {


    public static void main(String[] args) {
        TreeSetTest treeSetTest = new TreeSetTest();
        treeSetTest.testDemo();
    }

    public void testDemo() {
        Set<String> set = new TreeSet();
        set.add("123");
        set.add("1asd");
        set.add("2sdsfs");

        //foreach遍历
        for (String s : set) {
            System.out.println(s);
        }

        //常规遍历
        for (int i = 0; i < set.size(); i++) {
            Object[] o = set.toArray();
            System.out.println(o[i]);
        }

        //Iterator遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
    }

}
