package com.zcy.basic;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {
    public static void main(String[] args) {

        // 软引用
        SoftReference<String> s = new SoftReference<>(new String("This is softString"));
        System.out.println(s.get()); //This is softString
        System.gc();
        System.out.println(s.get()); //This is softString


        // 弱引用
        WeakReference<String> s2 = new WeakReference<>(new String("This is weakString"));
        System.out.println(s2.get()); //This is weakString
        System.gc();
        System.out.println(s2.get()); //null




    }
}
