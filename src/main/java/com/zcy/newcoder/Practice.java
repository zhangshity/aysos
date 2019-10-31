package com.zcy.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

    public static void main(String[] args) {

//        System.out.println("111");
//
//        char c[] = {'h', 'e', 'l', 'l', 'o'};
//        for (int i = 0; i < c.length;i++) {
//            System.out.println(c[i]);
//        }


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.contains("v"));


        Map<String, Integer> map = new HashMap<>();

        map.put("a", 2);
        map.put("b", 3);
        map.put("c", 4);
        map.put("c", 10);
        map.put("c", 5);


        System.out.println(map.containsKey("c"));
        System.out.println(map.get("c"));

        for (String key : map.keySet()) {
            System.out.println("k " +key + "v " +map.get(key));
        }

    }

}
