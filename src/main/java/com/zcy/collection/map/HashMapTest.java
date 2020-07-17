package com.zcy.collection.map;

import com.zcy.collection.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:13 2019-05-22
 * @ Modified: By:
 */

public class HashMapTest {


    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        hashMapTest.hashMapDemo();
    }


    public void hashMapDemo() {
        String s1 = "123";
        String s2 = "abc";
        String s3 = "2";

        Student student = new Student();
        student.setAge(18);
        student.setName("麻子");
        student.setGender("male");

        Map<String, Object> map1 = new HashMap();
        map1.put(s1, s2);
        map1.put(s3, student);

        System.out.println("map1 's value is >>> " + map1.get("123"));
        System.out.println("map1 's value is >>> " + map1.get("2"));


        //==============================2020-07-17遍历===============================
        System.out.println("==============================2020-07-17遍历===============================");
        Map<String, String> map = new HashMap<>();
        map.put("v1", "213");
        map.put("v2", "23111");
        map.put("v3", "2123");
        map.put("v4", "25wer");
        map.put("v5", "2er3");
        map.put(null, "??");
        map.put("v6", null);

        //foreach Map.Entry<k,v>遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.println(entry);
            System.out.println(entry.getKey() + " " + entry.getValue());

        }





    }


}
