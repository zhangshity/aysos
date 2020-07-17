package com.zcy.collection.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《HashTable》 extends Dictionary<K,V>  implements Map<K,V>, Cloneable, java.io.Serializable
 * @ Date: Created in 14:14 2020/7/17
 * @ Modified: By:
 */
public class HashTableTest {


    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "ZhangSan");
        hashtable.put(2, "Allen");
        hashtable.put(3, "Peter");
        hashtable.put(4, "Joe");
        //hashtable.put(null, "??"); //空指针异常(kv均不能为null)
        //hashtable.put(5, null);    //空指针异常(kv均不能为null)


        //用foreach遍历
        for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("=============");

        //Iterator遍历
        for (Iterator<Map.Entry<Integer, String>> iterator = hashtable.entrySet().iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }


    }
}
