package com.zcy.collection.map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 《利用反射动态观察 {@link HashMap}的 [容量] 和 [扩容时机] 》
 *  <p> @date ***
 * @author chunyang.zhang
 */
public class HashMap_reflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        System.out.print("======================================== 初始[2],添加[1]个 ========================================");
        Map<String, String> hashMap = new HashMap<>(2);
        getPropertiesByReflect(hashMap);

        hashMap.put("k1", "v1");
        getPropertiesByReflect(hashMap);

        System.out.print("\n======================================== 初始[3],添加[2]个 ========================================");
        Map<String, String> hashMap2 = new HashMap<>(3); // 2/0.75=2.66, %=2, +1=3, 实际上会变成4
        getPropertiesByReflect(hashMap2);

        hashMap2.put("k1", "v1");
        getPropertiesByReflect(hashMap2);
        hashMap2.put("k2", "v2");
        getPropertiesByReflect(hashMap2);


        System.out.print("\n======================================== 初始[6],添加[4]个 ========================================");
        Map<String, String> hashMap3 = new HashMap<>(6); // 4/0.75=5.33, %=5, +1=6, 实际上会变成8
        getPropertiesByReflect(hashMap3);

        hashMap3.put("k1", "v1");
        getPropertiesByReflect(hashMap3);
        hashMap3.put("k2", "v2");
        getPropertiesByReflect(hashMap3);
        hashMap3.put("k3", "v3");
        getPropertiesByReflect(hashMap3);
        hashMap3.put("k4", "v4");
        getPropertiesByReflect(hashMap3);



        System.out.print("\n======================================== 初始[6],添加[6]个 ========================================");
        Map<String, String> hashMap4 = new HashMap<>(6); // 实际上会变成8
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k1", "v1");
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k2", "v2");
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k3", "v3");
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k4", "v4");
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k5", "v5");
        getPropertiesByReflect(hashMap4);
        hashMap4.put("k6", "v6");
        getPropertiesByReflect(hashMap4);
        //触发扩容
        hashMap4.put("k7", "v7");
        getPropertiesByReflect(hashMap4);
    }


    /**
     * 反射获取属性
     * @param hashMap 哈希map
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static void getPropertiesByReflect(Map<String,String> hashMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        System.out.println("\n------------------------------ 反射获取 ------------------------------");
        Class<?> clazz = hashMap.getClass();

        //数组容量
        Method method = clazz.getDeclaredMethod("capacity");
        method.setAccessible(true);
        System.out.print("capacity : " + method.invoke(hashMap) + "      数组容量|      ");

        //负载因子(默认0.75)
        Field field1 = clazz.getDeclaredField("loadFactor");
        field1.setAccessible(true);
        System.out.print("loadFactor : " + field1.get(hashMap) + "      负载因子(默认0.75)|       ");

        //扩容阈值(大于此数字才扩容)
        Field field2 = clazz.getDeclaredField("threshold");
        field2.setAccessible(true);
        System.out.print("threshold : " + field2.get(hashMap) + "      扩容阈值(大于此数字才扩容)|      ");

        //容器内实际数据量
        Field field4 = clazz.getDeclaredField("size");
        field4.setAccessible(true);
        System.out.print("size : " + field4.get(hashMap) + "      容器内实际数据量");

        //Field field3 = clazz.getDeclaredField("table");
        //field3.setAccessible(true);
        //System.out.print("table.size : " + field3.get(hashMap));
    }
}
