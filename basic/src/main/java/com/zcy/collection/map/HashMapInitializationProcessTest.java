package com.zcy.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapInitializationProcessTest {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>(64);
        map.put("aaa", "aaav");


        //-----------------------------------------------------------------------
        Map<String, String> map1 = new HashMap<String, String>(64) {
            String s = "666";

            {
                for (int i = 0; i < 10; i++) {
                    put("key" + i, "value" + i);
                }
            }

            private void print_s() {
                System.out.println(s);
            }
        };

        System.out.println(map1);






    }
}
