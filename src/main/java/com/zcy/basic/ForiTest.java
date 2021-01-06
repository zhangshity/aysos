package com.zcy.basic;

import java.util.ArrayList;
import java.util.List;

public class ForiTest {
    public static void main(String[] args) {

        //基本正向循环 (0-4,5次)
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        System.out.println("----------------------");

        //反向基本循环 (4-0,,5次)
        for (int i = 5 - 1; i >= 0; i--) {
            System.out.println(i);
        }




        System.out.println("------------- List fori基本遍历 ---------------");
        List<String> list = new ArrayList<>();
        list.add("die1");
        list.add("wang2");
        list.add("zhang3");
        list.add("li4");
        list.add("niao5");
        list.add("liu6");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
