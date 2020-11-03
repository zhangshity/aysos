package com.zcy.basic;

import java.util.ArrayList;
import java.util.List;

public class NullPoninterTest {
    public static void main(String[] args) {


        String ss = null;
        if (ss != null && ss.equals("qwe")) {  // 不会空指针！
            System.out.println("测试");
        }


        String s = null;

        //System.out.println(s.length());
        System.out.println("ok");




        //=================== List空指针测试 =========================
        List list = null;
        if (list == null || list.isEmpty()) { // apache lang 包方法
            System.out.println("空");
        }

    }
}
