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


        System.out.println(map.get(1)); //ZhangSan
        System.out.println(map.get(8)); //null
        /**
         *     public V get(Object key) {
         *         Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
         *         int h = spread(key.hashCode());
         *         if ((tab = table) != null && (n = tab.length) > 0 &&
         *             (e = tabAt(tab, (n - 1) & h)) != null) {
         *             if ((eh = e.hash) == h) {
         *                 if ((ek = e.key) == key || (ek != null && key.equals(ek)))
         *                     return e.val;
         *             }
         *             else if (eh < 0)
         *                 return (p = e.find(h, key)) != null ? p.val : null;
         *             while ((e = e.next) != null) {
         *                 if (e.hash == h &&
         *                     ((ek = e.key) == key || (ek != null && key.equals(ek))))
         *                     return e.val;
         *             }
         *         }
         *         return null;
         *     }
         */
    }
}
