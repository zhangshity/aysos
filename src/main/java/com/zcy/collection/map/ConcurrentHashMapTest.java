package com.zcy.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:42 2020/7/17
 * @ Modified: By:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ZhangSan");
        map.put(2, "Allen");
        map.put(3, "Peter");
        map.put(4, "Joe");
        //map.put(5, null);    //value为null，空指针异常
        //map.put(null, "??"); //key为null，空指针异常

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }


    }
}
