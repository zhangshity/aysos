package com.zcy.collection._1_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 最常见的遍历
 */
public class Traversal_2_2Fori {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        list.add("test04");
        list.add("test05");
        list.add("test06");
        list.add("test07");
        list.add("test08");
        list.add("test09");
        list.add("test10");
        list.add("test10");
        System.out.println(list); //[test01, test02, test03, test04, test05, test06, test07, test08, test09, test10, test10]


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
