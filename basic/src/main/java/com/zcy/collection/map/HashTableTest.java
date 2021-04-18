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

        // HashTable取不存在key测试
        System.out.println(hashtable.get(1)); //ZhangSan
        System.out.println(hashtable.get(8)); //null
        /**
         *     public synchronized V get(Object key) {
         *         Entry<?,?> tab[] = table;
         *         int hash = key.hashCode();
         *         int index = (hash & 0x7FFFFFFF) % tab.length;
         *         for (Entry<?,?> e = tab[index] ; e != null ; e = e.next) {
         *             if ((e.hash == hash) && e.key.equals(key)) {
         *                 return (V)e.value;
         *             }
         *         }
         *         return null;
         *     }
         */
    }
}
