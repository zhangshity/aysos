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
        Map<String, String> hashMap = new HashMap<>(2);   //容量的初始值直接设置为 = 数据量大小/负载因子 +1
        hashMap.put("key1", "value1");
        //hashMap.put("key2", "value2");
        //hashMap.put("key3", "value3");
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

}
