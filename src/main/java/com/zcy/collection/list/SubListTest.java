package com.zcy.collection.list;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(22222);
        list.add(55555);
        list.add(6456522);
        list.add(2120045622);
        list.add(456456);
        list.add(45645645);
        list.add(28882);
        list.add(28882);
        list.add(299992);
        list.add(22222);
        list.add(2696662);
        list.add(28789797);
        list.add(999);


        System.out.println(list.size()); //13
        System.out.println(list.subList(0, 1)); //[22222]
        System.out.println(list.subList(0, 0)); //[]
        System.out.println(list.subList(1, 1));
        System.out.println(list.subList(0, list.size())); //[22222, 55555, 6456522, 2120045622, 456456, 45645645, 28882, 28882, 299992, 22222, 2696662, 28789797, 999]
        System.out.println(list.subList(12,13)); //[999]
        System.out.println(list.subList(13,13)); //[]



    }
}
