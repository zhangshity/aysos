package com.zcy.collection.map;

import java.util.*;
import java.util.Map.Entry;

public class HashMap_sort {
    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 245);
        map.put("b", 31);
        map.put("c", 4);
        map.put("d", 10);

        //无排序遍历 Map
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key >>> " + entry.getKey() + " | value >>> " + entry.getValue());
        }

        //排序遍历 Map(需先放入List才能用Collections工具类)
        System.out.println("排序遍历 Map(需先放入List才能用Collections工具类)");

        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Entry<String, Integer> entry : list) {
            System.out.println("key >>> " + entry.getKey() + " | value >>> " + entry.getValue());
        }


    }

}


