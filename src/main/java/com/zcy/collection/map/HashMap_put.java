package com.zcy.collection.map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class HashMap_put {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

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

        //map直接打印
        System.out.println(map);



        //================================= capacity 容量测试 =====================================================
        System.out.println("\n\n\n================================= capacity 容量测试 =====================================================");
        Map<String, String> hashMap = new HashMap<>();   //容量的初始值直接设置为 = 数据量大小/负载因子 +1
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        //hashMap.put("key4", "value4");
        //hashMap.put("key5", "value5");
        //hashMap.put("key6", "value6");


        Class<?> clazz = hashMap.getClass();

        //数组容量
        Method method = clazz.getDeclaredMethod("capacity");
        method.setAccessible(true);
        System.out.println("capacity : " + method.invoke(hashMap) + "      数组容量");

        //负载因子(默认0.75)
        Field field1 = clazz.getDeclaredField("loadFactor");
        field1.setAccessible(true);
        System.out.println("loadFactor : " + field1.get(hashMap) + "      负载因子(默认0.75)");

        //扩容阈值(大于此数字才扩容)
        Field field2 = clazz.getDeclaredField("threshold");
        field2.setAccessible(true);
        System.out.println("threshold : " + field2.get(hashMap) + "      扩容阈值(大于此数字才扩容)");

        //容器内实际数据量
        Field field4 = clazz.getDeclaredField("size");
        field4.setAccessible(true);
        System.out.println("size : " + field4.get(hashMap) + "      容器内实际数据量");

        //Field field3 = clazz.getDeclaredField("table");
        //field3.setAccessible(true);
        //System.out.println("table.size : " + field3.get(hashMap));
    }


    /**
     * ###源码分析:
     *
     *  threshold初始值为不小于capacity最小的2的n次幂 如 1->1  2->2  3->4  4->4  5->8  ...  8->8  9->16
     *  当初始化完成后 第一次调用put方法，因为(table==null) 所以第一次put会resize()，
     *  通过这次resize() threshold 即变为原先threshold的loadFactor倍(默认0.75)
     * <code>
     *     // 构造函数1
     *     public HashMap(int initialCapacity) {
     *         this(initialCapacity, DEFAULT_LOAD_FACTOR);
     *     }
     *
     *     // 构造函数2
     *     public HashMap(int initialCapacity, float loadFactor) {
     *         if (initialCapacity < 0)
     *             throw new IllegalArgumentException("Illegal initial capacity: " +
     *                                                initialCapacity);
     *         if (initialCapacity > MAXIMUM_CAPACITY)
     *             initialCapacity = MAXIMUM_CAPACITY;
     *         if (loadFactor <= 0 || Float.isNaN(loadFactor))
     *             throw new IllegalArgumentException("Illegal load factor: " +
     *                                                loadFactor);
     *         this.loadFactor = loadFactor;
     *         this.threshold = tableSizeFor(initialCapacity);
     *     }
     *
     *     // 初始化阈值threshold
     *     static final int tableSizeFor(int cap) {
     *         int n = cap - 1;
     *         n |= n >>> 1;
     *         n |= n >>> 2;
     *         n |= n >>> 4;
     *         n |= n >>> 8;
     *         n |= n >>> 16;
     *         return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
     *     }
     * </code>
     */
}
