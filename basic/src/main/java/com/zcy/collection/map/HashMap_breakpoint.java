package com.zcy.collection.map;

import java.util.HashMap;

/**
 * {@link HashMap}断点看启动过程
 */
public class HashMap_breakpoint {
    public static void main(String[] args) {

        /**
         * // 1.创建
         * - breakpoint:
         * <pre>
         *    public HashMap() {
         *         this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
         *     }
         * </pre>
         */
        HashMap<String, String> map = new HashMap<>();


        /**
         * // 2.添加
         * - breakpoint:
         *
         */



        /**
         * // 3.获取
         * - breakpoint:
         * (1) {@link HashMap#get(Object)}}
         * <pre>
         *     public V get(Object key) {
         *         Node<K,V> e;
         *         return (e = getNode(hash(key), key)) == null ? null : e.value;
         *     }
         * </pre>
         * (2) {@link HashMap#containsKey(Object)}
         * <pre>
         *     public boolean containsKey(Object key) {
         *         return getNode(hash(key), key) != null;
         *     }
         * </pre>
         * (3) {@link HashMap#getNode(int, Object)}
         * <pre>
         *     final Node<K,V> getNode(int hash, Object key) {
         *         Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
         *         if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) { // 获取Node数组中的
         *             if (first.hash == hash && // always check first node 总是检查第一个节点
         *                 ((k = first.key) == key || (key != null && key.equals(k))))
         *                 return first;
         *             if ((e = first.next) != null) {
         *                 if (first instanceof TreeNode)
         *                     return ((TreeNode<K,V>)first).getTreeNode(hash, key);
         *                 do {
         *                     if (e.hash == hash &&
         *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *                         return e;
         *                 } while ((e = e.next) != null);
         *             }
         *         }
         *         return null;
         *     }
         * </pre>
         */
    }
}
