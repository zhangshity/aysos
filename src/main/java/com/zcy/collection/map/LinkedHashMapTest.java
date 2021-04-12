package com.zcy.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {

        // ================== 基于添加顺序 =====================
        // 常规，无代码 accessOrder 默认 false


        // ================== 基于访问顺序 (LRU算法 - Least Recently Used) =====================
        // 1.默认顺序
        Map<Integer,Integer> testMap = new LinkedHashMap<>(10,0.75f,true);
        testMap.put(3, 11);
        testMap.put(1, 12);
        testMap.put(5, 23);
        testMap.put(2, 22);
        for(Map.Entry<Integer,Integer> e : testMap.entrySet()) {
            System.out.println(e.getKey()); //3 1 5 2
        }
        /**
         * 这时直接告诉你答案，打印的顺序是3，1，5，2，也就是会按插入的顺序来打印。你有没有感觉到奇怪？
         * 散列表中数据是经过散列函数打乱之后无规律的，这里是如何实现按照数据的插入顺序来遍历打印的呢？
         */


        // 2.新增key冲突后顺序
        System.out.println("=== ");
        testMap.put(3, 26);
        for(Map.Entry<Integer,Integer> e : testMap.entrySet()) {
            System.out.println(e.getKey()); //1 5 2 3
        }
        /**
         * 每次调用put()函数，往LinkeHashMap中添加数据的时候，都会将数据添加到链表的尾部，所以，在前四个操作完成之后，
         * 链表中的数据是下面这样：3 1 5 2
         * <p>在第26代码中，再次将键值为3的数据放入LinkedhashMap的时候，会先找这个键值是否已经有了，
         * 然后，再将已经存在的（3，11）删除，并且将新的（3，26）放到链表的尾部。
         * 所以，这个时候链表中的数据就是下面这样： 1 5 2 3
         */


        // 3.获取某个key的值
        System.out.println("=== ");
        testMap.get(5);
        for(Map.Entry<Integer,Integer> e : testMap.entrySet()) {
            System.out.println(e.getKey()); //1 2 3 5
        }
        /**
         * 第41行代码访问到key为5的数据时，我们将被访问的数据移动到链表的尾部。所以，
         * 链表中的数据是下面这样： 1 2 3 5
         */


        //---------------------------------------------------------------------------------
        /**
         * 从上面的分析，你有没有发现，按照访问时间排序的LinkedHashMap本身就是一个支持LRU缓存淘汰策略的缓存系统？实际上，它们两个的实现的原理也是一模一样的。
         * </p>
         * 总结下，LinkedHashMap是通过双向链表和散列表这两种数据结构组合实现的。LinkedHashMap中的“linked”实际上是指双向链表，并非指用链表法解决散列冲突。
         * HashMap和双向链表合二为一即是LinkedHashMap
         *
         * LinkedHashMap底层还是HashMap 只不过其子类 Entry多维护了一个链表, 记录before 和 after 节点实现有序
         *
         *  <pre class="code">
         *  &#064;Configuration
         *      static class Entry<K,V> extends HashMap.Node<K,V> {
         *          Entry<K,V> before, after;
         *          Entry(int hash, K key, V value, Node<K,V> next) {
         *              super(hash, key, value, next);
         *          }
         *      }
         *  </pre>
         */
    }
}
