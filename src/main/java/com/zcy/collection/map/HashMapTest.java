package com.zcy.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:13 2019-05-22
 * @ Modified: By:
 */

public class HashMapTest {

    public void hashMapDemo() {

        String s1 = "123";
        String s2 = "abc";
        Map<String, String> map1 = new HashMap();
        map1.put(s1, s2);

        System.out.println("map1 's value is >>> " + map1.get("123"));
    }
}
