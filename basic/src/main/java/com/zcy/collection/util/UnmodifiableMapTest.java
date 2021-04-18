package com.zcy.collection.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapTest {
    // 1
    private static final Map<String, String> constantMap = new HashMap<>();
    static {    // 原始变量定义 (不安全可修改)
        for (int i = 0; i < 10; i++) {
            constantMap.put("key" + i, "value" + i);
        }
    }

    // 2
    private static final Map<String, String> unmodifiableConstantMap;
    static {    // 安全的变量定义
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, "value" + i);
        }
        unmodifiableConstantMap = Collections.unmodifiableMap(map);
    }

    // 3
    private static final Map<String, String> unmodifiableConstantMap2 = Collections.unmodifiableMap(new HashMap<String, String>(64) {{
        for (int i = 0; i < 10; i++) {
            put("key" + i, "value" + i);
        }
    }});




    public static void main(String[] args) {
        // 不安全map 常量测试
        System.out.println(constantMap);
        constantMap.put("key5", "################# [hahahahahahahhahh misc}@@@@@@@@###########");
        System.out.println(constantMap); // 成功被修改

//        // 安全map 常量测试
//        System.out.println(unmodifiableConstantMap);
//        unmodifiableConstantMap.put("key5", "################# [hahahahahahahhahh misc}@@@@@@@@###########"); // Exception in thread "main" java.lang.UnsupportedOperationException
//        System.out.println(unmodifiableConstantMap);                                                          //     at java.util.Collections$UnmodifiableMap.put(Collections.java:1459)
//                                                                                                              //     at com.com.zcy.collection.util.UnmodifiableMapTest.main(UnmodifiableMapTest.java:38)
//
//        // 安全map 常量测试
//        System.out.println(unmodifiableConstantMap2);
//        unmodifiableConstantMap2.put("key5", "################# [hahahahahahahhahh misc}@@@@@@@@###########"); // Exception in thread "main" java.lang.UnsupportedOperationException
//        System.out.println(unmodifiableConstantMap2);                                                          //     at java.util.Collections$UnmodifiableMap.put(Collections.java:1459)
//                                                                                                               //     at com.com.zcy.collection.util.UnmodifiableMapTest.main(UnmodifiableMapTest.java:52)





        // 额外测试 1.被
        Map<String, String> originalMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            originalMap.put("key" + i, "value" + i);
        }

        Map<String, String> afterUnmodifiableMap = Collections.unmodifiableMap(originalMap);

        // 原始map修改
        originalMap.put("key1", "asdasdas89d4984984123!!!!!!!!!!!!#######################");
        System.out.println(originalMap); // {key1=asdasdas89d4984984123!!!!!!!!!!!!#######################, key2=value2, key0=value0, key5=value5, key6=value6, key3=value3, key4=value4, key9=value9, key7=value7, key8=value8}

        // 被修饰的返回的map修改
        System.out.println(afterUnmodifiableMap.get("key1")); //原始数据被修改，视图也会修改: asdasdas89d4984984123!!!!!!!!!!!!#######################
//        afterUnmodifiableMap.put("key1", "asdasdas89d4984984123!!!!!!!!!!!!#######################");      // Exception in thread "main" java.lang.UnsupportedOperationException
//        System.out.println(afterUnmodifiableMap);                                                          //     at java.util.Collections$UnmodifiableMap.put(Collections.java:1459)
//                                                                                                           //     at com.com.zcy.collection.util.UnmodifiableMapTest.main(UnmodifiableMapTest.java:71)

    }
}
