package com.zcy.collection.map;

import java.util.*;

public class HashMap_put {

    public static void main(String[] args) {

        //HashMap的key和value均可为null ,(key只能哟一个null因为不能重复)


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 3);
        map.put(null, 2);
        map.put(null, 4);
        map.put("c", 4);
        map.put("c", 10);
        map.put("c", 5);   //可见如果key重复，put()插入map时，则只会覆盖掉value


        System.out.println(map.containsKey("c"));
        System.out.println(map.get("c"));

        //keySet()遍历Map
        for (String key : map.keySet()) {
            System.out.println("key >>> " + key + "| v >>> " + map.get(key));
        }











        //===============HashTable========================================
        Map<String, Integer> map1 = new Hashtable<>();


    }

}
